import java.util.*;

public class HospitalManagementSystem {
    static Scanner sc = new Scanner(System.in);

    static class Patient {
        String name, disease;
        int age, id;
    }

    static class Staff {
        String name, role;
        int id;
    }

    static class Appointment {
        int patientId;
        String doctorName, date;
    }

    static class Bill {
        int patientId;
        double amount;
    }

    static class Inventory {
        String itemName;
        int quantity;
    }

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Staff> staffList = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<Bill> bills = new ArrayList<>();
    static ArrayList<Inventory> inventoryList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Add Staff");
            System.out.println("4. Generate Bill");
            System.out.println("5. Add Inventory Item");
            System.out.println("6. View All Data");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> scheduleAppointment();
                case 3 -> addStaff();
                case 4 -> generateBill();
                case 5 -> addInventory();
                case 6 -> viewAllData();
                case 0 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void registerPatient() {
        Patient p = new Patient();
        System.out.print("Enter Patient ID: ");
        p.id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        p.name = sc.nextLine();
        System.out.print("Enter Age: ");
        p.age = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Disease: ");
        p.disease = sc.nextLine();
        patients.add(p);
        System.out.println("✅ Patient Registered!");
    }

    static void scheduleAppointment() {
        Appointment a = new Appointment();
        System.out.print("Enter Patient ID: ");
        a.patientId = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        a.doctorName = sc.nextLine();
        System.out.print("Enter Date (dd-mm-yyyy): ");
        a.date = sc.nextLine();
        appointments.add(a);
        System.out.println("📅 Appointment Scheduled!");
    }

    static void addStaff() {
        Staff s = new Staff();
        System.out.print("Enter Staff ID: ");
        s.id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Name: ");
        s.name = sc.nextLine();
        System.out.print("Enter Role: ");
        s.role = sc.nextLine();
        staffList.add(s);
        System.out.println("👨‍⚕️ Staff Added!");
    }

    static void generateBill() {
        Bill b = new Bill();
        System.out.print("Enter Patient ID: ");
        b.patientId = sc.nextInt();
        System.out.print("Enter Amount: ");
        b.amount = sc.nextDouble();
        bills.add(b);
        System.out.println("💰 Bill Generated!");
    }

    static void addInventory() {
        Inventory i = new Inventory();
        System.out.print("Enter Item Name: ");
        i.itemName = sc.nextLine();
        System.out.print("Enter Quantity: ");
        i.quantity = sc.nextInt();
        inventoryList.add(i);
        System.out.println("📦 Inventory Item Added!");
    }

    static void viewAllData() {
        System.out.println("\n--- Patients ---");
        for (Patient p : patients)
            System.out.println("ID: " + p.id + ", Name: " + p.name + ", Age: " + p.age + ", Disease: " + p.disease);

        System.out.println("\n--- Appointments ---");
        for (Appointment a : appointments)
            System.out.println("Patient ID: " + a.patientId + ", Doctor: " + a.doctorName + ", Date: " + a.date);

        System.out.println("\n--- Staff ---");
        for (Staff s : staffList)
            System.out.println("ID: " + s.id + ", Name: " + s.name + ", Role: " + s.role);

        System.out.println("\n--- Bills ---");
        for (Bill b : bills)
            System.out.println("Patient ID: " + b.patientId + ", Amount: ₹" + b.amount);

        System.out.println("\n--- Inventory ---");
        for (Inventory i : inventoryList)
            System.out.println("Item: " + i.itemName + ", Quantity: " + i.quantity);
    }
}
