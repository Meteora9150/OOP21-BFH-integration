package model.items;

import java.util.Random;

import controller.globalGenerator.GlobalGenerator;
import model.enemies.Enemy;
/**
 * The implementation of the {@link Items}.
 *  When an {@link Enemy} dies it drops additional experience for the Player.
 */
public class ExpOrb implements Items {

	private int Experience;
	private Random rand = new Random();
	
	public ExpOrb(boolean enemyType) {
		if(enemyType) {
			// strong enemy ExpOrb 
			this.Experience=(rand.nextInt(12)+ 5)*(rand.nextInt(4)+ 2);
		}
		else {
			// simple enemy ExpOrb 
			this.Experience=(rand.nextInt(10)+ 3)*(rand.nextInt(3)+ 1);
		}
		System.out.println("you discovered additional EXP +" + this.Experience);
		equip();
	}

	/**
     * {@inheritDoc}
     */	
	@Override
	public void equip() {
		GlobalGenerator gg = GlobalGenerator.getInstance();
		gg.player.getExperience().gainExp(this.Experience);
	}
}
