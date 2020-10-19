package ir.javacup.thread;

public class Resource {

	private int content;
	
	public synchronized int get() {
//		System.out.println("C: " + Thread.currentThread().getId() + " " + content);
		if (content == -1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int tmp = content;
		content = -1;
		notify();
		return tmp;
	}
	
	public synchronized void set(int value) {
//		System.out.println("P: " + Thread.currentThread().getId() + " " + content);
		if (value == 0) {
			return;
		}

		if (content != -1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		content = value;
		notify();

	}
	
}
