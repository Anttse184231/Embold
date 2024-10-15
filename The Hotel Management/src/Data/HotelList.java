package Data;

import MyUtils.Utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class HotelList {

    List<String> listfile = new ArrayList();
    List<Hotel> listnew = new ArrayList();

    public HotelList() {
        super();
    }

    public void setListNew(List<Hotel> listnew) {
        this.listnew = listnew;
    }

    public List<Hotel> getListNew() {
        return listnew;
    }

    public void loadListFile(String fName) {
        if (listfile.size() > 0) {
            listfile.clear();
        }

        try {
            File f = new File(fName);
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);

            String line;
            while ((line = bf.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "\t");
                String hotelID = tokenizer.nextToken();
                String hotelName = tokenizer.nextToken();
                int hotelRoomAvailable = Integer.parseInt(tokenizer.nextToken());
                String hotelAddress = tokenizer.nextToken();
                String hotelPhone = tokenizer.nextToken();
                String hotelRating = tokenizer.nextToken();

                listnew.add(new Hotel(hotelID, hotelName, hotelRoomAvailable, hotelAddress, hotelPhone, hotelRating));
            }

            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private int find(String aHotelID) {
        for (int i = 0; i < listnew.size(); i++) {
            if (listnew.get(i).getHotelID().equals(aHotelID)) {
                return i;
            }
        }
        return -1;
    }

    //8. Saving to file
    public void saveToFile(String fName) {
        if (listnew.isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        try {
            boolean append = true;
            File f = new File(fName);
            FileWriter fw = new FileWriter(f, append);
            PrintWriter pw = new PrintWriter(fw);

            List<Hotel> existingHotels = loadExistingHotelsFromFile(fName);

            for (Hotel hotel : listnew) {
                if (!hotelExistsInList(existingHotels, hotel.getHotelID())) {
                    pw.printf("%s\t%s\t%d\t%s\t%s\t%s\n",
                            hotel.getHotelID(),
                            hotel.getHotelName(),
                            hotel.getHotelRoomAvailable(),
                            hotel.getHotelAddress(),
                            hotel.getHotelPhone(),
                            hotel.getHotelRating());
                } else {
                    System.out.println("Hotel " + hotel.getHotelID() + " already exists in the file. Skipping...");
                }
            }

            pw.flush();
            pw.close();
            fw.close();

            loadListFile(fName);
            listnew.clear();
            System.out.println("Data saved successfully to " + fName);
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private boolean hotelExistsInList(List<Hotel> existingHotels, String idToCheck) {
        if (idToCheck == null) {
            return false;
        }
        for (Hotel hotel : existingHotels) {
            if (idToCheck.equals(hotel.getHotelID())) {
                return true;
            }
        }

        return false;
    }

    private List<Hotel> loadExistingHotelsFromFile(String fName) {
        List<Hotel> existingHotels = new ArrayList<>();

        try {
            File f = new File(fName);
            if (!f.exists()) {
                return existingHotels;
            }

            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);

            String line;
            while ((line = bf.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "\t");
                String hotelID = tokenizer.nextToken();
                existingHotels.add(new Hotel(hotelID, "", 0, "", "", ""));
            }

            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return existingHotels;
    }

    //1. Adding new Hotel.
    public void addNewHotel() {
        String newHotelID, newHotelName, newHotelAddress, newHotelPhone, newHotelRating;
        int newHotelRoomAvailable;
        System.out.println("Enter new hotel information:");
        boolean check = true;
        do {
            newHotelID = Utils.getStringreg("Enter hotel ID:", "H\\d{2}$", "Hotel ID is not null", "Hotel ID is wrong format(HXX)!!!");
            if (find(newHotelID) >= 0) {
                System.out.println("Hotel ID is not Duplicate");
            } else {
                check = false;
            }
        } while (check);
        newHotelName = Utils.getString("Enter Hotel Name: ", "Hotel Name is not null");
        newHotelAddress = Utils.getString("Enter Hotel Address: ", "Hotel Address is not null");
        newHotelPhone = Utils.getString("Enter Hotel Phone: ", "Hotel Phone is not null");
        newHotelRating = Utils.getString("Enter Hotel Rating: ", "Hotel Rating is not null");
        newHotelRoomAvailable = Utils.getInt("Enter Room Available: ", 0);
        listnew.add(new Hotel(newHotelID, newHotelName, newHotelRoomAvailable, newHotelAddress, newHotelPhone, newHotelRating));
        System.out.println("New hotel has been added successfully.");
    }

    //3. Check to exist hotel
    public void checkExistence() {
        boolean continueChecking = true;
        while (continueChecking) {
            String idHotelCheck = Utils.getStringreg("Enter the Hotel ID: ", "H\\d{2}$", "Hotel ID is not null", "Hotel ID is wrong format (HXX)!!!");

            if (hotelExists(idHotelCheck)) {
                System.out.println("Exist Hotel");
            } else {
                System.out.println("No Hotel Found!");
            }
            continueChecking = goBackToMenu();
        }
    }

    private boolean goBackToMenu() {
        while (true) {
            System.out.print("Do you want to go back to the main menu? (Y/N): ");
            String userChoice = Utils.getString("", "");
            if (userChoice.equalsIgnoreCase("N")) {
                return true;
            } else if (userChoice.equalsIgnoreCase("Y")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }

    private boolean hotelExists(String idToCheck) {
        if (idToCheck == null) {
            return false;
        }
        for (Hotel hotel : listnew) {
            if (idToCheck.equals(hotel.getHotelID())) {
                return true;
            }
        }

        return false;
    }

    //4. Update hotel information
    public void update() {
        String idHotel;
        idHotel = Utils.getStringreg("Enter the Hotel ID: ",
                "H\\d{2}$", "Hotel ID is not null", "Hotel ID is wrong format(HXX)!!!");
        int pos = find(idHotel);
        if (pos < 0) {
            System.out.println("Hotel does not exist.");
        } else {
            String oldHotelName = listnew.get(pos).getHotelName();
            int oldHotelRoomAvailable = listnew.get(pos).getHotelRoomAvailable();
            String oldHotelAddress = listnew.get(pos).getHotelAddress();
            String oldHotelPhone = listnew.get(pos).getHotelPhone();
            String oldHotelRating = listnew.get(pos).getHotelRating();

            System.out.println("Old hotel name: " + oldHotelName);
            System.out.println("Old hotel room available: " + oldHotelRoomAvailable);
            System.out.println("Old hotel address: " + oldHotelAddress);
            System.out.println("Old hotel phone: " + oldHotelPhone);
            System.out.println("Old hotel rating: " + oldHotelRating);

            String newHotelName = Utils.inputString("Enter a new hotel name (press Enter to keep " + oldHotelName + "): ", oldHotelName);
            if (!newHotelName.isEmpty()) {
                listnew.get(pos).setHotelName(newHotelName);
            }

            String newRoomAvailableInput = Utils.inputString("Enter a new hotel room available (press Enter to keep " + oldHotelRoomAvailable + "): ", "");
            if (!newRoomAvailableInput.isEmpty()) {
                try {
                    int newRoomAvailable = Integer.parseInt(newRoomAvailableInput);
                    listnew.get(pos).setHotelRoomAvailable(newRoomAvailable);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            String newHotelAddress = Utils.inputString("Enter a new hotel address (press Enter to keep " + oldHotelAddress + "): ", oldHotelAddress);
            if (!newHotelAddress.isEmpty()) {
                listnew.get(pos).setHotelAddress(newHotelAddress);
            }

            String newHotelPhone = Utils.inputString("Enter a new hotel phone (press Enter to keep " + oldHotelPhone + "): ", oldHotelPhone);
            if (!newHotelPhone.isEmpty()) {
                listnew.get(pos).setHotelPhone(newHotelPhone);
            }

            String newHotelRating = Utils.inputString("Enter a new hotel rating (press Enter to keep " + oldHotelRating + "): ", oldHotelRating);
            if (!newHotelRating.isEmpty()) {
                listnew.get(pos).setHotelRating(newHotelRating);
            }
            System.out.println("The Hotel " + idHotel + " has been updated.");
        }
    }

    //5. Deleting hotel
    public void deleteHotel() {
        String dHotelID;
        dHotelID = Utils.getStringreg("Enter the hotel ID of deleted hotel:",
                "H\\d{2}$", "Hotel ID is not null", "Hotel ID is wrong format(HXX)!!!");
        int pos = find(dHotelID);
        if (pos < 0) {
            System.out.println("This hotel ID does not exist.");
        } else {
            boolean comfirmDelete = comfirmDelete();
            if (comfirmDelete) {
                listnew.remove(listnew.get(pos));
                System.out.println("The hotel " + dHotelID + " has been deleted.");
            } else {
                System.out.println("Deletion canceled.");
            }
        }
    }

    private boolean comfirmDelete() {
        while (true) {
            System.out.print("Do you ready want to delete this hotel? (Y/N): ");
            String userChoice = Utils.getString("", "");
            if (userChoice.equalsIgnoreCase("Y")) {
                return true;
            } else if (userChoice.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }

    //6. Search hotel.
    public void searchHotel() {
        int choice = Utils.getInt("Select search option:\n1. Search by Hotel ID\n2. Search by Hotel Address\nEnter your choice (1-2): ", 1);

        switch (choice) {
            case 1:
                searchHotelById();
                break;
            case 2:
                searchHotelByAddress();
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    public void searchHotelById() {
        String searchId = Utils.getStringreg("Enter the hotel ID: ",
                "H\\d{2}$", "Hotel ID is not null", "Hotel ID is wrong format(HXX)!!!");
        List<Hotel> result = searchByIdInFile(searchId);
        displaySearchResults(result);
    }

    public class HotelRoomAvailableComparator implements Comparator<Hotel> {

        @Override
        public int compare(Hotel hotel1, Hotel hotel2) {
            return Integer.compare(hotel2.getHotelRoomAvailable(), hotel1.getHotelRoomAvailable());
        }
    }

    private List<Hotel> searchByIdInFile(String searchId) {
        List<Hotel> result = new ArrayList<>();
        for (Hotel hotel : listnew) {
            if (hotel.getHotelID().equalsIgnoreCase(searchId)) {
                result.add(hotel);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No matching hotels found.");
        }
        return result;
    }

    public void searchHotelByAddress() {
        String searchAddress = Utils.getString("Enter the hotel address: ", "Hotel address is not null");
        List<Hotel> result = searchByAddressInFile(searchAddress);
        displaySearchResults(result);
    }

    private List<Hotel> searchByAddressInFile(String searchAddress) {
        List<Hotel> result = new ArrayList<>();
        for (Hotel hotel : listnew) {
            if (hotel.getHotelAddress().toLowerCase().contains(searchAddress.toLowerCase())) {
                result.add(hotel);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No matching hotels found.");
        } else {
            result.sort(new HotelRoomAvailableComparator());
        }
        return result;
    }

    private void displaySearchResults(List<Hotel> result) {
        if (result.isEmpty()) {
            System.out.println("No matching hotels found.");
        } else {
            System.out.println("Search results:");
            System.out.printf("| %-7s | %-15s | %-20s | %-70s | %-15s | %-15s |%n", "Hotel ID", "Hotel Name", "Hotel Room Available", "Hotel Address", "Hotel Phone", "Hotel Rating");
            System.out.println("__________________________________________________________________________________________________________________________________________________________________");

            for (Hotel hotel : result) {
                System.out.printf("| %-7s | %-15s | %-20d | %-70s | %-15s | %-15s |%n",
                        hotel.getHotelID(), hotel.getHotelName(), hotel.getHotelRoomAvailable(), hotel.getHotelAddress(),
                        hotel.getHotelPhone(), hotel.getHotelRating());
            }
            System.out.println("__________________________________________________________________________________________________________________________________________________________________");
        }
    }

    //7. Displaying a hotel list.
    public void displayHotelList() {
        List<Hotel> hotelList = getListNew();

        if (!hotelList.isEmpty()) {
            hotelList.sort(new HotelNameComparator());

            System.out.println("\nHOTEL LIST");
            System.out.println("__________________________________________________________________________________________________________________________________________________________________");
            display(hotelList);
        } else {
            System.out.println("No hotels found in the list.");
        }
    }

    private void display(List<Hotel> hotelList) {
        System.out.printf("| %-7s | %-15s | %-20s | %-70s | %-15s | %-15s |%n", "Hotel ID", "Hotel Name", "Hotel Room Available", "Hotel Address", "Hotel Phone", "Hotel Rating");
        System.out.println("__________________________________________________________________________________________________________________________________________________________________");

        for (Hotel hotel : hotelList) {
            System.out.printf("| %-7s | %-15s | %-20d | %-70s | %-15s | %-15s |%n",
                    hotel.getHotelID(), hotel.getHotelName(), hotel.getHotelRoomAvailable(), hotel.getHotelAddress(),
                    hotel.getHotelPhone(), hotel.getHotelRating());
        }
        System.out.println("__________________________________________________________________________________________________________________________________________________________________");
    }

    public class HotelNameComparator implements Comparator<Hotel> {

        @Override
        public int compare(Hotel hotel1, Hotel hotel2) {
            return hotel2.getHotelName().compareTo(hotel1.getHotelName());
        }
    }
}
