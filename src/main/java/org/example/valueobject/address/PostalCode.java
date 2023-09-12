package org.example.valueobject.address;

import java.util.Objects;

public final class PostalCode {

    private final String value;

    public PostalCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalCode that = (PostalCode) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PostalCode{" +
                "value='" + value + '\'' +
                '}';
    }
}
