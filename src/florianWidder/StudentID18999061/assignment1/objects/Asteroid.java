package florianWidder.StudentID18999061.assignment1.objects;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

/**
 * @author Florian Widder
 * @author Student ID 18999061
 */
public class Asteroid extends AbstractGraphicObject {
	/**
	 * @param radius
	 *            Radius of the asteroid
	 */
	public Asteroid(float radius) {
		super(new Point(0, -2));
		// init
		float x1, y1, x2, y2;
		float angle;

		x1 = 0f;
		y1 = 0f;

		ArrayList<Point> points = new ArrayList<Point>();
		points.add(new Point(x1, y1));

		for (angle = 1.0f; angle < 361.0f; angle += 36) {
			x2 = (float) ((x1 + Math.sin(angle) * radius) + (Math.random() * 0.02));
			y2 = (float) ((y1 + Math.cos(angle) * radius) + (Math.random() * 0.02));
			points.add(new Point(x2, y2));
		}
		this.points = points.toArray(new Point[0]);
		calculate();
	}

	/**
	 * Saving the pre calculated form of the asteroid
	 */
	private Point[] points;

	@Override
	protected void realDraw(GL2 gl) {
		gl.glColor3d(color[0], color[1], color[2]);
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		for (int i = 0; i < points.length; i++)
			gl.glVertex2f(points[i].getX() + position.getX(), points[i].getY() + position.getY());
		gl.glEnd();
	}

	@Override
	public void calculate() {
		if (!visible)
			return;
		if (position.getY() <= -1f) {
			position.setX((float) (Math.random() * 2) - 1);
			position.setY((float) (1.1f + Math.random()));
		} else {
			float my;
			long currentTime = System.currentTimeMillis(), time = currentTime - lastUpdate;
			my = position.getY() - (dy / 1000) * time;
			position.setY(my);
			lastUpdate = currentTime;
		}
	}

}
