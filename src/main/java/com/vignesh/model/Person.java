package com.vignesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table
public class Person {
    @Id
//defining id as column name
    @Column
    private int id;
    //defining first_name as column name
    @Column
    private String first_name;
    //defining last_name as column name
    @Column
    private String last_name;
    //defining age as column name
    @Column
    private int age;
    //defining favourite_color as column name
    @Column
    private String favourite_color;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getFirst_name()
    {
        return first_name;
    }
    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }
    public String getLast_name()
    {
        return last_name;
    }
    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getFavourite_color()
    {
        return favourite_color;
    }
    public void setFavourite_color(String favourite_color)
    {
        this.favourite_color = favourite_color;
    }
}
