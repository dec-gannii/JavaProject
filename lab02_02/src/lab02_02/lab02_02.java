package lab02_02;

import java.util.Scanner;

public class lab02_02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("키를 입력하시오 : ");
		int height = input.nextInt();
		System.out.print("체중을 입력하시오 : ");
		int weight = input.nextInt();
		
		double stw = (height - 100) * 0.9;
		
		if(weight < stw) {
			System.out.print("저체중");
		} else if (weight == stw) {
			System.out.print("정상 체중");
		} else {
			System.out.print("과체중");
		}
	}

}
