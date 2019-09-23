package model;

import java.util.HashMap;

public class Map_Dic {
	
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public HashMap<String, String> dictionary = new HashMap<String, String>();	
	
	public Map_Dic() {
		
		for(int i = 0; i < 26; i++) {
			char value = alphabet.charAt(i);
			int key = i+97;
			dictionary.put(Character.toString(value),  String.valueOf(key));
		}
	}		
	
	public String selectWord(String word) {
		String noError = "No error with this returned";
		
		return noError;
	}	
}
