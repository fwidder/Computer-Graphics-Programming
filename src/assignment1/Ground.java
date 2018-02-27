package assignment1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Ground implements GLEventListener {

	@Override
	public void display(GLAutoDrawable arg0) {
		GL2 gl = arg0.getGL().getGL2();

		// Middle Layer
		gl.glBegin(GL2.GL_POLYGON);
		gl.glColor3f(0f, 0.4f, 0f);

		gl.glVertex2f(-1, -1);
		gl.glVertex2f(1, -1);
		gl.glVertex2f(1, -0.7f);
		gl.glVertex2f(0.9f, -0.698f);
		gl.glVertex2f(0.8f, -0.695f);
		gl.glVertex2f(0.7f, -0.692f);
		gl.glVertex2f(0.6f, -0.69f);
		gl.glVertex2f(0.5f, -0.689f);
		gl.glVertex2f(0.4f, -0.688f);
		gl.glVertex2f(0f, -0.687f);
		gl.glVertex2f(-0.4f, -0.688f);
		gl.glVertex2f(-0.5f, -0.689f);
		gl.glVertex2f(-0.6f, -0.69f);
		gl.glVertex2f(-0.7f, -0.692f);
		gl.glVertex2f(-0.8f, -0.695f);
		gl.glVertex2f(-0.9f, -0.698f);
		gl.glVertex2f(-1, -0.7f);

		gl.glEnd();

		// Front Layer
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(0.5f, 0.3f, 0.1f);

		gl.glVertex2f(-1, -1);
		gl.glVertex2f(1, -1);
		gl.glVertex2f(1, -0.8f);
		gl.glVertex2f(-1, -0.8f);

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
