
public class Student extends Person {
	private int id;
	private double grade;
	
	public Student(String name, int age) {
		this.setName(name);
		this.setAge(age); 
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [Name: " + this.getName() + " Id: "+ id +"]";
	}
	
	
}
