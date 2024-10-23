
package truckingtriprecord;

import java.util.Scanner;

public class trips {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String resp;
        do {

            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            trips test = new trips();
            switch (action) {
                case 1:
                    test.addTrip();
                    break;
                case 2:
                    test.viewTrip();
                    break;
                case 3:
                    test.viewTrip();
                    test.updateTrip();
                    break;
                case 4:
                    test.viewTrip();
                    test.deleteTrip();
                    test.viewTrip();
                    break;
            }

            System.out.print("Continue? ");
            resp = sc.next();

        } while (resp.equalsIgnoreCase("yes"));
        System.out.println("Thank You!");

    }

    public void addTrip() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Trip Date: ");
        String tripDate = sc.nextLine();
        System.out.print("Trip Start Location: ");
        String startLocation = sc.nextLine();
        System.out.print("Trip End Location: ");
        String endLocation = sc.nextLine();
        System.out.print("Trip Status: ");
        String status = sc.nextLine();

        String sql = "INSERT INTO tbl_trips (trip_date, trip_start_location, trip_end_location, trip_status) VALUES (?, ?, ?, ?)";

        conf.addRecord(sql, tripDate, startLocation, endLocation, status);
    }

    private void viewTrip() {

        String qry = "SELECT * FROM tbl_trips";
        String[] hdrs = {"ID", "Trip Date", "Start Location", "End Location", "Status"};
        String[] clms = {"trip_id", "trip_date", "trip_start_location", "trip_end_location", "trip_status"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clms);
    }

    private void updateTrip() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();

        System.out.print("Enter new Trip Date: ");
        String newDate = sc.next();
        System.out.print("Enter new Start Location: ");
        String newStart = sc.next();
        System.out.print("Enter new End Location: ");
        String newEnd = sc.next();
        System.out.print("Enter new Status: ");
        String newStatus = sc.next();

        String qry = "UPDATE tbl_trips SET trip_date = ?, trip_start_location = ?, trip_end_location = ?, trip_status = ? WHERE trip_id = ?";

        config conf = new config();
        conf.updateRecord(qry, newDate, newStart, newEnd, newStatus, id);

    }

    private void deleteTrip() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_trips WHERE trip_id = ?";

        config conf = new config();
        conf.deleteRecord(qry, id);

    }

}