package cs5004.animator.model.shape;

/**
 * This is an enum class representing the shape types.
 * @author zeyushen
 *
 */
public enum ShapeEnum {
  Rectangle("rectangle"), Oval("oval");

  private String type;
  
  /**
   * The constructor of the ShapeEnum.
   * @param type the given type.
   */
  private ShapeEnum(String type) {
    this.type = type;
  }
  
  @Override
  public String toString() {
    return this.type;
  }
  
}
