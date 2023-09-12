package org.example.valueobject.person;

import java.util.Objects;

public final class LastName {

    private final String value;

    public LastName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
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
        LastName lastName = (LastName) o;
        return Objects.equals(value, lastName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LastName{" +
                "value='" + value + '\'' +
                '}';
    }
}
