package com.kronae.ai.color;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

public class RGBA {
    private final short r;
    private final short g;
    private final short b;
    private final short a;

    public RGBA(@Range(from=0,to=255) int r, @Range(from=0,to=255) int g, @Range(from=0,to=255) int b, @Range(from=0,to=255) int a) {
        this.r = (short) r;
        this.g = (short) g;
        this.b = (short) b;
        this.a = (short) a;
    }

    public short getR() {
        return r;
    }
    public short getG() {
        return g;
    }
    public short getB() {
        return b;
    }
    public short getA() {
        return a;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        RGBA rgba = (RGBA) object;

        if (r != rgba.r) return false;
        if (g != rgba.g) return false;
        if (b != rgba.b) return false;
        return a == rgba.a;
    }

    @Override
    public int hashCode() {
        int result = r;
        result = 31 * result + (int) g;
        result = 31 * result + (int) b;
        result = 31 * result + (int) a;
        return result;
    }

    @Override
    public String toString() {
        return "RGBA{" +
                "r=" + r +
                ", g=" + g +
                ", b=" + b +
                ", a=" + a +
                '}';
    }
}
