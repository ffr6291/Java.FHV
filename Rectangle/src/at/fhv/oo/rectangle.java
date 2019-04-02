package at.fhv.oo;
import javax.swing.JOptionPane;

public class rectangle {
	public static void main(String[] args) {
		Point square = new Point();

		square.point1();
		//square.shift(1, 9);

		String point = JOptionPane.showInputDialog("Um welchen Punkt soll gedreht werden? (TopLeft = 1; TopRight = 2; BotLeft = 3; BotRight= 4;)");
		square.rotate((Integer.parseInt(point)));
		square.square();

	}
}