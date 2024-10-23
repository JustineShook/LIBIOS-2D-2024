package truckingtriprecord;

import java.util.Scanner;

public class trucks {

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
            trucks test = new trucks();
            switch (action) {
                case 1:
                    test.addTruck();
                    break;
                case 2:
                    test.viewTruck();
                    break;
                case 3:
                    test.viewTruck();
                    test.updateTruck();
                    break;
                case 4:
                    test.viewTruck();
                    test.deleteTruck();
                    test.viewTruck();
                    break;
            }

            System.out.print("Continue? ");
            resp = sc.next();

        } while (resp.equalsIgnoreCase("yes"));
        System.out.println("Thank You!");

    }

    public void addTruck() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Truck Plate Number: ");
        String plateNumber = sc.nextLine();
        System.out.print("Truck Model: ");
        String model = sc.nextLine();
        System.out.print("Truck Status: ");
        String status = sc.nextLine();

        String sql = "INSERT INTO tbl_trucks (truck_plate_number, truck_model, truck_status) VALUES (?, ?, ?)";

        conf.addRecord(sql, plateNumber, model, status);
    }

    private void viewTruck() {

        String qry = "SELECT * FROM tbl_trucks";
        String[] hdrs = {"ID", "Plate Number", "Model", "Status"};
        String[] clms = {"truck_id", "truck_plate_number", "truck_model", "truck_status"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clms);
    }

    private void updateTruck() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();

        System.out.print("Enter new Plate Number: ");
        String newPlateNumber = sc.next();
        System.out.print("Enter new Model: ");
        String newModel = sc.next();
        System.out.print("Enter new Status: ");
        String newStatus = sc.next();

        String qry = "UPDATE tbl_trucks SET truck_plate_number = ?, truck_model = ?, truck_status = ? WHERE truck_id = ?";

        config conf = new config();
        conf.updateRecord(qry, newPlateNumber, newModel, newStatus, id);

    }

    private void deleteTruck() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_trucks WHERE truck_id = ?";

        config conf = new config();
        conf.deleteRecord(qry, id);

    }

}

