package cs5004.animator.model.shape;

/**
 * This is a class represents the 2D position of a point.
 * 
 * @author zeyushen
 *
 */
public class Point2D {

  private double xcord;
  private double ycord;

  /**
   * Construct and initialize a 2D position with given parameters. For a
   * rectangle, the position is its minimum corner (left bottom corner), denoted
   * by (xcord, ycord). For an oval, the position is its center, denoted by
   * (xcord, ycord).
   * 
   * @param x the x coordinate of given position.
   * @param y the y coordinate of given position.
   */
  public Point2D(double x, double y) {
    this.xcord = x;
    this.ycord = y;
  }

  /**
   * Get the x coordinate of this position.
   * 
   * @return x the x coordinate of current position.
   */
  public double getXcord() {
    return this.xcord;
  }

  /**
   * Get the y coordinate of this position.
   * 
   * @return y the y coordinate of current position.
   */
  public double getYcord() {
    return this.ycord;
  }

  @Override
  public String toString() {
    return String.format("(%.1f, %.1f)", this.xcord, this.ycord);
  }
}
