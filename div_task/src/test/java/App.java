import java.util.Scanner;

public class App {
    public static float input() {
        Scanner input = new Scanner(System.in);

        float x = input.nextInt();
        if (x!=0){
            System.out.println(1/x);
            return(1/x);
        }else {
            System.out.println("Wrong value!");
            return(x);
        }
    }
}
