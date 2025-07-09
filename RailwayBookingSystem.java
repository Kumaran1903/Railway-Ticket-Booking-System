import java.util.Scanner;

public class RailwayBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketManager manager = new TicketManager();

        while (true) {
            System.out.println("\n===== Railway Booking System =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    manager.bookTicket(name, age);
                    break;
                case 2:
                    System.out.print("Enter Passenger ID to cancel: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    manager.cancelTicket(id);
                    break;
                case 3:
                    manager.viewAllTickets();
                    break;
                case 4:
                    System.out.println("Thank you for using the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
