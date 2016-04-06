/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstone.app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author khristianmorel
 */
public class FHIRwriter
{

    private ArrayList<String> tokens = new ArrayList<String>();

    /*
    *reads in a file path and parses the information by commas and qoutes.
    The information is split by a tokenizer and the elements are convert to 
    strings.
    
    Insert information where the println is.
     */
    void readIn(String fileExt) throws FileNotFoundException, IOException
    {

        String Tags[] =
        {
            "npi", "nppes_provider_last_org_name", "nppes_provider_first_name", "nppes_provider_mi\n", "nppes_credentials\n",
            "nppes_provider_gender\n", "nppes_entity_code\n", "nppes_provider_street1\n",
            "nppes_provider_street2\n", "nppes_provider_city\n", "nppes_provider_zip\n",
            "nppes_provider_state\n", "nppes_provider_country\n", "provider_type\n",
            "medicare_participation_indicator\n", "place_of_service\n", "hcpcs_code\n",
            "hcpcs_description\n", "line_srvc_cnt\n", "bene_unique_cnt\n", "bene_day_srvc_cnt\n",
            "average_Medicare_allowed_amt\n", "stdev_Medicare_allowed_amt\n", "average_submitted_chrg_amt\n",
            "stdev_submitted_chrg_amt\n", "average_Medicare_payment_amt\n",
            "stdev_Medicare_payment_amt"
        };

        try
        {
            FileInputStream inputStream = new FileInputStream(fileExt);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] tokes = line.split("\t");
                for (int i = 0; i < (tokes.length); i++)
                {
                    //System.out.println(tokes[i]);
                    tokens.add(tokes[i]);

                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File Path Not Found");
        } catch (IOException io)
        {
            System.out.println("File Path Not Found");
        }
        int testI = 0;
        for (int i = 29; i < tokens.size(); i++)
        {
            System.out.print(Tags[testI] + ": " + tokens.get(i));
            if (tokens.get(i).endsWith(" "))
            {
                testI++;
                if (testI >= 27)
                {
                    testI = testI % 27;
                }
                System.out.print("\n" + Tags[testI] + ": No Data");
            }
            System.out.print("\n");
            testI++;
            if (testI >= 27)
            {
                testI = testI % 27;
            }
        }
    }
    
    ArrayList<String> getFields()
    {
        return tokens;
    }
    
    public ArrayList<String> processLine(String line)
    {
        return null; // take in the line and split like it does above, but instead of printing put into an array correctly
        // also, this only processes one line, not all of them, main will feed this line by line.
    }
}
