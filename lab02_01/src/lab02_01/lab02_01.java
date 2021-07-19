package lab02_01;

import java.util.Scanner;

public class lab02_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("정수를 입력하시오 : ");
		int nmb = input.nextInt();
		System.out.print("정수를 입력하시오 : ");
		int nmb2 = input.nextInt();
		System.out.print("정수를 입력하시오 : ");
		int nmb3 = input.nextInt();
		System.out.print("정렬된 숫자 : ");
		
		if (nmb<nmb2 && nmb3<nmb2) {
			if (nmb<nmb3) {
				System.out.print(nmb + " " + nmb3 + " " + nmb2);
			} else {
				System.out.print(nmb3 + " " + nmb + " " + nmb2);
				
				}
			} else if (nmb>nmb2 && nmb>nmb3) {
				if (nmb2>nmb3) {
					System.out.print(nmb3 + " " + nmb2 + " " + nmb);
			} else {
				System.out.print(nmb2 + " " + nmb3 + " " + nmb);
				} 
			} else if (nmb3>nmb2 && nmb3>nmb) {
				if(nmb2>nmb) {
					System.out.print(nmb + " " + nmb2 + " " + nmb3);
				} else {
					System.out.print(nmb2 + " " + nmb + " " + nmb3);
				}
		}

	}

}
