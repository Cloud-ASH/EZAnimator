import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs5004.animator.model.IModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.operation.Freeze;
import cs5004.animator.model.shape.Color3D;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Size2D;
import cs5004.animator.view.IView;
import cs5004.animator.view.ViewEnum;
import cs5004.animator.view.ViewFactory;
import org.junit.Test;

/**
 * Test the view Factory.
 * @author zeyushen
 *
 */
public class ViewFactoryTest {
  
  /**
   * Test the constructor.
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
    Freeze f1 = new Freeze(r1, begin, end, position1, position2, size1, size2, color1, color2);
    m.addOperation(f1);
    
    ViewFactory vf = new ViewFactory(m, "aka.txt", 20);
    IView iv1 = vf.produceView("text");
    assertEquals(iv1.getViewType(), ViewEnum.TEXT);
    IView iv2 = vf.produceView("svg");
    assertEquals(iv2.getViewType(), ViewEnum.SVG);
    IView iv3 = vf.produceView("visual");
    assertEquals(iv3.getViewType(), ViewEnum.VISUAL);
    IView iv4 = vf.produceView("playback");
    assertEquals(iv4.getViewType(), ViewEnum.New);
    try {
      vf.produceView("aka");
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
  }
  
  /**
   * Test the getSpeed.
   */
  @Test
  public void testGetSpeed() {
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
    Freeze f1 = new Freeze(r1, begin, end, position1, position2, size1, size2, color1, color2);
    m.addOperation(f1);
    
    ViewFactory vf = new ViewFactory(m, "aka.txt", 20);
    assertEquals(vf.getSpeed(), 20);
  }
}
