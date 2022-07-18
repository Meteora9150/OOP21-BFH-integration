package model.items;

/**
 * The extension of the {@link Items}
 */
public interface EquippableItems extends Items{
	
	enum Type{
		SWORD,
		ACCESSORY;
	}
	
	/**
	 * @return The main statistic of the item
	 */
	int getInfo();

	/**
	 * @return The Type of the Equippable Item 
	 */
	public Type getType();
}
