package lab02_03;

public class lab02_03 {

	public static void main(String[] args) {
		double[] numbers = {1.0, 2.0, 3.0, 4.0};
		for (double value : numbers) {
			System.out.print(value + " ");	
		}
		
		double sum = 0;
		
		for (int i=0; i < numbers.length; i++ ) {
			sum += numbers[i];
		}
		System.out.print("\n" + "합은 " + sum);
		
		double max = 0;
		
		for (double value : numbers) {
			if (value > max) {
				max = value;
			} 
		}
		System.out.print("\n" + "최대값은 " + max);
	}
	

}
