package Data;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Menu extends ArrayList<String> {

    public Menu() {
        super();
    }

    public int displayMenu() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "-" + this.get(i));
        }
        System.out.println("-----------------------------------");
        do {
            System.out.print("Enter your choice (1-8): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 8) {
                    System.out.println("Number from 1 to 8");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number format");
                sc.nextLine();
            }
        } while (choice < 1 || choice > 8);
        return choice;
    }
}
