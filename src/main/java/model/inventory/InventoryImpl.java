package model.inventory;

import java.util.ArrayList;
import java.util.List;

import controller.globalGenerator.GlobalGenerator;
import model.items.EquippableItems;

public class InventoryImpl implements Inventory{

	private static final int INVENTORY_SIZE = 5;
	private List<EquippableItems> inventory;

	public InventoryImpl() {
		inventory = new ArrayList<EquippableItems>();
	}
	
	@Override
	public void add(EquippableItems item) {
		if ( checkSize() ) {
			inventory.add(item);
		}else {
			System.out.println(" your inventory is already full !! ");
			System.out.println(" Item lost: ( "+ item.getType() +" ) ");
		}
	}

	@Override
	public void resetInventory() {
		GlobalGenerator gg = GlobalGenerator.getInstance();
		
		if(getOccupation()!=0) {
			String s = getInventoryContents();		
			System.out.println(" you are going to lose all these items "+ s +" ");
		}else {
			System.out.println(" the curse takes nothing away from you ");
		}
		
		for(EquippableItems item: inventory) {
			if( item.getType() == EquippableItems.Type.SWORD) {
				gg.playerAttack.setAttackPoints( gg.playerAttack.getAttackPoints() - item.getInfo() );
				
			}else if(item.getType() == EquippableItems.Type.ACCESSORY){
				gg.player.getLife().setMaxLifePoints( gg.player.getLife().getMaxLifePoints() - item.getInfo() );
				if( gg.player.getLife().getLifePoints() >= gg.player.getLife().getMaxLifePoints() ) {
					gg.player.getLife().setLifePoints( gg.player.getLife().getMaxLifePoints() );		
				}			
			}		
		}
	}

	private boolean checkSize() {
		return inventory.size()<INVENTORY_SIZE;
	}

	@Override
	public void generateNewInventory() {
		inventory = new ArrayList<EquippableItems>();
	}
	
	public int getSize() {
		return INVENTORY_SIZE;
	}
	
	public int getOccupation() {
		return inventory.size();
	}
	
	public String getInventoryContents() {
		String s="\n";
		for(EquippableItems item: inventory) {
			s+=item.getType() +" +"+ item.getInfo()+" \n";
		}
		return s;
	}
	
}
