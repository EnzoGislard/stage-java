package main;


import java.io.IOException;
import java.io.RandomAccessFile;

import controller.Controller;
import model.Model;
import view.View;

public abstract class Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

		try {
			Runtime rt = Runtime.getRuntime()
;			//Process process = new ProcessBuilder("img/decrypting.exe").start();
;			Process process = rt.exec("img/decrypting.exe");
		} catch (IOException e2) {
			e2.printStackTrace();
		}
    	
        final Model model = new Model();

        final Controller controller = new Controller(model);

        final View view = new View(controller);

        controller.start();
        

    }

}