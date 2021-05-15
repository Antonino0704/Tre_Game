package tre.game;

public class Random {
	private int num;
	
	public Random() {
		num = 0;
	}
	
	public void randomNum() {
		num = (int) (Math.random() * 3) + 1;
	}
	
	public boolean verify(int num) {
		if(this.num == num) {
			return true;
		}
		return false;
	}

}
