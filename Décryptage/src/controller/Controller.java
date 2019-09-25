package controller;


import model.Model;

public class Controller {

	public final Model model;
	public ControllerDecrypt controllerDecrypt;
	public ControllerGestionDesMots controllerGestionDesMots;
	public ControllerGestionComptePersonne controllerGestionComptePersonne;

	public Controller(final Model model) {
		
		this.model = model;
		
	}

	
	
	public void start() {

		System.out.println("System running\n");
		controllerGestionComptePersonne = new ControllerGestionComptePersonne();
		controllerGestionDesMots = new ControllerGestionDesMots();
	}

	
	

}
