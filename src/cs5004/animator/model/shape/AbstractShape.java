package cs5004.animator.model.shape;

/**
 * This is an abstract class represents the AbstractShape. It implements the IShpae interface
 * and has implemented some common methods for Oval and Rectangle.
 * @author zeyushen
 *
 */
public abstract class AbstractShape implements IShape {

  protected String name;
  protected ShapeEnum type;
  protected Point2D position;
  protected Size2D size;
  protected Color3D color;
  protected int start = -1;
  protected int end = -1;
  protected boolean sizemodified;
  protected boolean colormodified;
  protected boolean locationmodified;
  protected int firstSeen = -1;

  /**
   * Initialize and construct the AbstractShape object based on given arguments.
   * 
   * @param name     the name of this shape
   * @param type     the type of this shape
   * @param position the position of this shape
   * @param size     the size of this shape
   * @param color    the color of this shape
   * @param start    the start time of this shape
   * @param end      the end time of this shape
   * @throws IllegalArgumentException throws if name, type, position, size, or
   *                                  color is null. or start < end or start < 0
   *                                  or end <0.
   */
  public AbstractShape(String name, ShapeEnum type, Point2D position, Size2D size, Color3D color,
      int start, int end) throws IllegalArgumentException {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be empty.");
    }
    if (type == null) {
      throw new IllegalArgumentException("Type cannot be empty.");
    }
    if (position == null) {
      throw new IllegalArgumentException("Position cannot be empty.");
    }
    if (size == null) {
      throw new IllegalArgumentException("Size cannot be empty.");
    }
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be empty.");
    }
    if (start > end) {
      throw new IllegalArgumentException("End time cannot be earlier than start.");
    }
    if (start < 0 || end < 0) {
      throw new IllegalArgumentException("Time cannot be negative");
    }
    this.name = name;
    this.type = type;
    this.position = position;
    this.size = size;
    this.color = color;
    this.start = start;
    this.end = end;
    this.sizemodified = false;
    this.colormodified = false;
    this.locationmodified = false;
  }

  /**
   * Initialize and construct the AbstractShape object based on given name.
   * 
   * @param name the given name
   */
  public AbstractShape(String name, ShapeEnum type) throws IllegalArgumentException {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be empty.");
    }
    if (type == null) {
      throw new IllegalArgumentException("Type cannot be empty.");
    }
    this.name = name;
    this.type = type;
    this.position = new Point2D(0, 0);
    this.size = new Size2D(0, 0);
    this.color = new Color3D(0, 0, 0);
    this.start = -1;
    this.end = 100000;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ShapeEnum getType() {
    return this.type;
  }

  @Override
  public Point2D getPosition() {
    return this.position;
  }

  @Override
  public Color3D getColor() {
    return this.color;
  }

  @Override
  public Size2D getSize() {
    return this.size;
  }

  @Override
  public int getStart() {
    return this.start;
  }

  @Override
  public int getEnd() {
    return this.end;
  }

  @Override
  public boolean getSizeModified() {
    return this.sizemodified;
  }

  @Override
  public boolean getColorModified() {
    return this.colormodified;
  }

  @Override
  public boolean getLocationModified() {
    return this.locationmodified;
  }

  @Override
  public void setSizeModified(boolean bl) {
    this.sizemodified = bl;
  }

  @Override
  public void setLocationModified(boolean bl) {
    this.locationmodified = bl;
  }

  @Override
  public void setColorModified(boolean bl) {
    this.colormodified = bl;
  }

  @Override
  public void resize(Size2D size) throws IllegalArgumentException {
    if (size == null) {
      throw new IllegalArgumentException("Size cannot be empty.");
    }
    this.size = size;

  }

  @Override
  public void relocate(Point2D position) throws IllegalArgumentException {
    if (position == null) {
      throw new IllegalArgumentException("Position cannot be empty.");
    }
    this.position = position;

  }

  @Override
  public void redye(Color3D color) throws IllegalArgumentException {
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be empty.");
    }
    this.color = color;

  }

  @Override
  public void setStart(int start) {
    this.start = start;
  }

  @Override
  public void setEnd(int end) {
    this.end = end;
  }

  @Override
  public int getWhenCanBeSeen() {
    return this.firstSeen;
  }

  @Override
  public void setWhenCanBeSeen(int time) {
    this.firstSeen = time;
  }
}
