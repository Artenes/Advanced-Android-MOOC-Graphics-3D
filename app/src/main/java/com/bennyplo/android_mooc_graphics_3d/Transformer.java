package com.bennyplo.android_mooc_graphics_3d;

/**
 * Makes affine transformations on 3D objects.
 */
public class Transformer {

    /**
     * Moves an object.
     *
     * @param vertices the vertices of the object
     * @param tx       the x coordinate to move the object to
     * @param ty       the y coordinate to move the object to
     * @param tz       the z coordinate to move the object to
     * @return the new coordinates of the object
     */
    public Coordinate[] translate(Coordinate[] vertices, double tx, double ty, double tz) {
        double[] matrix = makeIdentityMatrix();
        matrix[3] = tx;
        matrix[7] = ty;
        matrix[11] = tz;
        return transform(vertices, matrix);
    }

    /**
     * Scales an object.
     *
     * @param vertices the vertices of the object
     * @param sx       the x coordinate to scale the object to
     * @param sy       the y coordinate to scale the object to
     * @param sz       the z coordinate to scale the object to
     * @return the new coordinates of the object
     */
    public Coordinate[] scale(Coordinate[] vertices, double sx, double sy, double sz) {
        double[] matrix = makeIdentityMatrix();
        matrix[0] = sx;
        matrix[5] = sy;
        matrix[10] = sz;
        return transform(vertices, matrix);
    }

    /**
     * Affine transforms an array of vertices (a 3D object) with the given transformation matrix.
     *
     * @param vertices the vertices to transform
     * @param matrix   the transformation matrix to apply
     * @return the resulting array of transformed coordinates
     */
    private Coordinate[] transform(Coordinate[] vertices, double[] matrix) {
        Coordinate[] result = new Coordinate[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            result[i] = transform(vertices[i], matrix);
            result[i].Normalise();
        }
        return result;
    }

    /**
     * Multiplies (affine transforms with homogeneous coordinates) a coordinate (x, y, z) with a
     * transformation matrix to perform some operation such as rotation, translation, etc.
     *
     * @param vertex the vertex to transform
     * @param matrix the transformation matrix to apply
     * @return the resulting transformed coordinate
     */
    private Coordinate transform(Coordinate vertex, double[] matrix) {
        Coordinate result = new Coordinate();
        result.x = matrix[0] * vertex.x + matrix[1] * vertex.y + matrix[2] * vertex.z + matrix[3];
        result.y = matrix[4] * vertex.x + matrix[5] * vertex.y + matrix[6] * vertex.z + matrix[7];
        result.z = matrix[8] * vertex.x + matrix[9] * vertex.y + matrix[10] * vertex.z + matrix[11];
        result.w =
                matrix[12] * vertex.x + matrix[13] * vertex.y + matrix[14] * vertex.z + matrix[15];
        return result;
    }

    /**
     * Returns a 4x4 identity matrix for calculations.
     * A new one needs to be created every time because its values are changed.
     *
     * @return a new identity matrix
     */
    private double[] makeIdentityMatrix() {
        return new double[]{1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
    }
}
