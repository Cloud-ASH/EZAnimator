package cs5004.animator.model.operation;

import cs5004.animator.model.shape.IShape;

/**
 * This is an abstract class represents the shape. This class implements the
 * IOperation interfaces and implement some common methods for the Move, Scale,
 * ChangeColor and Freeze operations.
 * 
 * @author zeyushen
 *
 */
public abstract class AbstractOperation implements IOperation {

  protected IShape shape;
  protected int begin;
  protected int end;

  /**
   * Construct and initialize the operations with given shape and start/end time.
   * 
   * @param shape the given shape that is related to this operation
   * @param begin the given start time
   * @param end   the given end time
   * @throws IllegalArgumentException throw if the end time is earlier than the
   *                                  start time or both time are negative.
   */
  public AbstractOperation(IShape shape, int begin, int end) throws IllegalArgumentException {
    if (end < begin) {
      throw new IllegalArgumentException("End time cannot be earlier than begin time.");
    }
    if (end < 0 || begin < 0) {
      throw new IllegalArgumentException("Time cannot be negative.");
    }
    if (begin < shape.getStart() || end > shape.getEnd()) {
      // System.out.println(String.format("Operation begin %d, end %d \n", begin,
      // end));
      // System.out.print(String.format("Name %s, RGB %d, %d, %d, x, y %.1f,"
      // + " %.1f, w h %.1f %.1f, begin %d, end %d\n",
      // shape.getName(),
      // (int) shape.getColor().getR(), (int) shape.getColor().getG(),
      // (int) shape.getColor().getB(),
      // shape.getPosition().getXcord(), shape.getPosition().getYcord(),
      // shape.getSize().getHorizontal(),
      // shape.getSize().getVertical(), shape.getStart(), shape.getEnd()));

      throw new IllegalArgumentException("Operations cannot begin before or end after the shape.");
    }
    this.shape = shape;
    this.begin = begin;
    this.end = end;
  }

  @Override
  public int getOpStart() {
    return this.begin;
  }

  @Override
  public int getOpEnd() {
    return this.end;
  }

  @Override
  public IShape getShape() {
    return this.shape;
  }

  @Override
  public double interpolate(double beginValue, double endValue, double beginTime, double endTime,
      double cur) {
    double distance = endValue - beginValue;
    double timeperiod = endTime - beginTime;
    double changeVelocity = distance / timeperiod;
    double curstatus = beginValue + (cur - beginTime) * changeVelocity;
    return curstatus;
  }
}
