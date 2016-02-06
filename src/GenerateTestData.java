import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;
import java.util.Scanner;

public class GenerateTestData {

	public static void main(String[] args) {
		// The name of the file to open.
        String fileName = "TestDataGeneration.txt";
        
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);

            String[] reason = {"home","profile","message","notification","groups"};
            String[] ipAddress = {"ip1", "ip2", "ip3", "ip4", "ip5","ip6","ip7","ip8","ip9","ip10"};
            
            
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("TimeStamp");
            bufferedWriter.write("          ");
            bufferedWriter.write("SourceId");
            bufferedWriter.write("          ");
            bufferedWriter.write("Reason");
            bufferedWriter.write("          ");
            bufferedWriter.write("HTTPStatus");
            bufferedWriter.write("          ");
            bufferedWriter.write("\n");
            
            Random randomIpGen = new Random();
            Random randomReasonGen = new Random();
            
            System.out.print("Enter total no of transaction for data file : ");
            Scanner in = new Scanner(System.in);
            int transaction = in.nextInt();
            
            int i;
            for (i = 0; i < transaction; i++) {
            	java.util.Date date = new java.util.Date();
            	bufferedWriter.write(""+new Timestamp(date.getTime()));
            	bufferedWriter.write("          ");
            	bufferedWriter.write(""+ ipAddress[randomIpGen.nextInt(10)]);
            	bufferedWriter.write("          ");
            	bufferedWriter.write(""+ reason[randomReasonGen.nextInt(5)]);
            	bufferedWriter.write("          ");
            	bufferedWriter.write("200");
            	bufferedWriter.write("\n");
			}
            
            bufferedWriter.close();
            in.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '"+ fileName + "'");
        }
	}

}
