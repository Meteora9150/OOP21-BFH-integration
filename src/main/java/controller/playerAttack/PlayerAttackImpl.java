/**
 * 
 */
package controller.playerAttack;
import controller.globalGenerator.GlobalGenerator;
import model.enemies.Enemy;
import model.player.Player;

/**
 * The implementation of the {@link PlayerAttack}.
 *
 */
public class PlayerAttackImpl implements PlayerAttack {

	private int DEFAULT_ATTACK_POINTS = 5; 
	private int attackPoints = DEFAULT_ATTACK_POINTS;

	private int temporaryAttack = 0;
	
	private GlobalGenerator gg = GlobalGenerator.getInstance();
	Player player;

	public PlayerAttackImpl( Player player) {
		this.player = player;
	}
	
	 /**
     * {@inheritDoc}
     */
	public int getAttackPoints() {
		return attackPoints;
	}
	
	 /**
     * {@inheritDoc}
     */
	public void attack(Enemy enemy) {
		System.out.println("Hero is attacking!");
		
		if(temporaryAttack != 0) {
			enemy.GetHit(GetTemporaryAttack());
			SetTemporaryAttack(0);
		}else {
			enemy.GetHit(getAttackPoints());
		}
		
	}

	 /**
     * {@inheritDoc}
     */
	public void setAttackPoints(int newAttackPoints) {
		this.attackPoints = newAttackPoints;
	}

	 /**
	 * {@inheritDoc}
	 */
	public void getHit(int enemyID, int enemyResponseHit) {
		gg.player.getLife().setLifePoints(gg.player.getLife().getLifePoints() - enemyResponseHit);
	}
	

	public int GetTemporaryAttack() {
		return this.temporaryAttack;
	}
	
	public void SetTemporaryAttack(int tempAttack) {
		this.temporaryAttack = tempAttack;
	}
	
}
