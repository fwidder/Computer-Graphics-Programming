package assignment1.objects;

import com.jogamp.opengl.GL2;

public class Plane extends GraphicObject {

	private Point window1, window2, window3, window4, body_p1, body_p2, body_p3, body_p4, rudder_p1, rudder_p2,
			rudder_p3, rudder_p4, front_window_p1, front_window_p2, front_window_p3;

	public Plane(Point position) {
		super(position);
		calculate();
	}

	@Override
	protected void realDraw(GL2 gl) {
		// Body
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(0f, 0f, 0.3f);

		gl.glVertex2f(body_p1.getX(), body_p1.getY());
		gl.glVertex2f(body_p2.getX(), body_p2.getY());
		gl.glVertex2f(body_p3.getX(), body_p3.getY());
		gl.glVertex2f(body_p4.getX(), body_p4.getY());

		gl.glEnd();

		// Rudder
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(0f, 0f, 0.9f);

		gl.glVertex2f(rudder_p1.getX(), rudder_p1.getY());
		gl.glVertex2f(rudder_p2.getX(), rudder_p2.getY());
		gl.glVertex2f(rudder_p3.getX(), rudder_p3.getY());
		gl.glVertex2f(rudder_p4.getX(), rudder_p4.getY());

		gl.glEnd();

		// Windows
		gl.glPointSize(3);
		gl.glBegin(GL2.GL_POINTS);
		gl.glColor3f(0f, 0f, 0.9f);

		gl.glVertex2f(window1.getX(), window1.getY());
		gl.glVertex2f(window2.getX(), window2.getY());
		gl.glVertex2f(window3.getX(), window3.getY());
		gl.glVertex2f(window4.getX(), window4.getY());

		gl.glEnd();

		// Front Window
		gl.glBegin(GL2.GL_TRIANGLES);
		gl.glColor3f(0f, 0f, 0.9f);

		gl.glVertex2f(front_window_p1.getX(), front_window_p1.getY());
		gl.glVertex2f(front_window_p2.getX(), front_window_p2.getY());
		gl.glVertex2f(front_window_p3.getX(), front_window_p3.getY());

		gl.glEnd();

		gl.glFlush();
	}

	@Override
	public void calculate() {
		if (!visible || position.getX() >= 1.1f)
			position.setX(-1.3f);
		else {
			float mx;
			long currentTime = System.currentTimeMillis(), time = currentTime - lastUpdate;
			mx = position.getX() + (dx / 1000) * time;
			position.setX(mx);
			lastUpdate = currentTime;
		}
		body_p1 = new Point(0 + position.getX(), 0 + position.getY());
		body_p2 = new Point(0.06f + position.getX(), -0.03f + position.getY());
		body_p3 = new Point(0.26f + position.getX(), -0.03f + position.getY());
		body_p4 = new Point(0.2f + position.getX(), 0f + position.getY());
		rudder_p1 = new Point(0.03f + position.getX(), 0f + position.getY());
		rudder_p2 = new Point(0.06f + position.getX(), 0f + position.getY());
		rudder_p3 = new Point(0.05f + position.getX(), 0.06f + position.getY());
		rudder_p4 = new Point(0.03f + position.getX(), 0.06f + position.getY());
		window1 = new Point(0.18f + position.getX(), -0.015f + position.getY());
		window2 = new Point(0.15f + position.getX(), -0.015f + position.getY());
		window3 = new Point(0.12f + position.getX(), -0.015f + position.getY());
		window4 = new Point(0.09f + position.getX(), -0.015f + position.getY());
		front_window_p1 = new Point(0.22f + position.getX(), -0.01f + position.getY());
		front_window_p2 = new Point(0.24f + position.getX(), -0.02f + position.getY());
		front_window_p3 = new Point(0.22f + position.getX(), -0.02f + position.getY());
	}

}
