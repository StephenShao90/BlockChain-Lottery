package Controller;

//imports
import java.util.Arrays;

//Block class
public class Block {
	
	//fields
	private String name;
	private int[] lotteryNumbers = new int[6];
	private int blockHash;
	private int previousBlockHash;
	
	//constructor(no block hash parameter)
	public Block(String name, int[] lotteryNumbers, int previousBlockHash) {
		super();
		this.name = name;
		this.lotteryNumbers = lotteryNumbers;
		this.previousBlockHash = previousBlockHash;
		this.blockHash = Arrays.hashCode(new int[] {Arrays.hashCode(lotteryNumbers), this.previousBlockHash});
	}
	
	//getters and setters(unedited autogeneration)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getLotteryNumbers() {
		return lotteryNumbers;
	}
	public void setLotteryNumbers(int[] lotteryNumbers) {
		this.lotteryNumbers = lotteryNumbers;
	}
	public int getBlockHash() {
		return blockHash;
	}
	public void setBlockHash(int blockHash) {
		this.blockHash = blockHash;
	}
	public int getPreviousBlockHash() {
		return previousBlockHash;
	}
	public void setPreviousBlockHash(int previousBlockHash) {
		this.previousBlockHash = previousBlockHash;
	}
	
	//to string method(unedited autogeneration)
	@Override
	public String toString() {
		return "Block [name=" + name + ", lotteryNumbers=" + Arrays.toString(lotteryNumbers) + ", blockHash="
				+ blockHash + ", previousBlockHash=" + previousBlockHash + "]";
	}
	
	
	
	
	
}
