package controller;


import model.Model;

public class Controller {

	public final Model model;
	public ControllerSGBDR ControllerSGBDR;
	public ControllerDecrypt controllerDecrypt;

	public Controller(final Model model) {
		
		this.model = model;
		
	}

	
	
	
	
	
	public void start() {

		System.out.println("System running\n");
		ControllerSGBDR = new ControllerSGBDR();
	}

	
	

}
