package controller;

import model.Model;


public class ControllerDecrypt {

	Model model;
	Controller controller;
	
	String cryptFile;
	String destFile;
	String keyPart = "";
	
	int[] keyPartInt;
	int[] totalKey = new int[12];
	

	int stop = 0;
	String outputFromRecursiveDecrypt = "";
	String[] finalResults = new String[2];

	private int[] keyTab;
	private int[] decoupeChaineTab;

	public ControllerDecrypt(String cryptFile, String destFile, Model model, Controller controller, String keyPart) {

		this.cryptFile = cryptFile;
		this.model = model;
		this.controller = controller;
		this.keyPart = keyPart;
		
		char[] keyPartChar = keyPart.toCharArray();
		
		keyPartInt = new int[keyPartChar.length];
		
		for (int i = 0; i < keyPartChar.length; i++) {
			keyPartInt[i] = keyPartChar[i];
		}

		keyTab = new int[12-keyPartChar.length];

		for (int i = 0; i < keyTab.length; i++) {

			keyTab[i] = 97;
		}

	}

	public String[] decryptage() {

		String[] output;

		decoupeChaineTab = transformerAsciiInt(cryptFile);

		output = forceBrute(0);

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
				
				for(int a = 0 ; a < keyPartInt.length; a++) {
					totalKey[a]=keyPartInt[a];
					
				    for(int b = 0 ; b < keyTab.length; b++) {
				    	totalKey[b+keyPartInt.length]=keyTab[b]; 
				    }
				       
				}

				resultatXor = this.model.modelDecrypt.xor(decoupeChaineTab, totalKey);

				System.out.println(resultatXor);
				
			}
			else {
				resultatXor = this.model.modelDecrypt.xor(decoupeChaineTab, keyTab);

				System.out.println(resultatXor);
			}
			
			if (controller.controllerGestionDesMots.testerUnMot(resultatXor, controller.model.cad)) {

				if (keyPart != "") {
					System.out.println("The key is : " + convertString(totalKey));
					outputFromRecursiveDecrypt = convertString(totalKey);
					finalResults[0] = outputFromRecursiveDecrypt;
					finalResults[1] = resultatXor;
				}
				else {
					System.out.println("The key is : " + convertString(keyTab));
					outputFromRecursiveDecrypt = convertString(keyTab);
					finalResults[0] = outputFromRecursiveDecrypt;
					finalResults[1] = resultatXor;
				}

				stop = 1;
				break;
			}
			else if (debut < keyTab.length - 1 && stop == 0)
				forceBrute(debut + 1);
		}
		return finalResults;
	}
	
	public int[] transformerAsciiInt (String chaine) {
		
		char[] StringToCharArray;
		int[] IntegerArray;
		
		StringToCharArray = chaine.toCharArray();
		
		IntegerArray= new int[chaine.length()];
		
		for (int i = 0; i < chaine.length(); i++) {
            
			IntegerArray[i] = (int)StringToCharArray[i];
			//System.out.println(IntegerArray[i]);
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
