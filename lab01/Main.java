import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static int count=0;
    public static int menu( String data, String[] result,ArrayList words){
        System.out.println("-----------------Menu:-------------\n" +
                "a. Data input;\n" +
                "b. View data;\n" +
                "c. Calculations;\n" +
                "d. Result;\n" +
                "e. End of Program;\n" +
                "-h Help\n" +
                "-d Debug\n" +
                "-------------------------------\n");
        Scanner scan= new Scanner(System.in);
        String choice= scan.nextLine();
        if(choice.equals("a")){
            data = a(data);
        }
        else if(choice.equals("b")){
            b(data);
        }
        else if(choice.equals("c")){
            result = c(data,result,words);
        }
        else if(choice.equals("d")){
            d(result);
        }
        else if(choice.equals("e")) {
            e();
        }
        else if(choice.equals("-h")){
            Help.help();
        }
        else if(choice.equals("-d")){
            Debug.debug(data,words);
        }
        else{
            System.out.println("Wrong input! Try again.");
            menu(data,result,words);
        }
        return menu(data,result,words);
    }
    public static String a( String str){
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        return str;
    }
    public static void b(String str){
        if( str != null){
            System.out.println("Your input:");
            System.out.println(str);
        }
        else{
            System.out.println("There is no data.");
        }
    }
    public static  String[] c(String str, String[] result, ArrayList<String> words) {
        if(str!=null){
        int counter=0,wordStart=0;
        boolean word = false;
            while (counter != str.length()) {
                if ((Character.isDigit(str.charAt(counter)) ||
                        Character.isAlphabetic(str.charAt(counter))) && !word) {
                    wordStart = counter;
                    word = true;
                }
                else if (!Character.isDigit(str.charAt(counter)) &&
                        !Character.isAlphabetic(str.charAt(counter)) && word) {
                    words.add(str.substring(wordStart, counter));
                    word = false;
                }
                counter++;
            }
            System.out.println("Done!");
        }
        else{
            System.out.println("Error. Put data first.");
        }
        for(int i=0;i<words.size();i++){
           int length = words.get(i).length();
                if(words.get(i).charAt(0) == words.get(i).charAt(length-1)){
                    result[count]=words.get(i);
                    count++;
                }

        }

        return result;
    }
    public static void d(String[] result){
        System.out.println("Result:");
        for (int j = 0; j < count;j++)
        {
            System.out.println(result[j]);
        }
    }
    public static void e(){
        System.out.println("Bye-bye!");
        System.exit(0);
    }

    public static void main(String[] args) {
        String data = new String();
        ArrayList<String> words = new ArrayList<>();
        String[] result = new String[1000];
        menu(data,result,words);

    }

}
