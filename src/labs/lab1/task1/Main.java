package labs.lab1.task1;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

/**
 * Creates a frame with two random {@link labs.lab1.task1.SimpleLine lines} in
 * it.
 * 
 * @author Florian Widder
 *
 */
public class Main implements GLEventListener {

	public static void main(String[] args) {
		// Create frame
		Frame frame = new Frame("SimpleLine Demo");
		// Set openGL settings
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		// Create a simple canvas for drawing
		GLCanvas canvas = new GLCanvas(capabilities);
		// Create two random Lines
		SimpleLine simple1 = new SimpleLine((float) Math.random(), (float) Math.random(), (float) Math.random(),
				(float) Math.random(), (float) Math.random(), (float) Math.random(), (float) Math.random());
		SimpleLine simple2 = new SimpleLine((float) Math.random(), (float) Math.random(), (float) Math.random(),
				(float) Math.random(), (float) Math.random(), (float) Math.random(), (float) Math.random());
		// Add lines to canvas
		canvas.addGLEventListener(simple1);
		canvas.addGLEventListener(simple2);
		// Add canvas to frame
		frame.add(canvas);
		// Create Animator for canvas
		final Animator animator = new Animator(canvas);
		// Set frame settings
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Make frame closable
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				new Thread(new Runnable() {

					public void run() {
						animator.stop();
						System.exit(0);
					}
				}).start();
			}
		});
		// Set focus of frame to canvas
		canvas.requestFocusInWindow();
	}

	@Override
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

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
