/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Library;
import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import model.Order;
import view.Menu;

/**
 *
 * @author ACER
 */
public class FruitController extends Menu {

    static String[] mc = {"Create Fruit", "View Orders", "Shopping (for buyer)", "Exit"};
    Library l;
    ArrayList<Fruit> list_F;
    Hashtable<String, ArrayList<Order>> ht;

    public FruitController() {
        super("FRUIT SHOP SYSTEM", mc);
        l = new Library();
        list_F = new ArrayList<>();
        ht= new Hashtable<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createFruit();
                break;
            case 2:
                viewListOrder();
                break;
            case 3:
                shopping();
                break;
            case 4:
                System.exit(0);
        }
    }
    
     public void viewListOrder(){
        if(ht.isEmpty()){
            System.out.println("No Order");
            return;
        }
        for(String name: ht.keySet()){
            System.out.println("Customer: "+ name);
            ArrayList<Order> array_o = ht.get(name);
            displayListOrder(array_o);
        }
    }

    public void createFruit() {
        while(true) {
            int id = generateID();
            String name = l.getString("Enter fruit name: ");
            double price = l.getDouble("Enter fruit price");
            int quantity = l.getInt("Enter fruit quantity", 1, 100);
            String origin = l.getString("Enter fruit origin: ");
            list_F.add(new Fruit(id, name, price, quantity, origin));
            System.out.println("Add Successfull");
            if(!l.getString("Do you want to continue(Y,N): ").equalsIgnoreCase("Y")){
                break;
            }  
        }
    }
    
    public ArrayList<Fruit> checkListFruit(ArrayList<Fruit> list_F) {
        ArrayList<Fruit> temp = new ArrayList<>();
        for (int i=0; i<list_F.size(); i++) {
            if(list_F.get(i).getQuantity() == 0) {
                list_F.get(i+1).setId(list_F.get(i).getId());
                temp.add(list_F.get(i+1));
                i++;
            }
            else {
                temp.add(list_F.get(i));
            }
        }
        return temp;
    }
    
    public void displayFruit() {
        for (Fruit f : list_F) {
            System.out.println("Id: " + f.getId() + " - Name: " + f.getName() + " - Price: " + f.getPrice() + " - quantity:" + f.getQuantity() + " - origin: " + f.getOrigin());
        }
    }

    public void shopping() {
        list_F = checkListFruit(list_F);
        if (list_F.isEmpty()) {
            System.out.println("No Product");
            return;
        }
        displayFruit();
        ArrayList<Order> list_o = new ArrayList<>();
        while(true) {
            int idF = l.getInt("Select item", 1, list_F.size());
            for (Fruit f : list_F) {
                if (idF == f.getId()) {
                    int id = generateIDOrder(list_o);
                    String name = f.getName();
                    System.out.println("You selected:" + name);
                    double price = f.getPrice();
                    int quantity = f.getQuantity();
                    int quantityOrder = l.getInt("Please input quantity", 1, quantity);
                    f.setQuantity(quantity - quantityOrder);
                    list_o.add(new Order(id, name, quantityOrder, price));
                }
            }
            if(!l.getString("Do you want to continue(Y,N): ").equalsIgnoreCase("Y")){
                break;
            }       
        }
        displayListOrder(list_o);
        String customer = l.getString("Enter Customer of name: ");
        ht.put(customer, list_o);
        System.out.println("Add Successfull");
    }
    
     private void displayListOrder(ArrayList<Order> list_o) {
        double total = 0;
        for (Order o : list_o) {
            System.out.println("Product: " + o.getId()+"."+o.getName() + " - quanlity: " + o.getQuanlity() + " - price: " + o.getPrice() + " - amount: "+ o.getQuanlity()*o.getPrice());
            total += o.getPrice() * o.getQuanlity();
        }
        System.out.println("Total: "+ total);
    }

    public int generateID() {
        int id = 0;
        if (list_F.isEmpty()) {
            return 1;
        } else {

            for (Fruit s : list_F) {
                if (s.getId() == list_F.size()) {
                    id = s.getId() + 1;
                }
            }
        }
        return id;
    }
    
    public int generateIDOrder(ArrayList<Order> list_o) {
        int id = 0;
        if (list_o.isEmpty()) {
            return 1;
        } else {
            for (Order s : list_o) {
                if (s.getId() == list_o.size()) {
                    id = s.getId() + 1;
                }
            }
        }
        return id;
    }

}