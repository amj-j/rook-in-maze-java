### Rook in a maze

Sigleplayer game Rook in maze, where the the task is to navigate a "rook" out of a maze. This is a desktop JAVA aplication, AWT and Swing libraries are used for graphical user interface.
The maze layout is generated by [randomized depth first search](https://www.baeldung.com/cs/maze-generation#dfs-maze) algorithm.

## My motivation
This is my second object-ortiented programming project with graphic user interface. I coded this in February of 2023.

This project is based on an assignment originally given in the "Object-Oriented Programming" course at my university.
Although I had not yet taken the course at the time, I found the assignment on the course website and decided to complete it as a self-directed challenge.
My goal was to deepen my understanding of Java and object-oriented programming principles, as well as to prepare myself for the actual course.

I also completed three other assignments from the same course (from previous years) as part of this initiative. 
These projects can be found on my GitHub: [Monopoly lite](https://github.com/amj-j/monopoly-lite-java), [Duck hunt](https://github.com/amj-j/duck-hunt-java), and [Reversi](https://github.com/amj-j/reversi-java).

### Goal
The purpose of this assignment is to practide the foundational principles of GUI development, such as event-driven programming and component-based design, which are also used in modern frameworks, through the Java Swing library.

## Prerequisites
You need to have Java 1.8 (also known as Java 8) or higher installed on you computer to run this app.

## Installation
1. Download the ```rook-in-maze.jar``` file.
2. Open your terminal and navigate to folder in which the downloaded ```rook-in-maze.jar``` file is located.
3. Type this command into the terminal to run the app: ```java -jar rook-in-maze.jar```.
4. The app will run in a new window.

## Gameplay
Players task is to move the rook (red circle) using key arrows or mouse from the upper-left corner to the bottom-right corner of the maze. The GUI contains solved mazes counter, which can be reset by a button. The player can choose from three dfficulty levels, the harder the difficulty, the bigger the maze.

## Architecture
This was the second time I tried to implement MVC pattern, to make the game logic indipendent of the AWT and Swing classes. As oppose to the first time (my [Reversi](https://github.com/amj-j/reversi-java) project), this time I opted for different approach, where the model doesn't notify the view directly, but only through the controller. The main controller, found in ```Controller.java``` contains instances of the implementation of view interface (```MainWindow```) and of model interface (```Model```). The controller creates its own instances of ```MazeController``` and ```MenuController``` which it then passes into the view as listeners, which then dispatches them into its two main components - the menu (solved mazes counter and difficulty selector) and the maze (the view of the game itself). The view notifies its listeners about user input, the listeners call controller methods, the controller calls model methods, which return the change of state in the app and the controller then calls view methods to update the view accordingly. Instantiation of the model, view and controller classes is done in the main class (```RookInMaze.java``` file).
