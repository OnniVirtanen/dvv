package org.example.valueobject.building;

import java.util.Objects;

public final class SurfaceArea {

    private final int value;

    public SurfaceArea(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Surface area cannot be negative or 0.");
        }

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurfaceArea that = (SurfaceArea) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "SurfaceArea{" +
                "value=" + value +
                '}';
    }
}
