package Test;

import parkingLot.ParkingLot;
import parkingLot.ParkingSpot;
import parkingLot.Vehicle;
import searchEngine.SearchEngine;

public class test2 {

	public static void main(String[] args) {

		 // create a new parking lot with 10 spots, 4 regular, 2 EV, and 2 RV
        ParkingLot lot = new ParkingLot(10, 4, 2, 2);
        
        System.out.println("Parking Lot Capacity: "+lot.getCapacity());
        System.out.println("Parking Lot Size: "+lot.getSize());
        System.out.println("Parking Lot Occupancy: "+lot.getOccupancy());
        
        //testing addarkingSpot method
        //checking error condition of unsupported type
        lot.addParkingSpot("eg");
        
        lot.addParkingSpot("ev");
        System.out.println("Parking Lot New Size: "+lot.getSize());
        
        lot.addParkingSpot("rv");
        System.out.println("Parking Lot New Size: "+lot.getSize());
        
        //since capacity reached, checking error condition
        lot.addParkingSpot("rg");
        
        //adding vehicles for simulation
        //Regulars 
        Vehicle rg1 = new Vehicle("Honda", "Civic", "JFB-192", "rg");
		Vehicle rg2 = new Vehicle("Toyota", "Camry", "LPN-327", "rg");
		Vehicle rg3 = new Vehicle("Chevrolet", "Malibu", "GFO-781", "rg");
		Vehicle rg4 = new Vehicle("Ford", "Mustang", "APV-924", "rg");
		Vehicle rg5 = new Vehicle("Nissan", "Altima", "ELF-303", "rg");
		
		//Electric
		Vehicle ev1 = new Vehicle("Tesla", "Model S", "FIV-931", "ev");
		Vehicle ev2 = new Vehicle("Nissan", "Leaf", "NOK-538", "ev");
		Vehicle ev3 = new Vehicle("Chevrolet", "Bolt", "ALD-284", "ev");
		Vehicle ev4 = new Vehicle("Ford", "Mustang Mach-E", "PLW-107", "ev");
		Vehicle ev5 = new Vehicle("Hyundai", "Kona Electric", "PHM-629", "ev");
		
		//RVs
		Vehicle rv1 = new Vehicle("Winnebago", "Travato", "BZO-476", "rv");
		Vehicle rv2 = new Vehicle("Airstream", "Interstate", "KZJ-316", "rv");
		Vehicle rv3 = new Vehicle("Coachmen", "Leprechaun", "VUO-575", "rv");	
		
		//testing parkVehicle method
		lot.parkVehicle(rg1);
		lot.parkVehicle(rg2);
		lot.parkVehicle(rg3);
		lot.parkVehicle(rg4);
		
		lot.parkVehicle(ev1);
		lot.parkVehicle(ev2);
		lot.parkVehicle(ev3);
		
		lot.parkVehicle(rv1);
		lot.parkVehicle(rv2);
		lot.parkVehicle(rv3);
		
		//testing out error conditions
		Vehicle rv4 = new Vehicle("Thor", "Chateau", "JTW-392", "eg");
		lot.parkVehicle(rg5);
		
		//testing the parking fee calculation
		try {
			Thread.sleep(60000); // Pauses the execution for 1 minute to simulate car parked for 1 minute before leaving 
		} catch (InterruptedException e) {} 
		
		lot.removeVehicle(rg1);				
        
		//testing search engine object
		SearchEngine se = new SearchEngine(lot);
		se.searchByBrand("ford");
		se.searchByType("rv");
		
		//testing error condition
    }
	

}
