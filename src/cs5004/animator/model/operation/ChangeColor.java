package cs5004.animator.model.operation;

import cs5004.animator.model.shape.Color3D;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Size2D;

/**
 * This is a class represent the ChangeColor operation.
 * 
 * @author zeyushen
 *
 */
public class ChangeColor extends AbstractOperation {

  private OperationEnum type;
  private Point2D beginPosition;
  private Point2D endPosition;
  private Size2D beginSize;
  private Size2D endSize;
  private Color3D beginColor;
  private Color3D endColor;

  /**
   * Construct and initialize a ChangeColor object with given parameters.
   * 
   * @param shape the given shape, related to this operation
   * @param begin the given begin time of this operation
   * @param end   the given end time of this operation
   * @param from  the given start color of this operation
   * @param to    the given end color of this operation
   * @throws IllegalArgumentException throws if there is exceptions in the super
   *                                  constructor.
   */
  public ChangeColor(IShape shape, int begin, int end, Color3D from, Color3D to)
      throws IllegalArgumentException {
    super(shape, begin, end);
    this.beginColor = from;
    this.endColor = to;
    this.type = OperationEnum.CHANGECOLOR;
  }

  /**
   * Construct and initialize a ChangeColor object with all the parameters can be
   * provided by AnimationReader and AnimationBuilderImpl. This helps to ensure
   * that the operation-related shapes' other attributes will remain stable in
   * VisualView and NewView during changing one of the three attributes (size,
   * color, position).
   * 
   * @param shape     the given shape, related to this operation
   * @param begin     the given begin time of this operation
   * @param end       the given end time of this operation
   * @param position1 the given start position of this operation
   * @param position2 the given end position of this operation
   * @param size1     the given start size of this position
   * @param size2     the given end size of this position
   * @param color1    the given start color of this position
   * @param color2    the given end color of this position
   * @throws IllegalArgumentException throws if there is exceptions in the super
   *                                  constructor.
   */
  public ChangeColor(IShape shape, int begin, int end, Point2D position1, Point2D position2,
      Size2D size1, Size2D size2, Color3D color1, Color3D color2) throws IllegalArgumentException {
    super(shape, begin, end);
    this.beginPosition = position1;
    this.endPosition = position2;
    this.beginSize = size1;
    this.endSize = size2;
    this.beginColor = color1;
    this.endColor = color2;
    this.type = OperationEnum.CHANGECOLOR;
  }

  @Override
  public OperationEnum getOpType() {
    return this.type;
  }

  /**
   * Get the begin position for this operation.
   * 
   * @return the begin position for this operation.
   */
  public Point2D getBeginPosition() {
    return this.beginPosition;
  }

  /**
   * Get the end position for this operation.
   * 
   * @return the end position for this operation.
   */
  public Point2D getEndPosition() {
    return this.endPosition;
  }

  /**
   * Get the begin position for this operation.
   * 
   * @return the begin position for this operation.
   */
  public Size2D getBeginSize() {
    return this.beginSize;
  }

  /**
   * Get the end position for this operation.
   * 
   * @return the end position for this operation.
   */
  public Size2D getEndSize() {
    return this.endSize;
  }

  /**
   * Get the begin color for this operation.
   * 
   * @return the begin color for this operation.
   */
  public Color3D getBeginColor() {
    return this.beginColor;
  }

  /**
   * Get the end color for this operation.
   * 
   * @return the end color for this operation.
   */
  public Color3D getEndColor() {
    return this.endColor;
  }

  @Override
  public IShape getShapeAtTime() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void operate(IShape shape, int cur) {
    // if (this.getOpStart() == this.getOpEnd() && this.getOpStart() == cur) {
    // this.getShape().redye(this.endColor);
    // } else if (this.getOpStart() <= cur && this.getOpEnd() >= cur) {
    // double r = this.interpolate(this.beginColor.getR(), this.endColor.getR(),
    // this.getOpStart(), this.getOpEnd(), cur);
    // double g = this.interpolate(this.beginColor.getG(), this.endColor.getG(),
    // this.getOpStart(), this.getOpEnd(), cur);
    // double b = this.interpolate(this.beginColor.getB(), this.endColor.getB(),
    // this.getOpStart(), this.getOpEnd(), cur);
    // this.getShape().redye(new Color3D(r,g,b));
    // }

    // if (this.getOpStart() == this.getOpEnd() && this.getOpStart() == cur) {
    // shape.redye(this.endColor);
    // } else if (this.getOpStart() <= cur && this.getOpEnd() >= cur) {
    // double r = this.interpolate(this.beginColor.getR(), this.endColor.getR(),
    // this.getOpStart(), this.getOpEnd(), cur);
    // double g = this.interpolate(this.beginColor.getG(), this.endColor.getG(),
    // this.getOpStart(), this.getOpEnd(), cur);
    // double b = this.interpolate(this.beginColor.getB(), this.endColor.getB(),
    // this.getOpStart(), this.getOpEnd(), cur);
    // shape.redye(new Color3D(r,g,b));
    // }

    if (this.getOpStart() == this.getOpEnd() && this.getOpStart() == cur) {
      shape.relocate(this.getEndPosition());
    } else if (this.getOpStart() <= cur && this.getOpEnd() >= cur) {
      double x = this.interpolate(this.beginPosition.getXcord(), this.endPosition.getXcord(),
          this.getOpStart(), this.getOpEnd(), cur);
      double y = this.interpolate(this.beginPosition.getYcord(), this.endPosition.getYcord(),
          this.getOpStart(), this.getOpEnd(), cur);
      shape.relocate(new Point2D(x, y));
    }

    if (this.getOpStart() == this.getOpEnd() && this.getOpStart() == cur) {
      shape.relocate(this.getEndPosition());
    } else if (this.getOpStart() <= cur && this.getOpEnd() >= cur) {
      double x = this.interpolate(this.beginPosition.getXcord(), this.endPosition.getXcord(),
          this.getOpStart(), this.getOpEnd(), cur);
      double y = this.interpolate(this.beginPosition.getYcord(), this.endPosition.getYcord(),
          this.getOpStart(), this.getOpEnd(), cur);
      shape.relocate(new Point2D(x, y));
    }

    if (this.getOpStart() == this.getOpEnd() && this.getOpStart() == cur) {
      shape.redye(this.endColor);
    } else if (this.getOpStart() <= cur && this.getOpEnd() >= cur) {
      double r = this.interpolate(this.beginColor.getR(), this.endColor.getR(), this.getOpStart(),
          this.getOpEnd(), cur);
      double g = this.interpolate(this.beginColor.getG(), this.endColor.getG(), this.getOpStart(),
          this.getOpEnd(), cur);
      double b = this.interpolate(this.beginColor.getB(), this.endColor.getB(), this.getOpStart(),
          this.getOpEnd(), cur);
      shape.redye(new Color3D(r, g, b));
    }
  }

  @Override
  public IOperation duplicateOp() {
    // return new ChangeColor(this.getShape(), this.getOpStart(), this.getOpEnd(),
    // this.getBeginColor(), this.getEndColor());
    return new ChangeColor(this.shape, this.getOpStart(), this.getOpEnd(), this.getBeginPosition(),
        this.getEndPosition(), this.beginSize, this.endSize, this.beginColor, this.endColor);
  }

  @Override
  public String svgString(int speed) {
    int start = this.getOpStart() * 1000 / speed;
    int end = this.getOpEnd() * 1000 / speed;
    int duration = end - start;
    StringBuilder svgout = new StringBuilder();

    String svgstr = String.format("   <animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\""
        + " attributeName=\"fill\" from=\"rgb(%.1f,%.1f,%.1f)\" to=\"rgb(%.1f,%.1f,%.1f)\""
        + " fill=\"freeze\" />\n\n",
        start, duration, this.getBeginColor().getR(), this.getBeginColor().getG(),
        this.getBeginColor().getB(), this.getEndColor().getR(), this.getEndColor().getG(),
        this.getEndColor().getB());
    svgout.append(svgstr);

    return svgout.toString();
  }

  @Override
  public String toString() {
    String output;

    if (this.getBeginColor() == this.getEndColor()) {
      output = "";
    } else {

      output = "Shape " + this.getShape().getName().toString() + " changes color from"
          + this.getBeginColor().toString() + " to " + this.getEndColor().toString()
          + String.format(" from t= %d to t=%d", this.getOpStart(), this.getOpEnd());
    }
    return output;
  }
}
