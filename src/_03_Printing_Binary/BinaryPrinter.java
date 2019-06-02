package _03_Printing_Binary;

public class BinaryPrinter {
	public static void main(String[] args) {
		 BinaryPrinter bp = new BinaryPrinter();
		 bp.printLongBinary(34);
		 System.out.println("\n");
		 bp.printByteBinary((byte) 34);
		 System.out.println("\n");
		 
	}
	//Complete the methods below so they print the passed in parameter in binary.
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public void printByteBinary(byte b) {
		
	}
	
	public void printShortBinary(short s) {
		
	}
	
	public void printIntBinary(int i) {
		
	}
	
	public void printLongBinary(long l) {
		for(int i = (int)Math.pow(2, (int)(Math.log(l)/Math.log(2)));i > 0; i/=2) {
			if ((l&i) > 0)
				System.out.print(1);
			else
				System.out.print(0);
		}
	}
}
