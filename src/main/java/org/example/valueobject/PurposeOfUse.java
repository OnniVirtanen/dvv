package org.example.valueobject;

import java.util.Objects;

public class PurposeOfUse {

    private final Type type;

    public PurposeOfUse(Type type) {
        if (type == null) {
            throw new IllegalArgumentException("PurposeOfUse cannot be null.");
        }
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurposeOfUse that = (PurposeOfUse) o;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "PurposeOfUse{" +
                "type=" + type +
                '}';
    }

    public enum Type {
        RESIDENTIAL,
        COMMERCIAL,
        INDUSTRIAL,
        AGRICULTURAL,
        RECREATIONAL,
        EDUCATIONAL,
        HEALTHCARE,
        GOVERNMENTAL,
        RELIGIOUS,
        PARKING,
        STORAGE,
        MIXED_USE,
        RETAIL,
        OFFICE_SPACE,
        HOSPITALITY,  // Hotels, motels, etc.
        CULTURAL,     // Museums, galleries, etc.
        SPORTS,       // Stadiums, sports facilities, etc.
        TRANSPORT,    // Train stations, airports, etc.
        OTHER;
    }
}
