package Application;

//imports
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Controller.Block;
import Model.Player;

//Application class
public class Application {

	//main method
	public static void main(String[] args) {
		
		//system input
		Scanner input = new Scanner(System.in);
		
		//Lists
		ArrayList<Player> playerList = new ArrayList<Player>();//contains lottery players
		ArrayList<Block> blockChain = new ArrayList<Block>();//contains blocks in blockchain
		
		//variables
		String addPlayer; //Y/N value 
		int currentBlock = 0; //makes sure each player gets added to correct block
		int previousHash; //previous hash value
		int trueHash = -1;//validates hash value
		int truePreviousHash = -1;//validates previous hash value
		boolean winnerFound = false;
		
		//do loop
		do {
			
			//ask user if they want to add a new player
			System.out.print("Add a new player?(Y/N): ");
			addPlayer = input.next();
			System.out.println("");
			
			//if user wants to add player...
			if(addPlayer.equals("Y") || addPlayer.equals("y")) {
				
				//Prompts for player name
				System.out.print("Player name: ");
				String playerName = input.next();
				
				//creates new player object
				Player newPlayer = new Player(playerName);
				
				//add new player to the player list
				playerList.add(newPlayer);
				
				//display player name
				System.out.println("Name: " + newPlayer.getName());
				
				//display lottery ticket number
				System.out.print("Ticket number:");
				for(int i = 0; i < 6; i++) 
					System.out.print(" " + newPlayer.getLotteryNumbers()[i]);
				System.out.println(" ");
				
				//Makes sure current block isnt the first block
				if(currentBlock > 0) {
					
					//get previous blocks hash value
					previousHash = blockChain.get(currentBlock-1).getBlockHash();
					
				//If current block is first block
				}else {
					
					//set previous hash just to zero
					previousHash = 0;
				}
				
				//create and add new block to block chain
				Block block = new Block(playerName, newPlayer.getLotteryNumbers(), previousHash);
				blockChain.add(block);
				
				//display current and previous hash values for block
				System.out.println("hash: " + block.getBlockHash());
				System.out.println("previous hash: " + block.getPreviousBlockHash());
			}
			System.out.println(" ");
			
			//move on to next block
			currentBlock++;
			
		//checks if user wants to keep adding new players
		}while(addPlayer.equals("Y") || addPlayer.equals("y"));
		
		//pick a random player from player list
		Random rand = new Random();
		int selection = rand.nextInt(playerList.size());
		Player winningPlayer = playerList.get(selection);
		
		//display winning players ticket number
		System.out.println("The winning numbers are: ");
		for(int i = 0; i < 6; i++) {
			System.out.print(winningPlayer.getLotteryNumbers()[i] + " ");
		}
		do {
			//Prompts winner to claim prize
			System.out.println("");
			System.out.print("Winner claim prize by entering name: ");
			String claimWinner = input.next();
			System.out.println(" ");
			
			//looks through all blocks
			for(Block blockIndex : blockChain) {
				//finding block with entered name
				if(blockIndex.getName().equals(claimWinner)) {
					
					//finds that blocks true hash and previous hash values
					trueHash = blockIndex.getBlockHash();
					truePreviousHash = blockIndex.getPreviousBlockHash();
					
				}
			}
			
			//create a test block with given name and lottery ticket number and find its hash
			Block testBlock = new Block(claimWinner, winningPlayer.getLotteryNumbers(), truePreviousHash);
			int claimedWinnerHash = testBlock.getBlockHash();
			
			//compare claimed winners hash to real winners hash
			if(trueHash == testBlock.getBlockHash()) {
				//congragulate winner if hash matches
				System.out.println("Congragulations " + claimWinner + " on winning the lottery!");
				winnerFound = true;
			}else {
				//re-prompts winner to enter name
				System.out.println(claimWinner + " does not contain correct hash value. Enter correct winners name.");
			}
		}while(winnerFound == false);
		
		
		
		
		
	}
}
