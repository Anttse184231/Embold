/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.HotelList;
import Data.Menu;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class HotelManager {

    public static void main(String[] args) {
        String filename = "Hotel.dat";
        Scanner sc = new Scanner(System.in);
        Menu mn = new Menu();
        mn.add("Add new Hotel");
        mn.add("Check to exist hotel");
        mn.add("Update hotel information");
        mn.add("Delete hotel");
        mn.add("search hotel");
        mn.add("Displaying a hotel list");
        mn.add("Save to file");
        mn.add("Exit the program");
        int choice;
        HotelList listobj = new HotelList();
        listobj.loadListFile("Hotel.dat");
        do {
            System.out.println("\nHotel Management System Menu:");
            choice = mn.displayMenu();
            switch (choice) {
                case 1:
                    listobj.addNewHotel();
                    break;

                case 2:
                    listobj.checkExistence();
                    break;

                case 3:
                    listobj.update();
                    break;

                case 4:
                    listobj.deleteHotel();
                    break;

                case 5:
                    listobj.searchHotel();
                    break;

                case 6:
                    listobj.displayHotelList();
                    break;

                case 7:
                    listobj.saveToFile(filename);
                    break;

                default:
                    if (listobj.getListNew().size() > 0) {
                        System.out.print("Save changes Y/N: ");
                        String res = sc.nextLine().toUpperCase();
                        if (res.startsWith("Y")) {
                            listobj.saveToFile(filename);
                        }
                    }
            }
        } while (choice > 0 && choice < 8);
    }

}
