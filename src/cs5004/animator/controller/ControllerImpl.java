package cs5004.animator.controller;

import cs5004.animator.model.IModel;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * This is a calss represents the ControllerImpl.
 * 
 * @author zeyushen
 *
 */
public class ControllerImpl implements IController, ActionListener {

  private IModel model;
  private IView view;
  private String viewType;
  private int speed;
  private String outfile;

  /**
   * Construct and initialize a ControllerImpl object with given parameters.
   * 
   * @param model    the model to connect
   * @param viewType the view to connect
   * @param outfile  the output file's name
   * @param speed    the given speed
   * @throws IllegalArgumentException throws when the model or viewType is null,
   *                                  or the speed is smaller not positive.
   */
  public ControllerImpl(IModel model, String viewType, String outfile, int speed)
      throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }
    if (viewType == null) {
      throw new IllegalArgumentException("View type cannot be null.");
    }
    if (speed <= 0) {
      throw new IllegalArgumentException("Speed cannot negative or zero.");
    }
    this.model = model;
    this.viewType = viewType;
    this.speed = speed;
    this.outfile = outfile;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // leave this empty
  }

  @Override
  public void play() {
    ViewFactory vf = new ViewFactory(this.model, this.outfile, this.speed);
    IView theView = vf.produceView(this.viewType);
    this.view = theView;
    try {
      theView.display();
    } catch (IOException e) {
      JOptionPane.showMessageDialog(new JFrame(), "Cannot display.", "ERROR",
          JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }
  }
  
  /**
   * Getter for the view.
   */
  public IView getView() {
    return this.view;
  }
}
