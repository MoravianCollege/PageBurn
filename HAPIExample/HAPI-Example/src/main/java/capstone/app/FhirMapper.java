/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.app;

import ca.uhn.fhir.model.api.IDatatype;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.BoundCodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.resource.Practitioner.PractitionerRole;
import ca.uhn.fhir.model.dstu2.resource.Practitioner.Qualification;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.PractitionerRoleEnum;
import java.util.ArrayList;


public class FhirMapper 
{
    Practitioner practitioner;
    public boolean exists(String NPI)
    {
        if(NPI.equals(practitioner.getId()))
        {
            return true;
        }
        return false; // check NPI against current resource NPI
    }
    
    public void createPractitioner(DocData data)
    {
        ArrayList<AddressDt> addresses = new ArrayList(); //addresses requires an array argument
        ArrayList<PractitionerRole> roles = new ArrayList(); // practitioner role resouce requires an array of roles
        ArrayList<ResourceReferenceDt> descriptions = new ArrayList(); // practitioner healthcareServiceProvided also requires an array aof healthCareServices provided
        Qualification credential;
        
        
        practitioner = new Practitioner(); //create new practitioner
        practitioner.setId(data.get_NPI());
        practitioner.setName(new HumanNameDt().addGiven(data.get_nppes_provider_first_name()).addFamily(data.get_nppes_provider_last_org_name()));
        addresses.add(new AddressDt());
        addresses.get(0).addLine(data.get_nppes_provider_street1()).setCity(data.get_nppes_provider_city()).setState(data.get_nppes_provider_state()).setPostalCode(data.get_nppes_provider_zip());
        roles.add(new PractitionerRole().setRole(PractitionerRoleEnum.DOCTOR)); //add a role to the roles array, DOCTOR is only enum that makes sense
        descriptions.add(new ResourceReferenceDt().setDisplay(data.get_hcpcs_description()).setReference(data.get_hcpcs_code())); // add the description as the display and set its id to the code value
        roles.get(0).setHealthcareService(descriptions); // load the healthcare services into the role
        practitioner.setPractitionerRole(roles);
        if(data.get_medicare_participation_indicator().equals("Y")) // they participate in medicare so we can set their field for active
        {
            practitioner.setActive(true);
        }
        else
        {
            practitioner.setActive(false); //otherwise they are inactive because we are ONLY dealing with medicare data here
        }
        
        credential = new Practitioner.Qualification().addIdentifier(new IdentifierDt("system", data.get_nppes_credentials())); // get rid of system, when we decide on namespace
        practitioner.addQualification(credential); // load credential as a qualification int practitioner
        
        if(data.get_nppes_provider_gende().equals("M")) // gender of male
        {
            practitioner.setGender(AdministrativeGenderEnum.MALE);
        }
        else if(data.get_nppes_provider_gende().equals("F")) // gender of Female
        {
            practitioner.setGender(AdministrativeGenderEnum.FEMALE);
        }
        else    // Anything other than M or F
        {
            practitioner.setGender(AdministrativeGenderEnum.UNKNOWN);
        }
        
        ArrayList<ResourceReferenceDt> performers = new ArrayList();
        performers.add(new ResourceReferenceDt(practitioner));
        
        Observation observation = new Observation();
        observation.setPerformer(performers);

                 
        
    }
    
    public void addAttributes(DocData data)
    {
        // add all non-common elements of array to Practitioner object
    }
    
    public Practitioner getResource()
    {
        return practitioner; //return the Practitioner Resrouce
    }
}
