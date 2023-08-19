package cs5004.animator.view;

import cs5004.animator.model.IModel;
import cs5004.animator.model.Screen;
import cs5004.animator.model.shape.IShape;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;


/**
 * This is a class represents the visual view of the easy animator.
 * @author zeyushen
 *
 */
public class VisualView extends JFrame implements IView, ActionListener {

  private static final long serialVersionUID = 1L;
  private JMenuBar menuBar;
  private JMenu settings;
  private JMenuItem exitItem;
  private JPanel buttonPane;
  private JButton exitButton;
  private JTextField textfield;
  private VisualViewPanel vvp;
  private IModel model;
  private double speed;
  private ViewEnum type;
  private Timer tm;
  private int curTime;

  /**
   * Construct and initialize the visual view with given model, screen and speed.
   * @param model the linked model
   * @param screen the given screen
   * @param speed the given speed of the view
   */
  public VisualView(IModel model, Screen screen, double speed) {
    super("EasyAnimator");

    Screen thisScreen = screen;
    this.model = model;
    this.speed = speed;
    this.type = ViewEnum.VISUAL;
    this.tm = new Timer((int) (1000 / this.speed), this);
    this.curTime = 0;

    this.setSize((int) thisScreen.getWidth() + 200, (int) thisScreen.getHeight() + 200);
    this.setLocation(0, 0);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //    
    //    this.menuBar = new JMenuBar();
    //    this.setJMenuBar(this.menuBar);
    //    this.settings = new JMenu("Exit");
    //    this.menuBar.add(this.settings);
    //    
    //    this.exitItem = new JMenuItem("Exit");
    //    this.exitItem.setName("Quit");
    ////    this.settings.add(this.exitItem);
    //    this.exitItem.addActionListener(this);
    //    
    //    this.buttonPane = new JPanel(true);
    //    this.buttonPane.setBackground(Color.WHITE);
    //    this.buttonPane.setSize(200, 500);
    //    this.buttonPane.setLocation(0, 0);
    //    this.buttonPane.setLayout(new FlowLayout());
    //    
    ////    this.textfield = new JTextField(5);
    ////    this.buttonPane.add(this.textfield);
    //    this.exitButton = new JButton("Quit");
    //    this.exitButton.setName("Quit");
    //    this.buttonPane.add(this.exitButton);
    //    
    //    this.exitButton.addActionListener(this);
    //    this.add(buttonPane);

    // how to refresh? simply build a new visualviewpanel might be wrong.
    List<IShape> lsp = this.model.getAllShape();
    this.vvp = new VisualViewPanel(lsp);
    this.vvp.setPreferredSize(
        new Dimension((int) thisScreen.getWidth(), (int) thisScreen.getHeight()));
    this.vvp.setVisible(true);
    this.add(this.vvp);

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
  public void actionPerformed(ActionEvent e) {
    //    System.out.println("Time is ");
    //    System.out.println(curTime);
    //    System.out.println(this.model.getMaxTime());

    if (curTime >= this.model.getMaxTime()) {
      this.tm.stop();
      return;
    }
    List<IShape> lsp = this.model.getShapesAtTime(curTime);

    //    System.out.println(String.format("Time: %d ", curTime));

    this.vvp.updateShape(lsp);
    this.vvp.repaint();
    this.vvp.setVisible(true);

    curTime = (int) (curTime + 1);

    //    System.out.println("action is going on");
    //    List<IShape> lsp = this.model.getShapesAtTime(curTime);
    //    this.vvp = new VisualViewPanel(lsp);
    //    
    //    this.repaint();
    //    
    //    curTime = curTime + (int) (1000/this.speed);
    
    //  List<IShape> lsp = this.model.getShapesAtTime(curTime);
    //  this.repaint();
    
    //  this.repaint();
    
    //  Component c = (Component) e.getSource();
    //  if (c.getName().equals("Quit")) {
    //    System.exit(0);
    //  }

  }

  @Override
  public String viewOutput() {
    return null;
  }

  @Override
  public void display() {
    //    this.setVisible(true);
    this.tm.start();

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

  }

}
