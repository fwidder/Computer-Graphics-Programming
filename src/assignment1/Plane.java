package assignment1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Plane implements GLEventListener {

	private Point offset, window1, window2, window3, window4, body_p1, body_p2, body_p3, body_p4, rudder_p1, rudder_p2,
			rudder_p3, rudder_p4, front_window_p1, front_window_p2, front_window_p3;

	private void recalc() {
		body_p1 = new Point(0 + offset.getX(), 0 + offset.getY());
		body_p2 = new Point(0.06f + offset.getX(), -0.03f + offset.getY());
		body_p3 = new Point(0.26f + offset.getX(), -0.03f + offset.getY());
		body_p4 = new Point(0.2f + offset.getX(), 0f + offset.getY());
		rudder_p1 = new Point(0.03f + offset.getX(), 0f + offset.getY());
		rudder_p2 = new Point(0.06f + offset.getX(), 0f + offset.getY());
		rudder_p3 = new Point(0.05f + offset.getX(), 0.06f + offset.getY());
		rudder_p4 = new Point(0.03f + offset.getX(), 0.06f + offset.getY());
		window1 = new Point(0.18f + offset.getX(), -0.015f + offset.getY());
		window2 = new Point(0.15f + offset.getX(), -0.015f + offset.getY());
		window3 = new Point(0.12f + offset.getX(), -0.015f + offset.getY());
		window4 = new Point(0.09f + offset.getX(), -0.015f + offset.getY());
		front_window_p1 = new Point(0.22f + offset.getX(), -0.01f + offset.getY());
		front_window_p2 = new Point(0.24f + offset.getX(), -0.02f + offset.getY());
		front_window_p3 = new Point(0.22f + offset.getX(), -0.02f + offset.getY());
	}

	@Override
	public void display(GLAutoDrawable arg0) {
		recalc();
		GL2 gl = arg0.getGL().getGL2();

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
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable arg0) {
		offset = new Point(0f, 0);
	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub

	}

}
