package générateurClé;

public class générateurClé {

	public int[] tab;
	public String crypt = "000010110000100100001101";
	
	

	public générateurClé() {

		tab = new int[12];

		for (int i = 0; i < tab.length; i++) {

			tab[i] = 97;

		}

	}

	public void forceBrute(int debut) {

		for (int i = 97; i <= 122; i++) {

			tab[debut] = i;

			toString(tab);

			if (debut < tab.length-1)
				forceBrute(debut + 1);
			
		}
		

	}

	public void toString(int[] tab) {

		char[] tabChar = new char[tab.length];

		for (int i = 0; i < tab.length ; i++) {

			tabChar[i] = (char) tab[i];

			// System.out.println(tabChar[i]);
		}
		
		String output = new String(tabChar);

		System.out.println(output);
	}

	
	
	
	public void xor (char[] tab) {
		
		
		char [] cryptChar = this.crypt.toCharArray();
		
		char [] decrypt = new char [cryptChar.length];
		
		for (int i = 0; i < cryptChar.length; i++) {
			
			
			if (cryptChar[i] != tab[i]) {
				decrypt[i] = 0;
			}
			else 
				decrypt[i] = 0;
		}
		
		
		String output = new String(decrypt);
		
		System.out.println(output);
	}

}
