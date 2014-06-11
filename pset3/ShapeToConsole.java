/**
 * Created by Vince on 5/28/2014.
 */
public class ShapeToConsole implements ShapePrinter{

    public ShapeToConsole(){
    }

    public void print(PrintedShape shape){
        System.out.print(shape);
    }
}
