package OOPS_Concepts;

 class InheritanceDemo {
	// Parent class
	
	     void sound() {
	         System.out.println("Animals make sound");
	     }
	 }

	 // Child class (inherits from Animal)
	 class Dog extends InheritanceDemo {
	     void bark() {
	         System.out.println("Dog barks");
	     }

	     public static void main(String[] args) {
	         Dog d = new Dog();
	         d.sound(); // Inherited method
	         d.bark();  // Own method
	     }
	 }


