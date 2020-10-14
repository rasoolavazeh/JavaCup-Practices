package ir.javacup.contest.zoo;

public class CageCopier {

	public void copy(Cage c1, Cage c2) {
		if (c1 == null || c2 == null) {
			return;
		}

		if (c1.getBirds() != null) {
			Bird[] tmpBirds = c1.getBirds();
			Bird[] birds = new Bird[tmpBirds.length];
			Bird bird;
			for (int i = 0; i < birds.length; i++) {
				if (tmpBirds[i] != null) {
					bird = new Bird();
					bird.setName(tmpBirds[i].getName());
					bird.setColor(tmpBirds[i].getColor());
					birds[i] = bird;
				}
			}
			c2.setBirds(birds);
		} else {
			c2.setBirds(null);
		}

		c2.setName(c1.getName());
		c2.setId(c1.getId());
	}

//	public static void main(String[] args) {
//		Cage a = new Cage(1, "first");
//		a.setBirds(null);
//		Cage b = new Cage();
//
//		CageCopier copier = new CageCopier();
//		copier.copy(a, b);
//		System.out.println(a.getId());
//		System.out.println(a.getName());
//		System.out.println(a.getBirds());
//		System.out.println(b.getId());
//		System.out.println(b.getName());
//		System.out.println(b.getBirds());
//
//		a.setId(5);
//		a.setName("second");
//
//		System.out.println(a.getId());
//		System.out.println(a.getName());
//		System.out.println(b.getId());
//		System.out.println(b.getName());
//
//
//	}
}
