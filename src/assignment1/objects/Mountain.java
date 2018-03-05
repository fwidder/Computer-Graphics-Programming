package assignment1.objects;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;

public class Mountain extends GraphicObject {

	private Point[][] points;

	public Mountain() {
		super();
		ArrayList<Point[]> points = new ArrayList<Point[]>();
		for (double i = -1.1; i <= 1.1; i = i + (Math.random() * 0.2)) {
			Point[] p = new Point[3];
			p[0] = new Point((float) ((float) i - (0.1 + Math.random() * 0.2)), -1);
			p[1] = new Point((float) i, (float) ((Math.random() * -1) * 0.5));
			p[2] = new Point((float) ((float) i + (0.1 + Math.random() * 0.4)), -1);
			points.add(p);
		}
		this.points = points.toArray(new Point[0][0]);
	}

	@Override
	public void calculate() {
		// Nothing to calculate
	}

	@Override
	protected void realDraw(GL2 gl) {
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		for (int i = 0; i < points.length; i++) {
			gl.glColor3f(0.3f, 0.3f, 0.3f);
			gl.glVertex2f(points[i][0].getX(), points[i][0].getY());
			gl.glColor3f(1, 1, 1);
			gl.glVertex2f(points[i][1].getX(), points[i][1].getY());
			gl.glColor3f(0.3f, 0.3f, 0.3f);
			gl.glVertex2f(points[i][2].getX(), points[i][2].getY());
		}
		gl.glEnd();
	}

}
