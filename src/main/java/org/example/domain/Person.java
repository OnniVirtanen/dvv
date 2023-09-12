package org.example.domain;
import org.example.valueobject.*;

import java.util.Objects;
import java.util.Set;

public class Person {
    private ID id;
    private SocialSecurityNumber socialSecurityNumber;
    private FirstName firstName;
    private LastName lastName;
    private DateOfBirth dateOfBirth;
    private DateOfDeath dateOfDeath;
    private Set<Address> addresses;
    private MotherLanguage motherLanguage;
    private Set<Relationship> relationships;
    private Set<Nationality> nationalities;

    public Person(ID id, SocialSecurityNumber socialSecurityNumber, FirstName firstName, LastName lastName,
                  DateOfBirth dateOfBirth, DateOfDeath dateOfDeath, Set<Address> addresses,
                  MotherLanguage motherLanguage, Set<Relationship> relationships, Set<Nationality> nationalities) {
        this.id = id;
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.addresses = addresses;
        this.motherLanguage = motherLanguage;
        this.relationships = relationships;
        this.nationalities = nationalities;
    }

    public boolean isAlive() {
        return dateOfDeath == null;
    }

    public void markAsDeceased(DateOfDeath dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void addRelationship(Relationship relationship) {
        this.relationships.add(relationship);
    }

    public void removeRelationship(Relationship relationship) {
        this.relationships.remove(relationship);
    }

    public void move(Address newAddress) {
        // check later
        this.addresses.add(newAddress);
    }

    public void addNationality(Nationality nationality) {
        this.nationalities.add(nationality);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                '}';
    }
}
