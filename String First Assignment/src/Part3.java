
public class Part3 {
	public static boolean twoOccurrences(String a, String b){
		int index = b.indexOf(a);
		
		if(index == -1)
			return false;
		
		b = b.substring(index + a.length(), b.length());
		
		index = b.indexOf(a);
		if(index == -1)
			return false;
		
		return true;
	}
	
	public static String lastPart(String a, String b){
		int index = b.indexOf(a);
		if(index == -1)
			return b;
		
		return (b.substring(index + a.length(), b.length()));
	}
	
	public static void testing(){
		String a,b;
		
		a = "by";
		b = "A story by Abby Long";
		
		if(twoOccurrences(a,b))
			System.out.println("true");
		else
			System.out.println("false");
		
		a = "ab";
		b ="abcd";
		
		if(twoOccurrences(a,b))
			System.out.println("true");
		else
			System.out.println("false");
		
		a = "ab";
		b = "cccccc";
		
		if(twoOccurrences(a,b))
			System.out.println("true");
		else
			System.out.println("false");
		
		a = "an";
		b = "banana";
		System.out.println(lastPart(a,b));
		
		a = "zoo";
		b = "forest";
		System.out.println(lastPart(a,b));
		
	}
	
	public static void main(String[] args){
		testing();
	}
}
