/**
 * a class test the pots panel and its frame
 * author: Miray Ayerdem
 * version : 25/11/2020
 */
import java.util.Scanner;
public class Test {
    public static void main(String[] args)
    {
        MyFrame frame;
        Scanner in = new Scanner(System.in);
        System.out.println("Please insert the dimension of the pot luck game: ");
        int input = in.nextInt();
        frame = new MyFrame(input);




    }
}
