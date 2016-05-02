/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.app;
import ca.uhn.fhir.context.FhirContext;

import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

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
       try{
             // create new file;
             String path="/docgraph/" +dr.getName()+ dr.getId();
             System.out.println(path);
             File file = new File(path);

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                // write in file
                bw.write(encoded);
                // close connection
                bw.close();
          }catch(Exception e){
              System.out.println(e);
          }
        System.out.println(encoded);
    }
    
    public void outputJSON(Practitioner dr)
    {
       String encoded = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(dr);
       try{
             // create new file;
             String path="/docgraph/" +dr.getName()+ dr.getId();
             File file = new File(path);

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                // write in file
                bw.write(encoded);
                // close connection
                bw.close();
          }catch(Exception e){
              System.out.println(e);
          }
        System.out.println(encoded);
    }
    
}
