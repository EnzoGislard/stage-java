package model;

public class ModelDecrypt {



	public String xor(int[] tabInt, int[] key) {
		

		char[] outputChar = new char[tabInt.length];
		String output;

		int xorResult = 0;

		int keyCounter = 0;

		for (int i = 0; i < tabInt.length; i++) {

			if (keyCounter == key.length) {
				keyCounter = 0;
			}

			xorResult = tabInt[i] ^ key[keyCounter];

			outputChar[i] = (char) xorResult;
			

			keyCounter++;
		}
		
		output = new String(outputChar);
		
		
		return output;
	}

}
