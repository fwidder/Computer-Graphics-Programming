package template;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
		// Create Components

		// Add Components
		// canvas.addGLEventListener(simple1);
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

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						animator.stop();
						System.exit(0);
					}
				}).start();
			}
		});
	}
}
