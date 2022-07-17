package model.items;

import controller.globalGenerator.GlobalGenerator;
import model.enemies.Enemy;

/**
 * The implementation of the {@link Items}.
 *  When an {@link Enemy} dies, the Player regains the uses of double attack.
 */
public class RegainDoubleAttack implements Items {

	public RegainDoubleAttack() {
		equip();
	}
	
	/**
     * {@inheritDoc}
     */	
	@Override
	public void equip() {
		GlobalGenerator gg = GlobalGenerator.getInstance();
		gg.abilityManager.generateAbilities();
		System.out.println("You regain all your double attack uses ");
	}

}
