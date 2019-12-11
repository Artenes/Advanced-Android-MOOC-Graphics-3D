package com.bennyplo.android_mooc_graphics_3d;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * A 3D shape.
 */
public class Shape3D {

    private final Transformer transformer;
    private Coordinate[] vertices;

    public Shape3D(Transformer transformer, Coordinate[] vertices) {
        this.transformer = transformer;
        this.vertices = vertices;
    }

    public Shape3D translate(double tx, double ty, double tz) {
        vertices = transformer.translate(vertices, tx, ty, tz);
        return this;
    }

    public Shape3D scale(double sx, double sy, double sz) {
        vertices = transformer.scale(vertices, sx, sy, sz);
        return this;
    }

    /**
     * Draw a line from a vertex to another.
     *
     * @param canvas the canvas to draw the line
     * @param start  the index of the starting vertex
     * @param end    the index of the ending vertex
     * @param paint  the paint to use
     */
    protected void drawLine(Canvas canvas, int start, int end, Paint paint) {
        canvas.drawLine(
                (int) vertices[start].x,
                (int) vertices[start].y,
                (int) vertices[end].x,
                (int) vertices[end].y,
                paint);
    }
}
