import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


 public class Main {
     public static void main(String[] args) throws IOException {
                Scanner in = new Scanner(System.in);
                System.out.print("Введите путь к файлу: ");
                String way = in.nextLine();
                String str;
                String unitedStr = "";
                BufferedReader bufferedReader = new BufferedReader(new FileReader(way));
                while ((str = bufferedReader.readLine()) !=  null){
                    unitedStr = unitedStr  +  str + " " ;
                }
                System.out.println("Символов в тексте: " + (unitedStr.length() - 1));
                System.out.println("Символов в тексте без пробелов: " + unitedStr.replaceAll(" ", "").length());
                System.out.println("Слов в тексте: " + (unitedStr.split(" ").length));
                
                FileWriter writer = new FileWriter("Result.txt");
                writer.write("Символов в тексте: " + (unitedStr.length() - 1) +
                        "\n" + "Символов в тексте без пробелов: "
                        + unitedStr.replaceAll(" ", "").length() +
                        "\n" + "Слов в тексте: " +(unitedStr.split(" ").length));
                writer.flush();
    }
}