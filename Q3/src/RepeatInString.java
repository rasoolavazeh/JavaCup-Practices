
public class RepeatInString {

	public  int StringInString(String one, String two) {

		if (one == null || two == null || one.length() == 0 || two.length() == 0) {
			return 0;
		}

		int count = 0;
		while(true) {
			if (one.indexOf(two) == -1) {
				break;
			}

			one = one.substring(one.indexOf(two) + 1);
			count++;
		}
		return count;
	}
}