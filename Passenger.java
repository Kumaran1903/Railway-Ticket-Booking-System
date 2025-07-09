public class Passenger {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int age;
    private String status; // Confirmed, RAC, WL

    public Passenger(String name, int age, String status) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PassengerID: " + id + ", Name: " + name + ", Age: " + age + ", Status: " + status;
    }
}
