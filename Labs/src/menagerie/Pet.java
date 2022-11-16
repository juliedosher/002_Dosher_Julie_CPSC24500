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
	
	public abstract String getType();
	//public abstract String act(int brain);
	
	public String toString() {														// returns String of pet's info
		String output = this.getType() + "\t" + name + "\t" + age + "\t" 		
				+ String.format(".2f", weight);
		return output;
	}
	
	public String act() {															// chooses an action and returns it as a String
		String action = "The " + this.getType() + ", " 
				+ this.getName() + ", ";
		
		Random rand = new Random();
		int max = actions.length;		
		int choice = rand.nextInt(max);

		if (needsFood(choice)) {
			action += Constants.FOOD;
			action += "\n" + "The " + this.getType() 
				+ ", " + this.getName() + ", "; 
		}
		
		if (needsAttention(choice)) {
			action += Constants.ATTENTION;
			action += "\n" + "The " + this.getType() 
				+ ", " + this.getName() + ", "; 
		}
		
		if (needsSleep(choice)) {
			action += Constants.SLEEP;
			action += "\n" + "The " + this.getType() 
				+ ", " + this.getName() + ", "; 
		}
		
		System.out.println("RNG: " + choice);
		
		action += actions[choice];
		return action;
	}
	
	public boolean needsFood(int choice) {
		boolean doesNeed = false;
		
		if (choice > Constants.HOUR_MIN && choice <= (foodCutoff + Constants.HOUR_MIN)) {
			doesNeed = true;
		}
		return doesNeed;
	}
	
	public boolean needsAttention(int choice) {
		boolean doesNeed = false;
		
		if (choice > foodCutoff && choice <= (attentionCutoff + foodCutoff)) {
			doesNeed = true;
		}
		return doesNeed;
	}
	
	public boolean needsSleep(int choice) {
		boolean doesNeed = false;
		
		if (choice > attentionCutoff && choice <= (sleepCutoff + attentionCutoff)) {
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
