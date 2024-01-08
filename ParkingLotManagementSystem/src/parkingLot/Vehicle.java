/*
 * @author Nihal Jani, 230149084
 * April 03, 2023
 * Vehicle class to create different types of vehicles, to test out the project.
 */
package parkingLot;

public class Vehicle {

	//Vehicle identifiers
	private String brand;
	private String model;
	private String type;
	private String licencePlate;
	private String info;
	private ParkingSpot parkingSpot;	//parking spot the vehicle is assigned to
	
	public Vehicle(String carBrand, String carModel, String licencePlate, String type) {
		if (!isValidVehicleType(type)) {
			System.out.println("Invalid Vehicle type: " + type);
		}
		this.brand = carBrand;
		this.model = carModel;
		this.licencePlate = licencePlate;
		this.type = type;
		this.info = carBrand+" "+carModel+" "+type+" License Plate: "+licencePlate;
		this.parkingSpot = null;
	}

	//getters
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getType() {
		return type;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public String getInfo() {
		return info;
	}

	public ParkingSpot getParkingSpot() {
		return this.parkingSpot;
	}
	
	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	//method to see if valid vehicle type is passed in argument
	public static boolean isValidVehicleType(String type) {
		return (type.equals("rg") || type.equals("ev") || type.equals("rv"));
	}

}
