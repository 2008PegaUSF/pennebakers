package Questions;

import java.util.Comparator;

public class questionSeven {
	
	String name, department;
	int age;
	
	public questionSeven(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public questionSeven() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return this.name + " " + this.department + " " + this.age;
	}
	
	class SortByDepartment implements Comparator<questionSeven>{
		public int compare(questionSeven a, questionSeven b) {
			return a.department.compareTo(b.department);
		}
	}
	
	class SortByName implements Comparator<questionSeven>{
		public int compare(questionSeven a, questionSeven b) {
			return a.name.compareTo(b.name);
		}
	}
	
	class SortByAge implements Comparator<questionSeven>{
		public int compare(questionSeven a, questionSeven b) {
			return a.age - b.age;
		}
	}
}
