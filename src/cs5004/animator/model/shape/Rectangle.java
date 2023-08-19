package cs5004.animator.model.shape;

/**
 * This is a class represents Rectangles.
 * 
 * @author zeyushen
 *
 */
public class Rectangle extends AbstractShape {

  /**
   * Construct and initialize a Rectangle object with given parameters.
   * 
   * @param name     the name of the Rectangle object
   * @param position the position of the Rectangle object
   * @param size     the size of the Rectangle object
   * @param color    the color of the Rectangle object
   * @param start    the start time of the Rectangle object
   * @param end      the end time of the Rectangle object
   * @throws IllegalArgumentException throw if there are illegal inputs
   */
  public Rectangle(String name, Point2D position, Size2D size, Color3D color, int start, int end)
      throws IllegalArgumentException {
    super(name, ShapeEnum.Rectangle, position, size, color, start, end);
  }

  /**
   * Construct and initialize a Rectangle object with only a name as parameter.
   * 
   * @param name the given name
   */
  public Rectangle(String name) {
    super(name, ShapeEnum.Rectangle);
  }

  @Override
  public IShape duplicate() {
    return new Rectangle(this.name, this.position, this.size, this.color, this.start, this.end);
  }

  @Override
  public String toString() {
    // here is a problem, if we initialize the shape with only a name (and type)
    // then some attributes' toString won't work. (SOLVED)
    String output = "Name: " + this.name.toString() + "\n" + "Type: " + this.getType().toString()
        + "\n" + "Min corner: " + this.getPosition().toString() + ", Width: "
        + this.getSize().getHorizontal() + ", Height: " + this.getSize().getVertical() + ", "
        // + String.format(", Width: %1.f, Height: %.1f, 
        // + ", this.getSize().getHorizontal(), this.getSize().getVertical())
        + "Color: " + this.getColor().toString() + "\n" + "Appears at t=" + this.getStart() + "\n"
        + "Disappears at t=" + this.getEnd() + "\n";
    return output;
  }

  @Override
  public String toSvg() {
    // see when we need to set it invisible
    String svgout = String.format(
        "<rect id=\"%s\" x=\"%.1f\" y=\"%.1f\" width=\"%.1f\" height=\"%.1f\" "
            + " fill=\"rgb(%.1f, %.1f, %.1f)\" visibility=\"hidden\">\n ",
        this.getName(), this.getPosition().getXcord(), this.getPosition().getYcord(),
        this.getSize().getHorizontal(), this.getSize().getVertical(), this.getColor().getR(),
        this.getColor().getG(), this.getColor().getB());

    return svgout;
  }

  @Override
  public String toSvHide(int time) {
    // System.out.println(time);
    String svgout = String.format(
        "<rect id=\"%s\" x=\"%.1f\" y=\"%.1f\" width=\"%.1f\" height=\"%.1f\"\" begin=\"%dms\""
            + " fill=\"rgb(%.1f, %.1f, %.1f)\" visibility=\"hidden\">\n ",
        this.getName(), this.getPosition().getXcord(), this.getPosition().getYcord(),
        this.getSize().getHorizontal(), this.getSize().getVertical(), time, this.getColor().getR(),
        this.getColor().getG(), this.getColor().getB());

    return svgout;
  }
}
