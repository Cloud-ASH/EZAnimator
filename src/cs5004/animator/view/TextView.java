package cs5004.animator.view;

import cs5004.animator.model.IModel;
import cs5004.animator.model.operation.IOperation;
import cs5004.animator.model.shape.IShape;
import cs5004.animator.model.shape.ShapeEnum;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is a class represents the text view.
 * @author zeyushen
 *
 */
public class TextView implements IView {
  
  private IModel model;  //TODO to private
  private double speed; 
  private ViewEnum viewtype;
  private String outfile;
  
  /**
   * Construct and initialize the text view base on given model, outfile's name and speed.
   * @param model the linked model
   * @param outfile the given name of output file
   * @param speed the given speed of the view
   */
  public TextView(IModel model, String outfile, double speed) {
    this.viewtype = ViewEnum.TEXT;
    this.model = model;
    this.outfile = outfile;
    this.speed = speed;
  }

  @Override
  public String viewOutput() {
    StringBuilder sb = new StringBuilder();

    List<IShape> shapelist = this.model.getAllShape();
    
    for (IShape sp : shapelist) {
      //      System.out.println(sp.toString());

      sb.append("Create ").append(sp.getType().toString()).append(" ").append(sp.getName())
          .append(" with color of ").append(sp.getColor().toString());
      if (sp.getType() == ShapeEnum.Rectangle) {
        sb.append(", with cornor at ").append(sp.getPosition().toString()).append(String.format(
            ", width %.1f and height %.1f",
            sp.getSize().getHorizontal(), sp.getSize().getVertical()));
      }
      if (sp.getType() == ShapeEnum.Oval) {
        sb.append(", with center at ").append(sp.getPosition().toString()).append(String.format(
            ", radius %.1f and %.1f", sp.getSize().getHorizontal(), sp.getSize().getVertical()));
      }
      sb.append("\n");
    }
    sb.append("\n");
    for (IShape sp : shapelist) {
      sb.append(sp.getName().toString()).append(" appears at time t=").append(sp.getStart())
          .append(" and disappears at time t=").append(sp.getEnd());
      sb.append("\n");
    }
    sb.append("\n");

    List<IOperation> operationlist = this.model.getShapeWithOp().values().stream()
        .flatMap(oplist -> oplist.stream()).sorted(Comparator.comparing(IOperation::getOpStart))
        .collect(Collectors.toList());
    for (IOperation op : operationlist) {
      //      if (op.getOpType() == OperationEnum.MOVE) {
      //        if (!(((Move) op).getBeginPosition() == ((Move) op).getEndPosition())) {
      //          sb.append(op.toString());
      //        }
      //      }
      sb.append(op.toString());
      sb.append("\n");
    }
    return sb.toString();
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
    // TODO Auto-generated method stub
    this.speed = newspeed;
  }

}
