package org.example.valueobject;

import java.util.Objects;

public final class Coordinates {

    private final String x;
    private final String y;

    public Coordinates(String x, String y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Coordinates cannot be null.");
        }

        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}
