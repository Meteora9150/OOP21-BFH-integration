package model.obstacles;

import model.player.Pair;

/**
 * The implementation of the {@link Obstacle}.
 *
 */
public class ObstacleImpl implements Obstacle {

	private final Pair<Integer, Integer> obstaclePos;

	private final Type obstacleType;
	
	 /**
     * Simple constructor of {@link Obstacle}.
     */
	public ObstacleImpl(final Pair<Integer, Integer> pos, Type type){
		this.obstaclePos = pos;
		this.obstacleType = type;
	}

	 /**
     * {@inheritDoc}
     */
	@Override
	public Pair<Integer, Integer> getObstaclePos(){
		return this.obstaclePos;
	}
	   
	/**
     * {@inheritDoc}
     */
	@Override
	public Obstacle.Type getObstacleType() {
		return this.obstacleType;
	}

}
