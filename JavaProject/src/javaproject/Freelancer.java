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
public class Freelancer implements Serializable{
         protected int freenacerID, orderID;

    public Freelancer(int freenacerID, int orderID) {
        this.freenacerID = freenacerID;
        this.orderID = orderID;
    }

    public int getFreenacerID() {
        return freenacerID;
    }

    public void setFreenacerID(int freenacerID) {
        this.freenacerID = freenacerID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
   
}
