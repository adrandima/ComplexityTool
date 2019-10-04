package CsType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericValues {
	private int complexityValue = 1;
	private int numberOfNumericValues = 0;
	private boolean ignore = true;
	// private int totalNumberOfNumericValues = 0;
	private int i = 0;

	public int[] complexity(String[] code) {
		int complexity[] = new int[code.length];

		for (String s : code) {
			String line = s;
			int length = s.length();
			for (int i = 0; i < length - 1; i++) {
				char character = line.charAt(i);
				char characterNext = line.charAt(i + 1);
				if (character == '/' && characterNext == '/') {
					if (i == 0) {
						ignore = false;
					}
					break;
				}
			}
			if (ignore == true) {
				Pattern p = Pattern.compile("(\\d+(?:\\.\\d+)?)");
				Matcher m = p.matcher(line);
				while (m.find()) {
					if (m.group() != null) {
						numberOfNumericValues++;
					}
				}
			}
			// System.out.println(s);
			// System.out.println("\tNumber Of Arithmetic Operators :"+
			// numberOfNumericValues);
			// System.out.println("");
			complexity[i] = numberOfNumericValues * complexityValue;

			// totalNumberOfNumericValues = totalNumberOfNumericValues +
			// numberOfNumericValues;
			ignore = true;
			numberOfNumericValues = 0;
			i++;
		}
		// System.out.println("Total Number Of Arithmetic Operators :"
		// +totalNumberOfNumericValues);

		return complexity;
	}

}
