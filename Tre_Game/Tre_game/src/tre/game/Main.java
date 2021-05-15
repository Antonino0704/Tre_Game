package tre.game;

public class Main {
	private static Random random;
	private static Gui gui;
	
	public static void main(String[] args) {
		random = new Random();
		random.randomNum();
		
		gui = new Gui();
		gui.actionButton1(random);
		gui.actionButton2(random);
		gui.actionButton3(random);
	}

}
