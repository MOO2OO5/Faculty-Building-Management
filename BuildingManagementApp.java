// BuildingManagementAppAns.java
// SKILL BASED TEST - Question 2
// SCSE1224 2025/2026-2
// Name: ???
// Matric No.: ???

import java.util.ArrayList;

class Person {
    public String name;
    public String contactNum;
    private Room roomAssigned;

    public Person(String name, String contactNum) {
        this.name = name;
        this.contactNum = contactNum;
    }

    public void assignRoom(Room roomAssigned) {
        this.roomAssigned = roomAssigned;
    }

    public void viewAssignedRoom() {
        System.out.println("Person In-Charge");
        System.out.println("Name: " + name);
        System.out.println("...room");
        if (roomAssigned != null) {
            System.out.println("Room Name: " + roomAssigned.roomName);
            System.out.println("Capacity: " + roomAssigned.capacity);
        }
    }

    @Override
    public String toString() {
        return "[ Name: " + name + " Contact Number: " + contactNum + " ]";
    }
}
class Room {
    public String roomName;
    public int capacity;
    ArrayList<Equipment> equipmentList;

    public Room(String name, int capacity) {
        this.roomName = name;
        this.capacity = capacity;
        this.equipmentList = new ArrayList<>();
    }

    public void addEquipment(Equipment equipment) {
        equipmentList.add(equipment);
    }

    public void displayRoomDetails() {
        System.out.println("Room Name: " + roomName + " and Capacity: " + capacity);
    }
}
class ComputerLab extends Room {
    private int numberOfComputer;

    public ComputerLab(String roomName, int capacity, int numberOfComputer) {
        super(roomName, capacity);
        this.numberOfComputer = numberOfComputer;
    }

    @Override
    public void displayRoomDetails() {
        super.displayRoomDetails();
    }
}

class LectureHall extends Room {
    private String seatingLayout;

    public LectureHall(String name, int capacity, String seatingLayout) {
        super(name, capacity);
        this.seatingLayout = seatingLayout;
    }

    @Override
    public void displayRoomDetails() {
        super.displayRoomDetails();
    }
}
class Equipment {
    String name;
    String type;

    public Equipment(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        // Formatted to match expected output [cite: 461, 470]
        return "[ Name: " + type + " Type: " + name + " ]";
    }

    public void displayEquipmentDetails() {
        System.out.println("Equipment Name: " + type);
        System.out.println("Equipment Type: " + name);
    }
}
class Building {
    public String buildingName;
    public ArrayList<Room> rooms;

    public Building(String buildingName) {
        this.buildingName = buildingName;
        this.rooms = new ArrayList<>();
    }

    public void addComputerLab(String name, int capacity, int numberOfComputers) {
        rooms.add(new ComputerLab(name, capacity, numberOfComputers));
    }

    public void addLectureHall(String name, int capacity, String seatingLayout) {
        rooms.add(new LectureHall(name, capacity, seatingLayout));
    }

    public void displayBuildingDetails() {
        System.out.println("Building name " + buildingName);
        if (rooms.isEmpty()) {
            System.out.println("No room in this building...");
        } else {
            System.out.println("List of rooms :");
            for (int i = 0; i < rooms.size(); i++) {
                System.out.println("Room (" + i + ") : Name: " + rooms.get(i).roomName + " and Capacity: " + rooms.get(i).capacity);
            }
        }
    }
}

// Main class to run the program
public class BuildingManagementApp { 
 public static void main(String[] args) {
        System.out.println("---- FACULTY BUILDING MANAGEMENT APP --------");
        
        // Checkpoint #1 [cite: 454]
        System.out.println("\nCheckpoint #1");
        Person person1 = new Person("Ahmad Zolkafli", "017-7018088");
        Person person2 = new Person("Samad Abu", "013-9705090");
        System.out.println("using toString()");
        System.out.println(person1.toString());
        System.out.println(person2.toString());

        // Checkpoint #2 [cite: 463]
        System.out.println("\nCheckpoint #2");
        Equipment computer1 = new Equipment("Computer for teacher in MPK1", "Electronics");
        Equipment projector = new Equipment("Projector in Dewan Kejora", "Visual");
        Equipment paSystem = new Equipment("Dewan Kejora PA Audio System", "Audio Equipment");
        System.out.println("using toString()");
        System.out.println(projector.toString());
        System.out.println(computer1.toString());
        System.out.println(paSystem.toString());
        System.out.println("using displayEquipmentDetails()");
        computer1.displayEquipmentDetails();
        projector.displayEquipmentDetails();
        paSystem.displayEquipmentDetails();

        // Checkpoint #3 [cite: 496]
        System.out.println("\nCheckpoint #3");
        Building fcBuilding = new Building("N28a Faculty Computing");
        System.out.println(fcBuilding.toString());
        fcBuilding.displayBuildingDetails();
        fcBuilding.addComputerLab("MPK01", 50, 25);
        fcBuilding.addLectureHall("Dewan Kejora", 250, "U-shape");
        fcBuilding.displayBuildingDetails();

        // Checkpoint #4 [cite: 523]
        System.out.println("\nCheckpoint #4");
        person1.assignRoom(fcBuilding.rooms.get(0));
        person2.assignRoom(fcBuilding.rooms.get(1));
        person1.viewAssignedRoom();
        person2.viewAssignedRoom();

        // Checkpoint #5 [cite: 564]
        System.out.println("\nCheckpoint #5");
        fcBuilding.rooms.get(0).addEquipment(computer1);
        fcBuilding.rooms.get(1).addEquipment(projector);
        fcBuilding.rooms.get(1).addEquipment(paSystem);
    }
}