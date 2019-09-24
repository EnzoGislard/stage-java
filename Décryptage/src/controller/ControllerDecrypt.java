package controller;

import model.Model;

public class ControllerDecrypt {

	Model model;
	Controller controller;
	String cryptFile;
	String destFile;

	int stop = 0;
	String outputFromRecursiveDecrypt = "";

	private int[] keyTab;
	private int[] decoupeChaineTab;

	public ControllerDecrypt(String cryptFile, String destFile, Model model, Controller controller) {

		this.cryptFile = cryptFile;
		this.model = model;
		this.controller = controller;

		keyTab = new int[3];

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

			resultatXor = this.model.modelDecrypt.xor(decoupeChaineTab, keyTab);

			System.out.println(resultatXor);

			
			dictionnary = controller.ControllerSGBDR.contactDictionnary(resultatXor);
			
			
			
			if (dictionnary) {

				System.out.println("La clé est: " + convertString(keyTab));
				outputFromRecursiveDecrypt = convertString(keyTab);

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
