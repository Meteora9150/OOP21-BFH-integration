package model.items;

/**
 * The extension of the {@link Items}
 */
public interface EquippableItems extends Items{
	
	enum Type{
		SWORD,
		ACCESSORY;
	}
	
	int getInfo();

	public Type getType();
}
