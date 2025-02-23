package OOPS_Concepts;

 class ConstructorDemo {
	    String name;
	    int age;

	    // Constructor (automatically called when an object is created)
	    ConstructorDemo(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    void display() {
	        System.out.println("Employee Name: " + name);
	        System.out.println("Employee Age: " + age);
	    }

	    public static void main(String[] args) {
	    	ConstructorDemo e1 = new ConstructorDemo("John", 30);
	        e1.display();
	    }
	}


