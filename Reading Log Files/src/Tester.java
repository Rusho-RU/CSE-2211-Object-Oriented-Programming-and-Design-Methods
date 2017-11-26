import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Tester {
    public static void main(String args[]){
        LogAnalyzer obj = new LogAnalyzer();
        obj.readFile("http://www.dukelearntoprogram.com/java/weblog3-short_log");
        HashMap<String, Integer> counts = new HashMap<>();
        counts = obj.countVisitsPerIP();

        for(String IP : counts.keySet())
            System.out.println(IP + "visited " + counts.get(IP) + " times");

        System.out.println("\n" + "Most visited by IPs : " + obj.mostNumberVisitsByIP(counts) + "\n");

        ArrayList<String> list = obj.iPsMostVisits(counts);
        System.out.println("IPs those visited maximum times :");
        for(String IP : list)
            System.out.println(IP);

        HashMap<String, ArrayList<String> > countsPerDay = obj.iPsForDays();
        for(String day : countsPerDay.keySet()){
            System.out.println("On date " + day + " " + countsPerDay.get(day).size() + " IP addresses visited the site");
        }
        
        System.out.println("\nOn the day " + obj.dayWithMostIPVisits(countsPerDay) + " most IP visited");

        ArrayList<String> IPList = obj.iPsWithMostVisitsOnDay(countsPerDay, "Sep 30");
        System.out.println("\nIPs those visited on Sep 30:");
        for(String IP : IPList)
            System.out.println(IP);

    }
}
