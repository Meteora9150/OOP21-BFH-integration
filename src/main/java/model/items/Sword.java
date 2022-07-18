package model.items;

import java.util.Random;

import controller.globalGenerator.GlobalGenerator;
import model.enemies.Enemy;

/**
 *  The implementation of the {@link EquippableItems}.
 *  Adds the Sword drop when an {@link Enemy} dies.
 */
public class Sword implements EquippableItems {

	GlobalGenerator gg = GlobalGenerator.getInstance();
	private int Attack;
	private Type equipmentType;
	private Random rand = new Random();
	
	public Sword(boolean enemyType) {
		
		if(enemyType) {
			// strong enemy sword 
			System.out.println("strong");
			this.Attack=rand.nextInt(4)+3 + ( gg.player.getExperience().getExpPoints() / 250 );
		}
		else {
			// simple enemy sword 
			System.out.println("simple");
			this.Attack=rand.nextInt(2)+1 + ( gg.player.getExperience().getExpPoints() / 120 );
		}
		this.equipmentType=EquippableItems.Type.SWORD;
		equip();
	}

	/**
     * {@inheritDoc}
     */	
	@Override
	public void equip() {
		gg.player.getInventory().add(this);
		gg.playerAttack.setAttackPoints( gg.playerAttack.getAttackPoints() + this.Attack );		
	}

	@Override
	public int getInfo() {
		return this.Attack;
	}
	
	public Type getType() {
		return this.equipmentType;
	}

}
