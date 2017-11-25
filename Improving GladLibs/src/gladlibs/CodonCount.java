package gladlibs;

import edu.duke.FileResource;
import java.util.HashMap;
import java.lang.String;

public class CodonCount {
    private HashMap<String, Integer>codons;

    public CodonCount(){
        codons = new HashMap<>();
    }

    public void buildCodonMap(int start, String dna){
        codons.clear();
        int limit = dna.length() - 2;
        for(int i=start; i<limit; i+=3){
            String codon = "";
            codon += dna.charAt(i);
            codon += dna.charAt(i+1);
            codon += dna.charAt(i+2);

            if(codons.containsKey(codon))
                codons.put(codon, codons.get(codon) + 1);

            else
                codons.put(codon, 1);
        }
    }

    public void printCodonCounts(int start, int end){
        for(String key : codons.keySet()){
            int count = codons.get(key);
            if(count >= start && count<=end)
                System.out.println(key + ": " + count);
        }
    }

    public String getMostCommonCodon(){
        String key = null;
        int max = 0, value;
        for(String str : codons.keySet()){
            value = codons.get(str);

            if(value > max){
                max = value;
                key = str;
            }
        }
        return key;
    }

    private void tester(){
        int start = 1, end = 5;
        FileResource file = new FileResource();
        String dna = file.asString().trim(), common;
        dna = dna.toUpperCase();

        buildCodonMap(0, dna);
        System.out.println("Reading frame starting with 0" +" results in " + codons.size() + " unique codons");
        common = getMostCommonCodon();
        System.out.println("and most common codon is " + common +" with count " + codons.get(common));
        printCodonCounts(start, end);
        System.out.println();

        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1" +" results in " + codons.size() + " unique codons");
        common = getMostCommonCodon();
        System.out.println("and most common codon is " + common +" with count " + codons.get(common));
        printCodonCounts(start, end);
        System.out.println();

        buildCodonMap(2, dna);
        System.out.println("Reading frame starting with 2" +" results in " + codons.size() + " unique codons");
        common = getMostCommonCodon();
        System.out.println("and most common codon is " + common +" with count " + codons.get(common));
        printCodonCounts(start, end);
        System.out.println();
    }

    public static void main(String args[]){
        CodonCount obj = new CodonCount();
        obj.tester();
    }
}
