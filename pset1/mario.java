
import java.util.Scanner;

/**
 * Created by Vince on 5/23/2014.
 */

public class Mario {
    static final int MAX_HEIGHT = 23;
    public static void main(String[] args){
//        PrintStream out = System.out;
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Mario world!");

        int h = -1;
        //validate
        do {
            System.out.print(String.format("Enter the pyramid's height (0-%s): ", MAX_HEIGHT));
            if(in.hasNextInt()){
                h = in.nextInt();
            } else{
                in.next();
            }
            in.nextLine();
        } while(h<0 || h>MAX_HEIGHT);

        System.out.println();

        StringBuffer layer = new StringBuffer();
        for(int i = 1; i < h; i++){
            layer.append(" ");
        }
        layer.append("##");
        for(int i = 1; i <= h; i++){
            System.out.println(layer.toString());
            if(i < h) {
                layer.replace(h-i-1, h-i, "#");
            }
        }

    }
}
