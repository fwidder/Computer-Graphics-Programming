package assignment1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;

/**
 * 
 * @author Florian Widder
 *
 */
public class Main {

	public static void main(String[] args) {
		// Create frame
		JFrame frame = new JFrame("Assignment 1- 2D Animation: Planet xxx");
		// Set openGL settings
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		// Create a simple canvas for drawing
		GLCanvas canvas = new GLCanvas(capabilities);
		// Create Components
		Stars starts = new Stars();
		Trees trees = new Trees();
		Plane plane = new Plane();
		Ground ground = new Ground();
		// Add Components
		canvas.addGLEventListener(starts);
		canvas.addGLEventListener(trees);
		canvas.addGLEventListener(ground);
		canvas.addGLEventListener(plane);
		// Add canvas to frame
		frame.add(canvas);
		// Create Animator for canvas
		final Animator animator = new Animator(canvas);
		// Set frame settings
		frame.setLocation(0, 0);
		frame.setSize(1280, 1024);
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
