import static org.junit.Assert.assertEquals;

import cs5004.animator.model.IModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.operation.Move;
import cs5004.animator.model.shape.Color3D;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Size2D;
import cs5004.animator.view.TextView;
import cs5004.animator.view.ViewEnum;
import org.junit.Test;

/**
 * This is a class test the view.
 * 
 * @author zeyushen
 *
 */
public class TextViewTest {

  /**
   * Test the textview's constructor.
   */
  @Test
  public void testConstructor() {
    int test = 1;
    IModel m = new ModelImpl();
    IShape sp = null;
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    m.addShape(r1);
    int begin = 10;
    int end = 50;
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);
    Move m1 = new Move(r1, begin, end, position1, position2, size1, size2, color1, color2);
    m.addOperation(m1);

    TextView tv = new TextView(m, "aka.txt", 20);
    assertEquals(tv.getViewType(), ViewEnum.TEXT);
    assertEquals(tv.getSpeed(), 20, 0.001);
  }

  /**
   * Test the viewOutPut.
   */
  @Test
  public void testViewOutPut() {
    int test = 1;
    IModel m = new ModelImpl();
    IShape sp = null;
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    IShape c1 = new Oval("c1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 1,
        100);
    m.addShape(r1);
    m.addShape(c1);
    int begin = 10;
    int end = 50;
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);
    Move m1 = new Move(r1, begin, end, position1, position2, size1, size2, color1, color2);
    m.addOperation(m1);

    TextView tv = new TextView(m, "aka.txt", 20);
    assertEquals(tv.viewOutput(),
        "Create rectangle r1 with color of (1.0, 2.0, 3.0), with cornor at (10.0, 15.0),"
            + " width 20.0 and height 30.0\n"
            + "Create oval c1 with color of (1.0, 2.0, 3.0), with center at (10.0, 15.0),"
            + " radius 20.0 and 30.0\n" + "\n"
            + "r1 appears at time t=1 and disappears at time t=100\n"
            + "c1 appears at time t=1 and disappears at time t=100\n" + "\n"
            + "Shape r1 moves from(10.0, 15.0) to (100.0, 150.0) from t= 10 to t=50\n" + "");
  }
}
