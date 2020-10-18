package ir.javacup.dq;

import java.util.Deque;

public interface DequeUtil<T> {

	Deque<T> getDeque();

	T get(int index);

	boolean push(T element, int index); 

	boolean replace(T element, int index);

	boolean reverse(int first, int second);

}
