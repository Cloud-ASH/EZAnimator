package cs5004.animator.model.shape;

/**
 * This is class represent the Oval.
 * 
 * @author zeyushen
 *
 */
public class Oval extends AbstractShape {
  
  /**
   * Construct and initialize a Oval object with given parameters.
   * 
   * @param name     the name of the Oval object
   * @param position the position of the Oval object
   * @param size     the size of the Oval object
   * @param color    the color of the Oval object
   * @param start    the start time of the Oval object
   * @param end      the end time of the Oval object
   * @throws IllegalArgumentException throw if there are illegal inputs
   */
  public Oval(String name, Point2D position, Size2D size, Color3D color, int start, int end)
      throws IllegalArgumentException {
    super(name, ShapeEnum.Oval, position, size, color, start, end);
  }
  
  /**
   * Construct and initialize a Oval object with only a name as parameter.
   * 
   * @param name the given name
   */
  public Oval(String name) {
    super(name, ShapeEnum.Oval);
  }

  @Override
  public IShape duplicate() {
    return new Oval(this.name, this.position, this.size, this.color, this.start, this.end);
  }

  @Override
  public String toString() {
    String output = "Name: " + this.name.toString() + "\n" + "Type: " + this.type.toString() + "\n"
        + "Center: " + this.getPosition().toString() + ", X radius: "
        + this.getSize().getHorizontal() + ", Y radius: " + this.getSize().getVertical() + ", "
        // + String.format(", X radius: %1.f, Y radius: %.1f, 
        // ", this.getSize().getHorizontal(), this.getSize().getVertical())
        + "Color: " + this.getColor().toString() + "\n" + "Appears at t=" + this.getStart() + "\n"
        + "Disappears at t=" + this.getEnd() + "\n";
    return output;
  }

  @Override
  public String toSvg() {

    String svgout = String.format(
        "<ellipse id=\"%s\" cx=\"%.1f\" cy=\"%.1f\" rx=\"%.1f\" ry=\"%.1f\" "
            + " fill=\"rgb(%.1f, %.1f, %.1f)\" visibility=\"hidden\">\n ",
        this.getName(), this.getPosition().getXcord(), this.getPosition().getYcord(),
        this.getSize().getHorizontal(), this.getSize().getVertical(), this.getColor().getR(),
        this.getColor().getG(), this.getColor().getB());

    return svgout;
  }

  @Override
  public String toSvHide(int time) {

    // String svgout = 
    // "<ellipse>\n <animate id=\"base\" begin=\"0;base.end\" dur=\""+ time +"ms\""
    // + " attributeName=\"visibility\" from=\"hide\" to=\"hide\"/> \n</ellipse>\n\n";

    String svgout = String.format(
        "<ellipse id=\"%s\" cx=\"%.1f\" cy=\"%.1f\" rx=\"%.1f\" ry=\"%.1f\" \" begin=\"%dms\""
            + " fill=\"rgb(%.1f, %.1f, %.1f)\" visibility=\"hidden\">\n ",
        this.getName(), this.getPosition().getXcord(), this.getPosition().getYcord(),
        this.getSize().getHorizontal(), this.getSize().getVertical(), time, this.getColor().getR(),
        this.getColor().getG(), this.getColor().getB());

    return svgout;
  }
}
