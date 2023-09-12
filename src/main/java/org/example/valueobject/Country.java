package org.example.valueobject;

import java.util.Objects;

public final class Country {

    private final String value;

    public Country(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(value, country.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Country{" +
                "value='" + value + '\'' +
                '}';
    }
}
