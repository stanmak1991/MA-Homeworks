package Homework10;

import java.lang.Double;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode() {
        return (int) (Double.hashCode(re) + Double.hashCode(im) * 31);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != ComplexNumber.class) {
            return false;
        }
        if (Double.compare(re, ((ComplexNumber) obj).re) == 0 && Double.compare(im, ((ComplexNumber) obj).im) == 0) {
            return true;
        }
        return false;
    }
}