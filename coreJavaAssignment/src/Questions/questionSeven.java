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
	
	public String toString() {
		return this.name + " " + this.department + " " + this.age;
	}
}

class Sortbyname implements Comparator<questionSeven>{
	public int compare(questionSeven a, questionSeven b) {
		return a.name.compareTo(b.name);
	}
}

class Sortbydepartment implements Comparator<questionSeven>{
	public int compare(questionSeven a, questionSeven b) {
		return a.name.compareTo(b.name);
	}
}

class Sortbyage implements Comparator<questionSeven>{
	public int compare(questionSeven a, questionSeven b) {
		return a.age - b.age;
	}
}