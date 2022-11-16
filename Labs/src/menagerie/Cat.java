/*
 * The class that defines Cat, inherited from Pet
 */

package menagerie;

import java.util.*;

public class Cat extends Pet {

	public Cat() {																	// default constructor
		this.name = "";
		this.age = 0;
		this.weight = 0;
		this.foodCutoff = 3;
		this.attentionCutoff = 2;
		this.sleepCutoff = 8;
		this.actions = new String[] {"had some catnip.", "chased its tail.", 
				"jumped on the bookshelf.", "jumped on the countertop.", 
				"hid under the bed.", "caught a mouse.", "played with its toy.",
				"scratched its scratching pole.", "looked out the window.", 
				"meowed.", "plotted your demise.", "jumped on your bed."};
	}
	
	public Cat(String name, int age, double weight) {								// constructor
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.foodCutoff = 3;
		this.attentionCutoff = 2;
		this.sleepCutoff = 8;
		this.actions = new String[] {"had some catnip.", "chased its tail.", 
				"jumped on the bookshelf.", "jumped on the countertop.", 
				"hid under the bed.", "caught a mouse.", "played with its toy.",
				"scratched its scratching pole.", "looked out the window.", 
				"meowed.", "plotted your demise.", "jumped on your bed."};
	}
	
	
	@Override
	public String getType() {														// returns type as String
		return "cat";
	}

	@Override
	public String act(int brain) {												// TODO
		
		return "";
	}
}
