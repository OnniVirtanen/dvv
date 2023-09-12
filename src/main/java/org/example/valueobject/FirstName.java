package org.example.valueobject;

import java.util.Objects;

public final class FirstName {

    private final String value;

    public FirstName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
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
        FirstName firstName = (FirstName) o;
        return Objects.equals(value, firstName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "FirstName{" +
                "value='" + value + '\'' +
                '}';
    }
}
