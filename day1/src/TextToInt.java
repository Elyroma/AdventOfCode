import java.util.Arrays;
import java.util.HashMap;

public class TextToInt {
    private static final String[] TEXT = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String text;

    public TextToInt(String text){
        this.text = addIntValue(text);
    }

    private String addIntValue(String text){
        String tmp = "";
        String newText = "";
        for(String character : text.split("")){
            tmp += character;
            newText += character;
            for(String intInText : TEXT){
                if(tmp.contains(intInText)){
                    // on ajoute la valeur convertie
                    newText += Arrays.asList(TEXT).indexOf(intInText);
                    // remise à 0 du tmp
                    tmp = character;
                }
            }
        }
        return newText;
    }

    public String getText(){
        return this.text;
    }
    @Override
    public String toString(){
        return this.text;
    }
}
