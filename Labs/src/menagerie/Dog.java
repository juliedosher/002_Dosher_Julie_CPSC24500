/*
 * The class that defines Dog, inherited from Pet
 */

package menagerie;

public class Dog extends Pet {

	public Dog() {																	// default constructor
		this.name = "";
		this.age = 0;
		this.weight = 0;
		this.foodCutoff = 4;
		this.attentionCutoff = 6;
		this.sleepCutoff = 8;
		this.actions = new String[] {"barked at the window.", "whimpered.",
				"tore the squeaker out of its toy.", "played fetch.", 
				"wagged its tail.", "drank some water.", "chased its tail.", 
				"played with its chew toy.", "ran around.", "barked.",
				"hid one of your shoes.", "jumped on the couch."};
	}
	
	public Dog(String name, int age, double weight) {								// constructor
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.foodCutoff = 4;
		this.attentionCutoff = 8;
		this.sleepCutoff = 8;
		this.actions = new String[] {"barked at the window.", "whimpered.",
				"tore the squeaker out of its toy.", "played fetch.", 
				"wagged its tail.", "drank some water.", "chased its tail.", 
				"played with its chew toy.", "ran around.", "barked.",
				"hid one of your shoes.", "jumped on the couch."};
	}
	
	
	@Override																		
	public String getType() {														// returns type as String
		return "dog";
	}

}
