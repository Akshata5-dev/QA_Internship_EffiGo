package OOPS_Concepts;

abstract  class AbstractionDemo {
	// Abstract class
	    abstract void draw(); // Abstract method (must be implemented by subclasses)
	}

	// Concrete subclass
	class Circle extends AbstractionDemo  {
	    void draw() {
	        System.out.println("Drawing a Circle");
	    }
	
	    public static void main(String[] args) {
	    	AbstractionDemo  s = new Circle(); // Dynamic method dispatch
	        s.draw(); // Calling overridden method
	    
	}

}
