/**
 * 
 */
package rrassi2;

import java.awt.Frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import com.jogamp.newt.event.WindowListener;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

/**
 * @author rajshree--- to make home
 *
 */
public class circle implements GLEventListener{

	/**
	 * @param args
	 */
	 int r;
	int pntX1 = 50, pntY1=50;
	private GLU glu;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GLProfile glp = GLProfile.get(GLProfile.GL2);
		GLCapabilities cap = new GLCapabilities(glp);
		GLCanvas canvas = new GLCanvas(cap);
		
		Frame frame = new Frame("Assignment1");
		frame.setSize(1200, 800);
		frame.add(canvas);
		frame.setVisible(true);
		
		circle l = new circle();
		l.readRadius();
	    canvas.addGLEventListener(l);  
	  /*  Scanner bucky = new Scanner(System.in);
	    r = bucky.nextInt();
	    bucky.close();*/
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}});
		}
		
		
	private void readRadius() {
		// TODO Auto-generated method stub
		 Scanner bucky = new Scanner(System.in);

		  this.r = bucky.nextInt();
		  bucky.close();
	}


	void plot(GL2 gl,int x, int y)
	{
		gl.glBegin(GL2.GL_POINTS);
		gl.glVertex2i(x+pntX1, y+pntY1);
		gl.glEnd();
	}

	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
		GL2 gl = drawable.getGL().getGL2();

		gl.glClear (GL2.GL_COLOR_BUFFER_BIT);
		//gl.glColor3f (0.0f, 0.0f, 0.0f);
		gl.glPointSize(1.0f);

		midPointCircleAlgo(gl);

	gl.glFlush ();
	}
	
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		
	}

	public void init(GLAutoDrawable gld) {
		// TODO Auto-generated method stub
		
		 GL2 gl = gld.getGL().getGL2();
		 glu = new GLU();

		gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
		gl.glColor3f(0.0f, 0.0f, 0.0f);
		gl.glPointSize(4.0f);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
	glu.gluOrtho2D(0.0, 640.0, 0.0, 480.0);
		
	}
	void midPointCircleAlgo(GL2 gl)
	{
		int x = 0;
		int y = r;
		float decision = 5/4 - r;
		plot(gl, x, y);

		while (y > x)
		{
			if (decision < 0)
			{
				x++; 
				decision += 2*x+1;
			}
			else
			{
				y--;
				x++;
				decision += 2*(x-y)+1;
			}
			plot(gl,x, y);
			plot(gl,x, -y);
			plot(gl,-x, y);
			plot(gl,-x, -y);
			plot(gl,y, x);
			plot(gl,-y, x);
			plot(gl,y, -x);
			plot(gl,-y, -x);
		}

	}
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		
		
		// TODO Auto-generated method stub
		
	}

}




