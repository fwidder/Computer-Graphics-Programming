/**
 * 
 */
package florianWidder.StudentID18999061.assignment1.objects;

import com.jogamp.opengl.GL2;

/**
 * @author Florian Widder
 * @author Student ID 18999061
 */
public class DayNightCycle extends AbstractGraphicObject {

	@Override
	public void calculate() {
		int m = getTime().getMinute();
		double h = getTime().getHour() + m * 0.0166667;
		double faktor;
		int phase;
		if (h < 6) {
			h = h % 6;
			faktor = (h * 1.66667) / 10;
			phase = 0;
		} else if (h < 12) {
			h = h % 6;
			faktor = (h * 1.66667) / 10;
			phase = 1;
		} else if (h < 18) {
			h = h % 6;
			faktor = (h * 1.66667) / 10;
			phase = 2;
		} else {
			h = h % 6;
			faktor = (h * 1.66667) / 10;
			phase = 3;
		}
		// TODO Calc the Color
	}

	@Override
	protected void realDraw(GL2 gl) {
		// TODO Auto-generated method stub

	}
}
