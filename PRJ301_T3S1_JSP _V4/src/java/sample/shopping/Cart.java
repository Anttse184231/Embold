/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Cart {

    private Map<String, Clothes> cart;

    public Cart() {
    }

    public Cart(Map<String, Clothes> cart) {
        this.cart = cart;
    }

    public Map<String, Clothes> getCart() {
        return cart;
    }

    public void setCart(Map<String, Clothes> cart) {
        this.cart = cart;
    }

    public boolean add(Clothes clothes) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(clothes.getId())) {
                int currentQuantity = this.cart.get(clothes.getId()).getQuantity();
                clothes.setQuantity(currentQuantity + clothes.getQuantity());
            }
            this.cart.put(clothes.getId(), clothes);
            check = true;
        } catch (Exception e) {

        }
        return check;
    }

    public boolean remove(String id) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.remove(id);
                    check = true;
                }

            }
        } catch (Exception e) {

        }
        return check;
    }
    
    public boolean edit(String id, int quantity) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
//                  Clothes clothes= this.cart.get(id);
//                  clothes.setQuantity(quantity);
//                  this.cart.replace(id, clothes);
                    this.cart.get(id).setQuantity(quantity);
                    check = true;
                }

            }
        } catch (Exception e) {

        }
        return check;
    }
}
