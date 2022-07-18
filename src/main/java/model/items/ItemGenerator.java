package model.items;

import java.util.Random;
/**
 * Handles the generation of the items after an Enemy dies
 */
public class ItemGenerator {
	
	public void spawn(boolean enemyType) {
	Random r = new Random();
	Items equipment;
	int value = r.nextInt(13);
	
	if(enemyType) {
		//item for strong enemy
		switch(value){
			case 1: 
			case 2:
			case 3:
				equipment = new Sword(enemyType);
			break; 
			case 4:
			case 5:
			case 6:
				equipment = new Accessory(enemyType);
			break;
			case 7:
			case 8:
			case 9:
				equipment = new ExpOrb(enemyType);
			break;
			case 10: 
			case 11:
				equipment = new GoldBar();
			break;
			default:
				equipment = new RegainDoubleAttack();
			break;
		}
	}else {
		//item for simple enemy
		switch(value){
			case 1:
				equipment = new Sword(enemyType);
			break; 
			case 2: 
				equipment = new Accessory(enemyType);
			break;
			case 3:
			case 4: 
				equipment = new ExpOrb(enemyType);
			break;
			case 5: 
				equipment = new GoldBar();
			break;
			case 6:
			case 7:  
				equipment = new MalusActions();
			break;
			case 8:
			case 9: 
				equipment = new MalusHp();
			break;
			case 10:
				equipment = new RegainDoubleAttack();
			break;
			case 11:
			case 12:
				equipment = new CurseInventory();
			break; 
			default:  
				System.out.println("dropping nothing ");
			break;
		}
	}
	
	}

}
