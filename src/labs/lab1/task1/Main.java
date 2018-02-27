package labs.lab1.task1;

import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
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
public class Main {

	public static void main(String[] args) {
		// Create frame
		JFrame frame = new JFrame("SimpleLine Demo");
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
		frame.setVisible(true);
		// Start Animator
		animator.start();
		// Set focus of frame to canvas
		canvas.requestFocusInWindow();
	}
}
