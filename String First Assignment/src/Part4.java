import edu.duke.URLResource;

public class Part4 {
    public static void main(String args[]){
        URLResource urlResource = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");

        for(String word : urlResource.words()){
            String lowerCase = word.toLowerCase();
            int index =  lowerCase.indexOf("youtube.com");
              if(index !=- 1){
                    int start = lowerCase.substring(0, index).lastIndexOf('\"');
                    int end = lowerCase.substring(index).indexOf('\"');
                    System.out.println(word.substring(start+1, index + end));
                }
        }
    }
}
