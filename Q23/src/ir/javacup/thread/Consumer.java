package ir.javacup.thread;

import java.util.Deque;

public class Consumer extends Thread {

	private Resource resource;
	private Deque<Integer> holder;
	private int count;

	public Consumer(Resource resource, Deque<Integer> holder, int count) {
		this.resource = resource;
		this.holder = holder;
		this.count = count;
	}

	@Override
	public void run() {
		int value = 0;
		for (int i = 0; i < count; i++) {
			value = resource.get();
			holder.add(value);
		}
	}

}
