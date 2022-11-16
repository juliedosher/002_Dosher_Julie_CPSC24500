package menagerie;

public class Dog extends Pet {

	public Dog(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.foodCutoff = 3;
		this.attentionCutoff = 8;
		this.sleepCutoff = 8;
	}
	
	
	@Override
	public String getType() {
		return "dog";
	}

	@Override
	public String act() {												// TODO
		
		return "";
	}
	
}
