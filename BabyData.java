
public class BabyData {

	private String gender;
	private Integer rank;
	private String name;
	private Integer numOfBabies;	
	
	// Constructor for Problem 1
	BabyData(String newName){
		name = newName;
	}
	
	// Constructor for Problem 2
	BabyData(String newGender, String newName, Integer newNumOfBabies){
		gender = newGender;
		name = newName;
		numOfBabies = newNumOfBabies;
	}
	
	// Full Constructor
	BabyData(Integer newRank, String newGender, String newName, Integer newNumOfBabies){
		rank = newRank;
		gender = newGender;
		name = newName;
		numOfBabies = newNumOfBabies;
	}
	
	public Integer getRank(){
		return rank;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getName(){
		return name;
	}
	
	public void setNumOfBabies(Integer newNumOfBabies){
		numOfBabies = newNumOfBabies;
	}
	
	public Integer getNumOfBabies(){
		return numOfBabies;
	}

	
}
