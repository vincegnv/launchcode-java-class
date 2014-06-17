/**
 * Created by Vince on 5/28/2014.
 */
public class ConsolePrinter implements ShapePrinter {

    private static ConsolePrinter consolePrinter;

    private ConsolePrinter(){
    }

    public static ConsolePrinter getInstance(){
        if(consolePrinter == null){
            consolePrinter = new ConsolePrinter();
        }
        return consolePrinter;
    }

    public void print(PrintedShape shape){
        System.out.print(shape);
    }
}
