import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cs5004.animator.model.shape.Color3D;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.ShapeEnum;
import cs5004.animator.model.shape.Size2D;
import org.junit.Test;


/**
 * This is a test for IShape interface, Color3D class, Point2D class, Size2D
 * class, Oval class, Rectangle class and ShapeEnum enum.
 * 
 * @author zeyushen
 *
 */
public class IShapeTest {

  /**
   * Test the constructor of AbstractShape, Oval and Rectangle.
   */
  @Test
  public void testShapeConstructor() {
    // basic constructor
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    assertTrue(r1.getName().equals("r1"));
    assertEquals(r1.getType(), ShapeEnum.Rectangle);
    assertEquals(r1.getPosition().getXcord(), 10, 0.001);
    assertEquals(r1.getPosition().getYcord(), 15, 0.001);
    assertEquals(r1.getSize().getHorizontal(), 20, 0.001);
    assertEquals(r1.getSize().getVertical(), 30, 0.001);
    assertEquals(r1.getColor().getR(), 1, 0.001);
    assertEquals(r1.getColor().getG(), 2, 0.001);
    assertEquals(r1.getColor().getB(), 3, 0.001);
    assertEquals(r1.getStart(), 1, 0.001);
    assertEquals(r1.getEnd(), 100, 0.001);
    assertEquals(r1.getWhenCanBeSeen(), -1, 0.01);

    IShape c1 = new Oval("c1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 1,
        100);
    assertTrue(c1.getName().equals("c1"));
    assertEquals(c1.getType(), ShapeEnum.Oval);
    assertEquals(c1.getPosition().getXcord(), 10, 0.001);
    assertEquals(c1.getPosition().getYcord(), 15, 0.001);
    assertEquals(c1.getSize().getHorizontal(), 20, 0.001);
    assertEquals(c1.getSize().getVertical(), 30, 0.001);
    assertEquals(c1.getColor().getR(), 1, 0.001);
    assertEquals(c1.getColor().getG(), 2, 0.001);
    assertEquals(c1.getColor().getB(), 3, 0.001);
    assertEquals(c1.getStart(), 1, 0.001);
    assertEquals(c1.getEnd(), 100, 0.001);
    assertEquals(c1.getWhenCanBeSeen(), -1, 0.01);

    // constructor that only takes a name
    IShape r2 = new Rectangle("r2");
    assertTrue(r2.getName().equals("r2"));
    assertEquals(r2.getType(), ShapeEnum.Rectangle);
    assertEquals(r2.getPosition().getXcord(), 0, 0.001);
    assertEquals(r2.getPosition().getYcord(), 0, 0.001);
    assertEquals(r2.getSize().getHorizontal(), 0, 0.001);
    assertEquals(r2.getSize().getVertical(), 0, 0.001);
    assertEquals(r2.getColor().getR(), 0, 0.001);
    assertEquals(r2.getColor().getG(), 0, 0.001);
    assertEquals(r2.getColor().getB(), 0, 0.001);
    assertEquals(r2.getStart(), -1, 0.001);
    assertEquals(r2.getEnd(), 100000, 0.001);
    assertEquals(r2.getWhenCanBeSeen(), -1, 0.01);

    IShape c2 = new Oval("c2");
    assertTrue(c2.getName().equals("c2"));
    assertEquals(c2.getType(), ShapeEnum.Oval);
    assertEquals(c2.getPosition().getXcord(), 0, 0.001);
    assertEquals(c2.getPosition().getYcord(), 0, 0.001);
    assertEquals(c2.getSize().getHorizontal(), 0, 0.001);
    assertEquals(c2.getSize().getVertical(), 0, 0.001);
    assertEquals(c2.getColor().getR(), 0, 0.001);
    assertEquals(c2.getColor().getG(), 0, 0.001);
    assertEquals(c2.getColor().getB(), 0, 0.001);
    assertEquals(c2.getStart(), -1, 0.001);
    assertEquals(c2.getEnd(), 100000, 0.001);
    assertEquals(c2.getWhenCanBeSeen(), -1, 0.01);
  }

  /**
   * Test the constructor of AbstractShape, Oval and Rectangle for exceptions.
   */
  @Test
  public void testConstructorExceptions() {
    String name = null;
    Point2D position = null;
    Size2D size = null;
    Color3D color = null;
    int start1 = 2;
    int end1 = 1;
    int start2 = -3;
    int end2 = -1;

    try {
      IShape r1 = new Rectangle(name, new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
          1, 100);
    } catch (IllegalArgumentException e) {
      assertTrue(start1 > 0);
    }
    try {
      IShape r1 = new Rectangle("r1", position, new Size2D(20, 30), new Color3D(1, 2, 3), 1, 100);
    } catch (IllegalArgumentException e) {
      assertTrue(start1 > 0);
    }
    try {
      IShape r1 = new Rectangle("r1", new Point2D(10, 15), size, new Color3D(1, 2, 3), 1, 100);
    } catch (IllegalArgumentException e) {
      assertTrue(start1 > 0);
    }
    try {
      IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), color, 1, 100);
    } catch (IllegalArgumentException e) {
      assertTrue(start1 > 0);
    }
    try {
      IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
          start1, end1);
    } catch (IllegalArgumentException e) {
      assertTrue(start1 > 0);
    }
    try {
      IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
          start2, end2);
    } catch (IllegalArgumentException e) {
      assertTrue(start1 > 0);
    }
    try {
      IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
          start2, end1);
    } catch (IllegalArgumentException e) {
      assertTrue(start1 > 0);
    }
    try {
      IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
          start1, end2);
    } catch (IllegalArgumentException e) {
      assertTrue(start1 > 0);
    }
  }

  /**
   * Test the getters.
   */
  @Test
  public void testGetters() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    assertTrue(r1.getName().equals("r1"));
    assertEquals(r1.getType(), ShapeEnum.Rectangle);
    assertEquals(r1.getPosition().getXcord(), 10, 0.001);
    assertEquals(r1.getPosition().getYcord(), 15, 0.001);
    assertEquals(r1.getSize().getHorizontal(), 20, 0.001);
    assertEquals(r1.getSize().getVertical(), 30, 0.001);
    assertEquals(r1.getColor().getR(), 1, 0.001);
    assertEquals(r1.getColor().getG(), 2, 0.001);
    assertEquals(r1.getColor().getB(), 3, 0.001);
    assertEquals(r1.getStart(), 1, 0.001);
    assertEquals(r1.getEnd(), 100, 0.001);
    assertEquals(r1.getWhenCanBeSeen(), -1, 0.01);
    assertFalse(r1.getLocationModified());
    assertFalse(r1.getSizeModified());
    assertFalse(r1.getColorModified());

    IShape c1 = new Oval("c1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 1,
        100);
    assertTrue(c1.getName().equals("c1"));
    assertEquals(c1.getType(), ShapeEnum.Oval);
    assertEquals(c1.getPosition().getXcord(), 10, 0.001);
    assertEquals(c1.getPosition().getYcord(), 15, 0.001);
    assertEquals(c1.getSize().getHorizontal(), 20, 0.001);
    assertEquals(c1.getSize().getVertical(), 30, 0.001);
    assertEquals(c1.getColor().getR(), 1, 0.001);
    assertEquals(c1.getColor().getG(), 2, 0.001);
    assertEquals(c1.getColor().getB(), 3, 0.001);
    assertEquals(c1.getStart(), 1, 0.001);
    assertEquals(c1.getEnd(), 100, 0.001);
    assertEquals(c1.getWhenCanBeSeen(), -1, 0.01);
    assertFalse(c1.getLocationModified());
    assertFalse(c1.getSizeModified());
    assertFalse(c1.getColorModified());
  }

  /**
   * Test the setters.
   */
  @Test
  public void testSetters() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    r1.setColorModified(true);
    r1.setLocationModified(true);
    r1.setSizeModified(true);
    r1.setStart(100);
    r1.setEnd(200);
    r1.setWhenCanBeSeen(100);
    r1.redye(new Color3D(2,3,4));
    r1.resize(new Size2D(2,3));
    r1.relocate(new Point2D(1,2));
    assertTrue(r1.getLocationModified());
    assertTrue(r1.getSizeModified());
    assertTrue(r1.getColorModified());
    assertEquals(r1.getStart(), 100, 0.001);
    assertEquals(r1.getEnd(), 200, 0.001);
    assertEquals(r1.getWhenCanBeSeen(), 100, 0.01);
    assertEquals(r1.getPosition().getXcord(), 1, 0.001);
    assertEquals(r1.getPosition().getYcord(), 2, 0.001);
    assertEquals(r1.getSize().getHorizontal(), 2, 0.001);
    assertEquals(r1.getSize().getVertical(), 3, 0.001);
    assertEquals(r1.getColor().getR(), 2, 0.001);
    assertEquals(r1.getColor().getG(), 3, 0.001);
    assertEquals(r1.getColor().getB(), 4, 0.001);
  }

  /**
   * Test the duplicate method.
   */
  @Test
  public void testDuplicate() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    assertTrue(r1.getName().equals("r1"));
    assertEquals(r1.getType(), ShapeEnum.Rectangle);
    assertEquals(r1.getPosition().getXcord(), 10, 0.001);
    assertEquals(r1.getPosition().getYcord(), 15, 0.001);
    assertEquals(r1.getSize().getHorizontal(), 20, 0.001);
    assertEquals(r1.getSize().getVertical(), 30, 0.001);
    assertEquals(r1.getColor().getR(), 1, 0.001);
    assertEquals(r1.getColor().getG(), 2, 0.001);
    assertEquals(r1.getColor().getB(), 3, 0.001);
    assertEquals(r1.getStart(), 1, 0.001);
    assertEquals(r1.getEnd(), 100, 0.001);
    assertEquals(r1.getWhenCanBeSeen(), -1, 0.01);
    assertFalse(r1.getLocationModified());
    assertFalse(r1.getSizeModified());
    assertFalse(r1.getColorModified());

    Rectangle r2 = (Rectangle) r1.duplicate();
    assertTrue(r2.getName().equals("r1"));
    assertEquals(r2.getType(), ShapeEnum.Rectangle);
    assertEquals(r2.getPosition().getXcord(), 10, 0.001);
    assertEquals(r2.getPosition().getYcord(), 15, 0.001);
    assertEquals(r2.getSize().getHorizontal(), 20, 0.001);
    assertEquals(r2.getSize().getVertical(), 30, 0.001);
    assertEquals(r2.getColor().getR(), 1, 0.001);
    assertEquals(r2.getColor().getG(), 2, 0.001);
    assertEquals(r2.getColor().getB(), 3, 0.001);
    assertEquals(r2.getStart(), 1, 0.001);
    assertEquals(r2.getEnd(), 100, 0.001);
    assertEquals(r2.getWhenCanBeSeen(), -1, 0.01);
    assertFalse(r2.getLocationModified());
    assertFalse(r2.getSizeModified());
    assertFalse(r2.getColorModified());

    r1.setColorModified(true);
    r1.setLocationModified(true);
    r1.setSizeModified(true);
    r1.setStart(100);
    r1.setEnd(200);
    r1.setWhenCanBeSeen(100);
    assertTrue(r1.getLocationModified());
    assertTrue(r1.getSizeModified());
    assertTrue(r1.getColorModified());
    assertEquals(r1.getStart(), 100, 0.001);
    assertEquals(r1.getEnd(), 200, 0.001);
    assertEquals(r1.getWhenCanBeSeen(), 100, 0.01);

    assertFalse(r2.getLocationModified());
    assertFalse(r2.getSizeModified());
    assertFalse(r2.getColorModified());
    assertEquals(r2.getStart(), 1, 0.001);
    assertEquals(r2.getEnd(), 100, 0.001);
    assertEquals(r2.getWhenCanBeSeen(), -1, 0.01);

    IShape c1 = new Oval("c1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 1,
        100);
    assertTrue(c1.getName().equals("c1"));
    assertEquals(c1.getType(), ShapeEnum.Oval);
    assertEquals(c1.getPosition().getXcord(), 10, 0.001);
    assertEquals(c1.getPosition().getYcord(), 15, 0.001);
    assertEquals(c1.getSize().getHorizontal(), 20, 0.001);
    assertEquals(c1.getSize().getVertical(), 30, 0.001);
    assertEquals(c1.getColor().getR(), 1, 0.001);
    assertEquals(c1.getColor().getG(), 2, 0.001);
    assertEquals(c1.getColor().getB(), 3, 0.001);
    assertEquals(c1.getStart(), 1, 0.001);
    assertEquals(c1.getEnd(), 100, 0.001);
    assertEquals(c1.getWhenCanBeSeen(), -1, 0.01);
    assertFalse(c1.getLocationModified());
    assertFalse(c1.getSizeModified());
    assertFalse(c1.getColorModified());

    Oval c2 = (Oval) c1.duplicate();
    assertTrue(c2.getName().equals("c1"));
    assertEquals(c2.getType(), ShapeEnum.Oval);
    assertEquals(c2.getPosition().getXcord(), 10, 0.001);
    assertEquals(c2.getPosition().getYcord(), 15, 0.001);
    assertEquals(c2.getSize().getHorizontal(), 20, 0.001);
    assertEquals(c2.getSize().getVertical(), 30, 0.001);
    assertEquals(c2.getColor().getR(), 1, 0.001);
    assertEquals(c2.getColor().getG(), 2, 0.001);
    assertEquals(c2.getColor().getB(), 3, 0.001);
    assertEquals(c2.getStart(), 1, 0.001);
    assertEquals(c2.getEnd(), 100, 0.001);
    assertEquals(c2.getWhenCanBeSeen(), -1, 0.01);
    assertFalse(c2.getLocationModified());
    assertFalse(c2.getSizeModified());
    assertFalse(c2.getColorModified());

    c1.setColorModified(true);
    c1.setLocationModified(true);
    c1.setSizeModified(true);
    c1.setStart(100);
    c1.setEnd(200);
    c1.setWhenCanBeSeen(100);
    assertTrue(c1.getLocationModified());
    assertTrue(c1.getSizeModified());
    assertTrue(c1.getColorModified());
    assertEquals(c1.getStart(), 100, 0.001);
    assertEquals(c1.getEnd(), 200, 0.001);
    assertEquals(c1.getWhenCanBeSeen(), 100, 0.01);

    assertFalse(c2.getLocationModified());
    assertFalse(c2.getSizeModified());
    assertFalse(c2.getColorModified());
    assertEquals(c2.getStart(), 1, 0.001);
    assertEquals(c2.getEnd(), 100, 0.001);
    assertEquals(c2.getWhenCanBeSeen(), -1, 0.01);
  }

  /**
   * Test the setters for exceptions.
   */
  @Test
  public void testExcetpionSetter() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    Size2D size = null;
    Point2D position = null;
    Color3D color = null;
    int test = 2;
    try {
      r1.redye(color);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      r1.relocate(position);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      r1.resize(size);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
  }
  
  /**
   * Test the toString method of Oval and Rectangle.
   */
  @Test
  public void testToString() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    IShape c1 = new Oval("c1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 1,
        100);

    String r1str = "Name: r1\n" + "Type: rectangle\n"
        + "Min corner: (10.0, 15.0), Width: 20.0, Height: 30.0, Color: (1.0, 2.0, 3.0)\n"
        + "Appears at t=1\n" + "Disappears at t=100\n";
    String c1str = "Name: c1\n" + "Type: oval\n"
        + "Center: (10.0, 15.0), X radius: 20.0, Y radius: 30.0, Color: (1.0, 2.0, 3.0)\n"
        + "Appears at t=1\n" + "Disappears at t=100\n";

    assertEquals(r1.toString(), r1str);
    assertEquals(c1.toString(), c1str);
  }

  /**
   * Test the toSvg method of Oval and Rectangle.
   */
  @Test
  public void testToSvgString() {
    IShape r1 = new Rectangle("r1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3),
        1, 100);
    IShape c1 = new Oval("c1", new Point2D(10, 15), new Size2D(20, 30), new Color3D(1, 2, 3), 1,
        100);

    String r1str = "<rect id=\"r1\" x=\"10.0\" y=\"15.0\" width=\"20.0\" height=\"30.0\""
        + "  fill=\"rgb(1.0, 2.0, 3.0)\" visibility=\"hidden\">\n ";
    String c1str = "<ellipse id=\"c1\" cx=\"10.0\" cy=\"15.0\" rx=\"20.0\" ry=\"30.0\""
        + "  fill=\"rgb(1.0, 2.0, 3.0)\" visibility=\"hidden\">\n"
        + " ";

    assertEquals(r1.toSvg(), r1str);
    assertEquals(c1.toSvg(), c1str);

    String r1strhide = "<rect id=\"r1\" x=\"10.0\" y=\"15.0\" width=\"20.0\""
        + " height=\"30.0\"\" begin=\"20ms\" fill=\"rgb(1.0, 2.0, 3.0)\" visibility=\"hidden\">\n"
        + " ";
    String c1strhide = "<ellipse id=\"c1\" cx=\"10.0\" cy=\"15.0\" rx=\"20.0\""
        + " ry=\"30.0\" \" begin=\"20ms\" fill=\"rgb(1.0, 2.0, 3.0)\" visibility=\"hidden\">\n"
        + " ";
    assertEquals(((Rectangle) r1).toSvHide(20), r1strhide);
    assertEquals(((Oval) c1).toSvHide(20), c1strhide);
  }
  
  /**
   * Test the untested methods in Size2D, Point2D, Color2D.
   */
  @Test
  public void testUtil() {
    Size2D size = new Size2D(1, 2);
    int test = 1;
    assertEquals(size.toString(), "(1.0, 2.0)");
    try {
      size = new Size2D(-1,2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      size = new Size2D(1,-2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      size = new Size2D(-1,-2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    
    try {
      Color3D color = new Color3D(-1, 2, 2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      Color3D color = new Color3D(2, -2, 2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      Color3D color = new Color3D(2, 2, -2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      Color3D color = new Color3D(266, 2, 2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      Color3D color = new Color3D(2, 266, 2);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
    try {
      Color3D color = new Color3D(1, 2, 266);
    } catch (IllegalArgumentException e) {
      assertTrue(test > 0);
    }
  }
}
