package com.cagataygurturk.services.util;

public class PasswordValidation {
	public static boolean isOldPassword(String password) {
		if (password.equals("AgodaService2!@1TestData")) {
			return true;
		}
		return false;
	}

	public static int countAlphaNumericCharacters(String str) {
		int total = 0;
		String alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$&*";
		for (int i = 0; i < str.length(); i++) {
			if (alphaNumeric.indexOf(str.charAt(i)) != -1)
				total++;
		}
		return total;
	}

	public static boolean isContainUpperCase(String str) {
		String upperCaseRegex = ".*[ABCDEFGHIJKLMNOPQRSTUVWXYZ].*";
		if (str.matches(upperCaseRegex)) {
			return true;
		}
		return false;
	}

	public static boolean isContainLowerCase(String str) {
		String lowerCaseRegex = ".*[abcdefghijklmnopqrstuvwxyz].*";
		if (str.matches(lowerCaseRegex)) {
			return true;
		}
		return false;
	}

	public static boolean isContainNumeric(String str) {
		String numberRegex = ".*[0123456789].*";
		if (str.matches(numberRegex)) {
			return true;
		}
		return false;
	}

	public static boolean isContainSpecialCharacters(String str) {
		String specialCharactersRegex = ".*[ !\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~].*";
		if (str.matches(specialCharactersRegex)) {
			return true;
		}
		return false;
	}

	public static boolean isDuplicatedCharsExceed(String str, int numberOfDuplicated) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			if (stringBuilder.toString().indexOf(str.charAt(i)) == -1) {
				stringBuilder.append(str.charAt(i));
				for (int j = i + 1; j < str.length(); j++) {
					if (str.charAt(i) == str.charAt(j)) {
						count++;
					}
				}
			}
			if (count > numberOfDuplicated) {
				return true;
			}
		}
		return false;
	}

	public static boolean isSpecialCharsExceed(String str, int numberOfSpecialChars) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (isContainSpecialCharacters(str.substring(i, i + 1))) {
				count++;
			}
		}
		return count > numberOfSpecialChars ? true : false;
	}

	public static boolean isPercentOfNumberOfNumericMoreThan(String str, int limitPercent) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				count++;
			}
		}
		if (count * 100 / str.length() > limitPercent) {
			return true;
		}
		return false;
	}

	public static boolean isValidPassword(String password) {
		if (countAlphaNumericCharacters(password) < 18) {
			return false;
		} else if (!isContainUpperCase(password)) {
			return false;
		} else if (!isContainLowerCase(password)) {
			return false;
		} else if (!isContainNumeric(password)) {
			return false;
		} else if (!isContainSpecialCharacters(password)) {
			return false;
		} else if (isDuplicatedCharsExceed(password, 4)) {
			return false;
		} else if (isSpecialCharsExceed(password, 4)) {
			return false;
		} else if (isPercentOfNumberOfNumericMoreThan(password, 49)) {
			return false;
		}
		return true;
	}
}
