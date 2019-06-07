package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		int n = 0;
		byte b = 0;
		for(int i = 0;i<64;i++) {
			if(base64Chars[i] == c) {
				n = i;
			}
		}
		for(int i = 32;i>0;i/=2) {
			if((n&i)>0) {
				b+=i;
			}
		}
		return b;
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
		byte[] ba = new byte[3];
		int[] ia = new int[4];
		for(int n = 0;n<4;n++) {
			for(int i = 0;i<64;i++) {
				if(base64Chars[i] == s.charAt(n)) {
					ia[n] = i;
					break;
				}
			}
		}
		String s1 = "";
		for(int i = 0;i<4;i++) {
			for(int n = 32;n>0;n/=2) {
				if((ia[i]&n)>0) {
					s1+=1;
				}
				else
					s1+=0;
			}
		}
		for(int i = 0;i<3;i++) {
			for(int n = 7;n>-1;n--) {
				if(s1.charAt(i*8+7-n) == '1') {
					ba[i] += Math.pow(2, n);
				} else {
				}
			}
		}
		
		for(int i =0;i<3;i++) {
			System.out.print(ba[i]+" ");
		}
		return ba; 
	}
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		byte[] ba = new byte[file.length()];
		byte[] temp = new byte[3];
		for(int i = 0,j = 0;i<file.length();i+=4,j+=3) {
			temp = convert4CharsTo24Bits(file.substring(i,i+4));
			if(i<file.length()-1) {
				ba[j] = temp[0];
			}
			if(i<file.length()-2) {
				ba[j+1] = temp[1];
			}
			if(i<file.length()-3) {
				ba[j+2] = temp[2];
			}
		}

		System.out.println(" "+ba[1]);
		for(int i = 0;i<file.length();i++) {
			System.out.println(ba[i]);
		}
		return ba;

	}
}
