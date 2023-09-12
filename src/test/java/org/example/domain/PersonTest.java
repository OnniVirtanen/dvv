package org.example.domain;

import org.example.exception.AlreadyMarkedAsDeceasedException;
import org.example.valueobject.address.*;
import org.example.valueobject.person.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void isAlive_nullDeathDate_returnsTrue() {
        // Arrange
        Person person = createPerson();

        // Act
        boolean isAlive = person.isAlive();

        // Assert
        assertTrue(isAlive);
    }

    @Test
    void isAlive_withDeathDate_returnsFalse() {
        // Arrange
        Person person = createPerson();
        DateOfDeath dateOfDeath = new DateOfDeath(LocalDate.now());
        person.markAsDeceased(dateOfDeath);

        // Act
        boolean isAlive = person.isAlive();

        // Assert
        assertFalse(isAlive);
    }

    @Test
    void markDeceased_isNotAlive_throws() {
        // Arrange
        Person person = createPerson();
        DateOfDeath dateOfDeath = new DateOfDeath(LocalDate.now());
        person.markAsDeceased(dateOfDeath);

        // Act & Assert
        assertThrows(AlreadyMarkedAsDeceasedException.class, () -> person.markAsDeceased(dateOfDeath));
    }

    @Test
    void markDeceased_beforeBirth_throws() {
        // Arrange
        Person person = createPerson();
        DateOfBirth birthDate = person.getDateOfBirth();
        LocalDate dateBeforeBirth = birthDate.getValue().minusYears(5);
        DateOfDeath dateOfDeath = new DateOfDeath(dateBeforeBirth);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> person.markAsDeceased(dateOfDeath));
    }

    @Test
    void addRelationship_regularScenario_personHasRelationship() {
        // Arrange
        Person child = createPerson();
        Person father = createPerson();

        Relationship relationshipOfChild = new Relationship(UUID.randomUUID(), child, father,
                Relationship.RelationshipType.FATHER);

        Relationship relationshipOfFather = new Relationship(UUID.randomUUID(), father, child,
                Relationship.RelationshipType.CHILD);

        // Act
        child.addRelationship(relationshipOfChild);
        father.addRelationship(relationshipOfFather);

        // Assert
        assertTrue(child.getRelationships().contains(relationshipOfChild));
        assertTrue(father.getRelationships().contains(relationshipOfFather));

        assertEquals(Relationship.RelationshipType.FATHER, relationshipOfChild.getType());
        assertEquals(Relationship.RelationshipType.CHILD, relationshipOfFather.getType());
    }

    @Test
    void addNationality_newNationality_success() {
        // Arrange
        Person person = createPerson();
        Nationality newNationality = new Nationality("Swedish");

        // Act
        person.addNationality(newNationality);
        boolean hasNationality = person.hasNationality(newNationality);

        // Assert
        assertTrue(hasNationality);
    }

    @Test
    void addNationality_addSameNationality_throws() {
        // Arrange
        Person person = createPerson();
        Nationality newNationality = new Nationality("Swedish");

        // Act
        person.addNationality(newNationality);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> person.addNationality(newNationality));
    }

    @Test
    void socialSecurityNumberConstructor_validSSN_doesNotThrow() {
        // Arrange
        String validSSN = "123456X1234";

        // Act & Assert
        assertDoesNotThrow(() -> new SocialSecurityNumber(validSSN));
    }

    @Test
    void socialSecurityNumberConstructor_InvalidSSN_throws() {
        // Arrange
        String invalidSSN = "1234567890";

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new SocialSecurityNumber(invalidSSN));
    }

    private Address createAddress() {
        return new Address(
                UUID.randomUUID(),
                new Street("Kauppakatu 1"),
                new Apartment("A 2"),
                new PostalCode("40500"),
                new City("Helsinki"),
                new Country("Finland")
        );
    }

    private Person createPerson() {
        UUID id = UUID.randomUUID();
        SocialSecurityNumber ssn = generateRandomSSN();
        FirstName firstName = generateRandomFirstName();
        LastName lastName = generateRandomLastName();
        DateOfBirth dob = generateRandomDateOfBirth();
        Address address = createAddress();
        MotherLanguage motherLanguage = new MotherLanguage("Finnish");
        Set<Relationship> relationships = new HashSet<>();
        Set<Nationality> nationalities = new HashSet<>(Set.of(new Nationality("Finnish")));

        Person person = new Person(id, ssn, firstName, lastName, dob, null, address, motherLanguage,
                relationships, nationalities);

        return person;
    }

    private DateOfBirth generateRandomDateOfBirth() {
        int years = 120;
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusYears(years);

        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = today.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

        LocalDate randomDate = LocalDate.ofEpochDay(randomEpochDay);
        return new DateOfBirth(randomDate);
    }

    private SocialSecurityNumber generateRandomSSN() {
        Random rand = new Random();
        String value = String.format("%06dX%04d", rand.nextInt(1000000), rand.nextInt(10000));
        return new SocialSecurityNumber(value);
    }

    private FirstName generateRandomFirstName() {
        String[] firstNames = {"John", "Jane", "Markku", "Ella", "Sara", "Mike", "Peter", "Anna", "Sam", "Mary"};
        String firstName = firstNames[new Random().nextInt(firstNames.length)];
        return new FirstName(firstName);
    }

    private LastName generateRandomLastName() {
        String[] lastNames = {"Smith", "Doe", "Lehtinen", "Järvinen", "Korhonen", "Virtanen", "Mäkinen", "Niemi",
                "Heikkinen", "Koskinen"};
        String lastName = lastNames[new Random().nextInt(lastNames.length)];
        return new LastName(lastName);
    }
}