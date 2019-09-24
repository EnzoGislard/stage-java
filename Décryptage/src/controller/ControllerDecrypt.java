package controller;

import model.Model;

public class ControllerDecrypt {

	Model model;
	String cryptFile;
	String destFile;
	
	int stop = 0;

	private int[] keyTab;
	private int[] decoupeChaineTab;

	public ControllerDecrypt(String cryptFile, String destFile, Model model) {
		
		

		this.cryptFile = cryptFile;
		this.model = model;

		keyTab = new int[3];

		for (int i = 0; i < keyTab.length; i++) {

			keyTab[i] = 97;

		}

		decryptage();
	}

	public void decryptage() {

		String resultat;

		int[] tab = new int[3];

		decoupeChaineTab = decoupeChaine(cryptFile);


		forceBrute(0);

	}

	public void forceBrute(int debut) {

		String resultat;
		

		
		for (int i = 97; i <= 122; i++) {

			if (stop == 1) {
				break;
			}

			keyTab[debut] = i;


			resultat = this.model.modelDecrypt.xor(decoupeChaineTab, keyTab);

			System.out.println(resultat);
			

			if (resultat.equals("MESSAGE")) {
				
				System.out.println("La clé est:  " + convertString(keyTab));
				
				stop = 1;
				break;
			}



			if (debut < keyTab.length - 1 && stop == 0)
				forceBrute(debut + 1);

		}

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

			// System.out.println(tabChar[i]);
		}

		String output = new String(tabChar);

		// System.out.println(output);

		return output;
	}

}
