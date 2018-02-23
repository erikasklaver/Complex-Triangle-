
import objectdraw.*;
import java.awt.*;

/**
 * Draws a ComplexTriangle and allows it to be dragged around the window.
 * 
 * Erika Sklaver
 * Section 2
 */
public class Events extends FrameWindowController {

    // size of the program window
    private static final int WINDOW_SIZE = 600;
    
	// the three vertices of the complex triangle
	private static final Location VERTEX_1 = new Location(50, 400);
	private static final Location VERTEX_2 = new Location(500, 400);
	private static final Location VERTEX_3 = new Location(275, 50);

	// the triangle itself
	private ComplexTriangle triangle;

	// used to keep track of the last location of the triangle 
	// when the triangle is being dragged around
	private Location lastPoint;

	// create the complex triangle
	public void begin() {
	    resize(WINDOW_SIZE, WINDOW_SIZE);
		triangle = new ComplexTriangle(VERTEX_1, VERTEX_2, VERTEX_3, canvas);
	}
	
	// save the location of the mouse press
	public void onMousePress(Location point) {
		lastPoint = point;
	}
	
	// Move the triangle around by calling the ComplexTriangle
	// move method and moving the triangle by the x and y
	// offsets that are the difference between the current
	// location of the mouse and the previous location ("lastPoint").
	// Note that the triangle moves whether the mouse is pressed
	// inside *or* outside the triangle
	public void onMouseDrag(Location point) {
		triangle.move(point.getX() - lastPoint.getX(), 
		              point.getY() - lastPoint.getY());
		lastPoint = point;
	}
	
}
