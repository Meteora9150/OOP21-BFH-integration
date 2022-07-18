package model.inventory;

import model.items.EquippableItems;
/**
 * Interface for the {@link Inventory}.
 */
public interface Inventory {
	/**
	 * Adds an item to the inventory of the Player
	 * @param item
	 */
	void add(EquippableItems item);
	/**
	 * Removes all the items bonus in the inventory from the player stats
	 */
	void resetInventory();
	/**
	 * Generate a new empty inventory
	 */
	void generateNewInventory();
	
	/** 
	 * @return The maximum size of the inventory
	 */
	public int getSize();
	
	/**
	 * @return The current capacity of the inventory
	 */
	public int getOccupation();
	
	/**
	 * @return The contents of the inventory
	 */
	public String getInventoryContents();
}
