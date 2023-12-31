package org.example.domain;
import org.example.exception.AlreadyMarkedAsDeceasedException;
import org.example.valueobject.person.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Person {

    private UUID id;
    private SocialSecurityNumber socialSecurityNumber;
    private FirstName firstName;
    private LastName lastName;
    private DateOfBirth dateOfBirth;
    private DateOfDeath dateOfDeath;
    private Address address;
    private MotherLanguage motherLanguage;
    private Set<Relationship> relationships;
    private Set<Nationality> nationalities;

    public Person(UUID id, SocialSecurityNumber socialSecurityNumber, FirstName firstName, LastName lastName,
                  DateOfBirth dateOfBirth, DateOfDeath dateOfDeath, Address address,
                  MotherLanguage motherLanguage, Set<Relationship> relationships, Set<Nationality> nationalities) {
        this.id = id;
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.address = address;
        this.motherLanguage = motherLanguage;
        this.relationships = relationships;
        this.nationalities = nationalities;
    }

    public UUID getId() {
        return id;
    }

    public boolean isAlive() {
        return dateOfDeath == null;
    }

    public void markAsDeceased(DateOfDeath dateOfDeath) {
        if (this.dateOfDeath != null) {
            throw new AlreadyMarkedAsDeceasedException("This person has already been marked as deceased.");
        }
        if (isBeforeDateOfBirth(dateOfDeath.getValue())) {
            throw new IllegalArgumentException("Date of death cannot be before date of birth.");
        }

        this.dateOfDeath = dateOfDeath;
    }

    private boolean isBeforeDateOfBirth(LocalDate dateOfDeath) {
        return dateOfDeath.isBefore(dateOfBirth.getValue());
    }

    public void addRelationship(Relationship relationship) {
        this.relationships.add(relationship);
    }

    public void removeRelationship(Relationship relationship) {
        this.relationships.remove(relationship);
    }

    public void move(Address newAddress) {
        this.address = newAddress;
    }

    public void addNationality(Nationality nationality) {
        if (this.nationalities.contains(nationality)) {
            throw new IllegalArgumentException("Person already has the nationality.");
        }

        this.nationalities.add(nationality);
    }

    public void assignNewSocialSecurityNumber(SocialSecurityNumber socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Set<Relationship> getRelationships() {
        return Collections.unmodifiableSet(relationships);
    }

    public boolean hasNationality(Nationality nationality) {
        return this.nationalities.contains(nationality);
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
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
