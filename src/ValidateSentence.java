import java.util.Scanner;



public class ValidateSentence {
    public static void main(String[] args) {
        menu();

    }
    public static void menu(){
        System.out.println("Please enter sentence you would like checked : ");
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        if(SentenceCheck.isValid(sentence)==true){
            System.out.println("Sentence is valid!");

        }else{
            System.out.println("Sentence is invalid!");
            System.out.println("Would you like to enter another sentence?(Y/N)");
            String input = scan.nextLine();



            if(input.contains("Y") || input.contains("y")){
                menu();
            }else{System.exit(0);}

        }

    }

}
