package controller;

import model.Model;

public class ControllerDecrypt {

	Model model;
	Controller controller;
	
	
	
	String cryptFile;
	String destFile;
	String keyPart = "";
	
	int[] keyPartInt;
	int[] totalKey = new int[3];
	

	int stop = 0;
	String outputFromRecursiveDecrypt = "";

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
		

		
		keyTab = new int[3-keyPartChar.length];

		for (int i = 0; i < keyTab.length; i++) {

			keyTab[i] = 97;

		}

	}

	public String decryptage() {

		String ouptut;

		decoupeChaineTab = decoupeChaine(cryptFile);

		ouptut = forceBrute(0);

		return ouptut;

	}

	public String forceBrute(int debut) {

		String resultatXor;
		Boolean dictionnary;
		

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


			
			//dictionnary = controller.ControllerSGBDR.contactDictionnary(resultatXor);
			
			//dictionnary = true;
			
			
			if (controller.controllerGestionDesMots.testerUnMot(resultatXor)) {

				
				
				if (keyPart != "") {
					System.out.println("La cl� est: " + convertString(totalKey));
					outputFromRecursiveDecrypt = convertString(totalKey);
				}
				else {
					System.out.println("La cl� est: " + convertString(keyTab));
					outputFromRecursiveDecrypt = convertString(keyTab);
				}
				

				stop = 1;
				break;

			}

			else if (debut < keyTab.length - 1 && stop == 0)
				forceBrute(debut + 1);

		}
		return outputFromRecursiveDecrypt;
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
