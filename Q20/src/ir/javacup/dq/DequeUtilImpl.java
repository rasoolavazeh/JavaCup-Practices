package ir.javacup.dq;

import java.util.Deque;
import java.util.LinkedList;

public class DequeUtilImpl<T> implements DequeUtil<T> {
	private Deque<T> deque = new LinkedList<>();

	@Override
	public Deque<T> getDeque() {
		return deque;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= deque.size()) {
			throw new IllegalArgumentException("index should be between 0 and size-1");
		}

		LinkedList<T> tmp = new LinkedList<>();
		for (T t : deque) {
			tmp.add(t);
		}

		return tmp.get(index);
	}

	@Override
	public boolean push(T element, int index) {
		if (index < 0 || index >= deque.size()) {
			return false;
		}

		LinkedList<T> tmp = new LinkedList<>();
		for (T t : deque) {
			tmp.add(t);
		}

		tmp.add(index, element);

		deque.clear();

		for (T t : tmp) {
			deque.add(t);
		}

		return true;
	}

	@Override
	public boolean replace(T element, int index) {
		if (index < 0 || index >= deque.size()) {
			return false;
		}

		LinkedList<T> tmp = new LinkedList<>();
		for (T t : deque) {
			tmp.add(t);
		}

		tmp.remove(index);
		tmp.add(index, element);

		deque.clear();

		for (T t : tmp) {
			deque.add(t);
		}

		return true;
	}

	@Override
	public boolean reverse(int first, int second) {
		if (first > second || first < 0 || first >= deque.size() || second < 0 || second >= deque.size()) {
			return false;
		}

		LinkedList<T> tmp = new LinkedList<>();
		for (T t : deque) {
			tmp.add(t);
		}

		int fIndex = first;
		int sIndex = second;
		T t1, t2;

		while (first < second) {
			t1 = tmp.get(first);
			t2 = tmp.get(second);

			tmp.remove(first);
			tmp.add(first, t2);
			tmp.remove(second);
			tmp.add(second, t1);

			first++;
			second--;
		}

		deque.clear();

		for (T t : tmp) {
			deque.add(t);
		}

		return true;
	}

//	public static void main(String[] args) {
//		DequeUtilImpl<Integer> dequeImpl = new DequeUtilImpl<>();
//		for(int i=0; i<6; i++)
//			dequeImpl.getDeque().push(i);
//		System.out.println(dequeImpl.push(11, 2));
//		System.out.println(dequeImpl.replace(11, 2));
//		System.out.println(dequeImpl.reverse(1, 4));
//		System.out.println(dequeImpl.get(1));
//
//	}
}