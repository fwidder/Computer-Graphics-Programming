package assignment1;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public abstract class GraphicObject implements GLEventListener {

	protected boolean visible = false;
	protected boolean moving = false;	

	@Override
	public abstract void display(GLAutoDrawable arg0);

	@Override
	public abstract void dispose(GLAutoDrawable arg0);

	@Override
	public abstract void init(GLAutoDrawable arg0);

	@Override
	public abstract void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4);

	public abstract void move(float f);

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
}
