package model.items;

import java.util.Random;

import controller.globalGenerator.GlobalGenerator;
import model.enemies.Enemy;
/**
 * The implementation of the {@link Items}.
 *  When an {@link Enemy} dies it deals damage to the Player Health Points.
 */
public class MalusHp implements Items {

	private int Hp;
	private Random rand = new Random();
	
	public MalusHp() {
		this.Hp=(rand.nextInt(3)+2)*5;
		System.out.println("A sudden explosion deals you HP " + this.Hp);
		equip();
	}

	/**
     * {@inheritDoc}
     */	
	@Override
	public void equip() {
		GlobalGenerator gg = GlobalGenerator.getInstance();
		gg.player.getLife().setLifePoints( gg.player.getLife().getLifePoints() - this.Hp );
	}

}
