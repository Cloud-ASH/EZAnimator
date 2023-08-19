package cs5004.animator.view;

import cs5004.animator.model.IModel;
import cs5004.animator.model.Screen;

/**
 * This is a factory for the view, help to determine which view to produce based
 * on the inputs.
 * 
 * @author zeyushen
 *
 */
public class ViewFactory {

  private IModel model;
  private double speed;
  private String outfile;

  /**
   * Construct and initialize a ViewFactory object with given model and speed.
   * 
   * @param model the linked model
   * @param outfile the output file's name
   * @param speed the speed of the view
   */
  public ViewFactory(IModel model, String outfile, double speed) {
    this.model = model;
    this.speed = speed;
    this.outfile = outfile;
  }
  
  /**
   * Create a view according to the chosen viewType.
   * @param viewType the given viewType
   * @return view a corresponding view of the given viewType
   * @throws IllegalArgumentException throws when the viewType is not supported.
   */
  public IView produceView(String viewType) throws IllegalArgumentException {
    switch (viewType) {
      case "text":
        return new TextView(this.model, this.outfile, this.speed);
      case "svg":
        return new SvgView(this.model, this.outfile, this.speed);
      case "visual":
        return new VisualView(this.model, new Screen(0, 0, 1000, 1000), this.speed);
      case "playback":
        return new NewView(this.model, new Screen(0, 0, 1000, 1000), this.speed);
      default:
        throw new IllegalArgumentException("View type not supported.");
    }
  }

  /**
   * Get the speed of this ViewFactory.
   * 
   * @return speed the speed of this ViewFactory.
   */
  public int getSpeed() {
    return (int) this.speed;
  }
}
