/*
 * The abstract class defining Pet
 */

package menagerie;

import java.util.*;

public abstract class Pet {
																					// add random number generator
	protected String name;
	protected int age;
	protected double weight;
	
	protected int foodCutoff;
	protected int attentionCutoff;
	protected int sleepCutoff;
	
	public String actions[];
	
	Random brain = new Random();
	
	public abstract String getType();
	public abstract String act(int brain);
	
	public String toString() {														// returns String of pet's info
		String output = this.getType() + "\t" + name + "\t" + age + "\t" 		
				+ String.format(".2f", weight);
		return output;
	}
	
	public boolean needsFood(int food) {
		boolean doesNeed = false;
		
		if (food > Constants.BRAIN_MIN && food <= (foodCutoff + Constants.BRAIN_MIN)) {
			doesNeed = true;
		}
		return doesNeed;
	}
	
	public boolean needsAttention(int attention) {
		boolean doesNeed = false;
		
		if (attention > foodCutoff && attention <= (attentionCutoff + foodCutoff)) {
			doesNeed = true;
		}
		return doesNeed;
	}
	
	public boolean needsSleep(int sleep) {
		boolean doesNeed = false;
		
		if (sleep > attentionCutoff && sleep <= (sleepCutoff + attentionCutoff)) {
			doesNeed = true;
		}
		return doesNeed;
	}
	
	
	public String getName() {														// getters
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setName(String name) {												// setters
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
