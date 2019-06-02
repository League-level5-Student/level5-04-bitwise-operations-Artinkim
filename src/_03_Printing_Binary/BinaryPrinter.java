package _03_Printing_Binary;

public class BinaryPrinter {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		 BinaryPrinter bp = new BinaryPrinter();
		 bp.printLongBinary(34);
		 System.out.println("\n");
		 bp.printByteBinary((byte) 34);
		 System.out.println("\n");
		 bp.printByteBinary((byte) 255);
		 System.out.println("\n");
		 bp.printByteBinary((byte) -1);
		 System.out.println("\n");
		 bp.printShortBinary((short) 34); 
		 System.out.println("\n");
		 bp.printIntBinary(Integer.MAX_VALUE);
		 System.out.println("\n");
		 bp.printIntBinary(-1);
	}
	//Complete the methods below so they print the passed in parameter in binary.
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public void printByteBinary(byte b) {
		for(int i = 128;i>0;i/=2) {
			if((b&i)>0) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
	}
	
	public void printShortBinary(short s) {
		for(int i = (int) Math.pow(2, 16);i>0;i/=2) {
			if((s&i)>0) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}
	}
	
	public void printIntBinary(int i) {
		BinaryPrinter bp = new BinaryPrinter();
		bp.printShortBinary((short)(((short)i&0b11111111111111110000000000000000)>>16));
		bp.printShortBinary((short)i);
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
