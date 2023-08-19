import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs5004.animator.controller.ControllerImpl;
import cs5004.animator.model.IModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.operation.Freeze;
import cs5004.animator.model.shape.Color3D;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Size2D;
import cs5004.animator.view.ViewEnum;
import org.junit.Test;

/**
 * This is the test for controller.
 * 
 * @author zeyushen
 *
 */
public class ControllerImplTest {

  /**
   * Test the controller.
   */
  @Test
  public void test() {
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
    Freeze free1 = new Freeze(r1, begin, end, position1, position2, size1, size2, color1, color2);
    m.addOperation(free1);

    ControllerImpl ctr = new ControllerImpl(m, "text", "aka.txt", 20);

    IModel m1 = null;
    String v1 = null;

    try {
      ControllerImpl ctr1 = new ControllerImpl(m1, "text", "aka.txt", 20);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      ControllerImpl ctr1 = new ControllerImpl(m, v1, "aka.txt", 20);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      ControllerImpl ctr2 = new ControllerImpl(m, "text", "aka.txt", -20);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }

    ctr.play();
    assertEquals(ctr.getView().getViewType(), ViewEnum.TEXT);
    assertEquals(ctr.getView().getSpeed(), 20, 0.001);
    assertEquals(ctr.getView().viewOutput(),
        "Create rectangle r1 with color of (1.0, 2.0, 3.0), with cornor"
            + " at (10.0, 15.0), width 20.0 and height 30.0\n" + "\n"
            + "r1 appears at time t=1 and disappears at time" + " t=100\n" + "\n" + "\n" + "");
  }

}
