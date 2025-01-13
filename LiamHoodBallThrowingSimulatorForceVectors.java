/* Author: Liam Hood
 * Date: 4/29/24
 * School: Thales Academy Rolesville
 * Program Name: LiamHoodBallThrowingSimulatorForceVectors
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
import java.awt.Label;
//imports necessary java packages

public class LiamHoodBallThrowingSimulatorForceVectors
{
    private double forceMagnitude;
    private double timeForceApplied;
    private double ballMass;
    private double launchAngle;
    private double xVelocity;
    private double yVelocity;
    private double xPosition;
    private double yPosition;
    private double gravity;
    //declares nine private double variables, among which include, 'forceMagnitude', 'timeForceApplied', 'ballMass', 'launchAngle', 'xVelocity', 'yVelocity', 'xPosition', 'yPosition', and 'gravity'
    private int scoreValue;
    private int targetValue;
    //declares two private integer variables named 'scoreValue' and 'targetValue'
    
    public LiamHoodBallThrowingSimulatorForceVectors(double forceMagnitude, double timeForceApplied, double ballMass, double launchAngle)
    {
        this.forceMagnitude = forceMagnitude;
        this.timeForceApplied = timeForceApplied;
        this.ballMass = ballMass;
        this.launchAngle = launchAngle;
    }
    
  
    
    public double findImpulse(double forceMagnitude, double timeForceApplied)
    {
        double impulse = forceMagnitude * timeForceApplied;
        //declares a new double variable named 'impulse' and sets it equal to 'forceMagnitude' * 'timeForceApplied'
        return impulse;
    }
    //computes the impulse through multiplying forceMagnitude and timeForceApplied, then returns this value.
    
    public double findVelocity(double impulse, double ballMass)
    {
        double velocity = impulse / ballMass;
        //declares a new double variable named 'velovity' and computes it through dividing 'impulse' by 'ballMass'
        return velocity;
    }
    //computes velocity through dividing impulse by the mass of the ball then returns the value of velocity as a double
    
    public double xVelocity(double velocity, double launchAngle)
    {
        double cosine = Math.cos(launchAngle * Math.PI/180);
        //declares a double variable named 'cosine' and sets it equal to the cosine of 'launchAngle' in radians.
        double xVelocity = velocity * cosine;
        //computes 'xVelocity' through multiplying 'velocity' by 'cosine'
        return xVelocity;
    }
    //computes the x-component of velocity
    public static double yVelocity(double velocity, double launchAngle)
    {
        double sine = Math.sin(launchAngle * Math.PI/180);
        //declares a double variable named 'sine' and sets it equal to the sine of 'launchAngle' in radians
        double yVelocity = velocity * sine;
        //computes 'yVelocity'
        
       
        return yVelocity;
    }
    //computes the y-component of velocity
    
    /***************** Setters (Mutators) ******************/
    public void setTarget(int targetValue)
    {
        this.targetValue = targetValue;
    }
    //sets the value of 'targetValue'
     public void setScore(int score)
    {
        this.scoreValue = score;
    }
    //sets the value of 'scoreValue'
    public void setXVelocity(double xVelocity)
    {
        this.xVelocity = xVelocity;
    }
    //sets the value of 'xVelocity'
     public void setYVelocity(double yVelocity)
    {
        this.yVelocity = yVelocity;
    }
    //sets the value of 'yVelocity'
    public void setGravity(double gravity)
    {
        this.gravity = gravity;
    }
    //sets the value of 'gravity'
    public void setTimeForceApplied(double timeForceApplied)
    {
        this.timeForceApplied = timeForceApplied;
    }
    //sets the value of 'timeForceApplied'    
    public void setBallMass(double ballMass)
    {
        this.ballMass = ballMass;
    }
    //sets the value of 'ballMass'
    public void setYPosition(double yPosition)
   {
       this.yPosition = yPosition;
   }
   //sets the value of 'yPosition'
   public void setXPosition(double xPosition)
   {
       this.xPosition = xPosition;
   }
   //sets the value of 'xPosition'
    public void setLaunchAngle(double launchAngle)
    {
        this.launchAngle = launchAngle;
    }
    //sets the value of 'launchAngle'
    public void setForceMagnitude(double forceMagnitude)
    {
        this.forceMagnitude = forceMagnitude;
    }
    //sets the value of 'forceMagnitude'
    
    /********************* Getters (Accessors) *******************/
    public int getTarget()
    {
        return targetValue;
    }
    //retrieves the value of 'targetValue'
     public int getScore()
    {
        return scoreValue;
    }
    //retrieves the value of 'scoreValue'
    public double getXVelocity()
    {
        xVelocity = xVelocity(findVelocity(findImpulse(forceMagnitude, timeForceApplied), ballMass), launchAngle);
        return xVelocity;
    }
    //retrieves the value of 'xVelocity'
    public double getYVelocity()
    {
        yVelocity = yVelocity(findVelocity(findImpulse(forceMagnitude, timeForceApplied), ballMass), launchAngle);
        return yVelocity;
    }
    //retrieves the value of 'yVelocity'
     public double getGravity()
    {
        return gravity;
    }
    //retrieves the value of 'gravity'
   public double getForceMagnitude()
    {
        return forceMagnitude;
    }
    //retrieves the value of 'forceMagnitude'
    
    
    public double getBallMass()
    {
        return ballMass;
    }
    //retrieves the value of 'ballMass'
    public double getTimeForceApplied()
    {
        return timeForceApplied;
    }
    //retrieves the value of 'timeForceApplied'
    public double getLaunchAngle()
    {
        return launchAngle;
    }
    //retrieves the value of 'launchAngle'
   public double getXPosition()
   {
       return xPosition;
   }
   //retrieves the value of 'xPosition'
   public double getYPosition()
   {
       return yPosition;
   }
   //retrieves the value of 'yPosition'
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