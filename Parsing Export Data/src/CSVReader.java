import com.sun.corba.se.impl.resolver.FileResolverImpl;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.math.BigInteger;
import java.util.StringTokenizer;

public class CSVReader {
    public static String countryInfo(CSVParser parser, String country){
        for(CSVRecord record : parser){
            String info = record.get("Country");
            if(info.contains(country))
                return info + " : " + record.get("Exports");
        }

        return "NOT FOUND";
    }

    public static void listExportersTwoProduct(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record : parser){
            String exportRecord = record.get("Exports");
            if(exportRecord.contains(exportItem1) && exportRecord.contains(exportItem2))
                System.out.println(record.get("Country"));
        }
    }

    public static int numberOfExporter(CSVParser parser, String exportItem){
        int cnt = 0;

        for(CSVRecord record : parser)
            if(record.get("Exports").contains(exportItem))
                cnt++;

        return cnt;
    }

    public static void bigExporter(CSVParser parser, String string){
        BigInteger amountLimit  = new BigInteger(string.substring(1).replaceAll(",", ""));

        for(CSVRecord record : parser){
            String money = record.get("Value (dollars)");
            BigInteger amount = new BigInteger(money.substring(1).replaceAll(",", ""));

            if(amount.compareTo(amountLimit) == 1)
                System.out.println(record.get("Country") + " " + money);
        }
    }

    public static void tester(){
        FileResource fileResource = new FileResource();
        CSVParser csvParser = fileResource.getCSVParser();
        System.out.println(countryInfo(csvParser, "Germany"));

        csvParser = fileResource.getCSVParser();
        listExportersTwoProduct(csvParser, "gold", "diamonds");

        csvParser = fileResource.getCSVParser();
        System.out.println(numberOfExporter(csvParser, "gold"));

        csvParser = fileResource.getCSVParser();
        bigExporter(csvParser, "$999,999,999");
    }

    public static void main(String args[]){
        tester();
    }
}
