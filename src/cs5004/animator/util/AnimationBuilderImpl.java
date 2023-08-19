package cs5004.animator.util;

import cs5004.animator.model.IModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.operation.ChangeColor;
import cs5004.animator.model.operation.Freeze;
import cs5004.animator.model.operation.IOperation;
import cs5004.animator.model.operation.Move;
import cs5004.animator.model.operation.Scale;
import cs5004.animator.model.shape.Color3D;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.ShapeEnum;
import cs5004.animator.model.shape.Size2D;


/**
 * This is a class represents a AnimationBuliderImpl object, implements the
 * AnimationBuilder interface.
 * 
 * @author zeyushen
 *
 */
public class AnimationBuilderImpl implements AnimationBuilder<ModelImpl> {

  private IModel m;
  
  /**
   * Construct and initialize the AnimationBuilderImpl object with a given model.
   * @param m the given model.
   */
  public AnimationBuilderImpl(IModel m) {
    this.m = m;
  }

  @Override
  public ModelImpl build() {
    return (ModelImpl) this.m;
  }

  @Override
  public AnimationBuilder<ModelImpl> setBounds(int x, int y, int width, int height) {
    this.m.setScreen(x, y, width, height);
    return this;
  }

  @Override
  public AnimationBuilder<ModelImpl> declareShape(String name, String type) {
    if (type.equals(ShapeEnum.Oval.toString()) || type.equals("ellipse")) {
      IShape oval = new Oval(name);
      m.addShape(oval);
    } else if (type.equals(ShapeEnum.Rectangle.toString())) {
      IShape rectangle = new Rectangle(name);
      m.addShape(rectangle);
    } else {
      //      System.out.println(type);
      throw new IllegalArgumentException("Shape type not supported.");
    }

    return this;
  }

  @Override
  public AnimationBuilder<ModelImpl> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
      int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2)
      throws IllegalArgumentException {

    // List<IShape> ls = this.m.getAllShape();
    // System.out.println("begin1");
    // for (IShape sp : ls) {
    // System.out.println(String.format("%s, %d, %d", sp.getName(), sp.getStart(),
    // sp.getEnd()));
    // }
    // System.out.println("end1");
    // if (this.m.getShapeByName(name) != null) {
    // System.out.println(String.format("%s", name));
    // }

    // if (t1 == 51) {
    // System.out.println(String.format("t1 %d, t2 %d, name %s, x1 %d,
    // y1 %d, w1 %d, h1 %d, r1 %d, g1 %d, b1 %d"
    // + "x2 %d, y2 %d, w2 %d, h2 %d, r2 %d, g2 %d, b2 %d", t1, t2, name
    // , x1, y1, w1, h1, r1, g1, b1, x2, y2
    // , w2, h2, r2, g2, b2));
    // }
    //

    if (this.m.getShapeByName(name) == null) {
      throw new IllegalArgumentException("Shape does not exit.");
    }

    // set the shape at begin if not set
    if (this.m.getShapeByName(name).getStart() == -1) {
      // System.out.println(String.format("%s time not set", name));
      this.m.getShapeByName(name).setStart(t1);
    }

    if (!this.m.getShapeByName(name).getLocationModified()) {
      // System.out.println(String.format("%s position not set", name));
      this.m.getShapeByName(name).relocate(new Point2D(x1, y1));
      this.m.getShapeByName(name).setLocationModified(true);
    }

    if (!this.m.getShapeByName(name).getSizeModified()) {
      this.m.getShapeByName(name).resize(new Size2D(w1, h1));
      this.m.getShapeByName(name).setSizeModified(true);
    }

    if (!this.m.getShapeByName(name).getColorModified()) {
      this.m.getShapeByName(name).redye(new Color3D(r1, g1, b1));
      this.m.getShapeByName(name).setColorModified(true);
    }

    // set the operation

    if (x1 != x2 || y1 != y2) {
      if (this.m.getShapeByName(name).getEnd() < t2) {
        this.m.getShapeByName(name).setEnd(t2);
      } // TODO check if we should set the initial value of shape end at a big number.

      IOperation op = new Move(this.m.getShapeByName(name), t1, t2, new Point2D(x1, y1),
          new Point2D(x2, y2), new Size2D(w1, h1), new Size2D(w2, h2), new Color3D(r1, g1, b1),
          new Color3D(r2, g2, b2));
      //      IOperation op = new Move(this.m.getShapeByName(name), t1, t2, new Point2D(x1, y1),
      //      new Point2D(x2, y2));
      //      System.out.println(String.format("%s is here in the move", op.getShape().getName()));
      m.addOperation(op);
    }

    else if (w1 != w2 || h1 != h2) {
      if (this.m.getShapeByName(name).getEnd() < t2) {
        this.m.getShapeByName(name).setEnd(t2);
      } // TODO check if we should set the initial value of shape end at a big number.

      IOperation op = new Scale(this.m.getShapeByName(name), t1, t2, new Point2D(x1, y1),
          new Point2D(x2, y2), new Size2D(w1, h1), new Size2D(w2, h2), new Color3D(r1, g1, b1),
          new Color3D(r2, g2, b2));    
      //      IOperation op = new Scale(this.m.getShapeByName(name),
      //      t1, t2, new Size2D(w1, h1), new Size2D(w2, h2));
      m.addOperation(op);

      //      System.out.println(
      //          String.format("Position is %.1f, %.1f",
      //      op.getShape().getPosition().getXcord(), op.getShape().getPosition().getYcord()));
    }

    else if (r1 != r2 || g1 != g2 || b1 != b2) {
      if (this.m.getShapeByName(name).getEnd() < t2) {
        this.m.getShapeByName(name).setEnd(t2);
      } // TODO check if we should set the initial value of shape end at a big number.

      IOperation op = new ChangeColor(this.m.getShapeByName(name), t1, t2, new Point2D(x1, y1),
          new Point2D(x2, y2), new Size2D(w1, h1), new Size2D(w2, h2), new Color3D(r1, g1, b1),
          new Color3D(r2, g2, b2));
      //      IOperation op = new ChangeColor(this.m.getShapeByName(name),  
      //      t1, t2, new Color3D(r1, g1, b1), new Color3D(r2, g2, b2));
      m.addOperation(op);
    }

    else if (x1 == x2 && y1 == y2 && w1 == w2 && h1 == h2 && r1 == r2 && g1 == g2 && b1 == b2
        && this.m.getShapeByName(name).getLocationModified()
        && this.m.getShapeByName(name).getSizeModified()
        && this.m.getShapeByName(name).getColorModified()) {

      //      System.out.println(String.format("%s is here in freeze", name));

      //      IOperation op = new Move(this.m.getShapeByName(name), t1, t2,
      //      new Point2D(x1, y1), new Point2D(x2, y2));
      IOperation op = new Freeze(this.m.getShapeByName(name), t1, t2, new Point2D(x1, y1),
          new Size2D(w1, h1), new Color3D(r1, g1, b1));
      m.addOperation(op);

      if (this.m.getShapeByName(name).getEnd() < t2) {
        this.m.getShapeByName(name).setEnd(t2);
      } // TODO check if we should set the initial value of shape end at a big number.
    }

    //    ls = this.m.getAllShape();
    //    System.out.println("begin2");
    //    for (IShape sp : ls) {
    //      System.out.println(String.format("%s, %d, %d", sp.getName(),
    //    sp.getStart(), sp.getEnd()));
    //    }
    //    System.out.println("end2");
    return this;
  }

}
