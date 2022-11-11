package menagerie;

public abstract class Pet {
																				// add random number generator
	String name;
	int age;
	double weight;
	
	int foodCutoff;
	int attentionCutoff;
	int sleepCutoff;
	
	public abstract String getType();
	
	public abstract void setFoodCutoff(int cutoff);
	public abstract void setAttentionCutoff(int cutoff);
	public abstract void setSleepCutoff(int cutoff);
	
	public String toString() {													// finish!
		String output = this.getType() + name + age + weight;
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
}
