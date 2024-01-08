/*
 * @author Nihal Jani, 230149084
 * April 03, 2023
 * ParkingLot class to provide framework for parking spots and the whole management operation
 */
package parkingLot;

import java.util.LinkedList;

public class ParkingLot {

	//defined capacity
	private int capacity;
	//linkedlist of all parking spots in the lot. The size of
	//linkedlist will also act as id number for spot, thus eliminating the need for
	//a separate counter
	private LinkedList<ParkingSpot> parkingSpots = new LinkedList<>();

	//constructing a parking lot with just capacity declared
	public ParkingLot(int capacity) {
		this.capacity = capacity;
	}
	
	//constructing a parking lot with both capacity, and number of different spots created
	public ParkingLot(int capacity, int numRGSpots, int numEVSpots, int numRVSpots)  {
		
		//if requested initial number of spots exceed defined capacity
		if ((numRGSpots + numEVSpots + numRVSpots) > capacity) {	
			System.out.println("Spots requested more than capacity");
		}
		//check for negative numbers in arguments
		else if((capacity < 0)||(numRGSpots<0)||(numEVSpots<0)||(numRVSpots<0)) {
			throw new IllegalArgumentException("Any of the arguments cannot be negative.");
		}
		else {
		this.capacity = capacity;
		for (int i = 0; i < numRGSpots; i++)
			addParkingSpot("rg");
		for (int i = 0; i < numEVSpots; i++)
			addParkingSpot("ev");
		for (int i = 0; i < numRVSpots; i++)
			addParkingSpot("rv");
		}
	}

	
	//getters
	public int getCapacity() {
		return capacity;
	}

	public int getSize() {
		return parkingSpots.size();
	}
	
	public int getOccupancy() {
		int i=0;
		for(ParkingSpot spot: parkingSpots) {
			if(spot.getVehicle() != null)
				i++;
		}
		return i;
	}

	//to be used by the search engine
	public LinkedList<ParkingSpot> parkingSpots() {
		return this.parkingSpots;
	}
	
	// creating different types of parking spots based on need.
	public void addParkingSpot(String type) {
	 
		if(isAtCapacity()) 
			System.out.println("Capacity Reached in this Parking Lot"); 
		
		else {
			if (type.equals("rg") ) {
				parkingSpots.add(new ParkingSpot(parkingSpots.size(), type));
			}

			else if (type.equals("ev")) {
				parkingSpots.add(new ParkingSpot(parkingSpots.size(), type));
			}

			else if (type.equals("rv")) {
				parkingSpots.add(new ParkingSpot(parkingSpots.size(), type));
			}

			else
				System.out.println("Undefined type of parking spot. ");
			}
			
	}

	//park a new incoming vehicle.
	public void parkVehicle(Vehicle vehicle) {
			if(vehicle.getParkingSpot() == null) {	//making sure vehicle isn't already parked
			ParkingSpot spot = findAvailableSpot(vehicle);
			if (spot != null) {
				spot.assignVehicle(vehicle);
				System.out.println(vehicle.getInfo()+" parked successfully");
			}
			else
				System.out.println("No empty spot of requested type available, try again later.");
			
		}
	}
	
	public void removeVehicle(Vehicle vehicle) {
		vehicle.getParkingSpot().removeVehicle();
	//	System.out.println(vehicle.getInfo()+" removed from spot: "+vehicle.getParkingSpot().getId());
	}

	//helper methods
	private boolean isAtCapacity() {
		return parkingSpots.size() >= capacity;
	}

	private ParkingSpot findAvailableSpot(Vehicle vehicle) {
		for (ParkingSpot spot : parkingSpots) {
			if (spot.getSpotType().equals(vehicle.getType()) && spot.isFree()) {
				return spot;
			}
		}
		return null;
	}

}