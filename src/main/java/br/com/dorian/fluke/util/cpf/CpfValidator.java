package br.com.dorian.fluke.util.cpf;

public class CpfValidator {
	
	static int[] weight = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

	private static int calculateDigit(String str, int[] weight) {
		int result = 0;

		for (int index=str.length()-1, digit; index >= 0; index-- ) {
			digit = Integer.parseInt(str.substring(index,index+1));
			result += digit*weight[weight.length-str.length()+index];
		}
		result = 11 - result % 11;
		return result > 9 ? 0 : result;
	}
	
	public static boolean isValid(String cpf) {
		if ((cpf==null) || (cpf.length()!=11)) return false;
		Integer digitOne = calculateDigit(cpf.substring(0,9), weight);
		Integer digitTwo = calculateDigit(cpf.substring(0,9) + digitOne, weight);
		return cpf.equals(cpf.substring(0,9) + digitOne.toString() + digitTwo.toString());
	}
	
}
