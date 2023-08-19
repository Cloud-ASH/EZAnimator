package cs5004.animator.model;

import cs5004.animator.model.operation.IOperation;
import cs5004.animator.model.shape.IShape;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * This is a class represents the ModelImpl. 
 * Creates a concrete ModelImpl object.
 * @author zeyushen
 *
 */
public class ModelImpl implements IModel {

  private Map<IShape, List<IOperation>> shapeDic;
  private Screen ascreen;
  private int minTime;
  private int maxTime;
  
  /**
   * Construct and initialize a ModelImpl object.
   * Create the in-built shape dictionary and screen, with min/max time.
   */
  public ModelImpl() {
    this.shapeDic = new LinkedHashMap<>();
    this.ascreen = new Screen(0, 0, 1000, 1000);
    this.minTime = 0;
    this.maxTime = 5000;
  }

  @Override
  public Screen getScreen() {
    return this.ascreen;
  }

  @Override
  public void setScreen(double x, double y, double width, double height) {
    this.ascreen.setX(x);
    this.ascreen.setY(y);
    this.ascreen.setWidth(width);
    this.ascreen.setHeight(height);
  }

  @Override
  public void addShape(IShape shape) throws IllegalArgumentException {
    if (shape == null) {
      throw new IllegalArgumentException("Null Shape.");
    }
    if (isShapeExist(shape)) {
      throw new IllegalArgumentException("Shape already exists.");
    }

    shapeDic.put(shape, new ArrayList<>());

    // update the minTime and maxTime after every adding
    for (IShape sp : shapeDic.keySet()) {
      if (sp.getStart() < minTime) {
        minTime = sp.getStart();
      }
      if (sp.getEnd() > maxTime) {
        maxTime = sp.getEnd();
      }
    }

  }

  // TODO check if we need a addShape with start and end time

  /**
   * Check if the shape has already exist in the shapeDic.
   * 
   * @param shape the given shape to be checked
   * @return boolean a boolean represents whether the shape exists or not.
   */
  public boolean isShapeExist(IShape shape) {
    if (shape == null) {
      throw new IllegalArgumentException("Null Shape.");
    }
    for (IShape sp : shapeDic.keySet()) {
      if (sp.getName().equals(shape.getName())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void removeShape(IShape shape) throws IllegalArgumentException {
    if (shape == null) {
      throw new IllegalArgumentException("Null Shape.");
    }
    if (!isShapeExist(shape)) {
      throw new IllegalArgumentException("We cannot remove a shape that does not exits.");
    }
    shapeDic.remove(shape);
  }

  @Override
  public void addOperation(IOperation operation) throws IllegalArgumentException {
    if (operation == null) {
      throw new IllegalArgumentException("Null Operation.");
    }

    if (shapeDic.get(operation.getShape()) == null) {
      throw new IllegalArgumentException("The shape related to this operation does not exit.");
    }

    //    if (shapeDic.get(operation.getShape()) != null) {
    //      System.out.println(operation.getShape().getName());
    //    }

    // TODO check operationlist
    //    List<IOperation> oplist = shapeDic.get(operation.getShape());

    for (IShape sp : shapeDic.keySet()) {
      if (operation.getShape().getName().equals(sp.getName())) {
        for (IOperation op : shapeDic.get(sp)) {
          if (op.getOpType() == operation.getOpType() && ((op.getOpStart() < operation.getOpStart()
              && op.getOpEnd() > operation.getOpEnd())
              || (op.getOpStart() > operation.getOpStart() && op.getOpEnd() < operation.getOpEnd())
              || (op.getOpStart() < operation.getOpEnd() && op.getOpEnd() > operation.getOpEnd()
                  || (op.getOpStart() < operation.getOpStart()
                      && op.getOpEnd() > operation.getOpStart())))) {
            throw new IllegalArgumentException("Same type operations cannot overlap.");
          }
        }
      }
    }
    // add to the corresponding operation list of the shape
    shapeDic.get(operation.getShape()).add(operation);

  }

  @Override
  public IShape getShapeByName(String name) throws IllegalArgumentException {
    for (IShape sp : shapeDic.keySet()) {
      if (sp.getName().equals(name)) {
        return sp;
      }
    }
    throw new IllegalArgumentException("No shape of this name.");
  }

  @Override
  public List<IShape> getAllShape() {
    List<IShape> shapelist = new ArrayList<>();
    for (IShape shape : shapeDic.keySet()) {
      shapelist.add(shape);
    }
    return shapelist;
  }

  @Override
  public List<IOperation> getAllOperation() {
    List<IOperation> operationList = new ArrayList<IOperation>();
    //    operationList = shapeDic.values().stream().flatMap(oplist -> oplist.stream())
    //        .sorted(Comparator.comparing(IOperation::getOpStart)).collect(Collectors.toList());

    return operationList;
  }

  @Override
  public Map<IShape, List<IOperation>> getShapeWithOp() {
    return this.shapeDic;
  }

  @Override
  public List<IShape> getShapesAtTime(int time) throws IllegalArgumentException {
    if (time < 0) {
      throw new IllegalArgumentException("Time cannot be negative.");
    }
    List<IShape> shapeAtTime = new ArrayList<>();
    for (IShape shape : shapeDic.keySet()) {

      //      System.out.println(String.format("Name : %s, start time %d, end time %d"
      //          , shape.getName(), shape.getStart(), shape.getEnd()));
      //      System.out.println(", position x, y : ");
      //      System.out.println(shape.getPosition().toString());
      //     

      if (shape.getStart() != -1 && shape.getEnd() != -1 && shape.getStart() <= time
          && shape.getEnd() >= time) {
        IShape cpshape = shape.duplicate();
        for (IOperation op : this.getOpertationOfShape(shape)) {
          if (op.getOpStart() <= time) {
            op.operate(cpshape, time);
          }
        }

        //        if (cpshape.getType() == ShapeEnum.Rectangle) {
        //          System.out.print(String.format("Name %s, RGB %d, %d, %d,
        //        x, y %.1f, %.1f, w h %.1f %.1f\n",
        //              cpshape.getName(),
        //            (int) cpshape.getColor().getR(), (int) cpshape.getColor().getG(),
        //        (int) cpshape.getColor().getB(),
        //            cpshape.getPosition().getXcord(), cpshape.getPosition().getYcord(),
        //        cpshape.getSize().getHorizontal(),
        //            cpshape.getSize().getVertical()));
        //        }

        shapeAtTime.add(cpshape);
      }

    }
    return shapeAtTime;
  }

  @Override
  public List<IOperation> getOpertationOfShape(IShape shape) {
    if (shape == null) {
      throw new IllegalArgumentException("Null Shape.");
    }
    if (!isShapeExist(shape)) {
      throw new IllegalArgumentException("We cannot remove a shape that does not exits.");
    }

    return shapeDic.get(shape);
  }

  @Override
  public String toStatus() {

    StringBuilder st = new StringBuilder();
    st.append("Shapes: \n");

    List<String> shapelist = shapeDic.keySet().stream().map(a -> a.toString())
        .collect(Collectors.toList());
    for (String shapestring : shapelist) {
      st.append(shapestring);
      st.append("\n");
    }

    List<IOperation> operationlist = shapeDic.values().stream().flatMap(oplist -> oplist.stream())
        .sorted(Comparator.comparing(IOperation::getOpStart)).collect(Collectors.toList());
    for (IOperation op : operationlist) {
      st.append(op.toString());
      st.append("\n");
    }
    return st.toString();
  }

  @Override
  public int getMinTime() {
    int minTime = Integer.MAX_VALUE;
    for (IShape shape : shapeDic.keySet()) {
      if (shape.getStart() < minTime) {
        minTime = shape.getStart();
      }
    }
    return minTime;
  }

  @Override
  public int getMaxTime() {
    for (IShape shape : shapeDic.keySet()) {
      if (shape.getEnd() > maxTime) {
        maxTime = shape.getStart();
      }
    }
    return maxTime;
  }

  @Override
  public void setMaxTime(int maxtime) {
    this.maxTime = maxtime;

  }

  //  @Override
  //  public int getWhenCanBeSeen() {
  //    
  //  }

  @Override
  public void removeOperation(IOperation operation) throws IllegalArgumentException {
    // TODO Auto-generated method stub

  }

}
