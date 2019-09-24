package controller;


import model.Model;

public class Controller {

	public final Model model;
	public ControllerCompte controllerCompte;
	public ControllerDecrypt controllerDecrypt;

	public Controller(final Model model) {
		
		this.model = model;
		controllerCompte = new ControllerCompte();
	}

	
	
	
	
	
	public void start() {

		System.out.println("System running");

	}

	
	

}
