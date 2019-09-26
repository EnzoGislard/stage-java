package view;

public class DecryptingThread extends Thread{

		public DecryptingPanel decryptingPan;
		public int isTrue = 1;
		
		public DecryptingThread(Frame frame) {
			this.decryptingPan = new DecryptingPanel(frame);
		}
		
		@Override
		public void run() {
			while(isTrue == 1) {
				try {
					Thread.sleep(1000);
					decryptingPan.repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}