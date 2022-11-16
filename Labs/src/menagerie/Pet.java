package menagerie;

public abstract class Pet {
																					// add random number generator
	protected String name;
	protected int age;
	protected double weight;
	
	protected int foodCutoff;
	protected int attentionCutoff;
	protected int sleepCutoff;
	
	public abstract String getType();
	public abstract String act();
	
	public String toString() {														// returns String of pet's info
		String output = this.getType() + "\t" + name + "\t" + age + "\t" 		
				+ String.format(".2f", weight);
		return output;
	}
	
	public boolean needsFood(int food) {
		boolean doesNeed = false;
		
		if (food < foodCutoff) {
			doesNeed = true;
		}
		return doesNeed;
	}
	
	public boolean needsAttention(int attention) {
		boolean doesNeed = false;
		
		if (attention < attentionCutoff) {
			doesNeed = true;
		}
		return doesNeed;
	}
	
	public boolean needsSleep(int sleep) {
		boolean doesNeed = false;
		
		if (sleep < sleepCutoff) {
			doesNeed = true;
		}
		return doesNeed;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getWeight() {
		return weight;
	}
}
