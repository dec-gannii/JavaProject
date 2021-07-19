package lab07;

public class Rectangle implements GraphicsObject{
	private int length;
	private int width;
	
	public void setDimensions(int l, int w) {
		length = l;
		width = w;
	}
	
	public int getArea() {
		return length*width;
	}
	
	public void draw() {
		System.out.println("Rectangle class�� draw() ȣ��");
	}
	
	public static void main(String args[]) {
		Rectangle r = new Rectangle();
		r.setDimensions(2, 4);
		System.out.println(r.getArea());
		r.draw();
	}
}
