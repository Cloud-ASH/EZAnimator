package cs5004.animator.view;

/**
 * This is an enum represents the different type of views.
 * 
 * @author zeyushen
 *
 */
public enum ViewEnum {
  TEXT("text"), SVG("svg"), VISUAL("visual"), New("playback");

  private String type;

  /**
   * The constructor of the ViewEnum.
   * 
   * @param type the given type.
   */
  private ViewEnum(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return this.type;
  }
}
