package Game;

public abstract class Character {
	public String name;
	public int maxHP,hp,xp;
	public Character(String name,int hp,int xp) {
		this.name=name;
		this.maxHP=hp;
		this.xp=xp;
		this.hp=maxHP;
	}
	// abstract methods 
	
	public abstract int attack();
	public abstract int defend();
}
