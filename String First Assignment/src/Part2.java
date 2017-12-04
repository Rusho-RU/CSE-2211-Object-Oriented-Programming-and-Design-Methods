
public class Part2 {
	public static int startIndexOf(String dna, String codon){
        return dna.indexOf(codon);
    }
    
    public static int stopIndexOf(String dna, String codon){
        return dna.indexOf(codon);
    }
    
    public static boolean isValid(int startIndex, int stopIndex){
        if(startIndex == -1 || stopIndex == -1)
            return false;
            
        if((stopIndex - startIndex - 3) % 3 == 0)
            return true;
        
        return false;
    }
    
    public static String decideStartCodon(String dna){
    	if(dna.charAt(0)>='a' && dna.charAt(0)<='z')
    		return "atg";
    	return "ATG";
    }
    
    public static String decideStopCodon(String dna){
    	if(dna.charAt(0)>='a' && dna.charAt(0)<='z')
    		return "taa";
    	return "TAA";
    }
	
	public static String findSimpleGene(String dna, String startCodon, String stopCodon){
		int startIndex=0, stopIndex=0, currentIndex=0;
        
        while(stopIndex!=-1){
            startIndex = startIndexOf(dna.substring(currentIndex, dna.length()), startCodon);
            
            if(startIndex == -1)
                return "";
            
            stopIndex = startIndex + stopIndexOf(dna.substring(startIndex+3, dna.length()), stopCodon) + 3;
            
            if(isValid(startIndex, stopIndex)){
                return dna.substring(startIndex, stopIndex + 2);
            }
            
            currentIndex = startIndex + 3;
        }
        
        return "";
	}
	
	public static void testSimpleGene(){
		String dna = "AAAGGGTAA";
		String startCodon = decideStartCodon(dna);
		String stopCodon = decideStopCodon(dna);
		
		System.out.println(findSimpleGene(dna, startCodon, stopCodon));
		
		dna = "ATGAAAGGGTTT";
		
		startCodon = decideStartCodon(dna);
		stopCodon = decideStopCodon(dna);
		System.out.println(findSimpleGene(dna, startCodon, stopCodon));
		
		dna = "AAAAAAAAAAAAAAAAA";

		startCodon = decideStartCodon(dna);
		stopCodon = decideStopCodon(dna);
		System.out.println(findSimpleGene(dna, startCodon, stopCodon));
		
		dna = "AAAATGAAAGGGTTTTAAATT";
		
		startCodon = decideStartCodon(dna);
		stopCodon = decideStopCodon(dna);
		System.out.println(findSimpleGene(dna, startCodon, stopCodon));
		
		dna = "AAAATGAAAGGTTTTAAATT";
		
		startCodon = decideStartCodon(dna);
		stopCodon = decideStopCodon(dna);
		System.out.println(findSimpleGene(dna, startCodon, stopCodon));
	}
	
	public static void main(String[] args){
		testSimpleGene();
	}
}
