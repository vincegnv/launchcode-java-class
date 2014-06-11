import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Vince on 5/26/2014.
 */

public class Pyramid implements PrintedShape{


    private int height;
    private String pyramid;

    public Pyramid(int height) {
        this.height = height;
        this.pyramid = this.draw();
    }

    public int getHeight() {
        return height;
    }

    public String draw(){
        //prepare the pyramid
        int height = this.height;
        StringBuffer layer = new StringBuffer();
        StringBuffer pyramid = new StringBuffer();
        //prepare the top layer
        for(int i = 1; i < height; i++){
            layer.append(" ");
        }
        layer.append("##");
        for(int i = 1; i <= height; i++){
            pyramid.append(layer);
            pyramid.append("\n");
            //prepare the next layer
            if(i < height) {
                layer.replace(height-i-1, height-i, "#");
            }
        }
        return pyramid.toString();
    }

    @Override
    public String toString(){
        return this.pyramid;
    }

}
