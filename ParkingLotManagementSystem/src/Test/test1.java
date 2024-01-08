package Test;

import parkingLot.ParkingLot;
import parkingLot.Vehicle;

/*
 * Test case 1: Testing whether the project is fully functioning under ideal inputs
 * Parameters: parking lot with a capacity of 30 spots, initializing with 10 regular spots, 7 EV spots and 3 RV spots.
 */

public class test1 {

	public static void main(String[] args) {

		ParkingLot lot = new ParkingLot(30, 10, 7, 3);
		System.out.println(lot.parkingSpots().toString());
		//linkedList initialized
		
		//testing 
		lot.addParkingSpot("rv");
		System.out.println(lot.parkingSpots().toString());
		lot.addParkingSpot("rg");
		lot.addParkingSpot("ev");
		System.out.println(lot.parkingSpots().toString());
		
		//testing creating invalid parking spot type
		lot.addParkingSpot("eg");
		//works
		
		//testing getters
		System.out.println(lot.getCapacity());
		System.out.println(lot.getOccupancy());
		//works
		
		//creating 23 vehicles
		// Regular vehicles
		Vehicle vhc1 = new Vehicle("Honda", "Civic", "JFB-192", "rg");
		Vehicle vhc2 = new Vehicle("Toyota", "Camry", "LPN-327", "rg");
		Vehicle vhc3 = new Vehicle("Chevrolet", "Malibu", "GFO-781", "rg");
		Vehicle vhc4 = new Vehicle("Ford", "Mustang", "APV-924", "rg");
		Vehicle vhc5 = new Vehicle("Nissan", "Altima", "ELF-303", "rg");
		Vehicle vhc6 = new Vehicle("Mazda", "CX-5", "GOA-448", "rg");
		Vehicle vhc7 = new Vehicle("Hyundai", "Elantra", "LMI-121", "rg");
		Vehicle vhc8 = new Vehicle("Kia", "Sorento", "RVD-951", "rg");
		Vehicle vhc9 = new Vehicle("BMW", "3 Series", "FXY-507", "rg");
		Vehicle vhc10 = new Vehicle("Mercedes-Benz", "C-Class", "MNK-692", "rg");
		Vehicle vhc11 = new Vehicle("Audi", "A4", "OJW-825", "rg");

		// Electric vehicles
		Vehicle vhc12 = new Vehicle("Tesla", "Model S", "FIV-931", "ev");
		Vehicle vhc13 = new Vehicle("Nissan", "Leaf", "NOK-538", "ev");
		Vehicle vhc14 = new Vehicle("Chevrolet", "Bolt", "ALD-284", "ev");
		Vehicle vhc15 = new Vehicle("Ford", "Mustang Mach-E", "PLW-107", "ev");
		Vehicle vhc16 = new Vehicle("Hyundai", "Kona Electric", "PHM-629", "ev");
		Vehicle vhc17 = new Vehicle("Volkswagen", "ID.4", "OQU-246", "ev");
		Vehicle vhc18 = new Vehicle("Porsche", "Taycan", "RGS-594", "ev");
		Vehicle vhc19 = new Vehicle("Rivian", "R1S", "LTO-801", "ev");

		// RVs
		Vehicle vhc20 = new Vehicle("Winnebago", "Travato", "BZO-476", "rv");
		Vehicle vhc21 = new Vehicle("Airstream", "Interstate", "KZJ-316", "rv");
		Vehicle vhc22 = new Vehicle("Coachmen", "Leprechaun", "VUO-575", "rv");
		Vehicle vhc23 = new Vehicle("Thor", "Chateau", "JTW-392", "rv");
		
		//now parking all these vehicles
		// Park regular vehicles
		lot.parkVehicle(vhc1);
		lot.parkVehicle(vhc2);
		lot.parkVehicle(vhc3);
		lot.parkVehicle(vhc4);
		lot.parkVehicle(vhc5);
		lot.parkVehicle(vhc6);
		lot.parkVehicle(vhc7);
		lot.parkVehicle(vhc8);
		lot.parkVehicle(vhc9);
		lot.parkVehicle(vhc10);
		lot.parkVehicle(vhc11);
		//works

		// Park electric vehicles
		lot.parkVehicle(vhc12);
		lot.parkVehicle(vhc13);
		lot.parkVehicle(vhc14);
		lot.parkVehicle(vhc15);
		lot.parkVehicle(vhc16);
		lot.parkVehicle(vhc17);
		lot.parkVehicle(vhc18);
		lot.parkVehicle(vhc19);
		//works

		// Park RVs
		lot.parkVehicle(vhc20);
		lot.parkVehicle(vhc21);
		lot.parkVehicle(vhc22);
		lot.parkVehicle(vhc23);
		//works

		//checking if parking lot is full
		
		//finish test 1
	}

}
