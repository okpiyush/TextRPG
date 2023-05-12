package Game;

public class Player extends Character{
	public int numDefUpgrades,numAtkUpgrades;
	// player specific constructor
	public String[] atkUpgrades= {"Strength","Might","Power","Godlike Strength"};
	public String[] defUpgrades= {"Heavy Bones","StoneSkin","Scale Armor","Holy Aura"};
	
	
	int gold, restsLeft,potions,age;
	//
	int eyefordetail,resilience,puzzlesSolved,enemiesDefeated,logic;
	int strategy=0;
	public Player(String name) {
		//calling the constructor of superclass
		super(name, 100, 5);
		this.numAtkUpgrades=0;
		//
		this.numDefUpgrades=0;
		this.gold=5;
		this.restsLeft=1;
		this.potions=1;
		this.eyefordetail=0;
		this.puzzlesSolved=0;
		this.resilience=0;
		//let him choose a trait;
		choiceTrait();
	}
	
	//altered from what they have been assigned from their parent class 
	@Override
	public int attack() {
		
		return (int) (Math.random()*(xp/4+numAtkUpgrades*4+5)+xp/9+numAtkUpgrades*2+numDefUpgrades+1);
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*(xp/4+numDefUpgrades*4+4)+xp/10+numDefUpgrades*2+numAtkUpgrades+1);
	}
	public void choiceTrait() {
		GameLogic.clearConsole();
		if(numAtkUpgrades==4) {
			numDefUpgrades++;
			System.out.println("You were awarded "+defUpgrades[numDefUpgrades]);
		}
		if(numDefUpgrades==4) {
			numAtkUpgrades++;
			System.out.println("You were awarded "+atkUpgrades[numAtkUpgrades]);
		}
		GameLogic.printHeading("Choose a trait :");
		System.out.println("(1)" + atkUpgrades[numAtkUpgrades]);
		System.out.println("(2)" + defUpgrades[numDefUpgrades]);
		int input= GameLogic.readInt("->", 2);
		
		if(input==1) {
			GameLogic.printHeading("You Chose "+atkUpgrades[numAtkUpgrades]);
			numAtkUpgrades+=1;
		}else {
			GameLogic.printHeading("You Chose "+defUpgrades[numDefUpgrades]);
			numDefUpgrades+=1;
		}
		GameLogic.waitingFunction();
	}
	
	
}
