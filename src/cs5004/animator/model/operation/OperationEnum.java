package cs5004.animator.model.operation;

/**
 * This is an enum class representing the shape types.
 * @author zeyushen
 *
 */
public enum OperationEnum {
  MOVE("move"), SCALE("scale"), CHANGECOLOR("changecolor"), FREEZE("freeze");

  private String operationType;
  
  /**
   * The constructor of the OperationEnum.
   * @param opertationType the type of this operation.
   */
  private OperationEnum(String operationType) {
    this.operationType = operationType;
  }
  
  @Override
  public String toString() {
    return this.operationType;
  }
  
}
