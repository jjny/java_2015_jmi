import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import org.omg.CORBA.portable.InputStream;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

public class Cube implements GLEventListener{
	
	
	private float x,y,z;
	private float tx,ty,tz;
	private ArrayList<Cube> cube=new ArrayList<>();
	//private byte Texture[]={0,0,0,0, 0xFF,0xFF,0xFF,0xFF,0xFF,0xFF,0xFF,0xFF, 0,0,0,0
	//		};
	//private GLuint texture;
	
	  public static void main(String[] args) {
	        GLProfile glp = GLProfile.getDefault();
	        GLCapabilities caps = new GLCapabilities(glp);
	        GLCanvas canvas = new GLCanvas(caps);

	        Frame frame = new Frame("cube");
	        frame.setSize(600, 600);
	        frame.add(canvas);
	        frame.setVisible(true);
	        
	        // by default, an AWT Frame doesn't do anything when you click
	        // the close button; this bit of code will terminate the program when
	        // the window is asked to close
	        frame.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	            	 
	                System.exit(0);
	            }
	        });
	       
	        
	        canvas.addGLEventListener(new Cube());
	        
	      //  Animator animator = new FPSAnimator(canvas,60);
	        Animator animator = new Animator();
	        animator.add(canvas);
	        
	        animator.start();        
	           
	    }
	    
	   public Cube()
	   {
		   ty = 0;
		   tx = 0;
	   }
	    
	    public void display(GLAutoDrawable drawable){
	    	update();
	    	render(drawable);
	    }
	    
	    public void dispose(GLAutoDrawable drawable){ 	
	    }
	    
	    
	    public void init(GLAutoDrawable drawable){ 	
	    	GL2 gl=drawable.getGL().getGL2();
	    	gl.glShadeModel(gl.GL_SMOOTH);
	    	gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	    	gl.glClearDepthf(1.0f);
	    	gl.glEnable(gl.GL_DEPTH_TEST);
	    	gl.glEnable(gl.GL_TEXTURE_2D);
	    	gl.glDepthFunc(gl.GL_LEQUAL);
	    	gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT, gl.GL_NICEST);
	    	
	    }
	    
	    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h){ 
	    	GL2 gl=drawable.getGL().getGL2();
	    	gl.glViewport(0,0,w,h);
	    	gl.glMatrixMode(gl.GL_PROJECTION);
	    	gl.glLoadIdentity();
	    	GLU glu = new GLU();
	    	glu.gluPerspective(45.0f,(float)w/(float)h,0.1f,100.0f); //(GLfloat)
	    	gl.glMatrixMode(gl.GL_MODELVIEW);
	    	gl.glLoadIdentity();
	    	
	    	
	    }
	    
	   private void update(){
		  
	
		   tx=tx+2f;
		   ty=ty+2f;
	    	
	    }
	   
	   private void cube(float size,GL2 gl){
		
			gl.glBegin(GL2.GL_QUADS);
	    	
	        gl.glColor3f(255,0,0); //face rouge
	       
	        gl.glVertex3f(size,size,size);
	        gl.glVertex3f(size,size,-size);
	        gl.glVertex3f(-size,size,-size);
	        gl.glVertex3f(-size,size,size);

	       gl.glColor3f(0,255,0); //face verte
	        gl.glVertex3f(size,-size,size);
	        gl.glVertex3f(size,-size,-size);
	        gl.glVertex3f(size,size,-size);
	        gl.glVertex3f(size,size,size);

	       gl.glColor3f(0,0,255); //face bleue
	        gl.glVertex3f(-size,-size,size);
	        gl.glVertex3f(-size,-size,-size);
	        gl.glVertex3f(size,-size,-size);
	        gl.glVertex3f(size,-size,size);

	        gl.glColor3f(255,255,0); //face jaune
	        gl.glVertex3f(-size,size,size);
	        gl.glVertex3f(-size,size,-size);
	        gl.glVertex3f(-size,-size,-size);
	        gl.glVertex3f(-size,-size,size);

	        gl.glColor3f(0,255,255); //face cyan
	        gl.glVertex3f(size,size,-size);
	        gl.glVertex3f(size,-size,-size);
	        gl.glVertex3f(-size,-size,-size);
	        gl.glVertex3f(-size,size,-size);

	       gl.glColor3f(255,255,255); //face blanche
	        gl.glVertex3f(size,-size,size);
	        gl.glVertex3f(size,size,size);
	        gl.glVertex3f(-size,size,size);
	        gl.glVertex3f(-size,-size,size);

	        gl.glEnd();	           
	   }
	   
	   
	 private void render(GLAutoDrawable drawable){
	    	GL2 gl=drawable.getGL().getGL2();
	    	
	    	gl.glClear( gl.GL_DEPTH_BUFFER_BIT);
	    	gl.glClear( gl.GL_COLOR_BUFFER_BIT);
	    	//gl.glGenTextures(); texture a mapper
	    	//gl.glBindTexture() texture courante
	    	//gl.glTexTlage2D() parametret image l L format...
	    	//ArrayList<glColor3f> colors =new ArrayList<glColor3f>(); 
	    	
	    	gl.glLoadIdentity();
	    	gl.glPushMatrix();
	    		gl.glTranslatef(0.0f, -0.5f, -5f);
	    		gl.glRotatef(ty, 0, 1, 0);
	    		cube(0.25f,gl);           
	        gl.glPopMatrix();
	    	
    
	        gl.glLoadIdentity();
	    	gl.glPushMatrix();
	    			gl.glTranslatef(0.0f, 0.25f, -5f);
	    			gl.glRotatef(tx, 1, 0, 0);
	    			cube(0.25f,gl);
	        gl.glPopMatrix();
	        
	        
	        gl.glLoadIdentity();
	    	gl.glPushMatrix();
	    		gl.glTranslatef(0.0f, 1f, -5f);
	    		gl.glRotatef(ty, 0, -10, 0);
	    		gl.glTranslatef(-1f, -1f, 1f);
	    		 cube(0.25f,gl);
	        gl.glPopMatrix();
	    }
	

}