package ir.javacup.library;

import java.util.Random;

public class Library {

	private Member[] members;
	private final int capacity;
	private IdGenerator idGenerator;
	private int memberCount = 0;

	public Library(int capacity, IdGenerator idGenerator) {
		this.capacity = capacity;
		this.members = new Member[capacity];
		this.idGenerator = idGenerator;
	}

	public void register(Member member) throws LibraryFullException {
		// TODO implement
		if (members.length == memberCount) {
			throw new LibraryFullException("Library is full");
		}
		if (member == null) {
			throw new IllegalArgumentException("member is null");
		}
		if (member.getFirstName() == null) {
			throw new IllegalArgumentException("member.firstName is null");
		}
		if (member.getLastName() == null) {
			throw new IllegalArgumentException("member.lastName is null");
		}

		member.setId(idGenerator.generate());
		for (int i = 0; i < capacity; i++) {
			if (members[i] != null) {
				continue;
			}

			members[i] = member;
			break;
		}
		memberCount++;
//		members[memberCount] = member;
	}
	
	public Member unregister(int id) {
		// TODO implement
		Member tmp = new Member();
		for (int i = 0; i < capacity; i++) {
			if (members[i] != null) {
				if (id == members[i].getId()) {
					tmp.setId(members[i].getId());
					tmp.setFirstName(members[i].getFirstName());
					tmp.setLastName(members[i].getLastName());
					members[i] = null;
					memberCount--;
					return tmp;
				}
			}
		}

		throw new MemberNotFoundException("No member found with the given id");
	}

	public int getMemberCount() {
		// TODO implement
		return memberCount;
	}
	
	public boolean isFull() {
		// TODO implement
		if (capacity == memberCount) {
			return true;
		}
		return false;
	}
	
	public Member[] getMembers() {
		return members;
	}

	public int getCapacity() {
		return capacity;
	}

//	public static void main(String[] args) throws LibraryFullException {
//		Member m1 = new Member("A", "a");
//		Member m2 = new Member("B", "b");
//		Member m3 = new Member("C", "c");
//		Member m4 = new Member("D", "d");
//		Member m5 = new Member("E", "e");
//		Member m6 = new Member("F", "f");
//
//		Library library = new Library(5, new IdGenerator() {
//			@Override
//			public int generate() {
//				Random random = new Random();
//				return random.nextInt();
//			}
//		});
//
//		library.register(m1);
//		library.unregister(m1.getId());
//		library.register(m2);
//		library.register(m3);
//		library.register(m4);
//		library.register(m5);
//		library.register(m1);
//		library.unregister(m3.getId());
//		library.unregister(m5.getId());
//		library.unregister(m1.getId());
//		library.unregister(m2.getId());
//		library.unregister(m4.getId());
//		library.register(m5);
//		library.register(m6);
//		library.register(m3);
//	}

}
