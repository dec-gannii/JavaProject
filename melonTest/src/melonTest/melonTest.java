package melonTest;

class Food {
	private int cal;
	private int cost;
	private int kg;

	public int getCal() {
		return cal;
	}

	public int getCost() {
		return cost;
	}

	public int getKg() {
		return kg;
	}

	public void setCal(int cal) {
		this.cal = cal;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}
}

class Melon extends Food {
	private String info;
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String toString() {
		return "칼로리 : " + getCal() + "\n" + "가격 : " + getCost() + "\n" + "무게 : " + getKg() + "\n" + "경작지 정보 : " + getInfo();
	}
}

public class melonTest {

	public static void main(String[] args) {
		Food f1 = new Food();
		f1.setCal(20);
		f1.setCost(1000);
		f1.setKg(1);
		System.out.println("칼로리 : " + f1.getCal() + "\n" + "가격 : " + f1.getCost() + "\n" + "무게 : " + f1.getKg());
		
		Melon mln = new Melon();
		mln.setCal(100);
		mln.setCost(20000);
		mln.setKg(3);
		mln.setInfo("Africa");
		System.out.print(mln);;
	}

}
