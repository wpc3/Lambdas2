package org.example;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class personTest {

    private List<Person> roster;

    @Before
    public void setUp() {
        roster = new ArrayList<>();
        roster.add(new Person(34, "john@example.com", "John Doe", LocalDate.of(1990, 1, 15), Person.Sex.MALE));
        roster.add(new Person(39, "jane@example.com", "Jane Doe", LocalDate.of(1985, 5, 22), Person.Sex.FEMALE));
        roster.add(new Person(24, "alice@example.com", "Alice Smith", LocalDate.of(2000, 3, 12), Person.Sex.FEMALE));
    }

    @Test
    public void testCheckPersonAge() {
        // Local class CheckPersonAge
        Person.CheckPersonAge ageCriteria = new Person.CheckPersonAge(30);

        // Capture the output
        List<String> printedPersons = new ArrayList<>();
        System.setOut(new java.io.PrintStream(new java.io.OutputStream() {
            @Override
            public void write(int b) {
                printedPersons.add(String.valueOf((char) b));
            }
        }));

        Person.printPersons(roster, ageCriteria);

        // Convert the list to a single string for easier assertion
        String printedOutput = String.join("", printedPersons);

        // Check that the expected output is present
        assertTrue(printedOutput.contains("John Doe 34 MALE 1990-01-15 john@example.com"));
        assertTrue(printedOutput.contains("Jane Doe 39 FEMALE 1985-05-22 jane@example.com"));
        assertFalse(printedOutput.contains("Alice Smith 24 FEMALE 2000-03-12 alice@example.com"));
    }

}
