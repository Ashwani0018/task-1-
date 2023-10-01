import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reservation {
    private int pnr;
    private String name;
    private String trainName;
    private String classType;
    private String date;
    private String from;
    private String to;

    public Reservation(int pnr, String name, String trainName, String classType, String date, String from, String to) {
        this.pnr = pnr;
        this.name = name;
        this.trainName = trainName;
        this.classType = classType;
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public int getPnr() { return pnr; }
    public String getName() { return name; }
    public String getTrainName() { return trainName; }
    public String getClassType() { return classType; }
    public String getDate() { return date; }
    public String getFrom() { return from; }
    public String getTo() { return to; }
}

class ReservationSystem {
    private List<Reservation> reservations;
    private int nextPnr = 1;

    public ReservationSystem() {
        reservations = new ArrayList<>();
    }

    public void reserve(String name, String classType, String date, String from, String to) {
        String trainName = "Sample Train"; // You can add logic to determine the train name.
        Reservation reservation = new Reservation(nextPnr, name, trainName, classType, date, from, to);
        reservations.add(reservation);
        nextPnr++;
        System.out.println("Reservation successful. Your PNR number is: " + reservation.getPnr());
    }

    public void cancel(int pnr) {
        Reservation reservationToRemove = null;
        for (Reservation reservation : reservations) {
            if (reservation.getPnr() == pnr) {
                reservationToRemove = reservation;
                break;
            }
        }

        if (reservationToRemove != null) {
            reservations.remove(reservationToRemove);
            System.out.println("Cancellation successful for PNR number: " + pnr);
        } else {
            System.out.println("No reservation found for PNR number: " + pnr);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        while (true) {
            System.out.println("1. Reserve a ticket");
            System.out.println("2. Cancel a ticket");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter class type: ");
                    String classType = sc.nextLine();
                    System.out.print("Enter date: ");
                    String date = sc.nextLine();
                    System.out.print("Enter from: ");
                    String from = sc.nextLine();
                    System.out.print("Enter to: ");
                    String to = sc.nextLine();
                    reservationSystem.reserve(name, classType, date, from, to);
                    break;
                case 2:
                    System.out.print("Enter PNR number to cancel: ");
                    int pnrToCancel = sc.nextInt();
                    reservationSystem.cancel(pnrToCancel);
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
