
package truckingtriprecord;


import java.util.Scanner;

public class TruckingTripRecord {

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
            TruckingTripRecord test = new TruckingTripRecord();
            switch (action) {
                case 1:
                    test.addDriver();
                    break;
                case 2:
                    test.viewDriver();
                    break;
                case 3:
                    test.viewDriver();
                    test.updateDriver();
                    break;
                case 4:
                    test.viewDriver();
                    test.deleteDriver();
                    test.viewDriver();
                    break;
            }

            System.out.print("Continue? ");
            resp = sc.next();

        } while (resp.equalsIgnoreCase("yes"));
        System.out.println("Thank You!");

    }

    public void addDriver() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Driver First Name: ");
        String fname = sc.nextLine();
        System.out.print("Driver Last Name: ");
        String lname = sc.nextLine();
        System.out.print("Driver License: ");
        String license = sc.nextLine();
        System.out.print("Driver Status: ");
        String status = sc.nextLine();

        String sql = "INSERT INTO tbl_drivers (d_fname, d_lname, d_license, d_status) VALUES (?, ?, ?, ?)";

        conf.addRecord(sql, fname, lname, license, status);
    }

    private void viewDriver() {

            String qry = "SELECT * FROM tbl_drivers";
        String[] hdrs = {"ID", "First Name", "Last Name", "License", "Status"};
        String[] clms = {"d_id", "d_fname", "d_lname", "d_license", "d_status"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clms);
    }

    private void updateDriver() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();

        System.out.print("Enter new First Name: ");
        String nfname = sc.next();
        System.out.print("Enter new Last Name: ");
        String nlname = sc.next();
        System.out.print("Enter new License: ");
        String nlicense = sc.next();
        System.out.print("Enter new Status: ");
        String nstatus = sc.next();

        String qry = "UPDATE tbl_drivers SET d_fname = ?, d_lname = ?, d_license = ?, d_status = ? WHERE d_id = ?";

        config conf = new config();
        conf.updateRecord(qry, nfname, nlname, nlicense, nstatus, id);

    }

    private void deleteDriver() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_drivers WHERE d_id = ?";

        config conf = new config();
        conf.deleteRecord(qry, id);

    }

}


