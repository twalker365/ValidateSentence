import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceCheck {

    public static boolean isValid(String sentence) {
        boolean sentenceValid = false;
        //Makes sure input is not null and checks if all conditions are met
        if (sentence != null && !sentence.equals("")) {
            String trimSentence = sentence.trim();
            if ( isFirstCharacterUppercase(trimSentence) == true
                    && isNumberOfQuotationMarksEven(trimSentence) == true
                    && onlyPeriodAtEnd(trimSentence) == true
                    && lowestNumberBiggerThen13(trimSentence) == true)
            {
                sentenceValid = true;
            }


        } else {
            System.out.println("Please enter valid sentence! ");
            ValidateSentence.menu();
        }

        return sentenceValid;
    }
    //Method to count how many of the desired value is in the String - used in other methods
    private static int characterCount(String sentence, Character value) {
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if (c == value) {
                count++;
            }
        }
        return count;
    }
    //Returns true if the first character is uppercase
    private static boolean isFirstCharacterUppercase(String sentence){
        return Character.isUpperCase(sentence.charAt(0));
    }
    // Uses % to see if number of quotation marks is even as no remainder
    private static boolean isNumberOfQuotationMarksEven(String sentence){
        if(characterCount(sentence,'"')%2 ==0){
            return true;
    }
        return false;
    }
    // Uses characterCount method to make sure there is only one in a sentence and it is at end
    private static boolean onlyPeriodAtEnd(String sentence){
        if (sentence.charAt(sentence.length() - 1) == '.' && characterCount(sentence,'.') == 1){
            return true;
        } else if (sentence.charAt(sentence.length() - 1) == '!' && characterCount(sentence,'!') == 1) {
            return true;
        } else if (sentence.charAt(sentence.length() - 1) == '?' && characterCount(sentence,'?') == 1) {
            return true;
        }
        return false;
    }
    // Uses regex to extract numbers within String and compares to minNumber of 13
    private static boolean lowestNumberBiggerThen13(String sentence){
        int minNumber = 13;
        Pattern p = Pattern.compile("-?[0-9]+");
        Matcher m = p.matcher(sentence);
        while (m.find()) {
            int number = Integer.parseInt(m.group());

            if(number>minNumber){
                return true;

            }
        }

        return false;
    }
}
