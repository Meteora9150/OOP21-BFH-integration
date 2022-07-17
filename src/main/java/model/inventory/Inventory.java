package model.inventory;

import model.items.EquippableItems;
/**
 * Interface for the {@link Inventory}.
 */
public interface Inventory {

	void add(EquippableItems item);
	
	void resetInventory();

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
