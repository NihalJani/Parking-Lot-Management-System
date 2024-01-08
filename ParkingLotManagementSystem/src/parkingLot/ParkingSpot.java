/*
 * @author Nihal Jani, 230149084
 * April 03, 2023
 * ParkingSpot class to create different types of spots for respective types of vehicles to park into
 */
package parkingLot;

import java.time.*;

public class ParkingSpot {

	private int id; // assigning id number to spot
	private final String spotType;	// type of spot
	private Vehicle vehicle; // vehicle in this spot
	private boolean isFree; // is spot free to get assigned any vehicle?

	// used to calculate parking fee
	private LocalDateTime entryTime;

	public ParkingSpot(int id, String type) {
		if (!isValidVehicleType(type)) {
			System.out.println("Invalid spot type: " + type);
		}
		this.id = id;
		this.vehicle = null;
		this.isFree = true;
		this.spotType = type;
	}

	//getters
	public int getId() {
		return id;
	}

	public String getSpotType() {
		return spotType;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public boolean isFree() {
		return isFree;
	}

	// method to assign vehicle to spot
	protected void assignVehicle(Vehicle vehicle) {
		if (isFree) {
			this.vehicle = vehicle;
			isFree = false;
			entryTime = LocalDateTime.now();
			vehicle.setParkingSpot(this);
		}
		else
			throw new IllegalArgumentException("Spot not free");
	}

	// method to remove vehicle. If spot not free, show parking fee due, remove
	// vehicle, spot free
	protected void removeVehicle() {
		if (!isFree) {
			System.out.printf("Vehicle " + vehicle.getInfo() + " Removed. \nParking fee due: $" + parkingFee());
			this.vehicle = null;
			this.isFree = true;
			this.entryTime = null;
		}
		else
			System.out.println("No car parked in this spot");
	}

	// charge rates based on type of spot. 
	// Base rate - 3$ + for regular spots -15$/hr, for EV spots - 21$/hr, for RV spots - 30$/hr.
	public double parkingFee() {
		if (!isFree) {
			Duration duration = Duration.between(entryTime, LocalDateTime.now());
			if (spotType.equals("rg"))
				return (3 + duration.toMinutes() * 0.25);
			else if (spotType.equals("ev"))
				return (3 + duration.toMinutes() * 0.35);
			else
				return (3 + duration.toMinutes() * 0.5);
		} else {
			System.out.println("Spot Empty");
			return 0;
		}
	}
	
	public static boolean isValidVehicleType(String type) {
		return (type.equals("rg") || type.equals("ev") || type.equals("rv"));
	}

}
