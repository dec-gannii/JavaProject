package lab02_02;

import java.util.Scanner;

public class lab02_02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Ű�� �Է��Ͻÿ� : ");
		int height = input.nextInt();
		System.out.print("ü���� �Է��Ͻÿ� : ");
		int weight = input.nextInt();
		
		double stw = (height - 100) * 0.9;
		
		if(weight < stw) {
			System.out.print("��ü��");
		} else if (weight == stw) {
			System.out.print("���� ü��");
		} else {
			System.out.print("��ü��");
		}
	}

}
