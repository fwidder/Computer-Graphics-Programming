package assignment1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Trees implements GLEventListener {

	private void drawCircle(GL2 gl, float x, float y, float r) {
		float x1, y1, x2, y2;
		float angle;
		double radius = r;

		x1 = x;
		y1 = y;

		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		gl.glVertex2f(x1, y1);

		for (angle = 1.0f; angle < 361.0f; angle += 0.2) {
			x2 = (float) (x1 + Math.sin(angle) * radius);
			y2 = (float) (y1 + Math.cos(angle) * radius);
			gl.glVertex2f(x2, y2);
		}

		gl.glEnd();
	}

	@Override
	public void display(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();

		// Left Treetrunk
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(0.5f, 0.25f, 0.1f);

		gl.glVertex2f(-0.8f, -1);
		gl.glVertex2f(-0.78f, -0.4f);
		gl.glVertex2f(-0.72f, -0.4f);
		gl.glVertex2f(-0.7f, -1f);

		gl.glEnd();

		// Left Tree Leaves
		// gl.glColor3f(0, 0.95f, 0);
		// drawCircle(gl, 0.1f, 0.1f, 0.1f);

		// Right Treetrunk
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(0.5f, 0.25f, 0.1f);

		gl.glVertex2f(0.8f, -1);
		gl.glVertex2f(0.78f, -0.4f);
		gl.glVertex2f(0.72f, -0.4f);
		gl.glVertex2f(0.7f, -1f);

		gl.glEnd();

		gl.glFlush();

	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub

	}

}
