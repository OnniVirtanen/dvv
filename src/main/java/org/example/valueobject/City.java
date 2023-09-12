package org.example.valueobject;

import java.util.Objects;

public final class City {

    private final String value;

    public City(String value) {
        if (value == null) {
            throw new IllegalArgumentException("City cannot be null.");
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
        City city = (City) o;
        return Objects.equals(value, city.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "City{" +
                "value='" + value + '\'' +
                '}';
    }
}
