package org.example.valueobject;

import java.util.Objects;

public final class Apartment {

    private final String value;

    public Apartment(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Apartment cannot be null.");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return Objects.equals(value, apartment.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "value='" + value + '\'' +
                '}';
    }
}
