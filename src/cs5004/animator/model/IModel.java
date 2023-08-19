package cs5004.animator.model;

import cs5004.animator.model.operation.IOperation;
import cs5004.animator.model.shape.IShape;

import java.util.List;
import java.util.Map;

/**
 * This is an interface represent the model.
 * 
 * @author zeyushen
 *
 */
public interface IModel {

  /**
   * Get the screen of the model.
   * 
   * @return the screen of the model.
   */
  Screen getScreen();

  /**
   * Set the screen of the model according to given parameters.
   * 
   * @param x      the new x coordinate of the left bottom point
   * @param y      the new y coordinate of the left bottom point
   * @param width  the new width of the screen
   * @param height the new height of the screen
   */
  void setScreen(double x, double y, double width, double height);

  /**
   * Add a given shape into the model's list of shape.
   * 
   * @param shape the given shape.
   * @throws IllegalArgumentException throw when the given shape is null or
   *                                  already in the model's list of shape.
   */
  void addShape(IShape shape) throws IllegalArgumentException;

  /**
   * Remove a chosen shape from the model.
   * 
   * @param shape the chosen shape.
   * @throws IllegalArgumentException throw when the given shape is null or not in
   *                                  the model's list of shape.
   */
  void removeShape(IShape shape) throws IllegalArgumentException;

  /**
   * Add a given operation into the model's list of operation.
   * 
   * @param operation the given operation.
   * @throws IllegalArgumentException throw when the given operation is null or
   *                                  already in the model's list of shape.
   */
  void addOperation(IOperation operation) throws IllegalArgumentException;

  /**
   * Remove a chosen operation from the model.
   * 
   * @param operation the chosen operation.
   * @throws IllegalArgumentException throw when the given operation is null or
   *                                  not in the model's list of operation.
   */
  void removeOperation(IOperation operation) throws IllegalArgumentException;

  /**
   * Get the shape by a given name.
   * 
   * @return shape the shape of a given name.
   * @throws IllegalArgumentException throw when there is no shape of the given
   *                                  name.
   */
  IShape getShapeByName(String name) throws IllegalArgumentException;

  /**
   * Get all the shapes in this model.
   * 
   * @return shapes all the shapes in this model.
   */
  List<IShape> getAllShape();

  /**
   * Get all the operations in this model.
   * 
   * @return operations all the operations in this model.
   */
  List<IOperation> getAllOperation();

  /**
   * Get the map of shapes and corresponding operations.
   * 
   * @return map the map of shapes and corresponding operations.
   */
  Map<IShape, List<IOperation>> getShapeWithOp();

  /**
   * Get the list of shapes at a given time.
   * 
   * @return the list of shapes at a given time.
   * @throws IllegalArgumentException throws when the input time is negative.
   */
  List<IShape> getShapesAtTime(int time) throws IllegalArgumentException;

  /**
   * Get the current status of model (with all the shapes and state) in String
   * format.
   * 
   * @return String a String representing the current status of model.
   */
  String toStatus();

  /**
   * Get all the operations related to the given shape.
   * 
   * @return list of operations all the operations related to the given shape.
   */
  List<IOperation> getOpertationOfShape(IShape shape);

  /**
   * Get the start time of the model.
   * 
   * @return the start time of the model.
   */
  int getMinTime();

  /**
   * Get the end time of the model.
   * 
   * @return the end time of the model.
   */
  int getMaxTime();

  /**
   * Set the end time of the mdoel.
   * 
   * @param maxtime the new end time of the model.
   */
  void setMaxTime(int maxtime);

  //  /**
  //   * Get earliest start time when this shape is assigned non-zero attributes.
  //   * @return time earliest start time when this shape can be seen.
  //   */
  //  int getWhenCanBeSeen();
}
