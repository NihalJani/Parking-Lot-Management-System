/*
 * @author Nihal Jani, 230149084
 * April 03, 2023
 * SearchEngine class to look for vehicles in the parking lot assigned to the search engine, based on different criterias.
 */
package searchEngine;

import java.util.LinkedList;

import parkingLot.ParkingLot;
import parkingLot.ParkingSpot;

public class SearchEngine {

	private LinkedList<ParkingSpot> parkingSpots;
	private ParkingLot parkingLot;
	
	public SearchEngine(ParkingLot parkingLot) {
		this.parkingSpots = parkingLot.parkingSpots();
		this.parkingLot = parkingLot;
	}
	
	public void searchByBrand(String carBrand) {
		updateLL();
		System.out.println("Cars found: ");
		for(ParkingSpot spot: parkingSpots) {
			if(spot.getVehicle().getBrand().equalsIgnoreCase(carBrand))
				System.out.println(spot.getVehicle().getInfo()+" in Lot Number: "+spot.getId());
		}
	}
	
	public void searchByType(String type) {
		updateLL();
		System.out.println("Cars found: ");
		for(ParkingSpot spot: parkingSpots) {
			if(spot.getVehicle().getType().equalsIgnoreCase(type))
				System.out.println(spot.getVehicle().getInfo()+" in Lot Number: "+spot.getId());
		}
	}
	
	public void searchByPlate(String carPlate) {
		updateLL();
		System.out.println("Cars found: ");
		for(ParkingSpot spot: parkingSpots) {
			if(spot.getVehicle().getLicencePlate().equalsIgnoreCase(carPlate))
				System.out.println(spot.getVehicle().getInfo()+" in Lot Number: "+spot.getId());
		}
	}
	
	private void updateLL() {
		this.parkingSpots = parkingLot.parkingSpots();
	}
	
}
