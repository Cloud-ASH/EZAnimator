import static org.junit.Assert.assertEquals;

import cs5004.animator.view.ViewEnum;
import org.junit.Test;

/**
 * Test the view enum.
 * @author zeyushen
 *
 */
public class ViewEnumTest {
  
  /**
   * Test the toString method.
   */
  @Test
  public void test() {
    ViewEnum ve = ViewEnum.SVG;
    assertEquals(ve.toString(), "svg");
  }

}
