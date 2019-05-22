package stream.ue.objects;

import java.io.Serializable;

public class Person implements Serializable
{
    String firstName;
    String surName;
    int age;

    public Person(String firstName, String surName, int age)
    {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }
}
