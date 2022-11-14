package menagerie;

public class Fish extends Pet {

	public Fish(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	@Override
	public String getType() {
		return "fish";
	}

	@Override
	public void setFoodCutoff(int cutoff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttentionCutoff(int cutoff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSleepCutoff(int cutoff) {
		// TODO Auto-generated method stub
		
	}

}
