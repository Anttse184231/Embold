package Data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Hotel {

    private String hotelID;
    private String hotelName;
    private int hotelRoomAvailable;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelRating;

    public Hotel(String hotelID, String hotelName, int hotelRoomAvailable, String hotelAddress, String hotelPhone, String hotelRating) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.hotelRoomAvailable = hotelRoomAvailable;
        this.hotelAddress = hotelAddress;
        this.hotelPhone = hotelPhone;
        this.hotelRating = hotelRating;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelRoomAvailable() {
        return hotelRoomAvailable;
    }

    public void setHotelRoomAvailable(int hotelRoomAvailable) {
        this.hotelRoomAvailable = hotelRoomAvailable;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(String hotelRating) {
        this.hotelRating = hotelRating;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotelID=" + hotelID + ", hotelName=" + hotelName + ", hotelRoomAvailable=" + hotelRoomAvailable + ", hotelAddress=" + hotelAddress + ", hotelPhone=" + hotelPhone + ", hotelRating=" + hotelRating + '}';
    }

}
