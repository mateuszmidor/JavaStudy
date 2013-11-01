public class StringCalculator {

	private static final String NUMBER_SEPARATOR = " ";

	public int addAndPrintOut(String numbers) {

		String[] numberArray = numbers.split(NUMBER_SEPARATOR);
		int result = 0;
		for (String number : numberArray)
			result += Integer.parseInt(number);

		System.out.print(result);
		return result;
	}

}
