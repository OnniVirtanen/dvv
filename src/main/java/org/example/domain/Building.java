package org.example.domain;

import org.example.valueobject.*;

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
}
