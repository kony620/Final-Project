
public class ScoreCounter {
	
	
	public int score = 0;
	
	/** Constructor of ScoreCounter class
	 * 
	 * @param i
	 */
	public ScoreCounter() {
		
	}
	
	/** Return score
	 * 
	 * @return score of current player
	 */
	public int getScore(){
		
		
		return score;
		
	}
	
	
	public void increaseScore(int i) {
		
		score += i;
		
	}

}
