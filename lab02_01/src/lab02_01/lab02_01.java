package lab02_01;

import java.util.Scanner;

public class lab02_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("������ �Է��Ͻÿ� : ");
		int nmb = input.nextInt();
		System.out.print("������ �Է��Ͻÿ� : ");
		int nmb2 = input.nextInt();
		System.out.print("������ �Է��Ͻÿ� : ");
		int nmb3 = input.nextInt();
		System.out.print("���ĵ� ���� : ");
		
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
