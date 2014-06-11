import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Vince on 5/28/2014.
 */
public class ShapeToFile implements ShapePrinter{
    private String fileName;

    public ShapeToFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void print(PrintedShape shape) {
        BufferedWriter bw = null;
        try {
            File file = new File(fileName);
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(shape.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null)
                try {
                    bw.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
        }
    }
}
