package org.example.domain;

import java.util.Objects;
import java.util.UUID;

public class Relationship {

    private UUID id;
    private Person sourcePerson;
    private Person targetPerson;
    private RelationshipType type;

    public Relationship(UUID id, Person sourcePerson, Person targetPerson, RelationshipType type) {
        this.id = id;
        this.sourcePerson = sourcePerson;
        this.targetPerson = targetPerson;
        this.type = type;
    }

    public void changeRelationshipType(RelationshipType type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public Person getSourcePerson() {
        return sourcePerson;
    }

    public Person getTargetPerson() {
        return targetPerson;
    }

    public RelationshipType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relationship that = (Relationship) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id=" + id +
                ", sourcePerson=" + sourcePerson +
                ", targetPerson=" + targetPerson +
                ", type=" + type +
                '}';
    }

    public enum RelationshipType {
        FATHER,
        MOTHER,
        SIBLING,
        CHILD,
        GRANDPARENT,
        GRANDCHILD,
        AUNT,
        UNCLE,
        NIECE,
        NEPHEW,
        COUSIN,
        SPOUSE,
        PARTNER,
        OTHER
    }
}
