package model.items;

import java.util.Random;

import controller.globalGenerator.GlobalGenerator;
import model.enemies.Enemy;

/**
 *  The implementation of the {@link EquippableItems}.
 *  Adds the Accessory drop when an {@link Enemy} dies.
 */
public class Accessory implements EquippableItems {
	
	GlobalGenerator gg = GlobalGenerator.getInstance();
	private int Hp;
	private Random rand = new Random();
	private Type equipmentType;
	
	public Accessory(boolean enemyType) {
		
		if(enemyType) {
			// strong enemy accessory
			this.Hp=(rand.nextInt(5)+2 + ( gg.player.getExperience().getExpPoints() / 350 ) )*5;
		}else {
			// simple enemy accessory
			this.Hp=(rand.nextInt(2)+1 + ( gg.player.getExperience().getExpPoints() / 200 ) )*5;
		}		
		this.equipmentType=EquippableItems.Type.ACCESSORY;
		equip();
	}

	/**
     * {@inheritDoc}
     */	
	@Override
	public void equip() {
		gg.player.getInventory().add(this);
		gg.player.getLife().setMaxLifePoints( gg.player.getLife().getMaxLifePoints() + this.Hp );	
	}

	@Override
	public int getInfo() {
		return this.Hp;
	}
	
	public Type getType() {
		return this.equipmentType;
	}
}
