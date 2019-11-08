/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltestkientruc;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Quynh Tran Ly
 */
public class Order implements IOrder{

    private int id;
    private LocalDate date;
    private String name;
    private String address;
    private int cId;
    
    ArrayList<Product> pro = new ArrayList<>();

    public Order() {
    }

    public Order(int id, LocalDate date, String name, String address, int cId) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.address = address;
        this.cId = cId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public ArrayList<Product> getPro() {
        return pro;
    }

    public void setPro(ArrayList<Product> pro) {
        this.pro = pro;
    }

    @Override
    public void shippingFee(ArrayList<Product> lp) {
        
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", date=" + date + ", name=" + name + ", address=" + address + ", cId=" + cId + ", pro=" + pro + '}';
    }
    

    
    
    

}