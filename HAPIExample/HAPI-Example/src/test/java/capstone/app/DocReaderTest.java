package capstone.app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class DocReaderTest
{

    DocReader FW;

    @Before
    public void Setup()
    {
        FW = new DocReader();
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testApp()
    {
        assertTrue(true);
    }

    /**
     * Tests DocReader when reading in data from medicare data to make sure it
     * gets 27 fields of data.
     *
     * @throws IOException
     */
    @Test
    public void testFHIRwriter27Items() throws IOException
    {

        FW.readIn("src/test/test files/TestFieldData.txt");

        assertEquals(27, FW.getFields().size());
    }
    
    @Test
    public void testDocReader2Times() throws IOException
    {
        FW.readIn("src/test/test files/TestFieldData.txt");
        FW.readIn("src/test/test files/TestFieldData.txt");
        
        assertEquals(54, FW.getFields().size());
    }
            /**
     * Test FHIRWriter when reading in data from ha1c data to make sure it gets
     * 16 fields of data. 
     * Uncomment test once parser has been updated to read in this data.
     *
     * @throws IOException
     */
//    @Test
//    public void testFHIRwriter16Items() throws IOException
//    {
//
//        FW.readIn("src/test/test files/TestFieldData.txt");
//
//        assertEquals(16,FW.getFields().size());
//    }
    /**
     * Test FHIRWriter when reading in data from medicare data to make
     * sure the data is read in the proper order.
     *
     * @throws IOException
     */
    @Test
    public void testFHIRWriterMedCorrectOrder() throws IOException
    {
        ArrayList<String> testData = new ArrayList<String>();
        testData.add("1234567890");
        testData.add("JOE");
        testData.add("BAGODONUTS");
        testData.add("");
        testData.add("M.D.");
        testData.add("M");
        testData.add("I");
        testData.add("123 CANDY DR");
        testData.add("");
        testData.add("NARNIA");
        testData.add("123456789");
        testData.add("PA");
        testData.add("US");
        testData.add("Funny Bone Specialist");
        testData.add("Y");
        testData.add("F");
        testData.add("123456");
        testData.add("COMEDIAN");
        testData.add("123");
        testData.add("123");
        testData.add("123");
        testData.add("123.45");
        testData.add("0");
        testData.add("123");
        testData.add("0");
        testData.add("123.45678901");
        testData.add("1.2345678901");

        FW.readIn("src/test/test files/TestFieldData.txt");

        for (int i = 0; i < FW.getFields().size(); i++)
        {
            assertEquals(testData.get(i), FW.getFields().get(i));
        }

    }
    
    @Test
    public void testDocReaderSameNPI() throws IOException
    {
        int numLines = 10;
        for (int x = 0; x < numLines; x ++)
        {
            FW.readIn("src/test/test files/TestFieldData.txt");
        }
             
           
        for (int i =0; i<numLines; i++)
        {
            assertEquals("1234567890", FW.getFields().get(i*27));
        }
    }
    
    
    @Test
    public void testDocReaderDifferentNPI() throws IOException
    {
        int numLines = 12;
        for (int x = 0; x < numLines; x ++)
        {
            FW.readIn("src/test/test files/Test11RowsData.txt");
        }
             
           
        for (int i =0; i<numLines; i++)
        {
            if (i < 10)
                assertEquals("1234567890", FW.getFields().get(i*27));
            else
                assertEquals("2345678901", FW.getFields().get(i*27));
            
        }
    }
    
    
    ///Make sure data cleans itself
    @Test
    public void testDocReaderHeader() throws IOException
    {
        //DocData data = null;
        FileInputStream inputStream = new FileInputStream("src/test/test files/Test11RowsData.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        
        String line;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null) // going to go through each line of the file
        {
            DocData data = new DocData();
            data = FW.processLine(line); // put a line into a DocData Element
            System.out.println("//////////////"+data.get_NPI()+"????????????????????????????");
            if(count < 10)
                assertEquals("1234567890", data.get_NPI());
            else
                assertEquals("2345678901", data.get_NPI());
            count += 1;
        }
    }
}
