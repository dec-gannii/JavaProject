package lab02_04;

public class lab02_04 {

	public static void main(String[] args) {
		
		String[] str1 = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] str2 = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		
		double num = Math.random();
		
		for ( ; num < 1; ) {
			if (num<0.4) {
				System.out.print(str1[(int)(num*10)] + "ÀÇ ");
			break;
			}
			else {
				num = Math.random();
			}
			}
		
		double num1 = Math.random();
		for ( ; num1 < 1; ) {
			if (num1*100<13) {
				System.out.print(str2[(int)(num1*100)]);
				break;
				}
			else {
				num1 = Math.random();
				}
			}
		}
	}
	
	
	
		
		

