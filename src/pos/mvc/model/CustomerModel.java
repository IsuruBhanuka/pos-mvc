/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.model;


/**
 *
 * @author BHANUKA
 */
public class CustomerModel {
    
    private String custID;
    private String custTitle;
    private String custName;
    private String custDOB;
    private String custAddress;
    private Double custSalary;
    private String custCity;
    private String custProvince;
    private String custZip;

    public CustomerModel() {
    }

    public CustomerModel(String custID, String custTitle, String custName, String custDOB, String custAddress, Double custSalary, String custCity, String custProvince, String custZip) {
        this.custID = custID;
        this.custTitle = custTitle;
        this.custName = custName;
        this.custDOB = custDOB;
        this.custAddress = custAddress;
        this.custSalary = custSalary;
        this.custCity = custCity;
        this.custProvince = custProvince;
        this.custZip = custZip;
    } 

    /**
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * @return the custTitle
     */
    public String getCustTitle() {
        return custTitle;
    }

    /**
     * @param custTitle the custTitle to set
     */
    public void setCustTitle(String custTitle) {
        this.custTitle = custTitle;
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the custDOB
     */
    public String getCustDOB() {
        return custDOB;
    }

    /**
     * @param custDOB the custDOB to set
     */
    public void setCustDOB(String custDOB) {
        this.custDOB = custDOB;
    }

    /**
     * @return the custAddress
     */
    public String getCustAddress() {
        return custAddress;
    }

    /**
     * @param custAddress the custAddress to set
     */
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    /**
     * @return the custSalary
     */
    public Double getCustSalary() {
        return custSalary;
    }

    /**
     * @param custSalary the custSalary to set
     */
    public void setCustSalary(Double custSalary) {
        this.custSalary = custSalary;
    }

    /**
     * @return the custCity
     */
    public String getCustCity() {
        return custCity;
    }

    /**
     * @param custCity the custCity to set
     */
    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    /**
     * @return the custProvince
     */
    public String getCustProvince() {
        return custProvince;
    }

    /**
     * @param custProvince the custProvince to set
     */
    public void setCustProvince(String custProvince) {
        this.custProvince = custProvince;
    }

    /**
     * @return the custZip
     */
    public String getCustZip() {
        return custZip;
    }

    /**
     * @param custZip the custZip to set
     */
    public void setCustZip(String custZip) {
        this.custZip = custZip;
    }

    @Override
    public String toString() {
        return "CustomerModel{" + "custID=" + custID + ", custTitle=" + custTitle + ", custName=" + custName + ", custDOB=" + custDOB + ", custAddress=" + custAddress + ", custSalary=" + custSalary + ", custCity=" + custCity + ", custProvince=" + custProvince + ", custZip=" + custZip + '}';
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                            
            
} 
