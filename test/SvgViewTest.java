import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs5004.animator.model.IModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.operation.Move;
import cs5004.animator.model.shape.Color3D;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Size2D;
import cs5004.animator.view.SvgView;
import cs5004.animator.view.ViewEnum;
import org.junit.Test;

/**
 * This is a class test the svg view.
 * @author zeyushen
 *
 */
public class SvgViewTest {

  /**
   * Test the SvgView's constructor.
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

    SvgView tv = new SvgView(m, "aka.txt", 20);
    assertEquals(tv.getViewType(), ViewEnum.SVG);
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

    SvgView tv = new SvgView(m, "aka.txt", 20);
    String str = "<svg width=\"1000.0\" height=\"1000.0\" version=\"1.1\" "
        + "     xmlns=\"http://www.w3.org/2000/svg\">\n"
        + "<rect id=\"r1\" x=\"10.0\" y=\"15.0\" width=\"20.0\" height=\"30.0\""
        + "  fill=\"rgb(1.0, 2.0, 3.0)\" visibility=\"hidden\">\n" + " \n"
        + "<set attributeName=\"visibility\" attributeType=\"CSS\" to=\"visible\""
        + " begin=\"500.0ms\" fill=\"freeze\"/>\n"
        + "   <animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\""
        + " attributeName=\"x\" from=\"10.0\" to=\"100.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\""
        + " attributeName=\"y\" from=\"15.0\" to=\"150.0\" fill=\"freeze\" />\n" + "\n"
        + "</rect></svg>";
    assertEquals(tv.viewOutput(), str);
    assertTrue(tv.viewOutput().equals(str));
  }

}
