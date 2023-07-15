/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class User implements Serializable{
    
    protected int id;  
    protected String name,gender,adresses;
    protected LocalDate joindate;

    public User(int id, String name, String gender, String adresses, LocalDate joindate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.adresses = adresses;
        this.joindate = joindate;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdresses() {
        return adresses;
    }

    public void setAdresses(String adresses) {
        this.adresses = adresses;
    }

    public LocalDate getJoindate() {
        return joindate;
    }

    public void setJoindate(LocalDate joindate) {
        this.joindate = joindate;
    }
    
    
}
