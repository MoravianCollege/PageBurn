/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.app;
import ca.uhn.fhir.context.FhirContext;

import ca.uhn.fhir.model.dstu2.resource.Practitioner;

/**
 *
 * @author Home
 */
public class FhirPrinter 
{
    FhirContext ctx = FhirContext.forDstu2();
    public void outputXML(Practitioner dr)
    {
       String encoded = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(dr);
        System.out.println(encoded);
    }
    
    public void outputJSON(Practitioner dr)
    {
       String encoded = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(dr);
       System.out.println(encoded);
    }
    
}
