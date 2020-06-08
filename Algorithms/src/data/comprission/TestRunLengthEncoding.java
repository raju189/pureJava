package data.comprission;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRunLengthEncoding {

	public static void main(String[] args) {
		String text = "rrrrorewoiureowiurrewiruew";
		String encodeText = RunLengthEncoding.encode(text);

		System.out.println("Encode String -> " + encodeText);
		System.out.println(RunLengthEncoding.decode(encodeText));
	}

}

class RunLengthEncoding {
	public static String encode(String pattern) {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < pattern.length(); i++) {
			int runLength = 1;

			while (i + 1 < pattern.length() && pattern.charAt(i) == pattern.charAt(i + 1)) {
				runLength++;
				i++;
			}

			builder.append(runLength);
			builder.append(pattern.charAt(i));
		}

		return builder.toString();
	}

	public static String decode(String encodeText) {
		StringBuilder builder = new StringBuilder();

		Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");

		Matcher matcher = pattern.matcher(encodeText);
		while (matcher.find()) {
			int times = Integer.parseInt(matcher.group());
			matcher.find();
			while (times-- != 0) {
				builder.append(matcher.group());
			}
		}

		return builder.toString();

	}
}
