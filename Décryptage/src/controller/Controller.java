package controller;


import model.Model;

public class Controller {

	public final Model model;
	public ControllerCompte ControllerCompte;

	public Controller(final Model model) {
		
		this.model = model;
		ControllerCompte = new ControllerCompte();
	}

	
	
	
	
	
	public void start() {

		System.out.print("System running");

	}

	
	

}
