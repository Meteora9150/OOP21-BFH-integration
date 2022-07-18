package model.enemies;

public class StrongerEnemy extends Enemy {
	
	/**
	 * Constructor for the StrongerEnemy. 
	 * By using {@value #rand} we can generate different stats for the enemies.
	 * @param id
	 */
	public StrongerEnemy(int id) {
		super(id);
		int value = rand.nextInt(7)+2; 
		
		HP =( 20+value + ( HeroEXP/(20*2) ))*(1 + HeroATK/9);
		def=( 0+value/6 + ( HeroEXP/(20*10) ) +( HeroATK/8) );
		atk=( 6+value/4 + ( HeroEXP/(10*10) ) +( HeroATK/6));
		exp=( 20+value - ( HeroEXP/(15*10) ));
		
		Gold=rand.nextInt(40)+25;
		
		EnemyType=true;
	}

}
