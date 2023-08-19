package cs5004.animator.model.shape;

/**
 * This is an interface represents the shapes.
 * 
 * @author zeyushen
 *
 */
public interface IShape {

  /**
   * Getter for the name of shape.
   * 
   * @return the name of this shape.
   */
  String getName();

  /**
   * Getter for the type of shape.
   * 
   * @return the type of this shape.
   */
  ShapeEnum getType();

  /**
   * Getter for the position of this shape. For Rectangle object, the position is
   * denoted by the left bottom point. For Oval the position is denoted by its
   * center point.
   * 
   * @return the position of this shape.
   */
  Point2D getPosition();

  /**
   * Getter for the size of this shape. For Rectangle object, the size is denoted
   * by width and height. For Oval, the size is denoted by x radius and y radius.
   * 
   * @return Size2D a Size2D object represents the result size.
   */
  Size2D getSize();

  /**
   * Getter for the color of this shape.
   * 
   * @return the color of this shape.
   */
  Color3D getColor();

  /**
   * Getter for the start time of this shape.
   * 
   * @return the start time of this shape.
   */
  int getStart();

  /**
   * Getter for the end time of this shape.
   * 
   * @return the end time of this shape.
   */
  int getEnd();

  /**
   * Check if the size is modified.
   * 
   * @return the boolean indicating whether the size is modified.
   */
  boolean getSizeModified();

  /**
   * Check if the color is modified.
   * 
   * @return the boolean indicating whether the color is modified.
   */
  boolean getColorModified();

  /**
   * Check if the location is modified.
   * 
   * @return the boolean indicating whether the location is modified.
   */
  boolean getLocationModified();

  /**
   * Setter for the SizeModified.
   * 
   * @param bl boolean to be set.
   */
  void setSizeModified(boolean bl);

  /**
   * Setter for the LocationModified.
   * 
   * @param bl boolean to be set.
   */
  void setLocationModified(boolean bl);

  /**
   * Setter for the ColorModified.
   * 
   * @param bl boolean to be set.
   */
  void setColorModified(boolean bl);

  /**
   * Setter for the start of this shape.
   * 
   * @param start the given start time.
   */
  void setStart(int start);

  /**
   * Setter for the end of this shape.
   * 
   * @param end the given end time.
   */
  void setEnd(int end);

  /**
   * Setter for the size of the shape.
   * 
   * @param size the given size.
   */
  void resize(Size2D size);

  /**
   * Setter for the position of the shape.
   * 
   * @param position the given position;
   */
  void relocate(Point2D position);

  /**
   * Setter for the color of the shape.
   * 
   * @param color the given color.
   */
  void redye(Color3D color);

  ///**
  //* Get the middle state of the shape during the motion.
  //* @return
  //*/
  //IShape getMid();

  /**
   * Create an identical copy of this shape.
   * 
   * @return an identical copy of this shape.
   */
  IShape duplicate();

  /**
   * Get earliest start time when this shape is assigned non-zero attributes.
   * 
   * @return time earliest start time when this shape can be seen.
   */
  int getWhenCanBeSeen();

  /**
   * Set earliest start time when this shape is assigned non-zero attributes.
   * 
   * @param time earliest start time when this shape can be seen.
   */
  void setWhenCanBeSeen(int time);

  /**
   * Get the SVG String.
   * 
   * @return String the SVG String.
   */
  String toSvg();

  /**
   * Get the SVG String to hide the shape when need.
   * 
   * @param time a given time.
   * @return String the SVG String
   */
  String toSvHide(int time);
}
