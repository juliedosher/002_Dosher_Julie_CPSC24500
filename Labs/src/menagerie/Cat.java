package menagerie;

public class Cat extends Pet {

	public Cat() {																	// default constructor
		this.name = "";
		this.age = 0;
		this.weight = 0;
		this.foodCutoff = 3;
		this.attentionCutoff = 2;
		this.sleepCutoff = 8;
	}
	
	public Cat(String name, int age, double weight) {								// constructor
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.foodCutoff = 3;
		this.attentionCutoff = 2;
		this.sleepCutoff = 8;
	}
	
	
	@Override
	public String getType() {														// returns type as String
		return "cat";
	}

	@Override
	public String act() {												// TODO
		
		return "";
	}

}
