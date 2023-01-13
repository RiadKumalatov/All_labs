package services;

public class Reservation {

    private int reservationCost;
    private Table reservationTable;
    private String reservationUser;

    public int getReservationCost() {
        return reservationCost;
    }

    public void setReservationCost(int reservationCost) {
        this.reservationCost = reservationCost;
    }

    public Table getReservationTable() {
        return reservationTable;
    }

    public void setReservationTable(Table reservationTable) {
        this.reservationTable = reservationTable;
    }

    public String getReservationUser() {
        return reservationUser;
    }

    public void setReservationUser(String reservationUser) {
        this.reservationUser = reservationUser;
    }
}
