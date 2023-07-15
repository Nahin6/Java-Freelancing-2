/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class CustomerCare implements Serializable {
        protected int salary;
        protected String WorkHour;

    public CustomerCare(int salary, String WorkHour) {
        this.salary = salary;
        this.WorkHour = WorkHour;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkHour() {
        return WorkHour;
    }

    public void setWorkHour(String WorkHour) {
        this.WorkHour = WorkHour;
    }
        
        
}
