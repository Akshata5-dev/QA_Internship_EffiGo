package OOPS_Concepts;

class staticKeywordDemo {
	    static int count = 0; // Static variable (shared among all objects)

	    staticKeywordDemo() {
	        count++;  // Increments count for each object created
	        System.out.println("Counter: " + count);
	    }

	    static void showCount() {  // Static method (can access static variables)
	        System.out.println("Total Count: " + count);
	    }

	    public static void main(String[] args) {
	        new staticKeywordDemo();
	        //new staticKeywordDemo();
	        staticKeywordDemo.showCount(); // Calling static method
	    }
	}


