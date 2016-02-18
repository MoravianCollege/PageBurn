/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docfhir;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.rest.gclient.TokenClientParam;
import java.util.ArrayList;
/**
 *
 * @author Derek
*/

        
public class DocFHIR {

    public static void main(String[] args) 
    {
        //Create a practitioner Object (resource)
        Practitioner pract = new Practitioner();
        //Create an IdentifierDt Object, takes 2 strings
        IdentifierDt identifier = new IdentifierDt("NPI", "123456789"); 
        //Adding my identifierDt to the practitioner object.
        pract.addIdentifier(identifier);
        //This sets a field called id. If you print just pract, it will tell you id = null if this is not set
        pract.setId("Bob");
        //setIdentifier takes a list of IdentifierDt's and getIdentifier conveniently returns Identifier Dt's as a list
        pract.setIdentifier(pract.getIdentifier());
        
        //print out just the practitioner resource to see what it does...prints the id NOT the IdentifierDt
        System.out.println(pract);
        //print out our Identifier Dt object which I set to be the NPI and a madeup number
        System.out.println(pract.getIdentifier());
        
    }
    
}
