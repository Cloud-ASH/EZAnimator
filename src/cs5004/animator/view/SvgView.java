package cs5004.animator.view;

import cs5004.animator.model.IModel;
import cs5004.animator.model.operation.IOperation;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.ShapeEnum;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This is a class represents the svg view of the easy animator. This allows the
 * user to output an svg file (or print into the Console).
 * 
 * @author zeyushen
 *
 */
public class SvgView implements IView {

  private IModel model;
  private double speed;
  private ViewEnum viewtype;
  private String outfile;

  /**
   * Construct and initialize the svg view with given model, outputfile's name and
   * speed.
   * 
   * @param model   the linked model
   * @param outfile the name of output file
   * @param speed   the given speed of this view.
   */
  public SvgView(IModel model, String outfile, double speed) {
    this.viewtype = ViewEnum.SVG;
    this.model = model;
    this.outfile = outfile;
    this.speed = speed;
  }

  @Override
  public String viewOutput() {

    StringBuilder svgout = new StringBuilder();

    //    head of the svg file
    // if (this.model.getScreen().getWidth() < 1100 &&
    // this.model.getScreen().getHeight() < 1100){
    // svgout.append("<svg width=\"").append(1100.0).append("\" height=\"")
    // .append(1100.0)
    // .append("\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n");
    // } else {
    svgout.append("<svg width=\"").append(this.model.getScreen().getWidth()).append("\" height=\"")
        .append(this.model.getScreen().getHeight())
        .append("\" version=\"1.1\"      xmlns=\"http://www.w3.org/2000/svg\">\n");

    for (IShape shape : this.model.getAllShape()) {
      svgout.append(shape.toSvg());

      int canbeseen = 10000;
      for (IOperation op : this.model.getOpertationOfShape(shape)) {
        if (op.getOpStart() < canbeseen) {
          canbeseen = op.getOpStart();
        }
      }

      String firstVisible = "\n<set attributeName=\"visibility\" attributeType=\"CSS\""
          + " to=\"visible\" begin=\"" + canbeseen * 1000 / speed + "ms\" fill=\"freeze\"/>\n";

      svgout.append(firstVisible);

      for (IOperation op : this.model.getOpertationOfShape(shape)) {
        svgout.append(op.svgString((int) speed));
      }
      if (shape.getType() == ShapeEnum.Oval) {
        svgout.append("</ellipse>");
      } else if (shape.getType() == ShapeEnum.Rectangle) {
        svgout.append("</rect>");
      }

    }
    svgout.append("</svg>");
    return svgout.toString();
  }

  @Override
  public void display() throws IOException {
    if (this.outfile.equals("")) {
      System.out.println(this.viewOutput());
    } else {
      try {
        FileWriter fw = new FileWriter(this.outfile);
        fw.write(this.viewOutput());
        fw.close();
      } catch (IOException ioe) {
        throw new IOException("Cannot open and write the file.");
      }
    }

  }

  @Override
  public ViewEnum getViewType() {
    return this.viewtype;
  }

  @Override
  public double getSpeed() {
    return this.speed;
  }

  @Override
  public void setSpeed(double newspeed) {
    this.speed = newspeed;
  }

}
