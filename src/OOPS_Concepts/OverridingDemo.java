package OOPS_Concepts;

class OverridingDemo {
	    void show() {
	        System.out.println("Parent class method");
	    }
	}

	class Child extends OverridingDemo {
	    @Override
	    void show() {  // Overriding the method
	        System.out.println("Child class method");
	    }
	
	    public static void main(String[] args) {
	    	OverridingDemo obj = new Child(); // Dynamic method dispatch
	        obj.show(); // Calls overridden method in Child
	    }
	
	}

