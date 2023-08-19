package cs5004.animator.view;

import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.ShapeEnum;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;


/**
 * This is a class represent the VisualViewPanel.
 * This is used to draw the shapes.
 * @author zeyushen
 *
 */
public class VisualViewPanel extends JPanel {
  private static final long serialVersionUID = 1L;
  private List<IShape> shapes;
  
  /**
   * Construct and initialize the VisualViewPanel according to given shape list.
   * @param shape the given shape list.
   */
  public VisualViewPanel(List<IShape> shape) {
    super(true);
    this.shapes = shape;
    this.setBackground(Color.WHITE);
    this.setSize(1200, 1200);
    this.setLocation(0, 50);

  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (this.shapes.size() == 0) {
      return;
    }

    for (IShape sp : shapes) {
      // System.out.println(sp.getStart());
      // System.out.println(sp.getName());
      // System.out.print(String.format("Name %s, RGB %d, %d, %d,
      // x, y %.1f, %.1f, w h %.1f %.1f\n",
      // sp.getName(),
      // (int) sp.getColor().getR(), (int) sp.getColor().getG(),
      // (int) sp.getColor().getB(),
      // sp.getPosition().getXcord(), sp.getPosition().getYcord(),
      // sp.getSize().getHorizontal(),
      // sp.getSize().getVertical()));

      Color nc = new Color((int) sp.getColor().getR(), (int) sp.getColor().getG(),
          (int) sp.getColor().getB());

      // Color nc = new Color(100, 100, 100);

      g.setColor(nc);

      if (sp.getType() == ShapeEnum.Oval) {
        g.drawOval((int) sp.getPosition().getXcord(), (int) sp.getPosition().getYcord(),
            (int) sp.getSize().getHorizontal(), (int) sp.getSize().getVertical());
        g.fillOval((int) sp.getPosition().getXcord(), (int) sp.getPosition().getYcord(),
            (int) sp.getSize().getHorizontal(), (int) sp.getSize().getVertical());

      } else if (sp.getType() == ShapeEnum.Rectangle) {

        // System.out.print(String.format("%d, %d, %d, %d\n",
        // (int) sp.getPosition().getXcord(), (int) sp.getPosition().getYcord(),
        // (int) sp.getSize().getHorizontal(), (int) sp.getSize().getVertical()));
        // if(sp.getColorModified() != false || sp.getLocationModified() != false ||
        // sp.getSizeModified() != false) {
        // g.drawRect((int) sp.getPosition().getXcord(), (int)
        // sp.getPosition().getYcord(),
        // (int) sp.getSize().getHorizontal(), (int) sp.getSize().getVertical());
        // g.fillRect((int) sp.getPosition().getXcord(), (int)
        // sp.getPosition().getYcord(),
        // (int) sp.getSize().getHorizontal(), (int) sp.getSize().getVertical());
        // }
        g.drawRect((int) sp.getPosition().getXcord(), (int) sp.getPosition().getYcord(),
            (int) sp.getSize().getHorizontal(), (int) sp.getSize().getVertical());
        g.fillRect((int) sp.getPosition().getXcord(), (int) sp.getPosition().getYcord(),
            (int) sp.getSize().getHorizontal(), (int) sp.getSize().getVertical());
      }
    }

  }

  /**
   * Update the shapes with given list of shapes.
   * 
   * @param shapes the given shapes
   */
  public void updateShape(List<IShape> shapes) {
    this.shapes = shapes;
  }
}
