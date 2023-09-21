/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class Order {

    private int id;
    private String Name;
    private int quanlity;
    private double price;

    public Order() {
    }

    public Order(int id, String Name, int quanlity, double price) {
        this.id = id;
        this.Name = Name;
        this.quanlity = quanlity;
        this.price = price;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the quanlity
     */
    public int getQuanlity() {
        return quanlity;
    }

    /**
     * @param quanlity the quanlity to set
     */
    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}