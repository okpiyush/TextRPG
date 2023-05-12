package Game;

public class Enemy extends Character{

	//vairable to store the players current xp'
	int playerXp;
	public Enemy(String name,int xp) {
		super(name,(int)(Math.random()*xp+xp/3+5),(int)(Math.random()*(xp))+1);
		this.playerXp=xp;
	}

	@Override
	public int attack() {
		
		return (int)(Math.random()*(playerXp/4+10)+xp/3+3);
	} 

	@Override
	public int defend() {
		
		return  (int)(Math.random()*(playerXp/3)+xp/4+4);
	}

}
