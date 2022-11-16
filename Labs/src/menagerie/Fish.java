/*
 * The class that defines Fish, inherited from Pet
 */

package menagerie;

import java.util.*;

public class Fish extends Pet {

	public Fish() {																			// default constructor
		this.name = "";
		this.age = 0;
		this.weight = 0;
		this.foodCutoff = 3;
		this.attentionCutoff = 1;
		this.sleepCutoff = 12;
		this.actions = new String[] {"swam up to the surface.", "hung out in the castle.", 
				"swam in circles.", "hid behind a plant", "swam laps in its tank."};
	}
	
	public Fish(String name, int age, double weight) {										// constructor
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.foodCutoff = 3;
		this.attentionCutoff = 1;
		this.sleepCutoff = 12;
		this.actions = new String[] {"swam up to the surface.", "hung out in the castle.", 
				"swam in circles.", "hid behind a plant", "swam laps in its tank."};
	}
	
	
	@Override
	public String getType() {														// returns type as String
		return "fish";
	}

	@Override
	public String act(int brain) {													// chooses an action and returns it as a String
		String action = "The fish, " + this.getName() + ", "
				+ " ";
		
		Random rand = new Random();
		int min = 0;
		int max = actions.length;		
		int choice = rand.nextInt(max);

		action += actions[choice];
		return action;
	}
}
