package org.example.valueobject.building;

import org.example.domain.Address;

import java.util.Objects;

public final class Location {

    private final Address address;
    private final Coordinates coordinates;

    public Location(Address address, Coordinates coordinates) {
        if (address == null || coordinates == null) {
            throw new IllegalArgumentException("A location must have address and coordinates. Neither can be null.");
        }

        this.address = address;
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(address, location.address) && Objects.equals(coordinates, location.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, coordinates);
    }

    @Override
    public String toString() {
        return "Location{" +
                "address=" + address +
                ", coordinates=" + coordinates +
                '}';
    }
}
