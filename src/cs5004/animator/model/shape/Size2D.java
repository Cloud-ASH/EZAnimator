package cs5004.animator.model.shape;

/**
 * This is a class represents the size of a shape.
 * 
 * @author zeyushen
 *
 */
public class Size2D {
  private double horizontal;
  private double vertical;
  

  /**
   * Construct and initialize a 2D position with given parameters.
   * For Rectangle object, the size is denoted by width and height.
   * For Oval, the size is denoted by x radius and y radius.
   * @param x the x coordinate of given position.
   * @param y the y coordinate of given position.
   */
  public Size2D(double x, double y) throws IllegalArgumentException {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Size cannot be negative.");
    }
    this.horizontal = x;
    this.vertical = y;
  }
  
  /**
   * Get the horizontal measurement of this shape.
   * @return horizontal the horizontal measurement of this shape
   */
  public double getHorizontal() {
    return this.horizontal;
  }
  
  /**
   * Get the vertical measurement of this shape.
   * @return vertical the vertical measurement of this shape
   */
  public double getVertical() {
    return this.vertical;
  }
 
  @Override
  public String toString() {
    return String.format("(%.1f, %.1f)", this.horizontal, this.vertical);
  }
}
