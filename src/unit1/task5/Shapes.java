package unit1.task5;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Shapes implements GLEventListener {

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		// clear the drawing canvas
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		// Triangle 1
		gl.glBegin(GL2.GL_TRIANGLES);
		gl.glVertex2f(-0.8f, 0.9f);
		gl.glVertex2f(-0.85f, 0.75f);
		gl.glVertex2f(-0.75f, 0.8f);
		gl.glEnd();
		// Triangle 2
		gl.glBegin(GL2.GL_TRIANGLES);
		gl.glVertex2f(-0.7f, 0.85f);
		gl.glVertex2f(-0.75f, 0.75f);
		gl.glVertex2f(-0.5f, 0.7f);
		gl.glEnd();
		// Triangle Strip
		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		gl.glVertex2f(-0.2f, 0.1f);
		gl.glVertex2f(0.2f, 0.15f);
		gl.glVertex2f(0.1f, 0.3f);
		gl.glVertex2f(-0.2f, 0.35f);
		gl.glVertex2f(-0.2f, 0.35f);
		gl.glEnd();

		gl.glFlush();

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub

	}

}
