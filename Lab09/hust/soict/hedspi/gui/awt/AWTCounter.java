package hust.soict.hedspi.gui.awt;

import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces

// An AWT program inherits from the top-level container java.awt.Frame
public class AWTCounter extends Frame implements ActionListener {
   private Label lblCount;    // Declare a Label component 
   private TextField tfCount; // Declare a TextField component 
   private Button btnCount;   // Declare a Button component
   private int count = 0;     // Counter's value
 
   // Constructor to setup GUI components and event handlers
   public AWTCounter () {
      setLayout(new FlowLayout());
         // "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
         // the components from left-to-right, and flow to next row from top-to-bottom.
 
      lblCount = new Label("Counter");  // construct the Label component
      add(lblCount);                    // "super" Frame container adds Label component
 
      tfCount = new TextField(count + "", 10); // construct the TextField component with initial text
      tfCount.setEditable(false);       // set to read-only
      add(tfCount);                     // "super" Frame container adds TextField component
 
      btnCount = new Button("Count");   // construct the Button component
      add(btnCount);                    // "super" Frame container adds Button component
 
      btnCount.addActionListener(this);
         // "btnCount" is the source object that fires an ActionEvent when clicked.
         // The source add "this" instance as an ActionEvent listener, which provides
         //   an ActionEvent handler called actionPerformed().
         // Clicking "btnCount" invokes actionPerformed().
         
         // close event
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent event) {
            dispose();
         }
      });

      setTitle("AWT Counter");  // "super" Frame sets its title
      setSize(250, 100);        // "super" Frame sets its initial window size
 
      setVisible(true);
   }
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      new AWTCounter();
   }
 
   // ActionEvent handler - Called back upon button-click.
   @Override
   public void actionPerformed(ActionEvent evt) {
      ++count;
      tfCount.setText(count + "");
   }
}