import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyBirth {
    private String fileResource = "H:\\Documents\\Projects\\IntelliJ\\CSE-2211-Object-Oriented-Programming-and-Design-Methods\\Analyzing Baby name\\Resource\\us_babynames_test\\yob";

    public void totalBirths(FileResource file){
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for(CSVRecord record : file.getCSVParser(false)) {
            int total = Integer.parseInt(record.get(2));
            totalBirths += total;
            String gender = record.get(1);

            if(gender.equals("M"))
                totalBoys += total;

            else if(gender.equals("F"))
                totalGirls += total;
        }

        System.out.println("Total Birth : " + totalBirths);
        System.out.println("Boys : " + totalBoys);
        System.out.println("Girls : " + totalGirls);
    }

    public int getRank(int year, String name, String gender){
        FileResource file = new FileResource(fileResource + Integer.toString(year) + "short.csv");
        int rank = 0;

        for(CSVRecord record : file.getCSVParser(false)){

            if(record.get(1).equals(gender)){
                rank++;
                if(record.get(0).equals(name))
                    return rank;
            }
        }

        return -1;
    }

    public int getRank(FileResource file, String name, String gender){
        int rank = 0;

        for(CSVRecord record : file.getCSVParser(false)){

            if(record.get(1).equals(gender)){
                rank++;
                if(record.get(0).equals(name))
                    return rank;
            }
        }

        return -1;
    }

    public String getName(int year, int rank, String gender){
        FileResource file = new FileResource(fileResource + Integer.toString(year) + "short.csv");
        int index = 0;

        for(CSVRecord record : file.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                index++;
                if(index == rank)
                    return record.get(0);
            }
        }

        return "NO NAME";
    }

    public String whatIsNameInYear(String name, int year, int newYear, String gender) {
        return getName(newYear, getRank(year, name, gender), gender);
    }

    public int yearOfHighestRank(String name, String gender){
        DirectoryResource directory = new DirectoryResource();
        String year = "";
        int maxRank = 1000000000;

        for(File f : directory.selectedFiles()){
            String fileName = f.getName();
            FileResource file = new FileResource(f);
            int rank = 0;

            for(CSVRecord record : file.getCSVParser(false)){
                if(record.get(1).equals(gender)){
                    rank++;

                    if(record.get(0).equals(name))
                        break;
                }
            }

            if(rank < maxRank){
                maxRank = rank;
                year = fileName.substring(3,7);
            }
        }

        return Integer.parseInt(year);
    }

    public double getAverageRank(String name, String gender){
        DirectoryResource directory = new DirectoryResource();
        double total = 0;
        int cnt = 0;

        for(File f : directory.selectedFiles()){
            FileResource file = new FileResource(f);
            cnt++;
            int rank = getRank(file, name, gender);
            if(rank == -1)
                return -1;
            total += rank;
        }

        return total/cnt;
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        FileResource file = new FileResource(fileResource + Integer.toString(year) + "short.csv");
        int total = 0;

        for(CSVRecord record : file.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                if(record.get(0).equals(name))
                    break;
                total += Integer.parseInt(record.get(2));
            }
        }

        return total;
    }

    public void testYearOfHighestRank(){
        System.out.println(yearOfHighestRank("Mason", "M"));
    }

    public void testGetAverageRank(){
        System.out.println(getAverageRank("Jacob", "M"));
    }

    public void testGetTotalBirthsRankedHigher(){
        System.out.println(getTotalBirthsRankedHigher(2012, "Ethan", "M"));
    }

    public void tester(){
        System.out.println(getRank(2012, "Mason", "M"));
        System.out.println(getName(2012, 3, "F"));
        System.out.print("Isabella born in 2012 would be ");
        System.out.println(whatIsNameInYear("Isabella", 2012, 2014, "F") + " if she was born in 2014");
    }

    public static void main(String args[]){
        BabyBirth obj = new BabyBirth();
        obj.tester();
        obj.testYearOfHighestRank();
        obj.testGetAverageRank();
        obj.testGetTotalBirthsRankedHigher();
    }
}
