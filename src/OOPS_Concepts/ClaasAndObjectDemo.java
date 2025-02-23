package OOPS_Concepts;

public class ClaasAndObjectDemo {
	// Class definition
	
	    String brand; // Instance variable
	    int speed;

	    // Method to display car details
	    void display() {
	        System.out.println("Car Brand: " + brand);
	        System.out.println("Speed: " + speed + " km/h");
	    }

	    public static void main(String[] args) {
	        // Creating an object of Car
	    	ClaasAndObjectDemo c1 = new ClaasAndObjectDemo();
	        c1.brand = "Tesla"; // Assigning values
	        c1.speed = 200;
	        c1.display(); // Calling method
	    }
	}



