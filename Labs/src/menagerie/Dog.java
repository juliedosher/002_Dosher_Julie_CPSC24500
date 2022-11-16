package menagerie;

public class Dog extends Pet {

	public Dog() {																	// default constructor
		this.name = "";
		this.age = 0;
		this.weight = 0;
		this.foodCutoff = 3;
		this.attentionCutoff = 8;
		this.sleepCutoff = 8;
	}
	
	public Dog(String name, int age, double weight) {								// constructor
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.foodCutoff = 3;
		this.attentionCutoff = 8;
		this.sleepCutoff = 8;
	}
	
	
	@Override																		
	public String getType() {														// returns type as String
		return "dog";
	}

	@Override
	public String act() {												// TODO
		
		return "";
	}
	
}
