package org.example.valueobject;

import java.util.Objects;

public final class Nationality {

    private final String value;

    public Nationality(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Nationality cannot be null.");
        }

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nationality that = (Nationality) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Nationality{" +
                "value='" + value + '\'' +
                '}';
    }
}
