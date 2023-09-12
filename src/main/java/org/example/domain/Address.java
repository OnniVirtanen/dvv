package org.example.domain;

import org.example.valueobject.address.*;

import java.util.Objects;
import java.util.UUID;

public class Address {

    private UUID id;
    private Street street;
    private Apartment apartment;
    private PostalCode postalCode;
    private City city;
    private Country country;

    public Address(UUID id, Street street, Apartment apartment, PostalCode postalCode, City city, Country country) {
        this.id = id;
        this.street = street;
        this.apartment = apartment;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public String formatFullAddress() {
        return street + ", " + city + ", " + postalCode + ", " + country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street=" + street +
                ", apartment=" + apartment +
                ", postalCode=" + postalCode +
                ", city=" + city +
                ", country=" + country +
                '}';
    }
}
