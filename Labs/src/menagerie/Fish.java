package menagerie;

public class Fish extends Pet {

	public Fish() {																	// default constructor
		this.name = "";
		this.age = 0;
		this.weight = 0;
		this.foodCutoff = 2;
		this.attentionCutoff = 0;
		this.sleepCutoff = 6;
	}
	
	public Fish(String name, int age, double weight) {								// constructor
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.foodCutoff = 2;
		this.attentionCutoff = 0;
		this.sleepCutoff = 6;
	}
	
	
	@Override
	public String getType() {														// returns type as String
		return "fish";
	}

	@Override
	public String act() {												// TODO
		
		return "";
	}
}
