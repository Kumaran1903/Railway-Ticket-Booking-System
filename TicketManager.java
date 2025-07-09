import java.util.*;

public class TicketManager {
    private final int TOTAL_BERTHS = 3;
    private final int RAC_LIMIT = 1;
    private final int WL_LIMIT = 1;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Queue<Passenger> racList = new LinkedList<>();
    private Queue<Passenger> waitingList = new LinkedList<>();

    public void bookTicket(String name, int age) {
        if (confirmedList.size() < TOTAL_BERTHS) {
            Passenger p = new Passenger(name, age, "Confirmed");
            confirmedList.add(p);
            System.out.println("✅ Ticket Booked: " + p);
        } else if (racList.size() < RAC_LIMIT) {
            Passenger p = new Passenger(name, age, "RAC");
            racList.add(p);
            System.out.println("🟡 RAC Ticket Booked: " + p);
        } else if (waitingList.size() < WL_LIMIT) {
            Passenger p = new Passenger(name, age, "Waiting");
            waitingList.add(p);
            System.out.println("⚠️ Waiting List Ticket Booked: " + p);
        } else {
            System.out.println("❌ No tickets available!");
        }
    }

    public void cancelTicket(int id) {
        boolean found = false;

        found = removeFromList(confirmedList, id);
        if (found) {
            promoteFromRAC();
            return;
        }

        found = removeFromQueue(racList, id);
        if (found) {
            promoteFromWL();
            return;
        }

        found = removeFromQueue(waitingList, id);
        if (found)
            return;

        System.out.println("❌ Passenger ID not found.");
    }

    private boolean removeFromList(List<Passenger> list, int id) {
        Iterator<Passenger> it = list.iterator();
        while (it.hasNext()) {
            Passenger p = it.next();
            if (p.getId() == id) {
                it.remove();
                System.out.println("✅ Cancelled Confirmed Ticket: " + p);
                return true;
            }
        }
        return false;
    }

    private boolean removeFromQueue(Queue<Passenger> queue, int id) {
        Iterator<Passenger> it = queue.iterator();
        while (it.hasNext()) {
            Passenger p = it.next();
            if (p.getId() == id) {
                it.remove();
                System.out.println("✅ Cancelled " + p.getStatus() + " Ticket: " + p);
                return true;
            }
        }
        return false;
    }

    private void promoteFromRAC() {
        if (!racList.isEmpty()) {
            Passenger rac = racList.poll();
            rac.setStatus("Confirmed");
            confirmedList.add(rac);
            System.out.println("🔁 Promoted from RAC to Confirmed: " + rac);
            promoteFromWL();
        }
    }

    private void promoteFromWL() {
        if (!waitingList.isEmpty()) {
            Passenger wl = waitingList.poll();
            wl.setStatus("RAC");
            racList.add(wl);
            System.out.println("🔁 Promoted from Waiting to RAC: " + wl);
        }
    }

    public void viewAllTickets() {
        System.out.println("\n🎫 Confirmed Tickets:");
        if (confirmedList.isEmpty())
            System.out.println("None");
        for (Passenger p : confirmedList)
            System.out.println(p);

        System.out.println("\n🟡 RAC List:");
        if (racList.isEmpty())
            System.out.println("None");
        for (Passenger p : racList)
            System.out.println(p);

        System.out.println("\n⚠️ Waiting List:");
        if (waitingList.isEmpty())
            System.out.println("None");
        for (Passenger p : waitingList)
            System.out.println(p);
    }
}
