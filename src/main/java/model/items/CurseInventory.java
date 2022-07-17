package model.items;

import controller.globalGenerator.GlobalGenerator;
import model.enemies.Enemy;

/**
 * The implementation of the {@link Items}.
 *  When an {@link Enemy} dies, it resets the {@link Inventory} of the Player.
 */
public class CurseInventory implements Items {

	public CurseInventory() {
		equip();
	}
	
	/**
     * {@inheritDoc}
     */	
	@Override
	public void equip() {
		GlobalGenerator gg = GlobalGenerator.getInstance();
		gg.player.getInventory().resetInventory();
		gg.player.getInventory().generateNewInventory();
	}

}
