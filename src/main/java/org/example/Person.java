package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person implements CheckPerson {


    @Override
    public boolean test(Person p) {
        return false;
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    Integer age;

    public Person(Integer age,String emailAddress, String name, LocalDate birthday, Sex gender) {
        this.emailAddress = emailAddress;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.age=age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void printPerson() {
        System.out.println(name + " " + age + " " + gender + " " + birthday + " " + emailAddress );

    }

    static class CheckPersonAge implements CheckPerson{
        private int age;

        public CheckPersonAge(int age) {
            this.age = age;
        }

        @Override
        public boolean test(Person p) {



            return p.getAge() > age;
        }


    }







    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

}
