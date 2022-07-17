package model.enemies;
import java.util.*;

import controller.globalGenerator.GlobalGenerator;
import model.items.ItemGenerator;
import model.player.Pair;
import model.player.Player;

/**
 * Class used to manage the enemies and their stats.
 *
 */
public class Enemy {

	// Giving the Arena size to avoid misplacing during generation.
	private final static int GRID_SIZEX = 10;
	private final static int GRID_SIZEY = 12;
	private Pair<Integer,Integer> pos;
	private GlobalGenerator gg = GlobalGenerator.getInstance();
	private ItemGenerator itemGeneration = new ItemGenerator();
	
	private int ID;
	private int x;
	private int y;
	
	protected int HP ;
	protected int def;
	protected int atk;
	protected int exp;
	protected int HeroEXP = gg.player.getExperience().getExpPoints();
	protected int HeroATK = gg.playerAttack.getAttackPoints();
	protected int Gold;
	
	protected boolean EnemyType;  // false = simple enemy  // true = stronger enemy
	
	Random rand = new Random();
	
	/**
	 * Constructor for the Enemy. 
	 * By using {@value #rand} we can generate different stats for the enemies.
	 * @param id
	 */
	public Enemy(int id) {
		
		//Enemy ID
		this.ID = id;
		int value = rand.nextInt(5)+1; 
		
		HP =( 5+value + ( HeroEXP/(10*2) ))*(1 + HeroATK/15);
		def=( 1+value/2 + ( HeroEXP/(20*8) ) +( HeroATK/8) );
		atk=( 1+value/3 + ( HeroEXP/(10*10) ) +( HeroATK/10));
		exp=( 10+value - ( HeroEXP/(15*6) ));
		
		Gold=rand.nextInt(15)+10;
		
		EnemyType=false;
		
		generate_pos();
	}
	
	/**
	 * Generate the position of the Enemies upon checking other Entities pos,
	 * avoiding overlapping issues.
	 */
	private void generate_pos() {
		boolean ok=false;
		while(!ok) {
			x= rand.nextInt(GRID_SIZEX);
			y= rand.nextInt(GRID_SIZEY);
			pos=new Pair<>(x,y);
			if(gg.checkEnemyPos(pos) && gg.checkObstaclesPos(pos) && gg.checkPlayerPos(pos)) {
				gg.enemyposwithID.add(new Pair<Integer, Pair<Integer, Integer>>(this.ID,pos));
				ok=true;
			}
		}
	}


	@Override
	public String toString() {
		String s = "HP = "+GetHP()+" atk = "+this.atk+" def = "+this.def+" exp = "+this.exp ;
		return s;
	}

	public int getID() {
		return this.ID;
	}
	public int GetHP() {
		return HP;
	}
	
	public int GetATK() {
		return atk;
	}
	
	public int GetDEF() {
		return def;
	}

	/**
	 * After getting damaged, the Enemy life is set at its new value,
	 * obtained by decreasing the damage taken.
	 * @param damage
	 */
	public void SetHP(int damage) {
		setHPEnemy(GetHP() - damage);
		System.out.println("Enemy " + this.ID + " - Life = " + GetHP());
		//Enemy death.
		if(GetHP() <= 0) {
			gg.player.getExperience().gainExp(this.getEXP());
			gg.player.getGold().gainGold_points(this.Gold);
			Death();
		}
	}
	
	public void setHPEnemy(int i) {
		HP = i;	
	}

	private int getEXP() {
		return this.exp;
	}

	public void GetHit(int hero_ATK) {
		System.out.println("Enemy " + this.ID + " hit by hero - Damage of " + (hero_ATK - GetDEF()));
		SetHP(hero_ATK - GetDEF());	
	}

	/**
	 * After the Enemy HP drops to 0 or lower, resets its values to 0
	 * and gets teleported outside the Arena.
	 */
	private void Death() {
		System.out.println("Enemy " + this.ID + " has died.");
		setEXP(0);
		setGold(0);
		if(!gg.skipenemy.contains(this.ID)) {
			gg.skipenemy.add(this.ID);
			gg.enemyposwithID.set(this.ID, new Pair<>(this.ID, new Pair<Integer, Integer> (99, 99)));
		}
		itemGeneration.spawn(this.EnemyType);
	}

	private void setGold(int i) {
		this.Gold = i;
	}

	private void setEXP(int i) {
		this.exp = i;
	}
}
