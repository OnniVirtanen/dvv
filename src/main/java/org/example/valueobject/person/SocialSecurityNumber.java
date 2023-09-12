package org.example.valueobject.person;

import java.util.Objects;

public final class SocialSecurityNumber {

    private final String value;

    public SocialSecurityNumber(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Social security number cannot be null or empty.");
        }

        // validate social security number with additional logic

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialSecurityNumber that = (SocialSecurityNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "SocialSecurityNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
