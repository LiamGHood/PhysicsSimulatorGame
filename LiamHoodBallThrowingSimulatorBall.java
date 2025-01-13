/* Author: Liam Hood
 * Date: 4/29/24
 * School: Thales Academy Rolesville
 * Program Name: LiamHoodBallThrowingSimulatorBall
 * Description: This program simulates kinematics and the parabolic path of a launched projectile. Additionally, it enables the user to set variable values for the time the force is applied, the magnitude of force, the angle of launch, gravity, and the mass of the ball.
 * Difficulties: The difficulties for this final project were three-fold mainly creating the GUI, updating score, and programming buttons for each planet to set the appropriate value for gravity. I solved the problem of implementing a GUI through utilizing a YouTube channel named 'Bro Code' who has a 30 part mini-series on coding a GUI in java (https://www.youtube.com/watch?v=-IMys4PCkIA&t=92s&pp=ygUUQnJvIENvZGUgYnV0dG9uIGphdmE%3D), following his tutorials, I successfully implemented actionlisteners, buttons, and animation into my project. To solve the problem of updating the score I utilized a geeksForGeeks article for creating JLabels (https://www.geeksforgeeks.org/jlabel-java-swing/)
 * What I learned: In this program, I learned how to create a GUI, animation, buttons, and JLabels. I also learned that a programming project may seem initially impossible especially if it involves coding with concepts that have not been learned, however through enough consistent hard work, one can overcome these obstacles.
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.io.File;
import javax.swing.AbstractAction;
import java.io.*;
import java.util.*;
//imports a series of necessary java packages

public class LiamHoodBallThrowingSimulatorBall extends JFrame implements ActionListener
{
    Scanner scan = new Scanner(System.in);
    //instantiates a new Scanner object named 'scan'
    double[] velocity = new double[2];
    //declares an array of type double named 'velocity' that contains two elements
    double[] position = new double[2];
    //declares an array of type double named 'position' that contains two elements
    
    private double forceMagnitude;
    private double timeForceApplied;
    private double ballMass;
    private double launchAngle;
    private double gravityValue;
    private double xTraversed;
    private int scoreValue;
    //declares five private instance variables of type 'double'
    
    String fire = "";
    //declares a string variable named 'fire' which is initialized to NULL.
    
    private int targetValue;
    //declares one instance variable of type 'int'
    
    JLabel score = new JLabel();
    JLabel gravity = new JLabel();
    JLabel target = new JLabel();
    JLabel xAxis = new JLabel();    
    JLabel yAxis = new JLabel();
    //Instantiates four JLabel objects named 'score', 'gravity', 'target', and 'xAxis'.
    
    JButton buttonMars = new JButton();
    JButton buttonEarth = new JButton();
    JButton buttonJupiter = new JButton();
    JButton buttonSaturn = new JButton();
     //Instantiates four JButton objects named 'buttonMars', 'buttonEarth', 'buttonJupiter', and 'buttonSaturn'.
   
     public void paint(Graphics g)
   {
       super.paint(g);
       //calls the paint method and passes the value 'g' from Graphics
       
       g.drawLine(50, 750, 600, 750);
       g.drawLine(50, 250, 50, 750);
       g.drawLine(0, 200, 750, 200);
       //draws three lines
       
       /*********draws Earth***********/
       g.setColor(Color.BLUE);
       //sets the color to Blue
       g.fillOval(40, 50, 120, 120);
       // draws a filled in oval at x-position: 40, y-position: 50, and x-radius and y-radius set to 120.
       
       g.setColor(Color.GREEN);
       //sets the color to Green
       g.fillOval(60, 70, 60, 40);
       // draws a filled in oval at x-position: 60, y-position: 70, x-radius: 60, and y-radius: 40.
        g.fillOval(90, 100, 30, 50);
        // draws a filled in oval at x-position: 90, y-position: 100, x-radius: 30, and y-radius: 50.
        
       /**********draws Mars***********/
       g.setColor(new Color(176, 44, 44));
       //creates and sets a new color
       g.fillOval(175, 50, 120, 120);
       // draws a filled in oval at x-position: 175, y-position: 50, x-radius: 120, and y-radius: 120.
       
       g.setColor(new Color(159, 108, 108));
       //creates and sets a new color
       g.fillOval(195, 70, 40, 10);
       // draws a filled in oval at x-position: 175, y-position: 50, x-radius: 120, and y-radius: 120.
       g.fillOval(245, 90, 40, 10);
       // draws a filled in oval at x-position: 245, y-position: 90, x-radius: 40, and y-radius: 10.
       g.fillOval(215, 140, 40, 10);
       // draws a filled in oval at x-position: 215, y-position: 140, x-radius: 40, and y-radius: 10.
     
     /************draws Jupiter************/  
       g.setColor(new Color(230, 157, 29));
       //creates and sets a new color
       g.fillOval(300, 50, 120, 120);
       // draws a filled in oval at x-position: 300, y-position: 50, x-radius: 120, and y-radius: 120.
       g.setColor(new Color(232, 108, 48));
       //creates and sets a new color
       g.fillOval(325, 110, 70, 30); 
       // draws a filled in oval at x-position: 325, y-position: 110, x-radius: 70, and y-radius: 30.
       
       /**********draws Saturn************/
       g.setColor(new Color(230, 108, 47));
       //creates and sets a new color
       g.fillOval(475, 70, 80, 80);
       // draws a filled in oval at x-position: 475, y-position: 70, x-radius: 80, and y-radius: 80.
       g.setColor(new Color(230, 157, 47));
       //creates and sets a new color
       g.fillRect(450, 100, 130, 10);
       //draws and fills a rectange at x-position: 450, y-position: 100, x-radius: 130, y-radius: 10.
       
       
       
       g.setColor(Color.BLACK);
       //sets the color to 'Black'
       
       for(int i = 1; i<= 11; i++)
           g.drawLine(i*50, 765, i*50, 735);
           //draws eleven vertical lines with a length of 30
           
       for(int i = 1; i<= 11; i++)
           g.drawLine(35, (i*50 + 200), 65, (i*50 + 200));
           //draws eleven horizontal lines with a length of 30
           
        g.fillOval(45, 745, 10, 10);
        //draws and fills an oval at x-position: 45, y-position: 745, x-radius: 10, and y-radius: 10.
       
       g.setColor(Color.red);
       //sets the color to 'Red'
       
       g.fillRect((targetValue - 10), 750, 20, 5);
       //draws and fills a rectangle at x-position: targetValue - 10, y-position: 750, length: 20, and width: 5
    }
    
   
    
    
    
     public void launch() { 
         
         LiamHoodBallThrowingSimulatorForceVectors force1 = new LiamHoodBallThrowingSimulatorForceVectors(forceMagnitude, timeForceApplied, ballMass, launchAngle);
         //declares a new 'LiamHoodBallThrowingSimulatorForceVectors' object named 'force1', and passes in the parameters of 'forceMagnitude', 'timeForceApplied', 'ballMass', and 'launchAngle'.
        setXVelocity(force1.xVelocity(force1.findVelocity(force1.findImpulse(forceMagnitude, timeForceApplied), ballMass), launchAngle));
        //sets the xVelocity using methods found in the 'LiamHoodBallThrowingSimulatorForceVectors' class
        setYVelocity(force1.yVelocity(force1.findVelocity(force1.findImpulse(forceMagnitude, timeForceApplied), ballMass), launchAngle));
         //sets the yVelocity using methods found in the 'LiamHoodBallThrowingSimulatorForceVectors' class
      
         setXTraversed(computeDistance(getXVelocity(), getYVelocity(), getGravity()));
         Graphics g = getGraphics();
         //declares a new 'Graphics' object naamed g
         
        double x = 45;
        //declares a new double variable named 'x' and sets it to 45
        double y = 745;
        //declares a new double variable named 'y' and sets it to 745
        
       
        //calls the 'defineVelocity' method.
        
       position[0] = 45;
       //sets the '0th' index of position to 'x'
       position[1] = 745;
       //sets the '1st' index of position to y'
        
        while(position[1] <= 745) {
        //loops while 'position[1] is less than or equal to 745
           
            long start = System.currentTimeMillis();
            //declares a variable of type 'long' named 'start' and sets it equal to System.currentTimeMillis()
            
            g.setColor(Color.black);
            //sets the color to 'black'
            g.fillOval((int)position[0], (int)position[1], 10, 10);
            //draws and fills an oval at x-position: position[0] and y-position: position[1] with an x-radius of 10, and a y-radius of 10.
           
           try
            {
                Thread.sleep(10);
                
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            //sleeps for 10 milliseconds
            
            g.setColor(Color.white);
            //sets color to White
            
            g.fillOval((int)position[0], (int)position[1], 10, 10);
            //draws and fills an oval at x-position: position[0] and y-position: position[1] with an x-radius of 10, and a y-radius of 10.
            position[0]+= velocity[0] * .1;
            //increments position[0] by velocity[0] * .1
            
            position[1]-= velocity[1] * .1;
            //decrements position[0] by velocity[1] * .1
            velocity[1]-= gravityValue * .1;
            //decrements velocity[1] by gravityValue * .1
            
            if(position[1] >= 745){
                g.setColor(Color.black);
                g.fillOval((int)position[0], (int)position[1], 10, 10);
            }
            
            g.setColor(Color.black);
            //sets color to black
            g.fillOval((int)position[0], (int)position[1], 10, 10);
            //draws and fills an oval at x-position: position[0] and y-position: position[1] with an x-radius of 10, and a y-radius of 10.
           
            long finish = System.currentTimeMillis();
            //declares a variable of type long named 'finish' to System.currentTimeMillis()
            
            try
            {
                Thread.sleep(100 - (finish-start));
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            //sleeps for (100 - (finish-start)) milliseconds. This ensures this code runs for exactly 100 milliseconds.
           
        }
        System.out.printf("traveled X: %.2f meters\n", getXTraversed());
        //prints the x-distance traveled by the ball
        if((position[0] >= (targetValue - 10)) && (position[0] <= (targetValue + 10))){
            scoreValue++;
            //increments score by one
           
            score.setText("Score: " + scoreValue);
             //prints score
            position[0] = x; 
            position[1] = y;
            //sets position[0] = 45 and position[1] = 745
            setTarget(targetGen());
            //calls the targetGen method and sets target to this value
            target.setText("Target: " + (getTarget() - 45));
            //sets target text to 'target: ' followed by a call to 'geTarget()'
              repaint();
              //calls the repaint method
            enterValues();
             //calls the 'enterValues' method
            }
        else
        {
            System.out.println("Game Over!");
            //prints 'game over'
            System.out.println("Final Score: " + scoreValue + "\n");
            //prints the final score
            scoreValue = 0;
            //sets the score to 0
        }
    }
    
    public double computeDistance(double xVelocity, double yVelocity, double gravityValue)
    {
        
        double timeInFlight = (yVelocity * 2)/gravityValue;
        double xTraversed = timeInFlight * xVelocity;
        return xTraversed;
    }
    
    public static int targetGen()
    {
        int target = (int)(405 * Math.random() + 95);
       //randomly generates a value for 'target' that is between 95 and 500
        System.out.println("Target: " + (target - 45) + "m");
       //displays 'target' 
       return target;
       //returns target
    }
    
   public LiamHoodBallThrowingSimulatorBall(int targetValue, int scoreValue)
   {  
       this.targetValue = targetValue;
      // this.forceMagnitude = forceMagnitude;
      // this.timeForceApplied = timeForceApplied;
      // this.ballMass = ballMass;
      // this.launchAngle = launchAngle;
       //sets 'targetValue' to the variable passed through the parameters
       this.scoreValue = scoreValue;
       //sets the value of score to 'scoreValue' using a call to 'setScore' method
        
       gravity.setBounds(15, 160, 150, 50);
        xAxis.setBounds(525, 735, 50, 15);
        yAxis.setBounds(55, 210, 50, 15);
        buttonJupiter.setBounds(305, 143, 75, 15);
        buttonMars.setBounds(187, 143, 75, 15);
          buttonSaturn.setBounds(460, 143, 75, 15);
           buttonEarth.setBounds(57, 143, 75, 15);
           score.setBounds(250, 160, 50, 50);
            target.setBounds(500, 160, 75, 50);
          //sets the bounds for 'gravity', 'xAxis', 'yAxis', 'buttonJupiter', 'buttonMars', 'buttonSaturn', 'buttonEarth', 'score' and 'target'.
            
       gravity.setText("Gravity: " + gravityValue);      
       xAxis.setText("500m");
        yAxis.setText("500m");
        buttonMars.setText("Mars");
        buttonJupiter.setText("Jupiter");
        buttonSaturn.setText("Saturn");
        score.setText("Score: " + scoreValue);
        target.setText("Target: " + (targetValue - 45));
         buttonEarth.setText("Earth");
         //sets the text for 'gravity', 'xAxis', 'yAxis', 'buttonJupiter', 'buttonMars', 'buttonSaturn', 'buttonEarth', 'score' and 'target'.
         
         buttonMars.setFocusable(false);
          buttonJupiter.setFocusable(false);
          buttonSaturn.setFocusable(false);
           buttonEarth.setFocusable(false);
           //sets the focusable for 'buttonJupiter', 'buttonMars', 'buttonSaturn', and 'buttonEarth' to false
        
        ActionListener marsListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gravityValue = 3.71;
                //sets gravity to 3.71
                gravity.setText("Gravity: " + gravityValue);
                //displays gravity
            }
        };
        //actionListener for the Mars button  
        
        ActionListener jupiterListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gravityValue = 24.79;
                //sets gravity to 24.79
                gravity.setText("Gravity: " + gravityValue);
                //displays gravity
            }
        };
        //actionListener for the Jupiter button  
        
        ActionListener saturnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gravityValue = 10.44;
                //sets gravity to 10.44
                gravity.setText("Gravity: " + gravityValue);
                //displays gravity
            }
        };
        //actionListener for the Saturn button  
        
            add(target);
            //adds target
       
      ActionListener earthListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gravityValue = 9.81;
                //sets gravity to 9.81
                gravity.setText("Gravity: " + gravityValue);
               //displays gravity
            }
        };
        //actionListener for the Earth button  
        
        buttonEarth.addActionListener(earthListener);
        buttonSaturn.addActionListener(saturnListener);
        buttonJupiter.addActionListener(jupiterListener);
        buttonMars.addActionListener(marsListener);
        //adds each action listener
      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the Default close operation of JFrame
        this.setLayout(null);
        //sets the layout of JFrame to 'null'
        this.setSize(600, 800);
        //sets the size of JFrame to 600 by 800.
        this.setVisible(true);
        //sets JFrame to true
        
        this.add(buttonEarth);
        this.add(buttonMars);
        this.add(buttonJupiter);
        this.add(buttonSaturn);
        this.add(xAxis);
        this.add(yAxis);
        this.add(score);
        this.add(gravity);
        //adds 'score', 'buttonEarth', 'buttonMars', 'buttonJupiter', 'buttonSaturn', 'xAxis', 'yAxis', and 'gravity' to JFrame
        
        enterValues();
        //calls the enterValues method
   }
   
   public void enterValues()
   {
       gravityValue = 0;
       gravity.setText("Gravity: " + gravityValue);
       //sets the value of 'gravity'
       System.out.println("Please select a planet");
       //prompts the user to select a planet
       while(gravityValue == 0){
         if(gravityValue != 0)
             break;
          try
          {
              Thread.sleep(10);
          }
          catch (InterruptedException ie)
          {
              ie.printStackTrace();
          }
          //creates a 10 millisecond delay
          
           //leaves the loop once the user selects a planet
    }
    //iterates until the user selects a planet
       while(true){
        System.out.print("Enter the magnitude of force exerted on the ball (enter a double from 1N to 14N): ");
        //prompts the user to enter a value for the magnitude of force exerted on the ball
        scan = new Scanner(System.in);        
        //assigns a new Scanner value to the object 'scan'
        if(scan.hasNextDouble())
        //enters the if-loop only when a double value is scanned
        {
           double forceMagnitudeEntry = scan.nextDouble();
           //declares a double variable named 'forceMagnitudeEntry' and sets it to the value of the double value scanned
            if((forceMagnitudeEntry >= 1 && forceMagnitudeEntry <= 14)){
                forceMagnitude = forceMagnitudeEntry;    
                break;
            }
                //if entered value is between 1 and 14, sets the value of 'forceMagnitude' to 'forceMagnitudeEntry', and leaves the while loop
        }
        System.out.println("Please enter a valid value between 1 and 14");
        //asks the user to enter a valid value from 1 to 14
    }
    
    while(true) {
        System.out.print("Enter the time the force is exerted on the ball (enter a double from 1s to 5s): ");
        //prompts the user to enter a value for the duration which the force is exerted on the ball
         scan = new Scanner(System.in);  
         //assigns a new Scanner value to the object 'scan'
        if(scan.hasNextDouble()) {
            //enters the if-loop only when a double value is scanned
            double timeForceAppliedEntry = scan.nextDouble();
            //declares a double variable named 'timeForceAppliedEntry' and sets it to the value of the double value scanned
            if(timeForceAppliedEntry >= 1 && timeForceAppliedEntry <=5){
                timeForceApplied = timeForceAppliedEntry;
                break;
            }
                //if entered value is between 1 and 5, leaves the while loop
        }
        System.out.println("Please enter a value between 1 and 5");
         //asks the user to enter a value from 1 to 5
    }
    while(true)
    {
        System.out.print("Enter the mass of the ball from (enter a double from 1Kg to 20Kg): ");
        //prompts the user to enter a value for the mass of the ball
        scan = new Scanner(System.in);  
         //assigns a new Scanner value to the object 'scan'
        if(scan.hasNextDouble())
        //enters the if-loop only when a double value is scanned
        {
            double ballMassEntry = scan.nextDouble();
             //declares a double variable named 'ballMassEntry' and sets it to the value of the double value scanned
            if(ballMassEntry >= 1 && ballMassEntry <= 20){
                ballMass = ballMassEntry;
                break;
            }
                //if entered value is between 1 and 20, sets the value of 'ballMass' to 'ballMassEntry', and leaves the while loop
        }
        System.out.println("Please enter a value between 1 and 20");
        //asks the user to enter a value from 1 to 20
    }
    while(true)
    {
        System.out.print("Enter the launch angle from 10° to 80°: ");
        //prompts the user to enter a value for the launch angle of the ball
        scan = new Scanner(System.in);  
        //assigns a new Scanner value to the object 'scan'
        if(scan.hasNextDouble())
        //enters the if-loop only when a double value is scanned
        {
            double launchAngleEntry = scan.nextDouble();
            //declares a double variable named 'launchAngleEntry' and sets it to the value of the double value scanned
            if(launchAngleEntry >= 10 && launchAngleEntry <= 80){
                launchAngle = launchAngleEntry;
                break;
            }
                //if entered value is between 10 and 80, sets the value of 'launchAngle' to 'launchAngleEntry', and leaves the while loop
        }
        System.out.println("Please enter a value between 10° to 80°: ");
         //asks the user to enter a value from 10 to 80
        
    }
     //sets forceMagnitude, timeForceApplied, ballMass, and launchAngle
   
     fire();
    //calls the 'fire' method
    
        
   }
   
   public void fire()
   {
           while(true) {
        System.out.print("Enter 'Fire': ");
        String fire = scan.next();
        //prompts the user to enter the string 'fire' then stores this value into 'fire' String variable
        if(fire.toUpperCase().equals("FIRE") && (gravityValue != 0)){
            launch();
            break;
        }
        //if string variable 'fire' converted to its uppercase is equal to 'FIRE' and gravity is not equal to 0, calls the launch method then exits the while loop.
        if(gravityValue == 0)
            System.out.println("Please Select a planet by clicking on a button, (if no buttons are showing up, resize the window)");
        //if gravity is equal to 0, prompts the user to select a planet
        if(!fire.toUpperCase().equals("FIRE"))
            System.out.println("Please enter 'Fire'");
        //if the String variable 'fire' is not equal to 'FIRE', prompts the user to enter 'Fire'
    }
   }

   public void actionPerformed(ActionEvent e)
   {
      launch();
   }
   //Used to override a method from the 'ActionListener' interface
   
   /************************** setters (Mutators)**************************/
   public void setForceMagnitude(double forceMagnitude)
   {
       //super.setForceMagnitude(forceMagnitude);
       this.forceMagnitude = forceMagnitude;
   }
   //sets the value for 'forceMagnitude'
  public void setTimeForceApplied(double timeForceApplied)
   {
       this.timeForceApplied = timeForceApplied;
   }
   //sets the value for 'timeForceApplied'
    public void setLaunchAngle(double launchAngle)
   {
       this.launchAngle = launchAngle;
   }
   //sets the value for 'launchAngle'
   public void setBallMass(double ballMass)
   {
       this.ballMass = ballMass;
   }
   //sets the value for 'ballMass'
   public void setGravity(double gravityValue)
   {
       this.gravityValue = gravityValue;
   }
   //sets the value of 'gravityValue'
    public void setXVelocity(double xVelocity)
   {
       velocity[0] = xVelocity;
   }
   //sets the value for 'xVelocity'
   public void setYVelocity(double yVelocity)
   {
       velocity[1] = yVelocity;
   }
   //sets the value for 'yVelocity'
   public void setXPosition(double xPosition)
   {
       position[0] = xPosition;
   }
   //sets the value for 'xPosition'
   public void setYPosition(double yPosition)
   {
       position[1] = yPosition;
   }
   //sets the value for 'yPosition'
   public void setTarget(int target)
   {
       this.targetValue = target;
   }
   //sets the value for 'targetValue'
   
   /***************** Getters (Accessors)************/
   public double getForceMagnitude()
   {
       return forceMagnitude;
   }
   //retrieves the value for 'forceMagnitude'
   public double getTimeForceApplied()
   {
       return timeForceApplied;
   }
   //retrieves the value for 'timeForceApplied'
   public double getLaunchAngle()
   {
       return launchAngle;
   }
   //retrieves the value for 'launchAngle'
   public double getBallMass()
   {
       return ballMass;
   }
   //retrieves the value for 'ballMass'
   public double getGravity()
   {
       return gravityValue;
   }
   //returns the value of 'gravityValue'
   public double getXVelocity()
   {
       return velocity[0];
   }
   //retrieves the value for xVelocity or velocity[0]
   public double getYVelocity()
   {
       return velocity[1];
   }
   //retrieves the value for yVelocity or velocity[1]
   public double getXPosition()
   {
       return position[0];
   }
   //retrieves the value for xPosition or position[0]
   public double getYPosition()
   {
       return position[1];
   }
  //retrieves the value for yPosition or position[1]
   public int getTarget()
   {
       return targetValue;
   }
   //retrieves the value for targetValue
   
   public double getXTraversed()
   {
       return xTraversed;
   }
   public void setXTraversed(double xTraversed)
   {
       this.xTraversed = xTraversed;
   }
}
/*
Target: 98m
Please select a planet
Enter the magnitude of force exerted on the ball (enter a double from 1N to 14N): 10
Enter the time the force is exerted on the ball (enter a double from 1s to 5s): 3.1
Enter the mass of the ball from (enter a double from 1Kg to 20Kg): 1
Enter the launch angle from 10° to 80°: 45
Enter 'Fire': fire
traveled X: 100.83 meters
Target: 403m
Please select a planet
Enter the magnitude of force exerted on the ball (enter a double from 1N to 14N): 10
Enter the time the force is exerted on the ball (enter a double from 1s to 5s): 3.8667
Enter the mass of the ball from (enter a double from 1Kg to 20Kg): 1
Enter the launch angle from 10° to 80°: 45
Enter 'Fire': fire
traveled X: 407.39 meters
Target: 264m
Please select a planet
Enter the magnitude of force exerted on the ball (enter a double from 1N to 14N): 10
Enter the time the force is exerted on the ball (enter a double from 1s to 5s): 2
Enter the mass of the ball from (enter a double from 1Kg to 20Kg): 3
Enter the launch angle from 10° to 80°: 45
Enter 'Fire': fire
traveled X: 5.19 meters
Game Over!
Final Score: 2
*/