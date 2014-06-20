/**
 * Created by Vince on 6/11/2014.
 */

package com.vincegnv.pset4;

public class ShapeBuilder {

    private static ShapeBuilder shapeBuilder;

    private ShapeBuilder() {
    }

    public static ShapeBuilder getInstance(){
        if(shapeBuilder == null){
            shapeBuilder = new ShapeBuilder();
        }
        return shapeBuilder;
    }

    public Pyramid pyramid(int height){
        return new Pyramid(height);
    }
}
