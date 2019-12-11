package com.bennyplo.android_mooc_graphics_3d;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * A cube.
 */
public class Cube extends Shape3D {

    public Cube(Transformer transformer) {
        super(transformer, new Coordinate[]{
                new Coordinate(-1, -1, -1, 1),
                new Coordinate(-1, -1, 1, 1),
                new Coordinate(-1, 1, -1, 1),
                new Coordinate(-1, 1, 1, 1),
                new Coordinate(1, -1, -1, 1),
                new Coordinate(1, -1, 1, 1),
                new Coordinate(1, 1, -1, 1),
                new Coordinate(1, 1, 1, 1)
        });
        translate(2, 2, 0).scale(40, 40, 0);
    }

    public void draw(Canvas canvas, Paint paint) {
        drawLine(canvas, 0, 1, paint);
        drawLine(canvas, 1, 3, paint);
        drawLine(canvas, 3, 2, paint);
        drawLine(canvas, 2, 0, paint);
        drawLine(canvas, 4, 5, paint);
        drawLine(canvas, 5, 7, paint);
        drawLine(canvas, 7, 6, paint);
        drawLine(canvas, 6, 4, paint);
        drawLine(canvas, 0, 4, paint);
        drawLine(canvas, 1, 5, paint);
        drawLine(canvas, 2, 6, paint);
        drawLine(canvas, 3, 7, paint);
    }
}
