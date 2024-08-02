package org.example2;

import org.example3.CheckPerson3;
import org.example3.Person3;

import java.time.LocalDate;
import java.util.List;

public class Person2 implements CheckPerson2{
    @Override
    public boolean test(Person2 p) {
        return false;
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender2;
    String emailAddress;
    Integer age;

    public Person2(Integer age,String emailAddress, String name, LocalDate birthday, Sex gender) {
        this.emailAddress = emailAddress;
        this.name = name;
        this.birthday = birthday;
        this.gender2 = gender;
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
        return gender2;
    }

    public void setGender(Sex gender) {
        this.gender2 = gender2;
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
        System.out.println(name + " " + age + " " + gender2 + " " + birthday + " " + emailAddress );

    }

    CheckPerson2 ageCriteria = new CheckPerson2() {
        @Override
        public boolean test(Person2 p) {
            return p.getAge() >= age;
        }
    };

//            p -> p.getAge() >= age;

//    static class CheckPersonAge implements CheckPerson3 {
//        private int age;
//
//        public CheckPersonAge(int age) {
//            this.age = age;
//        }
//
//
//
//
//
//
//        @Override
//        public boolean test(Person3 p) {
//            return false;
//        }
//    }







    public static void printPersons(
            List<Person2> roster, CheckPerson2 tester) {
        for (Person2 p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
