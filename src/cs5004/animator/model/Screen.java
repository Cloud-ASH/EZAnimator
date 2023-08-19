package cs5004.animator.model;

/**
 * This is a class represent the screen which all the shapes and operations are
 * in.
 * 
 * @author zeyushen
 *
 */
public class Screen {

  private double x;
  private double y;
  private double width;
  private double height;

  /**
   * Construct and initialize an screen object with given x, y coordinate of left
   * bottom point, width and height.
   * 
   * @param x      the x coordinate of the left bottom point
   * @param y      the y coordinate of the left bottom point
   * @param width  the width of the screen
   * @param height the height of the screen
   */
  public Screen(double x, double y, double width, double height) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Size measurement cannot <= 0.");
    }
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Getter for the x coordinate of the left bottom point of screen.
   * 
   * @return x the x coordinate of the left bottom point of screen.
   */
  public double getX() {
    return this.x;
  }

  /**
   * Getter for the y coordinate of the left bottom point of screen.
   * 
   * @return y the y coordinate of the left bottom point of screen.
   */
  public double getY() {
    return this.y;
  }

  /**
   * Getter for the width of screen.
   * 
   * @return width the width of screen.
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Getter for the height of screen.
   * 
   * @return height the height of screen.
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Setter for the x coordinate of the left bottom point of screen.
   */
  public void setX(double newx) {
    this.x = newx;
  }

  /**
   * Setter for the y coordinate of the left bottom point of screen.
   */
  public void setY(double newy) {
    this.y = newy;
  }

  /**
   * Setter for Width of screen.
   */
  public void setWidth(double newwidth) throws IllegalArgumentException {
    if (newwidth <= 0) {
      throw new IllegalArgumentException("Size measurement cannot <= 0.");
    }
    this.width = newwidth;
  }

  /**
   * Setter for Height of screen.
   */
  public void setHeight(double newheight) throws IllegalArgumentException {
    if (newheight <= 0) {
      throw new IllegalArgumentException("Size measurement cannot <= 0.");
    }
    this.height = newheight;
  }

}
