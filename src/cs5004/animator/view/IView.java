package cs5004.animator.view;

import java.io.IOException;

/**
 * This is an interface represents the view.
 * 
 * @author zeyushen
 *
 */
public interface IView {

  /**
   * Get the output of the view.
   * 
   * @return String a String represents the view's output.
   */
  String viewOutput();

  /**
   * Run the view.
   */
  void display() throws IOException;

  /**
   * Get the type of the view.
   * 
   * @return type the type of the view.
   */
  ViewEnum getViewType();

  /**
   * Get the speed of the view.
   * 
   * @return speed the speed of the view.
   */
  double getSpeed();

  /**
   * Set the speed of the view.
   * 
   * @param speed the given new speed.
   */
  void setSpeed(double speed);
}
