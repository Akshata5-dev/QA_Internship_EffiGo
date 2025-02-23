package OOPS_Concepts;

class superKeywordDemo {
	    void makeSound() {
	        System.out.println("Animal makes a sound");
	    }
	}

	class Cat extends superKeywordDemo {
	    void makeSound() {
	        super.makeSound(); // Calls parent class method
	        System.out.println("Meow Meow!");
	    }
	    public static void main(String[] args) {
	        Cat c = new Cat();
	        c.makeSound();
	    }
	}


