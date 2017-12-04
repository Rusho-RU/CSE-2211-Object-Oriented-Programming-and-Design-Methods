
public class Part1 {
	public static int startIndexOf(String dna){
        return dna.indexOf("ATG");
    }
    
    public static int stopIndexOf(String dna){
        return dna.indexOf("TAA");
    }
    
    public static boolean isValid(int startIndex, int stopIndex){
        if(startIndex == -1 || stopIndex == -1)
            return false;
            
        if((stopIndex - startIndex - 3) % 3 == 0)
            return true;
        
        return false;
    }
	
	public static String findSimpleGene(String dna){
		int startIndex=0, stopIndex=0, currentIndex=0;
        
        while(stopIndex!=-1){
            startIndex = startIndexOf(dna.substring(currentIndex, dna.length()));
            
            if(startIndex == -1)
                return "";
            
            stopIndex = startIndex + stopIndexOf(dna.substring(startIndex+3, dna.length())) + 3;
            
            if(isValid(startIndex, stopIndex)){
                return dna.substring(startIndex, stopIndex + 2);
            }
            
            currentIndex = startIndex + 3;
        }
        
        return "";
	}
	
	public static void testSimpleGene(){
		String dna = "AAAGGGTAA";
		System.out.println(findSimpleGene(dna));
		
		dna = "ATGAAAGGGTTT";
		System.out.println(findSimpleGene(dna));
		
		dna = "AAAAAAAAAAAAAAAAA";
		System.out.println(findSimpleGene(dna));
		
		dna = "AAAATGAAAGGGTTTTAAATT";
		System.out.println(findSimpleGene(dna));
		
		dna = "AAAATGAAAGGTTTTAAATT";
		System.out.println(findSimpleGene(dna));
	}
	
	public static void main(String[] args){
		testSimpleGene();
	}
}
