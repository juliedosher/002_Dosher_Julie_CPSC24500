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
		
		Random rand = new Random();													// determines which action the pet will do
		int max = actions.length;		
		int actionChoice = rand.nextInt(max);
		
		Random brain = new Random();												// determines if pet needs to eat, sleep, or seek attention
		int needsChoice = brain.nextInt(Constants.HOUR_MAX) + Constants.HOUR_MIN;

		if (needsFood(needsChoice)) {
			action += Constants.FOOD;
			action += "\n" + "The " + this.getType() 
				+ ", " + this.getName() + ", "; 
		}
		
		if (needsAttention(needsChoice)) {
			action += Constants.ATTENTION;
			action += "\n" + "The " + this.getType() 
				+ ", " + this.getName() + ", "; 
		}
		
		if (needsSleep(needsChoice)) {
			action += Constants.SLEEP;
			action += "\n" + "The " + this.getType() 
				+ ", " + this.getName() + ", "; 
		}
		
		action += actions[actionChoice];
		return action;
	}
	
	public boolean needsFood(int choice) {
		boolean doesNeed = false;
		
		if (choice > Constants.HOUR_MIN && choice <= (foodCutoff)) {
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
		
		if (choice > attentionCutoff && choice <= (sleepCutoff + attentionCutoff + foodCutoff)) {
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
