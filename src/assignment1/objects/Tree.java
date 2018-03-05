package assignment1.objects;

import com.jogamp.opengl.GL2;

public class Tree extends GraphicObject {

	public Tree(float x) {
		super(new Point(x, 0));
	}

	@Override
	protected void realDraw(GL2 gl) {
		// Treetrunk
		gl.glBegin(GL2.GL_QUADS);
		gl.glColor3f(0.5f, 0.25f, 0.1f);

		gl.glVertex2f(position.getX(), -1);
		gl.glVertex2f(position.getX() + 0.02f, -0.5f);
		gl.glVertex2f(position.getX() + 0.08f, -0.5f);
		gl.glVertex2f(position.getX() + 0.1f, -1f);

		gl.glEnd();

		// Left Tree Leaves
		gl.glColor3f(0.2f, 0.95f, 0.2f);
		drawCircle(gl, position.getX() + 0.05f, -0.5f, 0.1f);

		gl.glEnd();

		gl.glFlush();
	}

	@Override
	public void calculate() {
		// Nothing to calculate

	}
}
