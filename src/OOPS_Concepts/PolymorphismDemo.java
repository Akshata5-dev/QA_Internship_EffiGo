package OOPS_Concepts;

class PolymorphismDemo {
	    // Method with two int parameters
	    int add(int a, int b) {
	        return a + b;
	    }

	    // Method with two double parameters (Overloading)
	    double add(double a, double b) {
	        return a + b;
	    }
	
	    public static void main(String[] args) {
	    	PolymorphismDemo calc = new PolymorphismDemo();
	        System.out.println("Sum (int): " + calc.add(5, 10)); // Calls int version
	        System.out.println("Sum (double): " + calc.add(5.5, 10.2)); // Calls double version
	    }
	}


