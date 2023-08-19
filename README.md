# Readme

This project is created based on MVC Design Pattern.

The EasyAnimator allows us to create an application that will draw an animation according to how it is described in text, without being tied to how the description was produced. It get inputs from a file and draw the correpsonding animations.

Command:

- java -cp final.jar cs5004.animator.EasyAnimator -in “inputfile’s name” -view “view type” -speed “speed of view” -out “output file’s name”
- output is optional
- Sample:
    - java -cp final.jar cs5004.animator.EasyAnimator -in buildings.txt -view playback -speed 20

# Main

EasyAnimatior

- main method:
    - accept the inputs from command line, parse it and find out the input file’s name, view type, output file’s name and speed
    - Initialize an AnimationBuilderImpl with an empty ModelImpl
    - use AnimationReader to read and parse the inputs from the input file and update the model with these info
    - use the updated model, viewtype, outfile’s anme and speed to create a controller
    - let the controller plays.

# Model

The model act as the animation. It allows user to use oval and rectangle shapes and supports the operations needed: move, scale, change color and freeze.

## IModel Interface & ModelImpl Class:

The ModelImpl class is the main model. It implements the IModel interface.

The ModelImpl uses a Map<IShpae, List<IOperation>> to store the shapes and corresponding operations. (named as shapeDic).

The ModelImpl has 4 attributes: 

- shapeDic: the map to store shapes
- ascreen: the screen object
- minTime: the start time of model
- maxTime: the end time of model

The ModelImpl has many methods, but what matters most are:

- addShape: add shape to the model, check if there’s already a shape with same name before adding
- addOperation:
    - add operation to the model, loop through the keyset of shapeDic first to make sure there shape related to operation already exists;
    - check and ensure that there will not be an operation of the same type that overlaps with the operation to be added
- getShapeWithOp: return the shapeDic
- getAllShape: return all the keys of shapeDic
- getShapeByName: return the shape of a given name
- getOperationOfShape: return all the related operations of a shape
- getShapesAtTime:
    - return the updated shapes at a given time
    - It first loops through the keyset of shapeDic (which is all the shapes)
    - with in each step, it first copies the shape, then runs  all the operations that starts before the given time, in order to bring the copyshape to most up-to-date status
    - After loops, all the copyshape are collected into a list and return

## Screen

a class represents the screen of a model, has getters and setters for location and size.

## Shape

IShape interface & AbstracteShape class

- the IShape interface has all the common methods, including getters, setters.
- the AbstractShape class implements the IShape interface,
- It implemented two construcotrs, one with name, type, position, size, color, starttime, endtime; the other only needs name and type;
- It has getters and setters for attributes.
- One thing worth notice here is that I choose to add three special attributes here to monitor that whether the shapes’ initial status has been modified. This will let us know when to set it visible (after first modification).
    - **this**.sizemodified; **this**.colormodified; **this**.locationmodified
- It has three methods to change the shapes status
    - resize: change size
    - redye: change color
    - relocate: change position

Oval class

- extends the AbstractShape class, and has its toString, toSvg, toSvHide methods for TextView and SvgView.

Rectangle class

- extends the AbstractShape class, and has its toString, toSvg, toSvHide methods for TextView and SvgView.

Point2D class  & Size2D class & Color3D class & ShapeEnum enum

- represents the position, size, color and type of a shape, respectively

## Operation

IOperation interface & AbstractOperation class

- the IOperation interface contains getters for start and end time, getters for shape, toSvgString, duplicate method and a help method to calculate the middle status between start and end.
- the AbstractOperationclass implements the IOperation interface
    - It has a constructor that takes shape, start and end time
    - It overrides getters for time and shape
    - It overrides the interpolate method

Move class

- Represents the move operation.
- It has two constructor, one only takes shape, begin time, end time, begin position , end position; the other one takes all the parameters that AnimationBuilderImpl’s addMotion method can provide.
- It has getters for begin/end position/size/color
- It overrides the duplicate, toString, toSvg method
- Operate method: update a shape to the status of a given time. Even the operation itself carries a shape, I stiil choose to accept a shape as argument here, in order to allow this operation can be used on copies of the shape within operation. (just like what ModelImpl’s getShapesAtTime method do)

Scale class & ChangeColor class

- similar to Move class, except for the change’s are different

Freeze class

- similar to Move class, but it has a special constructor, takes shape, begin time, end time, start position, start size and start color
- It helps to holds the shape at currrent status when the inputs infers no change.

OperationEnum enum

- represents the operation types

# View

IView interface

- contains four common methods
- viewOutput: get the String output of the view (mainly for text and svg view)
- display: run the view
- getViewType: getter for viewtype
- getSpeed: getter for speed
- setSpeed: set the speed of the view ( mainly for svg, visual and new view)

TextView class

- displays the text output of model, allows user to export a .txt file
- command eg: -in buildings.txt -out bd.txt -view text -speed 20

SvgView class

- displays the text output of model, allows user to export a .svg file
- command eg: -in buildings.txt -out bd.svg -view svg -speed 20

VisualView class

- extends the JFrame and implements IView and ActionListener interface
- displays the visual view animation with javax.swing
- command eg: -in buildings.txt  -view visual -speed 20

NewView class

- extends the JFrame and implements IView and ActionListener interface
- displays the visual view animation with javax.swing
- allow users to start, pause, quit, resume, accelerate, slow down, playback and loop, displays the current speed and loop status
- command eg: -in buildings.txt  -view playback -speed 20

ViewFactory class

- factor for the view, the controller uses it to generate view according to its need
- produceView: produce view with a given viewType

VisuaViewPanel class

- extends JPanel
- overrides the paintComponent methods, accept a list of shapes and paint it out.
- The VisualView and NewView contians it.

ViewEnum enum

- represents the view type

# Controller

IController interface

- has a play method, runs the controller

ControllerImpl class

- constructor: accepts model, viewType, outfile’s name and speed
- overrides the play method, build a view accoridng to the viewtype given to this controller and displays the view

# Util

AnimationBuilder interface & AnimationBuilderImpl class

- helps build a model and add shapes/operations with parameters given by AnimationReader

AnimationReader class

- parse file and transfer parameters to AnimationBuilderImpl