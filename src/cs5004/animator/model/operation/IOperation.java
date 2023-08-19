package cs5004.animator.model.operation;

import cs5004.animator.model.shape.IShape;

/**
 * This is an interface represents the operation.
 * 
 * @author zeyushen
 *
 */
public interface IOperation {

  /**
   * Get the type of this operation.
   * 
   * @return the type of this operation.
   */
  OperationEnum getOpType();

  /**
   * Getter for the start time of this operation.
   * 
   * @return the start time of this operation.
   */
  int getOpStart();

  /**
   * Getter for the end time of this operation.
   * 
   * @return the end time of this operation.
   */
  int getOpEnd();

  /**
   * Get the shape of this operation.
   * 
   * @return the shape of this operation.
   */
  IShape getShape();

  //  /**
  //   * Get the begin status of this operation.
  //   * @param <T> the type of status
  //   * @param type the type of status
  //   * @return the begin status of this operation.
  //   */
  //  <T> T getBeginStatus(Class<T> type);
  //  
  //  /**
  //   * Get the begin status of this operation.
  //   * @param <T> the type of status
  //   * @param type the type of status
  //   * @return the end status of this operation.
  //   */
  //  <T> T getEndStatus(Class<T> type);

  /**
   * Get the shape's status at a given time (which is during the operation). This
   * is used to depict the shape's status at every tick.
   * 
   * @return IShape a copy of shape's status
   */
  IShape getShapeAtTime();

  /**
   * Change the status of the shape.
   * 
   * @param cur the current time/frame.
   */
  void operate(IShape shape, int cur);

  /**
   * Make a copy of this operation.
   * 
   * @return a new operation with identical data.
   */
  IOperation duplicateOp();

  /**
   * Get a string to create a svg file output.
   * 
   * @param speed the speed of the operation.
   * @return string the string to create svg file output.
   */
  String svgString(int speed);

  /**
   * Calculate the middle value at a given current time.
   * 
   * @param beginValue the value at begin
   * @param endValue   the value at end
   * @param beginTime  begin time
   * @param endTime    end time
   * @param cur        current time
   * @return the interpolated value at current time
   */
  double interpolate(double beginValue, double endValue, double beginTime, double endTime,
      double cur);
}
