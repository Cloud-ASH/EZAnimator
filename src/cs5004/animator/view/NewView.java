package cs5004.animator.view;

import cs5004.animator.model.IModel;
import cs5004.animator.model.Screen;
import cs5004.animator.model.operation.IOperation;
import cs5004.animator.model.shape.IShape;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;


/**
 * This is a class represents the new view, using gui and allows interaction.
 * @author zeyushen
 *
 */
public class NewView extends JFrame implements IView, ActionListener {

  private static final long serialVersionUID = 1L;
  private VisualViewPanel vvp;
  private IModel model;
  private double speed;
  private ViewEnum type;
  private Timer tm;
  private int curTime;
  private boolean loop;

  private JButton startButton;
  private JButton pauseButton;
  private JButton resumeButton;
  private JButton playbackButton;
  private JLabel speedNow;
  private JLabel loopStatus;
  
  /**
   * Construct and initialize the new view based on given model, screen and speed.
   * @param model the linked model
   * @param screen the given screen
   * @param speed the speed of this view
   */
  public NewView(IModel model, Screen screen, double speed) {
    super("EasyAnimator");

    this.model = model;
    this.speed = speed;
    this.type = ViewEnum.New;
    this.tm = new Timer((int) (1000 / this.speed), this);
    this.curTime = 0;
    Screen thisScreen = screen;
    this.setSize((int) thisScreen.getWidth() + 200, (int) thisScreen.getHeight() + 200);
    this.setLocation(0, 0);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // shapes & panel
    List<IShape> lsp = this.model.getAllShape();
    this.vvp = new VisualViewPanel(lsp);
    this.vvp.setPreferredSize(
        new Dimension((int) thisScreen.getWidth(), (int) thisScreen.getHeight()));
    this.vvp.setVisible(true);
    this.add(this.vvp);

    this.speedNow = new JLabel(String.format("SPEED NOW %d", (int) this.speed));
    this.speedNow.setPreferredSize(new Dimension(100, 20));
    this.speedNow.setVisible(true);
    this.vvp.add(this.speedNow);

    this.loopStatus = new JLabel(String.format("Loop: %b", this.loop));
    this.loopStatus.setPreferredSize(new Dimension(100, 20));
    this.loopStatus.setVisible(true);
    this.vvp.add(this.loopStatus);

    // buttons
    this.initializeButtons();

    // JScrollPane
    JScrollPane scrpane = new JScrollPane(this.vvp);
    scrpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrpane.setPreferredSize(
        new Dimension((int) thisScreen.getWidth(), (int) thisScreen.getHeight()));
    this.add(scrpane);

    this.setVisible(true);
    this.pack();
  }

  @Override
  public String viewOutput() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void display() throws IOException {
    //    this.tm.start();

  }

  @Override
  public ViewEnum getViewType() {
    return this.type;
  }

  @Override
  public double getSpeed() {
    return this.speed;
  }

  @Override
  public void setSpeed(double speed) {
    this.speed = speed;
    int delay = (int) (1000 / speed);
    this.tm.setDelay(delay);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    int maxOpTime = 100;

    for (IShape sp : this.model.getAllShape()) {
      for (IOperation op : this.model.getOpertationOfShape(sp)) {
        if (op.getOpEnd() > maxOpTime) {
          maxOpTime = op.getOpEnd();
        }
      }
    }

    //    System.out.println(String.format("%d, %d", curTime, maxOpTime));

    if (e.getSource() instanceof JButton) {
      //      System.out.println(e.getActionCommand());
      this.buttonPressed(e.getActionCommand());
    }

    if (e.getSource() instanceof JCheckBox) {
      this.buttonPressed(e.getActionCommand());
    }

    List<IShape> lsp = this.model.getShapesAtTime(curTime);

    //    System.out.println(String.format("Time: %d ", curTime));

    this.vvp.updateShape(lsp);
    this.vvp.repaint();
    this.vvp.setVisible(true);

    if (curTime >= maxOpTime) {
      if (!this.loop) {
        this.tm.stop();
        return;
      } else {
        this.playback();
        return;
      }

    }

    curTime = (int) (curTime + 1);
  }

  /**
   * Make reactions based on the button pressed.
   * 
   * @param button the string from the button.
   */
  public void buttonPressed(String button) {
    switch (button) {
      case "start":
        this.start();
        break;
      case "quit":
        this.quit();
        break;
      case "pause":
        this.pause();
        break;
      case "resume":
        this.resume();
        break;
      case "accelerate":
        this.accelerate();
        break;
      case "slowdown":
        this.slowDown();
        break;
      case "playback":
        this.playback();
        break;
      case "loop":
        this.loop();
        break;
      default:
        JOptionPane.showMessageDialog(new JFrame(), "No such button.", "ERROR",
            JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * Initialize the buttons for the view.
   */
  private void initializeButtons() {
    JCheckBox thisLoopBox = new JCheckBox("LOOP");
    thisLoopBox.setActionCommand("loop");
    this.vvp.add(thisLoopBox);
    thisLoopBox.addActionListener(this);

    this.startButton = new JButton("start");
    this.startButton.setActionCommand("start");
    this.vvp.add(startButton);
    this.startButton.addActionListener(this);

    this.pauseButton = new JButton("pause");
    this.pauseButton.setActionCommand("pause");
    this.vvp.add(pauseButton);
    this.pauseButton.addActionListener(this);
    
    JButton thisQuitButton = new JButton("quit");
    thisQuitButton.setActionCommand("quit");
    this.vvp.add(thisQuitButton);
    thisQuitButton.addActionListener(this);

    this.resumeButton = new JButton("resume");
    this.resumeButton.setActionCommand("resume");
    this.vvp.add(resumeButton);
    this.resumeButton.addActionListener(this);
    
    JButton thisAccelerateButton = new JButton("accelerate");
    thisAccelerateButton.setActionCommand("accelerate");
    this.vvp.add(thisAccelerateButton);
    thisAccelerateButton.addActionListener(this);
    //    thisAccelerateButton.addActionListener((new ActionListener()){
    //      @Override
    //      public void actionPerformed(ActionEvent e) {
    //        this.accelerate();
    //      }
    //    }

    JButton thisSlowDownButton = new JButton("slowdown");
    thisSlowDownButton.setActionCommand("slowdown");
    this.vvp.add(thisSlowDownButton);
    thisSlowDownButton.addActionListener(this);

    this.playbackButton = new JButton("playback");
    this.playbackButton.setActionCommand("playback");
    this.vvp.add(playbackButton);
    this.playbackButton.addActionListener(this);

    this.startButton.setEnabled(true);
    this.pauseButton.setEnabled(false);
    this.resumeButton.setEnabled(false);
    thisAccelerateButton.setEnabled(true);
    thisSlowDownButton.setEnabled(true);
    this.playbackButton.setEnabled(true);
    thisLoopBox.setEnabled(true);

  }

  /**
   * Start the game.
   */
  public void start() {
    this.tm.start();
    this.startButton.setEnabled(false);
    this.pauseButton.setEnabled(true);
    this.playbackButton.setEnabled(true);
  }

  /**
   * Quit the game.
   */
  public void quit() {
    System.exit(0);
  }

  /**
   * Pause the game.
   */
  public void pause() {
    this.tm.stop();
    this.resumeButton.setEnabled(true);
    this.pauseButton.setEnabled(false);
  }

  /**
   * Resume the game.
   */
  public void resume() {
    this.tm.restart();
    this.pauseButton.setEnabled(true);
    this.resumeButton.setEnabled(false);
  }

  /**
   * Accelerate the game.
   */
  public void accelerate() {
    //    System.out.println("Go");
    //    System.out.println(this.speed);
    this.setSpeed(this.speed + 5);
    //    System.out.println("Yo");
    //    System.out.println(this.speed);
    this.speedNow.setText(String.format("SPEED NOW %d", (int) this.speed));
  }

  /**
   * Slow down the game.
   */
  public void slowDown() {
    //    System.out.println("Go");
    //    System.out.println(this.speed);
    if (this.speed > 5) {
      this.setSpeed(this.speed - 5);
      this.speedNow.setText(String.format("SPEED NOW %d", (int) this.speed));
    }
    //    System.out.println("Yo");
    //    System.out.println(this.speed);
  }

  /**
   * Replay the game.
   */
  public void playback() {
    this.curTime = 0;
    //    this.vvp = new VisualViewPanel(this.model.getAllShape());

    this.vvp.updateShape(this.model.getShapesAtTime(curTime));

    this.vvp.repaint();
    this.resumeButton.setEnabled(false);
    this.pauseButton.setEnabled(true);
    this.startButton.setEnabled(false);
    this.tm.start();
  }
  
  /**
   * Change the loop status of the game.
   */
  public void loop() {
    //    System.out.println(String.format("Loop: %b", this.loop));
    if (this.loop) {
      this.loop = false;
      this.loopStatus.setText(String.format("Loop: %b", this.loop));
    } else {
      this.loop = true;
      this.loopStatus.setText(String.format("Loop: %b", this.loop));
    }
  }
}
