package model.items;

import controller.globalGenerator.GlobalGenerator;
import model.enemies.Enemy;
/**
 * The implementation of the {@link Items}.
 *  When an {@link Enemy} dies it drops a gold bar of value {@link #Gold}.
 */
public class GoldBar implements Items {

	private int Gold;
	
	public GoldBar() {
		this.Gold = 100;
		System.out.println("adding Gold " + this.Gold);
		equip();
	}

	/**
     * {@inheritDoc}
     */	
	@Override
	public void equip() {
		GlobalGenerator gg = GlobalGenerator.getInstance();
		gg.player.getGold().setGold_points(gg.player.getGold().getGold_points() + this.Gold);
	}

}
