package assignment1;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Mountain extends GraphicObject {

	private Point[][] points;

	public Mountain() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();

		// Mountain Layer
		gl.glBegin(GL2.GL_TRIANGLES);
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

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable arg0) {
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
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(float f) {
		// TODO Auto-generated method stub

	}

}
