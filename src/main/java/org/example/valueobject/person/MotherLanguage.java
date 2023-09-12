package org.example.valueobject.person;

import java.util.Objects;

public final class MotherLanguage {

    private final String value;

    public MotherLanguage(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Mother language cannot be null.");
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
        MotherLanguage that = (MotherLanguage) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MotherLanguage{" +
                "value='" + value + '\'' +
                '}';
    }
}
