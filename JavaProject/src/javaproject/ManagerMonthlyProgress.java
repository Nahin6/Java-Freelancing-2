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
public class ManagerMonthlyProgress implements Serializable {

    protected String Month;
    protected int CusReg, FreelancerReg, TotalInvestment, ordrGot, ordrDelivered;

    public ManagerMonthlyProgress(String Month, int CusReg, int FreelancerReg, int TotalInvestment, int ordrGot, int ordrDelivered) {
        this.Month = Month;
        this.CusReg = CusReg;
        this.FreelancerReg = FreelancerReg;
        this.TotalInvestment = TotalInvestment;
        this.ordrGot = ordrGot;
        this.ordrDelivered = ordrDelivered;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }

    public int getCusReg() {
        return CusReg;
    }

    public void setCusReg(int CusReg) {
        this.CusReg = CusReg;
    }

    public int getFreelancerReg() {
        return FreelancerReg;
    }

    public void setFreelancerReg(int FreelancerReg) {
        this.FreelancerReg = FreelancerReg;
    }

    public int getTotalInvestment() {
        return TotalInvestment;
    }

    public void setTotalInvestment(int TotalInvestment) {
        this.TotalInvestment = TotalInvestment;
    }

    public int getOrdrGot() {
        return ordrGot;
    }

    public void setOrdrGot(int ordrGot) {
        this.ordrGot = ordrGot;
    }

    public int getOrdrDelivered() {
        return ordrDelivered;
    }

    public void setOrdrDelivered(int ordrDelivered) {
        this.ordrDelivered = ordrDelivered;
    }
    
    

}

