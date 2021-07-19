class Student {
	protected String name;
	protected String major;
	protected int number;
	protected int grade;
	protected int credit;

	public void setName(String name) {
		this.name = name;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public int getNumber() {
		return number;
	}

	public int getGrade() {
		return grade;
	}

	public int getCredit() {
		return credit;
	}

	public Student() {
		name = " ";
		major = " ";
		number = 2019000000;
		grade = 0;
		credit = 0;
	}

	public Student(String name, String major, int number, int grade, int credit) {
		setName(name);
		setMajor(major);
		setNumber(number);
		setGrade(grade);
		setCredit(credit);
	}
	public void print() {
		System.out.println("이름 : " + getName() + "\n" + "전공 : " + getMajor() + "\n" + "학번 : " + getNumber() + "\n" + "학년 : " + getGrade() + "\n" + "이수 학점 : " + getCredit());
	}
}

class UnderGraduate extends Student {

	protected String club;

	public void setClub(String club) {
		this.club = club;
	}

	public String getClub() {
		return club;
	}

	public UnderGraduate() {
		super();
		club = " ";
	}

	public UnderGraduate(String club) {
		super("김가은", "디지털미디어학과", 2019111233, 2, 35);
		setClub(club);
	}
	public void print() {
		System.out.println("<학부생>");
		super.print();
		System.out.println("동아리 : " + getClub());
	}
}

class Graduate extends Student {
	protected String assistant;
	protected double scholarship;

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}

	public void setScholarship(double scholarship) {
		this.scholarship = scholarship;
	}

	public String getAssistant() {
		return assistant;
	}

	public double getScholarship() {
		return scholarship;
	}

	public Graduate() {
		super();
		assistant = " ";
		scholarship = 0.00;
	}

	public Graduate(String assistant, double scholarship) {
		super("김가은", "디지털미디어학과", 2019111233, 2, 35);
		setAssistant(assistant);
		setScholarship(scholarship);
	}
	public void print() {
		System.out.println("<대학원생>");
		super.print();
		System.out.println("조교 유형 : " + getAssistant() + "\n" + "장학금 비율 : " + getScholarship());
	}
}

public class studentTest {

	public static void main(String[] args) {
		Student s1 = new Student("김가은", "디지털미디어학과", 2019111233, 2, 35);
		s1.print();
		UnderGraduate s2 = new UnderGraduate("동아리 없음");
		s2.print();
		Graduate s3 = new Graduate("연구 조교", 0.7);
		s3.print();
	}
}
