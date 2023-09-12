package org.example.valueobject;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public final class DateOfBirth {

    private final LocalDate value;

    public DateOfBirth(LocalDate value) {
        if (value == null) {
            throw new IllegalArgumentException("Date of birth cannot be null.");
        }
        if (isDateInFuture(value)) {
            throw new IllegalArgumentException("Date of birth cannot be in the future.");
        }
        if (isOver150YearsAgo(value)) {
            throw new IllegalArgumentException("Date of birth cannot be over 150 years ago.");
        }

        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }

    private boolean isDateInFuture(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }

    private boolean isOver150YearsAgo(LocalDate date) {
        return Period.between(date, LocalDate.now()).getYears() > 150;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateOfBirth that = (DateOfBirth) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "DateOfBirth{" +
                "value=" + value +
                '}';
    }
}
