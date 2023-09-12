package org.example.valueobject;

import java.time.LocalDate;
import java.util.Objects;

public final class CompletionDate {

    private final LocalDate date;

    public CompletionDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }

        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompletionDate that = (CompletionDate) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public String toString() {
        return "CompletionDate{" +
                "date=" + date +
                '}';
    }
}
