package OOPS_Concepts;

class thisKeywordDemo {

	    String name;

	    // Constructor using 'this' keyword
	    thisKeywordDemo(String name) {
	        this.name = name;  
	    }

	    void display() {
	        System.out.println("Student Name: " + this.name);
	    }

	    public static void main(String[] args) {
	    	thisKeywordDemo s1 = new thisKeywordDemo("Alice");
	        s1.display();
	    }
	}


