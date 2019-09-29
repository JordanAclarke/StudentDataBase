package StudentDatabase;

public class Lab2 {

	public static void main(String[] args) {
		Student stu1 = new Student("Jack", "123455939");
		stu1.enroll("ENGL1330");
		stu1.enroll("MATH3120");
		stu1.showCourses();
		stu1.checkBalance();
		stu1.payTuition(2000);
		System.out.println(stu1.toString());
	}
	

}
class Student {
	private static int id = 0;
	private String userId;
	private String name;
	private String ssn;
	private String email;
	private String courses = "";
	private static final int costOfCourse = 800;
	private double balance = 0;
	private double refund;
	
	public Student(String name, String ssn) {
		id++;
		this.name = name;
		this.ssn = ssn;
		setUserId();
		setEmail();
	}
	
	
	private void setEmail() {
		email = name.toLowerCase()+ id + "@testuniversity.com";
		System.out.println("Your email is " + email);
	}
	private void setUserId() {
		int max = 9000;
		int min = 1000;
		int random = (int) (Math.random() * 10000) * ((max - min));
		random += min;
		userId = id +  ""+ random + ssn.substring(6);
		System.out.println("Your User ID: " + userId);
	}
	
	public void enroll(String course) {
		this.courses = this.courses + "\n" + course.toUpperCase();
		balance += costOfCourse;
		System.out.println("You have enrolled in " + course);
	}
	
	public void payTuition(double amount) {
		if(balance >= amount) {
		balance -= amount;
		System.out.println("Tuition $" + amount + " has been received!" +
		"\n You have " + balance + " remaining");
		} else if(balance < amount) {
			double leftOver = amount - balance;
			balance -= amount;
			refund += leftOver;
			System.out.println("Tuition $" + amount + " has been received!" +
					"\n You have been refunded $" + leftOver);
			balance = 0;
			System.out.println("Your pending refund account is $" + refund);
			checkBalance();
		}
	}
	
	public void checkBalance() {
		System.out.println("Balance: $" + balance );
	}
	public void showCourses() {
		System.out.println("Your current courses are : " + this.courses);
	}
	
	public String toString() {
		return "[Name: " + name + "]\n[Courses: " + courses + 
				" ]\nBalance Due: " + balance + " ]";
	}
	
	
}
