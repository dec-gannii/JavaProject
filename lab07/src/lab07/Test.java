package lab07;

public class Test implements controllable {
	
	public void play() {
		System.out.println("play");
	}
	public void stop() {
		System.out.println("stop");
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.play();
		test.stop();
	}
	
	/*public static void main(String[] args) {
		controllable c = new controllable() {
			public void play() {
				System.out.println("play");
				}
			public void stop() {
				System.out.println("stop");
				}
		};
		c.play();
		c.stop();
	}*/


}
