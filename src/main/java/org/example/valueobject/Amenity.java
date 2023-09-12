package org.example.valueobject;

public final class Amenity {

    private final Type type;

    public Amenity(Type type) {
        if (type == null) {
            throw new IllegalArgumentException("Amenity cannot be null.");
        }
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        SWIMMING_POOL,
        GYM,
        PARKING,
        SECURITY_SYSTEM,
        ROOFTOP_TERRACE,
        ELEVATOR,
        LOBBY,
        LOUNGE_AREA,
        PLAY_AREA,
        GARDEN,
        CONFERENCE_ROOM,
        WIFI,
        LAUNDRY_ROOM,
        PET_FRIENDLY_AREA,
        BIKE_STORAGE,
        CAFE,
        MOVIE_THEATER,
        BUSINESS_CENTER,
        LIBRARY,
        SAUNA,
        OTHER;
    }
}
