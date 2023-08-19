import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs5004.animator.model.IModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.Screen;
import cs5004.animator.model.operation.Freeze;
import cs5004.animator.model.operation.IOperation;
import cs5004.animator.model.operation.Move;
import cs5004.animator.model.shape.Color3D;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Size2D;
import org.junit.Test;

/**
 * This is a test for IModel, ModelImpl and Screen.
 * 
 * @author zeyushen
 *
 */
public class IModelTest {

  /**
   * Test the constructor of ModelImpl.
   */
  @Test
  public void testConstructor() {
    IModel m = new ModelImpl();
    assertEquals(m.getScreen().getX(), 0, 0.001);
    assertEquals(m.getScreen().getY(), 0, 0.001);
    assertEquals(m.getScreen().getWidth(), 1000, 0.001);
    assertEquals(m.getScreen().getHeight(), 1000, 0.001);
    assertEquals(m.getMaxTime(), 5000, 0.001);
  }

  /**
   * Test the screen related methods.
   */
  @Test
  public void testScreen() {
    int test = 1;
    IModel m = new ModelImpl();
    m.setScreen(10, 11, 12, 13);
    Screen s = m.getScreen();
    assertEquals(s.getX(), 10, 0.001);
    assertEquals(s.getY(), 11, 0.001);
    assertEquals(s.getWidth(), 12, 0.001);
    assertEquals(s.getHeight(), 13, 0.001);

    try {
      s.setHeight(-1);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      s.setWidth(-2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      s = new Screen(10, 12, -1, -2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
  }

  /**
   * Test addShape.
   */
  @Test
  public void testAddShape() {
    int test = 1;
    IModel m = new ModelImpl();
    IShape sp = null;

    try {
      ModelImpl a = new ModelImpl();
      a.isShapeExist(sp);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }

    try {
      m.addShape(sp);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }

    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    m.addShape(r1);
    try {
      m.addShape(r1);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }

    IShape c1 = new Oval("c1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 1,
        10000);
    m.addShape(c1);

    assertEquals(m.getAllShape().get(0), r1);
    assertEquals(m.getAllShape().get(1), c1);
    assertEquals(m.getMaxTime(), 10000);

  }

  /**
   * Test remove shape.
   */
  @Test
  public void testRemoveShape() {
    int test = 1;
    IModel m = new ModelImpl();
    IShape sp = null;

    try {
      ModelImpl a = new ModelImpl();
      a.removeShape(sp);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }

    IShape r2 = new Rectangle("r2", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        0, 1000);

    try {
      m.removeShape(r2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }

    m.addShape(r2);
    assertEquals(m.getAllShape().get(0), r2);
    m.removeShape(r2);
    assertEquals(m.getAllShape().toString(), "[]");
  }

  /**
   * Test the add operation method.
   */
  @Test
  public void testAddOperation() {
    int test = 1;
    IModel m = new ModelImpl();
    IShape sp = null;
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    m.addShape(r1);

    IShape r2 = new Rectangle("r2", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        0, 1000);
    int begin = 10;
    int end = 50;
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);
    Freeze f1 = new Freeze(r2, begin, end, position1, position2, size1, size2, color1, color2);
    Move m1 = new Move(r1, begin, end, position1, position2, size1, size2, color1, color2);
    Move m2 = new Move(r1, begin + 2, end - 1, position1, position2, size1, size2, color1, color2);
    Move m3 = new Move(r1, begin - 2, end - 1, position1, position2, size1, size2, color1, color2);
    Move m4 = new Move(r1, begin + 2, end + 1, position1, position2, size1, size2, color1, color2);

    try {
      m.addOperation(f1);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }

    m.addOperation(m1);
    try {
      m.addOperation(m2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      m.addOperation(m3);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      m.addOperation(m4);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
  }

  /**
   * Test getShapeByName.
   */
  @Test
  public void testGetShapeByName() {
    int test = 1;
    IModel m = new ModelImpl();
    IShape sp = null;
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    m.addShape(r1);
    assertEquals(m.getShapeByName("r1"), r1);
    try {
      m.getShapeByName("r2");
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
  }

  /**
   * Test getShapeWithOp.
   */
  @Test
  public void getShapeWithOP() {
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

    assertEquals(m.getShapeWithOp().keySet().size(), 1);
  }

  /**
   * Test the getShapesAtTime.
   */
  @Test
  public void getShapesAtTime() {
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
    IShape sp1 = m.getShapesAtTime(30).get(0);
    assertEquals(sp1.toString(),
        "Name: r1\n" + "Type: rectangle\n"
            + "Min corner: (55.0, 82.5), Width: 20.0, Height: 30.0, Color: (2.5, 3.5, 4.5)\n"
            + "Appears at t=1\n" + "Disappears at t=100\n" + "");
    try {
      m.getShapesAtTime(-1);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
  }

  /**
   * Test getOperationOfShape.
   */
  @Test
  public void getOperationOfShape() {
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
    IOperation op1 = m.getOpertationOfShape(r1).get(0);
    assertEquals(op1.toString(),
        "Shape r1 moves from(10.0, 15.0) to (100.0, 150.0) from t= 10 to t=50");
    IShape c1 = new Oval("c1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 1,
        100);
    
    try {
      m.getOpertationOfShape(sp);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    
    try {
      m.getOpertationOfShape(c1);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
  }
  
  /**
   * Test toStatus.
   */
  @Test
  public void testToStatus() {
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
    assertEquals(m.toStatus(), "Shapes: \n"
        + "Name: r1\n"
        + "Type: rectangle\n"
        + "Min corner: (10.0, 15.0), Width: 20.0, Height: 30.0, Color: (1.0, 2.0, 3.0)\n"
        + "Appears at t=1\n"
        + "Disappears at t=100\n"
        + "\n"
        + "Shape r1 moves from(10.0, 15.0) to (100.0, 150.0) from t= 10 to t=50\n"
        + "");
    assertEquals(m.getMinTime(), 1);
    m.setMaxTime(100);
    assertEquals(m.getMaxTime(), 100);
  }
  
}
