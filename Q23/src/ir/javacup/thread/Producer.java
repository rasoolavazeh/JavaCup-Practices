package ir.javacup.thread;

import java.util.Deque;

public class Producer extends Thread {

	private Resource resource;
	private Deque<Integer> holder;
	private int count;

	public Producer(Resource resource, Deque<Integer> holder, int count) {
		this.resource = resource;
		this.holder = holder;
		this.count = count;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.count; i++) {
			resource.set(i);
			holder.add(i);
			try {
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
