package OOPS_Concepts;

class finalKeywordDemo {
	    final int MAX_VALUE = 100; // Final variable (cannot be changed)

	    void show() {
	        System.out.println("Max Value: " + MAX_VALUE);
	    }

	
	    public static void main(String[] args) {
	    	finalKeywordDemo obj = new finalKeywordDemo();
	        obj.show();
	    }
	}


