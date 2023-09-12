package org.example.valueobject;

import java.util.Objects;

public final class Street {

    private final String value;

    public Street(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Street cannot be null.");
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
        Street street = (Street) o;
        return Objects.equals(value, street.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Street{" +
                "value='" + value + '\'' +
                '}';
    }
}
