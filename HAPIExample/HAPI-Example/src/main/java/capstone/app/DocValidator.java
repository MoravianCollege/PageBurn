package capstone.app;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.ValidationResult;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.hl7.fhir.instance.model.api.IBaseResource;

/**
 *
 * @author Home
 */
public class DocValidator {

    public void Validate(String path) {
        FhirContext ctx = FhirContext.forDstu2();

// Create a validator and configure it
        FhirValidator validator = ctx.newValidator();
        validator.setValidateAgainstStandardSchema(true);
        validator.setValidateAgainstStandardSchematron(true);

// Get a list of files in a given directory
        String[] fileList = new File(path).list(new WildcardFileFilter("*.txt"));

        for (String nextFile : fileList) {

            // For each file, load the contents into a string
            String nextFileContents = null;
            try {
                nextFileContents = IOUtils.toString(new FileReader(nextFile));
            } catch (IOException ex) {
                Logger.getLogger(DocValidator.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Parse that string (this example assumes JSON encoding)
            IBaseResource resource = ctx.newJsonParser().parseResource(nextFileContents);

   // Apply the validation. This will throw an exception on the first
            // validation failure
            ValidationResult result = validator.validateWithResult(resource);
            if (result.isSuccessful() == false) {
                try {
                    throw new Exception("We failed!");
                } catch (Exception ex) {
                    Logger.getLogger(DocValidator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
