import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs5004.animator.model.operation.ChangeColor;
import cs5004.animator.model.operation.Freeze;
import cs5004.animator.model.operation.Move;
import cs5004.animator.model.operation.OperationEnum;
import cs5004.animator.model.operation.Scale;
import cs5004.animator.model.shape.Color3D;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Size2D;
import org.junit.Test;

/**
 * This is a test for IOperation interface, AbstractOperation class, Move class,
 * Scale class, ChangeColor class, Freeze class and OperatoinEnum enum.
 * 
 * @author zeyushen
 *
 */
public class IOperationTest {

  /**
   * This is a test for the constructors.
   */
  @Test
  public void testConstructor() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        0, 1000);
    int begin = 10;
    int end = 100;
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);

    // move
    Move m1 = new Move(r1, begin, end, position1, position2);
    assertEquals(m1.getShape(), r1);
    assertEquals(m1.getBeginPosition().getXcord(), 10, 0.001);
    assertEquals(m1.getBeginPosition().getYcord(), 15, 0.001);
    assertEquals(m1.getEndPosition().getXcord(), 100, 0.001);
    assertEquals(m1.getEndPosition().getYcord(), 150, 0.001);
    assertEquals(m1.getOpStart(), 10);
    assertEquals(m1.getOpEnd(), 100);
    assertEquals(m1.getOpType(), OperationEnum.MOVE);

    m1 = new Move(r1, begin, end, position1, position2, size1, size2, color1, color2);
    assertEquals(m1.getShape(), r1);
    assertEquals(m1.getBeginPosition().getXcord(), 10, 0.001);
    assertEquals(m1.getBeginPosition().getYcord(), 15, 0.001);
    assertEquals(m1.getEndPosition().getXcord(), 100, 0.001);
    assertEquals(m1.getEndPosition().getYcord(), 150, 0.001);
    assertEquals(m1.getBeginSize().getHorizontal(), 20, 0.001);
    assertEquals(m1.getBeginSize().getVertical(), 30, 0.001);
    assertEquals(m1.getEndSize().getHorizontal(), 40, 0.001);
    assertEquals(m1.getEndSize().getVertical(), 60, 0.001);
    assertEquals(m1.getBeginColor().getR(), 1, 0.001);
    assertEquals(m1.getBeginColor().getG(), 2, 0.001);
    assertEquals(m1.getBeginColor().getB(), 3, 0.001);
    assertEquals(m1.getEndColor().getR(), 4, 0.001);
    assertEquals(m1.getEndColor().getG(), 5, 0.001);
    assertEquals(m1.getEndColor().getB(), 6, 0.001);
    assertEquals(m1.getOpStart(), 10);
    assertEquals(m1.getOpEnd(), 100);
    assertEquals(m1.getOpType(), OperationEnum.MOVE);

    // scale
    Scale s1 = new Scale(r1, begin, end, size1, size2);
    assertEquals(s1.getShape(), r1);
    assertEquals(s1.getBeginSize().getHorizontal(), 20, 0.001);
    assertEquals(s1.getBeginSize().getVertical(), 30, 0.001);
    assertEquals(s1.getEndSize().getHorizontal(), 40, 0.001);
    assertEquals(s1.getEndSize().getVertical(), 60, 0.001);
    assertEquals(s1.getOpStart(), 10);
    assertEquals(s1.getOpEnd(), 100);
    assertEquals(s1.getOpType(), OperationEnum.SCALE);

    s1 = new Scale(r1, begin, end, position1, position2, size1, size2, color1, color2);
    assertEquals(s1.getShape(), r1);
    assertEquals(s1.getBeginPosition().getXcord(), 10, 0.001);
    assertEquals(s1.getBeginPosition().getYcord(), 15, 0.001);
    assertEquals(s1.getEndPosition().getXcord(), 100, 0.001);
    assertEquals(s1.getEndPosition().getYcord(), 150, 0.001);
    assertEquals(s1.getBeginSize().getHorizontal(), 20, 0.001);
    assertEquals(s1.getBeginSize().getVertical(), 30, 0.001);
    assertEquals(s1.getEndSize().getHorizontal(), 40, 0.001);
    assertEquals(s1.getEndSize().getVertical(), 60, 0.001);
    assertEquals(s1.getBeginColor().getR(), 1, 0.001);
    assertEquals(s1.getBeginColor().getG(), 2, 0.001);
    assertEquals(s1.getBeginColor().getB(), 3, 0.001);
    assertEquals(s1.getEndColor().getR(), 4, 0.001);
    assertEquals(s1.getEndColor().getG(), 5, 0.001);
    assertEquals(s1.getEndColor().getB(), 6, 0.001);
    assertEquals(s1.getOpStart(), 10);
    assertEquals(s1.getOpEnd(), 100);
    assertEquals(s1.getOpType(), OperationEnum.SCALE);

    // changecolor
    ChangeColor c1 = new ChangeColor(r1, begin, end, color1, color2);
    assertEquals(c1.getShape(), r1);
    assertEquals(c1.getBeginColor().getR(), 1, 0.001);
    assertEquals(c1.getBeginColor().getG(), 2, 0.001);
    assertEquals(c1.getBeginColor().getB(), 3, 0.001);
    assertEquals(c1.getEndColor().getR(), 4, 0.001);
    assertEquals(c1.getEndColor().getG(), 5, 0.001);
    assertEquals(c1.getEndColor().getB(), 6, 0.001);
    assertEquals(c1.getOpStart(), 10);
    assertEquals(c1.getOpEnd(), 100);
    assertEquals(c1.getOpType(), OperationEnum.CHANGECOLOR);

    c1 = new ChangeColor(r1, begin, end, position1, position2, size1, size2, color1, color2);
    assertEquals(c1.getShape(), r1);
    assertEquals(c1.getBeginPosition().getXcord(), 10, 0.001);
    assertEquals(c1.getBeginPosition().getYcord(), 15, 0.001);
    assertEquals(c1.getEndPosition().getXcord(), 100, 0.001);
    assertEquals(c1.getEndPosition().getYcord(), 150, 0.001);
    assertEquals(c1.getBeginSize().getHorizontal(), 20, 0.001);
    assertEquals(c1.getBeginSize().getVertical(), 30, 0.001);
    assertEquals(c1.getEndSize().getHorizontal(), 40, 0.001);
    assertEquals(c1.getEndSize().getVertical(), 60, 0.001);
    assertEquals(c1.getBeginColor().getR(), 1, 0.001);
    assertEquals(c1.getBeginColor().getG(), 2, 0.001);
    assertEquals(c1.getBeginColor().getB(), 3, 0.001);
    assertEquals(c1.getEndColor().getR(), 4, 0.001);
    assertEquals(c1.getEndColor().getG(), 5, 0.001);
    assertEquals(c1.getEndColor().getB(), 6, 0.001);
    assertEquals(c1.getOpStart(), 10);
    assertEquals(c1.getOpEnd(), 100);
    assertEquals(c1.getOpType(), OperationEnum.CHANGECOLOR);

    // freeze
    Freeze f1 = new Freeze(r1, begin, end, position1, size1, color1);
    assertEquals(f1.getShape(), r1);
    assertEquals(f1.getBeginPosition().getXcord(), 10, 0.001);
    assertEquals(f1.getBeginPosition().getYcord(), 15, 0.001);
    assertEquals(f1.getEndPosition().getXcord(), 10, 0.001);
    assertEquals(f1.getEndPosition().getYcord(), 15, 0.001);
    assertEquals(f1.getBeginSize().getHorizontal(), 20, 0.001);
    assertEquals(f1.getBeginSize().getVertical(), 30, 0.001);
    assertEquals(f1.getEndSize().getHorizontal(), 20, 0.001);
    assertEquals(f1.getEndSize().getVertical(), 30, 0.001);
    assertEquals(f1.getBeginColor().getR(), 1, 0.001);
    assertEquals(f1.getBeginColor().getG(), 2, 0.001);
    assertEquals(f1.getBeginColor().getB(), 3, 0.001);
    assertEquals(f1.getEndColor().getR(), 1, 0.001);
    assertEquals(f1.getEndColor().getG(), 2, 0.001);
    assertEquals(f1.getEndColor().getB(), 3, 0.001);
    assertEquals(f1.getOpStart(), 10);
    assertEquals(f1.getOpEnd(), 100);
    assertEquals(f1.getOpType(), OperationEnum.FREEZE);

    f1 = new Freeze(r1, begin, end, position1, position2, size1, size2, color1, color2);
    assertEquals(f1.getShape(), r1);
    assertEquals(f1.getBeginPosition().getXcord(), 10, 0.001);
    assertEquals(f1.getBeginPosition().getYcord(), 15, 0.001);
    assertEquals(f1.getEndPosition().getXcord(), 100, 0.001);
    assertEquals(f1.getEndPosition().getYcord(), 150, 0.001);
    assertEquals(f1.getBeginSize().getHorizontal(), 20, 0.001);
    assertEquals(f1.getBeginSize().getVertical(), 30, 0.001);
    assertEquals(f1.getEndSize().getHorizontal(), 40, 0.001);
    assertEquals(f1.getEndSize().getVertical(), 60, 0.001);
    assertEquals(f1.getBeginColor().getR(), 1, 0.001);
    assertEquals(f1.getBeginColor().getG(), 2, 0.001);
    assertEquals(f1.getBeginColor().getB(), 3, 0.001);
    assertEquals(f1.getEndColor().getR(), 4, 0.001);
    assertEquals(f1.getEndColor().getG(), 5, 0.001);
    assertEquals(f1.getEndColor().getB(), 6, 0.001);
    assertEquals(f1.getOpStart(), 10);
    assertEquals(f1.getOpEnd(), 100);
    assertEquals(f1.getOpType(), OperationEnum.FREEZE);

  }

  /**
   * This is a test for the getters.
   */
  @Test
  public void testGetters() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        0, 1000);
    int begin = 10;
    int end = 100;
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);
    Freeze f1 = new Freeze(r1, begin, end, position1, position2, size1, size2, color1, color2);
    assertEquals(f1.getShape(), r1);
    assertEquals(f1.getBeginPosition().getXcord(), 10, 0.001);
    assertEquals(f1.getBeginPosition().getYcord(), 15, 0.001);
    assertEquals(f1.getEndPosition().getXcord(), 100, 0.001);
    assertEquals(f1.getEndPosition().getYcord(), 150, 0.001);
    assertEquals(f1.getBeginSize().getHorizontal(), 20, 0.001);
    assertEquals(f1.getBeginSize().getVertical(), 30, 0.001);
    assertEquals(f1.getEndSize().getHorizontal(), 40, 0.001);
    assertEquals(f1.getEndSize().getVertical(), 60, 0.001);
    assertEquals(f1.getBeginColor().getR(), 1, 0.001);
    assertEquals(f1.getBeginColor().getG(), 2, 0.001);
    assertEquals(f1.getBeginColor().getB(), 3, 0.001);
    assertEquals(f1.getEndColor().getR(), 4, 0.001);
    assertEquals(f1.getEndColor().getG(), 5, 0.001);
    assertEquals(f1.getEndColor().getB(), 6, 0.001);
    assertEquals(f1.getOpStart(), 10);
    assertEquals(f1.getOpEnd(), 100);
    assertEquals(f1.getOpType(), OperationEnum.FREEZE);
  }

  /**
   * Test the constructor's exceptions.
   */
  @Test
  public void testConstructorException() {
    int test = 2;
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        20, 1000);
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);

    try {
      Freeze f1 = new Freeze(r1, 25, 20, position1, position2, size1, size2, color1, color2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      Freeze f1 = new Freeze(r1, -5, 20, position1, position2, size1, size2, color1, color2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      Freeze f1 = new Freeze(r1, 25, -20, position1, position2, size1, size2, color1, color2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      Freeze f1 = new Freeze(r1, 25, 2000, position1, position2, size1, size2, color1, color2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      Freeze f1 = new Freeze(r1, 5, 200, position1, position2, size1, size2, color1, color2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
  }

  /**
   * Test the interpolate method.
   */
  @Test
  public void testInterpolate() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        0, 1000);
    int begin = 10;
    int end = 100;
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);
    Freeze f1 = new Freeze(r1, begin, end, position1, position2, size1, size2, color1, color2);

    double output = f1.interpolate(0, 100, 0, 100, 50);
    assertEquals(output, 50, 0.001);
  }

  /**
   * This is a test for duplicate method.
   */
  @Test
  public void testDuplicate() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        0, 1000);
    int begin = 10;
    int end = 100;
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);
    Freeze f1 = new Freeze(r1, begin, end, position1, position2, size1, size2, color1, color2);
    assertEquals(f1.getShape(), r1);
    assertEquals(f1.getBeginPosition().getXcord(), 10, 0.001);
    assertEquals(f1.getBeginPosition().getYcord(), 15, 0.001);
    assertEquals(f1.getEndPosition().getXcord(), 100, 0.001);
    assertEquals(f1.getEndPosition().getYcord(), 150, 0.001);
    assertEquals(f1.getBeginSize().getHorizontal(), 20, 0.001);
    assertEquals(f1.getBeginSize().getVertical(), 30, 0.001);
    assertEquals(f1.getEndSize().getHorizontal(), 40, 0.001);
    assertEquals(f1.getEndSize().getVertical(), 60, 0.001);
    assertEquals(f1.getBeginColor().getR(), 1, 0.001);
    assertEquals(f1.getBeginColor().getG(), 2, 0.001);
    assertEquals(f1.getBeginColor().getB(), 3, 0.001);
    assertEquals(f1.getEndColor().getR(), 4, 0.001);
    assertEquals(f1.getEndColor().getG(), 5, 0.001);
    assertEquals(f1.getEndColor().getB(), 6, 0.001);
    assertEquals(f1.getOpStart(), 10);
    assertEquals(f1.getOpEnd(), 100);
    assertEquals(f1.getOpType(), OperationEnum.FREEZE);

    Freeze f2 = (Freeze) f1.duplicateOp();
    assertEquals(f2.getShape(), r1);
    assertEquals(f2.getBeginPosition().getXcord(), 10, 0.001);
    assertEquals(f2.getBeginPosition().getYcord(), 15, 0.001);
    assertEquals(f2.getEndPosition().getXcord(), 100, 0.001);
    assertEquals(f2.getEndPosition().getYcord(), 150, 0.001);
    assertEquals(f2.getBeginSize().getHorizontal(), 20, 0.001);
    assertEquals(f2.getBeginSize().getVertical(), 30, 0.001);
    assertEquals(f2.getEndSize().getHorizontal(), 40, 0.001);
    assertEquals(f2.getEndSize().getVertical(), 60, 0.001);
    assertEquals(f2.getBeginColor().getR(), 1, 0.001);
    assertEquals(f2.getBeginColor().getG(), 2, 0.001);
    assertEquals(f2.getBeginColor().getB(), 3, 0.001);
    assertEquals(f2.getEndColor().getR(), 4, 0.001);
    assertEquals(f2.getEndColor().getG(), 5, 0.001);
    assertEquals(f2.getEndColor().getB(), 6, 0.001);
    assertEquals(f2.getOpStart(), 10);
    assertEquals(f2.getOpEnd(), 100);
    assertEquals(f2.getOpType(), OperationEnum.FREEZE);

    f1 = new Freeze(r1, begin, 200, position1, position2, size1, size2, color1, color2);
    assertEquals(f2.getOpEnd(), 100);
    assertEquals(f1.getOpEnd(), 200);

    Move m1 = new Move(r1, begin, end, position1, position2, size1, size2, color1, color2);
    Scale s1 = new Scale(r1, begin, end, position1, position2, size1, size2, color1, color2);
    ChangeColor c1 = new ChangeColor(r1, begin, end, position1, position2, size1, size2, color1,
        color2);

    Move m2 = (Move) m1.duplicateOp();
    Scale s2 = (Scale) s1.duplicateOp();
    ChangeColor c2 = (ChangeColor) c1.duplicateOp();

    assertEquals(m1.getOpStart(), 10);
    assertEquals(s1.getOpStart(), 10);
    assertEquals(c1.getOpStart(), 10);
    assertEquals(m2.getOpStart(), 10);
    assertEquals(s2.getOpStart(), 10);
    assertEquals(c2.getOpStart(), 10);

    m1 = new Move(r1, 15, end, position1, position2, size1, size2, color1, color2);
    s1 = new Scale(r1, 15, end, position1, position2, size1, size2, color1, color2);
    c1 = new ChangeColor(r1, 15, end, position1, position2, size1, size2, color1, color2);

    assertEquals(m1.getOpStart(), 15);
    assertEquals(s1.getOpStart(), 15);
    assertEquals(c1.getOpStart(), 15);
    assertEquals(m2.getOpStart(), 10);
    assertEquals(s2.getOpStart(), 10);
    assertEquals(c2.getOpStart(), 10);

  }

  /**
   * This is a test for operate method.
   */
  @Test
  public void testOperate() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        0, 1000);
    int begin = 10;
    int end = 20;
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);
    Freeze f1 = new Freeze(r1, begin, end, position1, position2, size1, size2, color1, color2);
    Move m1 = new Move(r1, begin, end, position1, position2, size1, size2, color1, color2);
    Scale s1 = new Scale(r1, begin, end, position1, position2, size1, size2, color1, color2);
    ChangeColor c1 = new ChangeColor(r1, begin, end, position1, position2, size1, size2, color1,
        color2);

    assertEquals(r1.toString(),
        "Name: r1\n" + "Type: rectangle\n"
            + "Min corner: (10.0, 15.0), Width: 20.0, Height: 30.0, Color: (1.0, 2.0, 3.0)\n"
            + "Appears at t=0\n" + "Disappears at t=1000\n" + "");
    f1.operate(r1, 15);
    assertEquals(r1.toString(),
        "Name: r1\n" + "Type: rectangle\n"
            + "Min corner: (55.0, 82.5), Width: 20.0, Height: 30.0, Color: (2.5, 3.5, 4.5)\n"
            + "Appears at t=0\n" + "Disappears at t=1000\n" + "");

    r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 0,
        1000);
    assertEquals(r1.toString(),
        "Name: r1\n" + "Type: rectangle\n"
            + "Min corner: (10.0, 15.0), Width: 20.0, Height: 30.0, Color: (1.0, 2.0, 3.0)\n"
            + "Appears at t=0\n" + "Disappears at t=1000\n" + "");
    m1.operate(r1, 15);
    assertEquals(r1.toString(),
        "Name: r1\n" + "Type: rectangle\n"
            + "Min corner: (55.0, 82.5), Width: 20.0, Height: 30.0, Color: (2.5, 3.5, 4.5)\n"
            + "Appears at t=0\n" + "Disappears at t=1000\n" + "");

    r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 0,
        1000);
    assertEquals(r1.toString(),
        "Name: r1\n" + "Type: rectangle\n"
            + "Min corner: (10.0, 15.0), Width: 20.0, Height: 30.0, Color: (1.0, 2.0, 3.0)\n"
            + "Appears at t=0\n" + "Disappears at t=1000\n" + "");
    s1.operate(r1, 15);
    assertEquals(r1.toString(),
        "Name: r1\n" + "Type: rectangle\n"
            + "Min corner: (55.0, 82.5), Width: 20.0, Height: 30.0, Color: (2.5, 3.5, 4.5)\n"
            + "Appears at t=0\n" + "Disappears at t=1000\n" + "");

    r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 0,
        1000);
    assertEquals(r1.toString(),
        "Name: r1\n" + "Type: rectangle\n"
            + "Min corner: (10.0, 15.0), Width: 20.0, Height: 30.0, Color: (1.0, 2.0, 3.0)\n"
            + "Appears at t=0\n" + "Disappears at t=1000\n" + "");
    c1.operate(r1, 15);
    assertEquals(r1.toString(),
        "Name: r1\n" + "Type: rectangle\n"
            + "Min corner: (55.0, 82.5), Width: 20.0, Height: 30.0, Color: (2.5, 3.5, 4.5)\n"
            + "Appears at t=0\n" + "Disappears at t=1000\n" + "");
  }

  /**
   * This is a test for toString method.
   */
  @Test
  public void testToString() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        0, 1000);
    int begin = 10;
    int end = 100;
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);
    Freeze f1 = new Freeze(r1, begin, end, position1, position2, size1, size2, color1, color2);
    Move m1 = new Move(r1, begin, end, position1, position2, size1, size2, color1, color2);
    Scale s1 = new Scale(r1, begin, end, position1, position2, size1, size2, color1, color2);
    ChangeColor c1 = new ChangeColor(r1, begin, end, position1, position2, size1, size2, color1,
        color2);

    assertEquals(f1.toString(), "");
    assertEquals(m1.toString(),
        "Shape r1 moves from(10.0, 15.0) to" + " (100.0, 150.0) from t= 10 to t=100");
    assertEquals(s1.toString(), "Shape r1 scales from Width: 20.0,"
        + " Height: 30.0 to Width: 40.0, Height: 60.0 from t= 10 to t=100");
    assertEquals(c1.toString(),
        "Shape r1 changes color from(1.0, 2.0, 3.0)" + " to (4.0, 5.0, 6.0) from t= 10 to t=100");

  }

  /**
   * This is a test for svgString method.
   */
  @Test
  public void testSvg() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        0, 1000);
    int begin = 10;
    int end = 100;
    Point2D position1 = new Point2D(10, 15);
    Point2D position2 = new Point2D(100, 150);
    Size2D size1 = new Size2D(20, 30);
    Size2D size2 = new Size2D(40, 60);
    Color3D color1 = new Color3D(1, 2, 3);
    Color3D color2 = new Color3D(4, 5, 6);
    Freeze f1 = new Freeze(r1, begin, end, position1, position2, size1, size2, color1, color2);
    Move m1 = new Move(r1, begin, end, position1, position2, size1, size2, color1, color2);
    Scale s1 = new Scale(r1, begin, end, position1, position2, size1, size2, color1, color2);
    ChangeColor c1 = new ChangeColor(r1, begin, end, position1, position2, size1, size2, color1,
        color2);

    assertEquals(f1.svgString(10), "");
    assertEquals(m1.svgString(10),
        "   <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\""
            + " attributeName=\"x\" from=\"10.0\" to=\"100.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\""
            + " attributeName=\"y\" from=\"15.0\" to=\"150.0\" fill=\"freeze\" />\n" + "\n" + "");
    assertEquals(s1.svgString(10),
        "   <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\""
            + " attributeName=\"width\" from=\"20.0\" to=\"40.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\""
            + " attributeName=\"height\" from=\"30.0\" to=\"60.0\" fill=\"freeze\" />\n" + "\n"
            + "");
    assertEquals(c1.svgString(10),
        "   <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\" attributeName=\"fill\""
            + " from=\"rgb(1.0,2.0,3.0)\" to=\"rgb(4.0,5.0,6.0)\" fill=\"freeze\" />\n" + "\n"
            + "");

    IShape o1 = new Oval("o1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 0,
        1000);
    Move m2 = new Move(o1, begin, end, position1, position2, size1, size2, color1, color2);
    Scale s2 = new Scale(o1, begin, end, position1, position2, size1, size2, color1, color2);
    assertEquals(m2.svgString(10),
        "   <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\""
            + " attributeName=\"cx\" from=\"10.0\" to=\"100.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\""
            + " attributeName=\"cy\" from=\"15.0\" to=\"150.0\" fill=\"freeze\" />\n" + "\n" + "");
    assertEquals(s2.svgString(10),
        "   <animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\""
            + " attributeName=\"cx\" from=\"20.0\" to=\"40.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"9000ms\""
            + " attributeName=\"cy\" from=\"30.0\" to=\"60.0\" fill=\"freeze\" />\n" + "\n" + "");
  }

  /**
   * Test operation enum to string.
   */
  @Test
  public void opEnumToString() {
    OperationEnum ope = OperationEnum.CHANGECOLOR;
    assertEquals(ope.toString(), "changecolor");
  }

}
