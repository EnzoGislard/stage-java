package view;

public class DecryptingThread extends Thread{

		public DecryptingPanel decryptingPan;
		public int isTrue = 1;
		
		public DecryptingThread(Frame frame) {
			this.decryptingPan = new DecryptingPanel(frame);
			
			System.out.println("TEST#1");
		}
		
		@Override
		public void run() {
			System.out.println("TEST#2");
			while(isTrue == 1) {
				System.out.println("TEST#3");
				try {
					System.out.println("TEST#4");
					decryptingPan.setIgnoreRepaint(false);
					decryptingPan.repaint();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}