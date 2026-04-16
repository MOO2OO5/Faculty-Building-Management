import java.util.ArrayList;

// Base Person classes
class Person {
    protected String id;
    protected String name;
    protected String phone;

    public Person(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}

class PersonInCharge extends Person {
    private String department;
    private String level;

    public PersonInCharge(String id, String name, String phone, String department, String level) {
        super(id, name, phone);
        this.department = department;
        this.level = level;
    }
}

// Base Device classes
class Device {
    protected String deviceId;
    protected String brand;
    protected String status;

    public Device(String deviceId, String brand, String status) {
        this.deviceId = deviceId;
        this.brand = brand;
        this.status = status;
    }

    public void displayInfo() {
        System.out.println("Device: " + deviceId + " [" + brand + "] - Status: " + status);
    }
}

class Light extends Device {
    private int brightness;
    public Light(String id, String brand, String status, int brightness) {
        super(id, brand, status);
        this.brightness = brightness;
    }
    @Override
    public void displayInfo() {
        System.out.println("Light: " + deviceId + " - " + brand + " (" + status + ") Brightness: " + brightness);
    }
}

class AirConditioner extends Device {
    private int temperature;
    public AirConditioner(String id, String brand, String status, int temp) {
        super(id, brand, status);
        this.temperature = temp;
    }
    @Override
    public void displayInfo() {
        System.out.println("AirCond: " + deviceId + " - " + brand + " (" + status + ") Temp: " + temperature + "°C");
    }
}

class Projector extends Device {
    private String resolution;
    public Projector(String id, String brand, String status, String res) {
        super(id, brand, status);
        this.resolution = res;
    }
    @Override
    public void displayInfo() {
        System.out.println("Projector: " + deviceId + " (" + resolution + ")");
    }
}

class CCTV extends Device {
    private String recording;
    public CCTV(String id, String brand, String status, String rec) {
        super(id, brand, status);
        this.recording = rec;
    }
    @Override
    public void displayInfo() {
        System.out.println("CCTV: " + deviceId + " (" + recording + ")");
    }
}

// Building and Room classes
class Building {
    private String buildingCode;
    private String buildingName;
    private ArrayList<Room> rooms;

    public Building(String buildingCode, String buildingName) {
        this.buildingCode = buildingCode;
        this.buildingName = buildingName;
        this.rooms = new ArrayList<>();
    }

    public Room addRoom(String roomId, String roomName, String roomType) {
        Room newRoom = new Room(roomId, roomName, roomType);
        rooms.add(newRoom);
        return newRoom;
    }

    public void displayBuildingInfo() {
        System.out.println("Building: " + buildingCode + " - " + buildingName);
    }

    public void displayAllRooms() {
        for (Room r : rooms) {
            r.displayRoomInfo();
            System.out.println("-----------------------------");
        }
    }
}

class Room {
    private String roomId;
    private String roomName;
    private String roomType;
    private ArrayList<Device> devices;
    private PersonInCharge pic;

    Room(String roomId, String roomName, String roomType) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomType = roomType;
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device d) {
        devices.add(d);
    }

    public void assignPersonInCharge(PersonInCharge p) {
        this.pic = p;
    }

    public void displayRoomInfo() {
        System.out.println("Room: " + roomId + " (" + roomType + ")");
        if (pic != null) {
            System.out.println("PIC: " + pic.name);
        }
        for (Device d : devices) {
            d.displayInfo();
        }
    }
}

// Main Execution Class
// Main Execution Class
public class SmartBuildingApp {
    public static void main(String[] args) {
        Building building = new Building("N28", "Faculty of Computing");

        // 5 Rooms as required 
        Room room1 = building.addRoom("R101", "Room 101", "Lecture Room");
        Room room2 = building.addRoom("MPK8", "MPK8", "Computer Lab");
        Room room3 = building.addRoom("MRA", "Meeting Room A", "Meeting Room");
        Room room4 = building.addRoom("S102", "Staff Room 1", "Office");
        Room room5 = building.addRoom("L05", "Lab 05", "Computer Lab");

        // PICs [cite: 148, 160, 161]
        PersonInCharge pic1 = new PersonInCharge("P001", "Mr. Surah", "012-111", "Academic", "High");
        PersonInCharge pic2 = new PersonInCharge("P002", "Ms. Siti", "012-222", "Technical", "Medium");
        PersonInCharge pic3 = new PersonInCharge("P003", "Mr. Kumar", "012-333", "Management", "High");

        room1.assignPersonInCharge(pic1);
        room2.assignPersonInCharge(pic2);
        room3.assignPersonInCharge(pic3);

        // 2+ Devices per room using 3+ subclasses 
        room1.addDevice(new Light("L001", "Philips", "ON", 80));
        room1.addDevice(new Projector("PJ001", "Epson", "ON", "Full HD"));
        
        room2.addDevice(new Light("L002", "Panasonic", "ON", 70));
        room2.addDevice(new CCTV("CCTV001", "Hikvision", "ON", "ACTIVE"));
        
        room3.addDevice(new AirConditioner("AC001", "Daikin", "OFF", 24));
        room3.addDevice(new CCTV("CCTV002", "Dahua", "ON", "ACTIVE"));

        // Final output [cite: 153, 162]
        System.out.println("===== SMART BUILDING MANAGEMENT SYSTEM =====");
        building.displayBuildingInfo();
        System.out.println();
        building.displayAllRooms();
    }
}