package Game;
import java.util.*;
public class GameLogic {
	static Scanner sc= new Scanner(System.in);
	static Player player;
	
	
	
	
	
	//game loop 
	static boolean isRunning;
	
	
	//Random encounters that would happen in the game 
	public static String[] encounters= {"Rest","Battle","Battle","Battle","Battle","Rest","Shop"};
	
	// Enemy names
	public static String[] enemy= {"Mimic","Minotaur","Gargoyle","Zombies","Ogre","SkinWalker","Possesed Assassian"};
		
	// the place and it's variables
	//place defines the current location 
	// act defines the current act of the player
	public static int place =0,act =1;
	public static String[] location = {"The Chamber of Ressilience", " The Secrets of Details", "The Curious One" , " The Puzzled Perseverance", " Gods of Logic"};
	
	
	
	
	
	
	
	
	
	
	//to read the various input in the game.
	public static int readInt(String prompt,int userChoices) {
		int input;
		//try taking values inside it.
		do {
			System.out.println(prompt);
				try {
					input=Integer.parseInt(sc.next());
				} catch (Exception e) {
					input=-1;
					System.out.println("Please enter an Integer");
				}
				
		}while(input<1||input>userChoices);
		return input;
	}
	
	
	
	
	
	
	//clear the console.for next commands
	public static void clearConsole() {
	
		for(int i=0;i<150;i++)
			System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	//separator to separate teo class or groups
	public static void printSeparator(int n ) {
		for(int i=0;i<n;i++)System.out.print("-");
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
//	method to print a heading;
	public static void printHeading(String title) {
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//method to stop the game until user enters anything.
	public static void waitingFunction() {
		System.out.println("\nEnter anything to continue");
		sc.next();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// method to start the games
	public static void startGame() {
		boolean nameSet=false;
		String name;
		printSeparator(100);
		printSeparator(80);
		System.out.println(" ######                                                  \r\n"
				+ " #     #  #    #  #    #   ####   ######   ####   #    # \r\n"
				+ " #     #  #    #  ##   #  #    #  #       #    #  ##   # \r\n"
				+ " #     #  #    #  # #  #  #       #####   #    #  # #  # \r\n"
				+ " #     #  #    #  #  # #  #  ###  #       #    #  #  # # \r\n"
				+ " #     #  #    #  #   ##  #    #  #       #    #  #   ## \r\n"
				+ " ######    ####   #    #   ####   ######   ####   #    # \r\n"
				+ "                                                         ");
		System.out.println("    #                                                                           \r\n"
				+ "   # #    #####   #    #  ######  #    #  #####  #    #  #####   ######   ####  \r\n"
				+ "  #   #   #    #  #    #  #       ##   #    #    #    #  #    #  #       #      \r\n"
				+ " #     #  #    #  #    #  #####   # #  #    #    #    #  #    #  #####    ####  \r\n"
				+ " #######  #    #  #    #  #       #  # #    #    #    #  #####   #            # \r\n"
				+ " #     #  #    #   #  #   #       #   ##    #    #    #  #   #   #       #    # \r\n"
				+ " #     #  #####     ##    ######  #    #    #     ####   #    #  ######   ####  \r\n"
				+ "                                                                                ");
		
		printSeparator(80);
		printSeparator(100);
		System.out.println("Text RPG by Piyush Kumar");
		printSeparator(100);
		waitingFunction();
		//taking the player name 
		do {
			clearConsole();
			printHeading("Your name ? : ");
			name=sc.next();
			clearConsole();
			printHeading("Your Name is : "+name +".\nIs that correct ?");
			System.out.println("(1) Yes");
			System.out.println("(2) No");
			int input = readInt("->", 2);
			if(input==1) {
				nameSet=true;
			}
		}while(!nameSet);
		System.out.println("Your age :");
		int age=sc.nextInt();
		if(age>=14) {
			isRunning = true;
		}else {
			isRunning = false;
			System.out.println("Game is not meant for kids under 14");
			return;
		}
		
		StoryLine.printIntro(name);
		
		player= new Player(name);
		
		player.age=age;
		//start the game loop set it to running 
		
		
		//print first story 
		StoryLine.printFirstActIntro();
		
		//start main game loop 
		gameLoop();
	}
	
	
	
	
	
	
	
	//ThePuzzler and his Puzzles();
	 public static void ThePuzzler(int n) {
		 printHeading("THE PUZZLER IS HERE BACK WITH HIS PUZZLES");
		 
		 if(n==1) {
			
			System.out.println("We met for the first time so I will only ask you a single question"); 
			printSeparator(30);
			waitingFunction();
			
			System.out.println("Five people were eating apples, A finished before B, but behind C."); 
			System.out.println("D finished before E, but behind B. What was the finishing order?"); 
			System.out.print("Write your answer : ");
			String input=sc.next().toLowerCase();
			if(input.equals("cabde")) {
				player.puzzlesSolved+=1;
				player.eyefordetail+=1;
				player.logic+=1;
				waitingFunction();
				
			}else {
				System.out.println("You failed to answer the current question, SO you will have to face the boss");
				waitingFunction();
				mainBattle(new Enemy("Wild Boar",50));
			}
			
		 }else if(n==2) {
			int ans=0;
			System.out.println("Hello my friend, We meet yet again and this time I have 2 Questions for you now.");
			printSeparator(30);
			System.out.println("But there is a catch that you would have to answer atleast one of the questions correctly");
			System.out.println("or Else You will have to face the Gungroo");
			waitingFunction();
			//question 1
			System.out.println("A man came to King's palace");
			System.out.println(" He asked him to find the counterfiet coin in a stack of 9 coins,");
			System.out.println("He added that the counterfiet coin is lighter in weight");
			System.out.println("He then asked the king to do it in the least number of comparisons.");
			System.out.println("What is the least number of comparisons it would take to find the counterfiet coin?");			
			System.out.print("Write your answer : ");
			String input=sc.next().toString();
			if(input.equals("2")) {
				ans++;
				player.puzzlesSolved+=1;
				player.eyefordetail+=1;
				player.logic+=1;
				player.strategy+=1;
				
			}
			//question 2
			printHeading("Are you ready for the next question ?");
			waitingFunction();
			System.out.println("In How many steps can you calculate 4L of water using a 3L and 5L bucket");
			System.out.print("Write your answer : ");
			input=sc.next().toString();
			if(input.equals("6")) {
				ans++;
				player.puzzlesSolved+=1;
				player.eyefordetail+=1;
				player.logic+=1;
				player.strategy+=1;
				waitingFunction();
			}
			
			//check if he will have to battle or not 
			if(ans==0) {
				System.out.println("You failed to answer any questions correctly, Face the Enemy to increase your xp and might");
				waitingFunction();
				mainBattle(new Enemy("Gungru",100+(player.xp/2)));
			}else if(ans==1) {
				System.out.println("You answered one question correctly");
				waitingFunction();
				mainBattle(new Enemy("Bejwa",50+(player.xp/2)));
			}
		 }else if(n==3) {
			 
			printHeading("Don't worry i dont have bosses this time around.");
			waitingFunction();
			System.out.println("The Mayan King was once asked a question.");
			System.out.print("What is something that speaks without a mouth and hear without ears./n It has no body but it comes alive with wind?");
			String input=sc.next().toLowerCase();
			if(input.equals("echo")) {
				player.puzzlesSolved+=1;
				player.eyefordetail+=1;
				player.logic+=1;
				waitingFunction();
			}
			printHeading("Are you ready for the next question ?");
			waitingFunction();
			System.out.println("Tell me one word in all the English that has three consecutive double letters?");
			System.out.print("Write your answer : ");
			input=sc.next().toLowerCase();
			if(input.equals("bookkeeper")) {
				player.puzzlesSolved+=1;
				player.eyefordetail+=1;
				player.logic+=1;
				player.strategy+=1;
				waitingFunction();
			}
			printHeading("Are you ready for the next question ?");
			waitingFunction();
			System.out.println("If three cats catch three mice in three minutes, how many cats would be needed to catch 100 mice in 100 minutes?");
			System.out.print("Write your answer : ");
			input=sc.next().toString();
			if(input.equals("3")) {
				player.puzzlesSolved+=1;
				player.eyefordetail+=1;
				player.logic+=1;
				player.strategy+=1;
				waitingFunction();
			}
		 }else {
			printHeading("Are you ready for the next question ?");
			waitingFunction();
			System.out.println("How many Enemies did you win against?");
			System.out.print("Write your answer : ");
			int input=sc.nextInt();
			if(input==player.enemiesDefeated){
				player.eyefordetail+=1;
			}
			printHeading("Are you ready for the next question ?");
			waitingFunction();
			System.out.println("How many puzzles did you solve ?");
			System.out.print("Write your answer : ");
			input=sc.nextInt();
			if(input==player.puzzlesSolved) {
				player.eyefordetail+=1;
				player.logic+=1;
			}
			printHeading("Are you ready for the next question ?");
			waitingFunction();
			System.out.println("Do you want to have another battle ?");
			System.out.print("Write your answer : ");
			input=readInt("->", 2);
			if(input==1) {
				player.resilience+=2;
				player.hp=player.maxHP;
				player.strategy++;
				mainBattle(new Enemy("The Puzzler",300+player.xp));
			}
			 
		 }
	 }
	
	
	
	
	
	//method to continue the journey
	public static void checkAct() {
		if(player.xp>=50 && act ==1 ) {
			//Increment act and place
			act=2;
			place=1;
			//story end
			StoryLine.printFirstActOutro();
			//let player level up and choose a trait
			player.choiceTrait();
			ThePuzzler(place);
			clearConsole();
			
			//start the second act 
			StoryLine.printSecondActIntro();
			
			//shuffling the array list of enemies
			List<String> enemiesString=Arrays.asList(enemy);
			Collections.shuffle(enemiesString);
			enemiesString.toArray(enemy);
			
			//shuffling the array list of the encounters;
			List<String> encounter=Arrays.asList(encounters);
			Collections.shuffle(encounter);
			encounter.toArray(encounters);
			
			//fully healing the player
			player.hp=player.maxHP;
		}else if(player.xp>=150 &&act ==2) {
			//Increment act and place
			act=3;
			place=2;
			//story end
			StoryLine.printSecondActOutro();
			//let player level up and choose a trait
			player.choiceTrait();
			ThePuzzler(place);
			//start the second act 
			StoryLine.printThirdActIntro();
			
			
			//shuffling the array list of enemies
			List<String> enemiesString=Arrays.asList(enemy);
			Collections.shuffle(enemiesString);
			enemiesString.toArray(enemy);
			
			//shuffling the array list of the encounters;
			List<String> encounter=Arrays.asList(encounters);
			Collections.shuffle(encounter);
			encounter.toArray(encounters);
			
			
			System.out.println("You saw a bottle with some water like liquid init");
			System.out.println("Do you want to drink the liquid ?");
			System.out.println("(1) Yes");
			System.out.println("(2) No");
			int input=readInt("->",2);
			if(input==1) {
				//fully healing the player
				player.hp=player.maxHP;
				System.out.println("You restored your health back to the max");
			}else {
				System.out.println("You are now suffering from kidney stones");
				player.hp-=(player.hp/4);
				System.out.println("You lost 1/4th of your HP");
			}
			waitingFunction();
		}else if(player.xp>=400 &&act ==3) {
			//Increment act and place
			act=4;
			place=3;
			//story end
			StoryLine.printThirdActOutro();
			//let player level up and choose a trait
			player.choiceTrait();
			ThePuzzler(place);
			
			//start the second act 
			StoryLine.printFourthActIntro();
			
//			//shuffling the array list of enemies
//			List<String> enemiesString=Arrays.asList(enemy);
//			Collections.shuffle(enemiesString);
//			enemiesString.toArray(enemy);
//			
//			//shuffling the array list of the encounters;
//			List<String> encounter=Arrays.asList(encounters);
//			Collections.shuffle(encounter);
//			encounter.toArray(encounters);
//			
			//fully healing the player
			System.out.println(" A light shines upon you healing you and fixing your items to full health");
			player.hp=player.maxHP;
		
			
			int num=(int)Math.random()*enemy.length;
			System.out.println("A "+ enemy[num]+" offers you some food");
			System.out.println("Do you want to eat it?");
			System.out.println("(1) Eat the meat");
			System.out.println("(2) Kill the enemy");
			int input=readInt("->",2);
			if(input==1) {
				//fully healing the player
				player.hp=player.hp/2;
				System.out.println("You ate poisonous meat.");
			}else {
				player.strategy++;
				player.eyefordetail++;
				System.out.println("You won against the 'MAGICAL "+ enemy[num].toUpperCase()+"', You recieved the bleesings of the god." );
				player.hp=player.maxHP;
				System.out.println("Health Restored to Maximum");
				player.choiceTrait();
			}
			waitingFunction();
			ThePuzzler(place);
			//proceeding to the final battle
			 finalBattle();
			 
			
		
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	//the continue journey feature here gives us the power to continue on our journey once the player selects the battle menu
	public static void continueJourney() {
		checkAct();
		if(act!=4) {
			randomEncounter();
		}
		
	}
	
	
	
	
	
	//method to calculation a random encounter
	public static void randomEncounter() {
		int encounter=(int) (Math.random()*encounters.length);
		if(encounters[encounter].equals("Battle")) {
			randomBattle();
		}else if(encounters[encounter].equals("Rest")){
			takeRest();
		}else {
			Shop();
		}
		return;
	}
	
	
	
	//shopping encountering a shop
	public static void Shop() {
		clearConsole();
		printHeading("You met a mysterious stranger. \nHe is offering you something");
		int price=(int) (Math.random()*(10+player.potions*3)+10+player.potions);
		System.out.println("Magic Potion :"+price +"gold coins");
		printSeparator(20);
		System.out.println("Do you want to buy 1 \n1) Yes\n2) No Thanks.");
		int input=readInt("-> ",2);
		if(input==1) {
			clearConsole();
			if(player.gold>=price) {
				printHeading("You bought a magical potion for  "+price +"gold coins.");
				player.potions+=1;
				player.gold-=price;
			}else {
				printHeading("You don't have enough gold for buying the potion.");
			}
			waitingFunction();
		}
	}
	
	//Rest function
	public static void takeRest() {
		clearConsole();
		if(player.restsLeft>=1) {
			printHeading("Do you want to take rest ? \n(1) Yes\n(2) No");
			System.out.println("(1) Yes \n(2) No");
			int input=readInt("->",2);
			if(input==1) {
				clearConsole();
				if(player.hp<player.maxHP) {
					int hprestored= (int)Math.random()*(player.hp/2+5)+10;
					player.hp+=hprestored;
					if(player.hp>player.maxHP) {
						int curr=hprestored-(player.hp-player.maxHP);
						System.out.println("You restored "+curr+"hp");
						player.hp=player.maxHP;						
					}else {
						System.out.println("You restored "+hprestored+"health");
					}
					System.out.println("You are now at "+player.hp+"health");
					player.restsLeft--;
				}else {
					System.out.println("You are now at max health");
				}
				waitingFunction();
			}
		}
	}
	
	//random battle generator
	public static void randomBattle() {
		clearConsole();
		printHeading("New enemy spotted");
		System.out.println(player.xp);
		waitingFunction();
		
		mainBattle(new Enemy(enemy[((int)(Math.random()*enemy.length))],player.xp));		
		
	}
	
	
	
	//we will have to battle the enemy 
	public static void mainBattle(Enemy enemy)
	{
		//we will have 
		//this wont exit until it completed
		while(true) {
			clearConsole();
			//enemy details
			printHeading("Enemy name :" + enemy.name+ "\n Enemy hp :"+enemy.hp +"/"+enemy.maxHP);
			printHeading("Your name :"+ player.name +"\n Your hp :"+player.hp+"/"+player.maxHP);
			System.out.println("1) Fight \n2)Use Potion \n3)Run Away");
			int input=readInt("->",3);
			if(input==1) {
				//fight method
				//limit the number of heavy attacks add some backfire to the attacks
				//we are assigning it 0 because we will anyway have the value used

				int dmg=0,dmgtook=0;
				
				System.out.println("1) Light Attack \n2)Heavy Attack (take some self damage, give big damage) \n3)Super Heavy Attack (One shot kill, Takes half of your health)");
				int att=readInt("->",3);
				if(att==1) {
					dmg=(int) ((player.attack())-enemy.defend());//because it is a light attack we will modify the damage given
					dmgtook=(int)(enemy.attack()-player.defend()-player.defend()/6);//your choice wont affect the enemies choice
				}else if(att==2) {
					dmg=(int) ((player.attack()*1.45)-enemy.defend());//because it is a light attack we will modify the damage given
					int pk=(int) (player.attack()*.1);
					player.hp-=pk; //this will deplete your health;
					System.out.println("You recieved "+pk+".");
					dmgtook=(int)(enemy.attack()-player.defend());//your choice wont affect the enemies choice
				}else {
					if(player.hp<enemy.hp)player.strategy++;
					if(act!=4) {
						dmg=(int) (enemy.hp);//this one would be a one shot ko hence we wont be using any defense
						dmgtook=(int)(player.maxHP/2);//your choice wont affect the enemies choice
					}else {
						dmg=(int) (enemy.hp/3);//this one would be a one shot ko hence we wont be using any defense
						dmgtook=(int)(player.maxHP/2);//your choice wont affect the enemies choice
						System.out.println("You cannot kill me with one shot K/o");
						waitingFunction();
					}
				}
				if(dmgtook<0) {
					
					dmg-=dmgtook/2;
					dmgtook=0;
				}
				if(dmg<0) dmg=0;		
				//we take the damage points // add choose the type of attack
				//calculate damage give , damage taken
				
				//now we deal damage to both the parties
				player.hp-=dmgtook;
				enemy.hp-=dmg;
				clearConsole();
				printHeading("BATTLE");
				if(dmgtook==0 && dmg==0) {
					System.out.println("You and " +enemy.name+" , struck each other at the same time.");
					printSeparator(15);
					System.out.println("You cancelled each other's attack");
				}else if(dmgtook==0 ) {
					System.out.println("You broke through"+ enemy.name+"'s attack");
					printSeparator(15);
					System.out.println(enemy.name+" lost "+dmg+"hp.");
				}else if(dmg==0) {
					System.out.println(enemy.name + " broke through your attacks");
					printSeparator(15);
					System.out.println("You lost "+dmgtook+"hp");
				}else {
					System.out.println("You dealt " + dmg + "hp to "+enemy.name);
					printSeparator(15);
					System.out.println("You recieved "+dmgtook+" from "+enemy.name);
				}
				waitingFunction();
				//check for player hp and then check for the enemy hp if no one is less than 0 then continue the battle
				if(player.hp<=0) {
					System.out.println("This ran");
					playerDied(); //this will end the game.
					break;
				}else if(enemy.hp<=0){
					clearConsole();
					printHeading("You defeated the "+enemy.name+"!");
					player.xp+=enemy.xp*5;
					System.out.println("You Earned "+enemy.xp*5+" XP.");
					//adding random drops
					boolean addRests=(Math.random()*5+1<=2.25);
					int goldEarned=(int)(Math.random()*enemy.xp);
					if(addRests) {
						player.restsLeft+=1;
						System.out.println("You earned an additional chance to rest");
					}
					if(goldEarned>0) {
						player.gold+=goldEarned;
						System.out.println("You just earned"+goldEarned+"gol coins.");
					}
					player.enemiesDefeated+=1;
					waitingFunction();
					break;
				}
				
				
				
				
			}else if(input==2){
				//DRINK THE POTION CASE
				if(player.potions>0&&player.hp<player.maxHP) {
					if(player.hp<player.maxHP/2) {
						player.strategy++;
					}
					System.out.println("Do you want to drink the potion ? ( "+player.potions+" left)");
					System.out.println("1) Yes \n2) No");
					int in=readInt("->",2);
					if(in==1) {
						player.hp+=(int)player.maxHP/3;
						if(player.hp>100) {
							player.hp=100;
						}
						clearConsole();
						printHeading("You drank the magic potion \nYou restored "+ player.maxHP/3 +"hp of your health");
						player.potions--;
						waitingFunction();
					}
					
				}else if(player.hp==player.maxHP) {
					System.out.println("Already have full health");
				}else {
					System.out.println("No potions left");
				}
			}else {
				//RUN AWAY CASE
				clearConsole();
//				setting 33% chance of escaping
				
				if(Math.random()*10+1<=3.3 &&act!=4) {
					printHeading("You ran away from the "+enemy.name+"!");
					if(player.hp<enemy.hp ) {
						player.strategy+=1;
					}
					waitingFunction();
					break;
				}else {
					
						System.out.println("Your escape failed and the "+enemy.name+" attacked you.");
						int dmgtook=(int)(enemy.attack());
						System.out.println("You took "+dmgtook+" damage");
						player.hp-=dmgtook;
						waitingFunction();
						//CHECKING IF THE PLAYER IS ALIVE AFTER THE DAMAGE
						if(player.hp<=0) {
							playerDied(); //this will end the game.
							break;
						}
				}
				
			}
		}
	}
	
	//player dies so we have to turn the game off
	public static void playerDied() {
		if(player.strategy>0) {
			player.strategy-=1;
		}
		isRunning=false;
		clearConsole();
		printHeading("You died at "+location[place]);
		printHeading("You Earned "+player.xp+"xp & "+player.gold+"gold coins");
//		use function to put in the information of the player to spreadsheet;.'
		StoryLine.printEnd(player,false);
		System.exit(0);
	}

	
	//method to see the character information and it's powers
	public static void characterInfo() {
		clearConsole();
		printSeparator(20);
		printHeading("Character Information");
		printSeparator(20);
		System.out.println("Player Name : "+ player.name);
		System.out.println("Player HP : "+ player.hp +"/"+player.maxHP);
		System.out.println("Player EXP : "+ player.xp);
		System.out.println("Gold: "+ player.gold);
		System.out.println("Puzzles solved: "+ player.puzzlesSolved);
		System.out.println("Potions : "+ player.potions);
		System.out.println("Rests left : "+ player.restsLeft);
		if(player.numAtkUpgrades>0) {
			System.out.println("Offensive Trait :"+ player.atkUpgrades[player.numAtkUpgrades-1]);
		}
		if(player.numDefUpgrades>0) {
			System.out.println("Defense Trait :"+ player.defUpgrades[player.numDefUpgrades-1]);
		}
		printSeparator(20);
		waitingFunction();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	///printing the main menu 
	public static void printMenu() {
		clearConsole();
		printHeading(location[place]);
		System.out.println("CHoose an action:");
		printSeparator(20);
		System.out.println("(1) Continue on your journey");
		System.out.println("(2) Character Information");
		System.out.println("(3) Exit Game");
		return;
	}
	
	
	
	
	//the final battle 
	//the boss battle
	public static void finalBattle() {
		act=4;
		mainBattle(new Enemy("The Watcher",300+player.xp));
		//printing the proper Ending
		ThePuzzler(act);
		StoryLine.printEnd(player,true);
		
		
		//add the three puzzles to check the abilities
		
		
		
		
		waitingFunction();
	}
	
	
	//Starts the game and loops it till it is closed or stopped
	public static void gameLoop() {
		while(isRunning) {
			printMenu();
			int input=readInt("->",3);
			if(input ==1) {
				continueJourney();
			}else if(input==2) {
				characterInfo();
				
			}else {
				isRunning =false;
				StoryLine.printEnd(player,false);
				
				break;
				//add datat to spreadsheet
			}
		}
	}
	
	
	
	
	
}
