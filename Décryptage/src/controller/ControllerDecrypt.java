package controller;

import model.Model;

public class ControllerDecrypt {

	Model model;
	Controller controller;

	String cryptString;
	String keyPart = "";

	int[] keyPartInt;
	int[] totalKey;

	int stop = 0;
	String outputFromRecursiveDecrypt = "";
	String[] finalResults = new String[2];	
	
	String stringFinal;

	private int[] keyTab;
	private int[] decoupeChaineTab;

	String chaineDecrypterDecouper[];
	Boolean motTrouve = false;

	public ControllerDecrypt(String cryptString, Model model, Controller controller, String keyPart, int keyLenght) {

		finalResults[0] = "";
		finalResults[1] = "";
		
		
		this.cryptString = cryptString;
		this.model = model;
		this.controller = controller;
		this.keyPart = keyPart;

		totalKey = new int[keyLenght];

		char[] keyPartChar = keyPart.toCharArray();

		keyPartInt = new int[keyPartChar.length];

		for (int i = 0; i < keyPartChar.length; i++) {
			keyPartInt[i] = keyPartChar[i];
		}

		keyTab = new int[keyLenght - keyPartChar.length];

	}

	public String[] decryptage() {

		String[] output;

		decoupeChaineTab = transformerAsciiInt(cryptString);

		if (totalKey.length == keyPartInt.length) {
			String resultatXor;

			String[] finalResults = new String[2];

			resultatXor = this.model.modelDecrypt.xor(decoupeChaineTab, keyPartInt);
			outputFromRecursiveDecrypt = convertString(totalKey);
			finalResults[0] = keyPart;
			finalResults[1] = resultatXor;

			output = finalResults;
		} else {

			for (int i = 0; i < keyTab.length; i++) {

				keyTab[i] = 97;
			}

			output = forceBrute(0);
		}
		
		return output;
	}

	public String[] forceBrute(int debut) {

		String resultatXor = "";

		for (int i = 97; i <= 122; i++) {

			if (stop == 1) {
				break;
			}


			keyTab[debut] = i;

			if (keyPart != "") {

				for (int a = 0; a < keyPartInt.length; a++) {
					totalKey[a] = keyPartInt[a];

					for (int b = 0; b < keyTab.length; b++) {
						totalKey[b + keyPartInt.length] = keyTab[b];
					}

				}

				resultatXor = this.model.modelDecrypt.xor(decoupeChaineTab, totalKey);

				System.out.println(resultatXor);

			} else {
				resultatXor = this.model.modelDecrypt.xor(decoupeChaineTab, keyTab);

				System.out.println(resultatXor);
			}

			
			stringFinal = resultatXor;
			
			resultatXor = resultatXor.replaceAll("[\"\\.\\,\\?\\!\\:\\;]", "");
			

			resultatXor = resultatXor.trim();
			chaineDecrypterDecouper = resultatXor.split("[ ]+");
			

			for (int counter = 0; counter < chaineDecrypterDecouper.length; counter++) {
				motTrouve = controller.controllerGestionDesMots.testerUnMot(chaineDecrypterDecouper[counter],
						controller.model.cad);
				

				
				if (motTrouve == false) {
					break;
				}

			}

			
			if (motTrouve) {

				if (keyPart != "") {
					System.out.println("The key is : " + convertString(totalKey));
					outputFromRecursiveDecrypt = convertString(totalKey);
					finalResults[0] = outputFromRecursiveDecrypt;
					finalResults[1] = stringFinal;
				} else {
					System.out.println("The key is : " + convertString(keyTab));
					outputFromRecursiveDecrypt = convertString(keyTab);
					finalResults[0] = outputFromRecursiveDecrypt;
					finalResults[1] = stringFinal;
				}

				stop = 1;
				break;
				
			} else if (debut < keyTab.length - 1  && stop == 0) {
				motTrouve = true;
				forceBrute(debut + 1);
			}

		}
		return finalResults;
	}

	public int[] transformerAsciiInt(String chaine) {

		char[] StringToCharArray;
		int[] IntegerArray;

		StringToCharArray = chaine.toCharArray();

		IntegerArray = new int[chaine.length()];

		for (int i = 0; i < chaine.length(); i++) {

			IntegerArray[i] = (int) StringToCharArray[i];
			// System.out.println(IntegerArray[i]);
		}

		return IntegerArray;
	}

	public int[] decoupeChaine(String chaine) {

		int compteur = 0;
		int ajout = 8;
		int i = 0;
		int test = 0;

		int[] tabInt = new int[chaine.length() / 8];

		while (compteur < chaine.length()) {

			test = Integer.parseInt(chaine.substring(compteur, ajout), 2);

			tabInt[i] = test;

			compteur = compteur + 8;
			ajout = ajout + 8;
			i++;
		}

		return tabInt;
	}

	public String convertString(int[] tab) {

		char[] tabChar = new char[tab.length];

		for (int i = 0; i < tab.length; i++) {
			tabChar[i] = (char) tab[i];
		}

		String output = new String(tabChar);

		return output;
	}
}