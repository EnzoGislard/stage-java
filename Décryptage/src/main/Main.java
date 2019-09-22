package main;

import controller.Controller;
import model.Model;
import view.View;

public abstract class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		final Model model = new Model();


		final Controller controller = new Controller(model);
		
		
		final View view = new View(controller);

		controller.start();

	}

}
