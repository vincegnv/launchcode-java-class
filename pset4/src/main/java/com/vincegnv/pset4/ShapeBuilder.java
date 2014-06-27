/**
 * Created by Vince on 6/11/2014.
 */

package com.vincegnv.pset4;

public class ShapeBuilder {

    private ShapeBuilder() {}

    public Pyramid pyramid(int height){
        return new Pyramid(height);
    }
}
