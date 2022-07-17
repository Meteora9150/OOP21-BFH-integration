package model.items;

import controller.globalGenerator.GlobalGenerator;
import model.enemies.Enemy;
/**
 * The implementation of the {@link Items}.
 *  When an {@link Enemy} dies it removes all the remaining actions points of the Player.
 */
public class MalusActions implements Items {

	public MalusActions() {
		equip();
	}

	/**
     * {@inheritDoc}
     */	
	@Override
	public void equip() {
		GlobalGenerator gg = GlobalGenerator.getInstance();
		gg.player.getPlayer_action().setActions(0);
		System.out.println(" CURSE !! you lost your turn "); 
	}


}
