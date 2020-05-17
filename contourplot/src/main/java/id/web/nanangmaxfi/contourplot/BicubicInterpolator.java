package id.web.nanangmaxfi.contourplot;

public class BicubicInterpolator extends CubicInterpolator{
    private double[] arr = new double[4];

    public double getValue(double[][] p, double x, double y) {
        int xi = (int) x;

        x -= xi;

        arr[0] = getValue(p[Math.max(0, xi - 1)], y);
        arr[1] = getValue(p[xi], y);
        arr[2] = getValue(p[Math.min(p.length - 1, xi + 1)], y);
        arr[3] = getValue(p[Math.min(p.length - 1, xi + 2)], y);

        return getValue(arr, x + 1);
    }
}
