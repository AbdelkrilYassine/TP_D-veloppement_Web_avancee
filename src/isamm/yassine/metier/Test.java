package isamm.yassine.metier;

public class Test {

	public static boolean testFloatInRange(float nb) {
		if (nb >= 0 && nb <= 20) {
			return true;
		} else
			return false;
	}

	public static boolean testLong(String nb) {
		try {
			Long L = Long.parseLong(nb);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean testFloat(String nb) {
		try {
			Float F = Float.parseFloat(nb);
			if (testFloatInRange(F)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean testStringWithAlpha(String name) {
		return name.matches(".*[a-zA-Z].*");
	}

	public static boolean testStringWithAlphaAndNumbers(String name) {
		return testStringWithAlpha(name) && name.matches(".*[0-9].*");
	}

}
