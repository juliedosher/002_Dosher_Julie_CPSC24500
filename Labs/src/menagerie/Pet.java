package menagerie;

public abstract class Pet {

	String name;
	int age;
	double weight;
	
	public abstract String getType();
	
	public String toString() {													//add proper spacing
		String output = this.getType() + name + age + weight;
		return output;
	}
	
}
