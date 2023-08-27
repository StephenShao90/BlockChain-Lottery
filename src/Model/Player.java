package Model;

//imports
import java.util.Random;

//Player class
public class Player {

	//fields
	private int[] lotteryNumbers = new int[6];
	private String name;
	
	//constructor(only name parameter)
	public Player(String name) {
		super();
		
		//generate a random lottery ticket number
		for(int index = 0; index < 6; index++) {
			Random rand = new Random();
			int digit = rand.nextInt(10);
			this.lotteryNumbers[index] = digit;
		}
		this.name = name;
	}
	
	//getters and setters(unedited autogeneration)
	public int[] getLotteryNumbers() {
		return lotteryNumbers;
	}
	public void setLotteryNumbers(int[] lotteryNumbers) {
		this.lotteryNumbers = lotteryNumbers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
