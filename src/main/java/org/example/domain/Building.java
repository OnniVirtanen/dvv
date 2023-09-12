package org.example.domain;

import org.example.valueobject.building.*;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Building {

    private UUID id;
    private Person owner;
    private Location location;
    private SurfaceArea surfaceArea;
    private Set<Amenity> amenities;
    private PurposeOfUse purpose;
    private CompletionDate completionDate;

    public Building(UUID id, Person owner, Location location, SurfaceArea surfaceArea, Set<Amenity> amenities,
                    PurposeOfUse purpose, CompletionDate completionDate) {
        this.id = id;
        this.owner = owner;
        this.location = location;
        this.surfaceArea = surfaceArea;
        this.amenities = amenities;
        this.purpose = purpose;
        this.completionDate = completionDate;
    }

    public void transferOwnership(Person newOwner) {
        this.owner = newOwner;
    }

    public void addAmenity(Amenity amenity) {
        this.amenities.add(amenity);
    }

    public void removeAmenity(Amenity amenity) {
        this.amenities.remove(amenity);
    }

    public void updateLocation(Location newLocation) {
        this.location = newLocation;
    }

    public boolean isPurpose(PurposeOfUse.Type type) {
        return this.purpose.getType() == type;
    }

    public void updateSurfaceArea(SurfaceArea newSurfaceArea) {
        this.surfaceArea = newSurfaceArea;
    }

    public boolean hasAmenity(Amenity amenity) {
        return this.amenities.contains(amenity);
    }

    public void changePurpose(PurposeOfUse newPurpose) {
        this.purpose = newPurpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equals(id, building.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", owner=" + owner +
                ", location=" + location +
                ", surfaceArea=" + surfaceArea +
                ", amenities=" + amenities +
                ", purpose=" + purpose +
                ", completionDate=" + completionDate +
                '}';
    }
}
