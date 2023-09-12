package org.example.valueobject.person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public final class DateOfDeath {

    private final LocalDate value;

    public DateOfDeath(LocalDate value, LocalDate dateOfBirth) {
        if (value == null) {
            throw new IllegalArgumentException("Date of death cannot be null.");
        }
        if (isDateInFuture(value)) {
            throw new IllegalArgumentException("Date of death cannot be in the future.");
        }
        if (dateOfBirth != null && !isAfterDateOfBirth(value, dateOfBirth)) {
            throw new IllegalArgumentException("Date of death cannot be before date of birth.");
        }
        if (isTooHistorical(value)) {
            throw new IllegalArgumentException("Date of death is too far in the past.");
        }

        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }

    private boolean isDateInFuture(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }

    private boolean isAfterDateOfBirth(LocalDate dateOfDeath, LocalDate dateOfBirth) {
        return !dateOfDeath.isBefore(dateOfBirth);
    }

    private boolean isTooHistorical(LocalDate date) {
        return Period.between(date, LocalDate.now()).getYears() > 200;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateOfDeath that = (DateOfDeath) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "DateOfDeath{" +
                "value=" + value +
                '}';
    }
}
