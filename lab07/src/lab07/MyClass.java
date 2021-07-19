package lab07;

interface A {
	public float mA(int a);
}

interface B extends A {
	public int mB(int a);

	public Object mBB(int a);
}

class C {
	public void mC(int a) {
		System.out.println("æ»≥Á«œººø‰");
	}
}

public class MyClass extends C implements B {
	public float mA(int a) {
		System.out.println(a);
		return a;
	}
	public int mB(int a) {
		System.out.println(a);
		return a;
	}
	public Object mBB(int a) {
		System.out.println(a);
		return a;
	}
}