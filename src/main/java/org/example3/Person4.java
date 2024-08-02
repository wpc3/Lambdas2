package org.example3;

import java.time.LocalDate;
import java.util.List;

public class Person4 implements CheckPerson3 {



    @Override
    public boolean test(Person4 p) {
        return false;
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender3;
    String emailAddress;
    Integer age;

    public Person4(Integer age,String emailAddress, String name, LocalDate birthday, Sex gender) {
        this.emailAddress = emailAddress;
        this.name = name;
        this.birthday = birthday;
        this.gender3 = gender;
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
        return gender3;
    }

    public void setGender(Sex gender) {
        this.gender3 = gender3;
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
        System.out.println(name + " " + age + " " + gender3 + " " + birthday + " " + emailAddress );

    }

    CheckPerson3 ageCriteria = p -> p.getAge() >= age;

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
            List<Person4> roster, CheckPerson3 tester) {
        for (Person4 p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }
}
