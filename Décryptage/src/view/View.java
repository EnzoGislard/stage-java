package view;


import model.Model;

public class View{

	private Frame frame;
	private int blocker= 0;

	public View(Model model) {

		this.setFrame(new Frame(model));
	}


	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame_p) {
		frame = frame_p;
	}



	public int getBlock() {
		return blocker;
	}

	public void setBlock(int block) {
		this.blocker = block;
	}
}
