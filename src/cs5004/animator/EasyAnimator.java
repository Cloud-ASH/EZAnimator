package cs5004.animator;

import cs5004.animator.controller.ControllerImpl;
import cs5004.animator.controller.IController;
import cs5004.animator.model.IModel;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This is a class to run the Animation.
 * 
 * @author zeyushen
 *
 */
public class EasyAnimator {
  
  /**
   * The main method of this project.
   * @param args the input arguments
   * @throws IOException throw when there is problem using AnimationREader to parseFile.
   */
  public static void main(String[] args) throws IOException {

    String inputfile = "";
    String outfile = "";
    String viewType = "";
    String speed = "1";

    Readable inputf = new StringReader("");

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "-in":
          inputfile = args[i + 1];
          continue;
        case "-view":
          viewType = args[i + 1];
          continue;
        case "-out":
          outfile = args[i + 1];
          continue;
        case "-speed":
          speed = args[i + 1];
          continue;
        default:
          continue;
      }

    }
    //    for (int i = 0; i < args.length; i ++) {
    //      System.out.println(args[i].toString());
    //    }
    //    System.out.println(speed.getClass().toString());
    //    System.out.println(speed.toString());

    double speedvalue = Double.valueOf(speed);

    IModel model = new ModelImpl();
    AnimationBuilderImpl builder = new AnimationBuilderImpl(model);

    try {
      //      System.out.println(inputfile);
      //      ShapeEnum a = ShapeEnum.Rectangle;
      //      System.out.println(a.toString());

      // here is the problem, need to check again.
      inputf = new FileReader("src/" + inputfile);
      model = AnimationReader.parseFile(inputf, builder);

    } catch (IOException e) {
      JOptionPane.showMessageDialog(new JFrame(), "Cannot Read the File.", "ERROR",
          JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }


    IController cl = new ControllerImpl(model, viewType, outfile, (int) speedvalue);
    cl.play();
  }

}
