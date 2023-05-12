package Game;

public class StoryLine {
	public static void printIntro(String name) {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("Story");
		GameLogic.printSeparator(30);
		System.out.println(name +" , You are an explorer that went out to explore the world");
		System.out.println("While you were exploring the Mayan ruins you accidently pressed a block which teleported you to the Dungeon");
		System.out.println("You wake up in a room with doors and a pedestal in front of you with light shining on it.");
		System.out.println("Fighting the monsters and solving the puzzles is the only way for you to get out of this world");
		GameLogic.waitingFunction();
	}
	
	public static void printFirstActIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("Story");
		GameLogic.printSeparator(30);
		System.out.println("You see the whole room and assess the situation.");
		System.out.println("The only gate you find is in front of the pedestal that has light shining on it.");
		System.out.println("You hear a revealation.");
		System.out.println("You have to make your way through all the problems to complete this game.");
		GameLogic.waitingFunction();
	}
	public static void printFirstActOutro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("Story");
		GameLogic.printSeparator(30);
		System.out.println("You get on the pedestal as light shines upon you and gets brighter");
		System.out.println("You get blinded by the light");
		System.out.println("You heart a sharp screech as you feel yourself disintegrate.");
		GameLogic.waitingFunction();	
	}
	public static void printSecondActIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("Story");
		GameLogic.printSeparator(30);
		System.out.println("You wake up as you find yourself in a completely different place.");
		System.out.println("The design and type of room were the same but the vibe from the room was different from the last room");
		System.out.println("It felt somewhat more sinister than the previous room.");
		GameLogic.waitingFunction();	
	}
	public static void printSecondActOutro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("Story");
		GameLogic.printSeparator(30);
		System.out.println("You see the puzzler leaving as you stan on the pedestal again");
		System.out.println("The room spins with the pedestal as it's center");
		System.out.println("The view changes as everythign around you gets dark");
		GameLogic.waitingFunction();
	}
	public static void printThirdActIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("Story");
		GameLogic.printSeparator(30);
		System.out.println("You wake up to the chirping birds only to see a room with forest like properties init");
		System.out.println("This time you see a door in front of you which you have to reach");
		System.out.println("You stand up and brace yourself to move forward.");
		GameLogic.waitingFunction();
	}
	public static void printThirdActOutro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("Story");
		GameLogic.printSeparator(30);
		System.out.println("The fight was intense but you still went through it finding your way to end it");
		System.out.println("You get near the door as you push it with all the force opening it up.");
		System.out.println("You face scorching heat on your face pushing you over to the back");
		System.out.println("You face the heat and march over inside the room to get to the final boss.");
		GameLogic.waitingFunction();
	}
	public static void printFourthActIntro() {
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println("Story");
		GameLogic.printSeparator(30);
		System.out.println("You sweat hard as you can already feel your whole body being burnt up from the scorching heat of the room.");
		System.out.println("A big fire ball approaches you as you dodge it using you skills and it burns the desk at you back.");
		System.out.println("Another big fireball hails towards you as you are not able to escape it this time as it hits you on the face.");
		GameLogic.waitingFunction();
	}
//	public static void printFourthActOutro() {
//		GameLogic.clearConsole();
//		GameLogic.printSeparator(30);
//		System.out.println("Story");
//		GameLogic.printSeparator(30);
//		System.out.println("Fourth Act Outro");
//		GameLogic.waitingFunction();
//	}
	public static void printEnd(Player player,boolean fin) {
		if(fin)GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		if(fin) System.out.println("Congratulations "+ player.name+"You have successfully teleported back to the outer world!");
		else  System.out.println("You woke up at the hospital with your legs and arms broken. \nDoctors say you need atleast an year before you can start exploring again");
		GameLogic.printSeparator(30);
		int totalPoints=(int)(player.strategy+1)*((player.restsLeft)+(player.gold)+(player.potions*2)+(player.puzzlesSolved*60)+(player.resilience*50)+((player.numAtkUpgrades+player.numDefUpgrades)*50)+(player.hp*5)+(player.xp)+(player.enemiesDefeated*40));
		System.out.println("You scored "+totalPoints +"Points");
		GameLogic.printSeparator(30);
		writeData.addData(player,totalPoints);
		System.out.println("This Game was Developed by Piyush Kumar");
		System.out.println("I hope you enjoyed it.");
		System.exit(0);
	}
}
