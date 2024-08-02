package org.example3;

import org.example2.CheckPerson2;
import org.example2.Person3;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class person3Test {
    private List<Person4> roster;
    private Integer age;

    @Before
    public void setup(){
        roster = new ArrayList<>();
        roster.add(new Person4(28,"williamC@aol.com","Will", LocalDate.of(1995,12,1), Person4.Sex.MALE));
        roster.add(new Person4(34, "john@example.com", "John Doe", LocalDate.of(1990, 1, 15), Person4.Sex.MALE));
        roster.add(new Person4(39, "jane@example.com", "Jane Doe", LocalDate.of(1985, 5, 22), Person4.Sex.FEMALE));
        roster.add(new Person4(24, "alice@example.com", "Alice Smith", LocalDate.of(2000, 3, 12), Person4.Sex.FEMALE));
    }

    @Test
    public void testCheckPerson2(){

//        CheckPerson2 Bryan = new Person2(26,"badboy2@yahoo.com","Bryan", LocalDate.of(1997,12,1),Person2.Sex.MALE);

       CheckPerson3 Bryan = x -> x.getAge()>=26;

        // Capture the output
        List<String> printedPersons = new ArrayList<>();
        System.setOut(new java.io.PrintStream(new java.io.OutputStream() {
            @Override
            public void write(int b) {
                printedPersons.add(String.valueOf((char) b));
            }
        }));

        Person4.printPersons(roster,Bryan);

        String printedOutput = String.join("",printedPersons);

        assertTrue(printedOutput.contains("Will 28 MALE 1995-12-01 williamC@aol.com"));
        assertTrue(printedOutput.contains("Jane Doe 39 FEMALE 1985-05-22 jane@example.com"));
        assertFalse(printedOutput.contains("Alice Smith 24 FEMALE 2000-03-12 alice@example.com"));

    }
}
