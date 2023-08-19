package cs5004.animator.model.shape;

/**
 * This is a class represents the color of a shape.
 * 
 * @author zeyushen
 *
 */
public class Color3D {

  private double r;
  private double g;
  private double b;

  /**
   * Construct and initialize the color with given r, g, b value.
   * 
   * @param r the given red value.
   * @param g the given green value.
   * @param b the given blue value.
   * @throws IllegalArgumentException throws when r or g or b value is not in [0,
   *                                  255](both side included) range.
   */
  public Color3D(double r, double g, double b) throws IllegalArgumentException {
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("Invalid rgb value out of range.");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Get the red value of this color.
   * 
   * @return r the red value of this color.
   */
  public double getR() {
    return this.r;
  }

  /**
   * Get the green value of this color.
   * 
   * @return g the green value of this color.
   */
  public double getG() {
    return this.g;
  }

  /**
   * Get the blue value of this color.
   * 
   * @return b the blue value of this color.
   */
  public double getB() {
    return this.b;
  }

  @Override
  public String toString() {
    return String.format("(%.1f, %.1f, %.1f)", this.r, this.g, this.b);
  }
}
