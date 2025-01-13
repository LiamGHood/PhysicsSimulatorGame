/* Author: Liam Hood
 * Date: 4/29/24
 * School: Thales Academy Rolesville
 * Program Name: LiamHoodBallThrowingSimulatorTester
 * Description: This program simulates kinematics and the parabolic path of a launched projectile. Additionally, it enables the user to set variable values for the time the force is applied, the magnitude of force, the angle of launch, gravity, and the mass of the ball.
 * Difficulties: The difficulties for this final project were three-fold, mainly creating the GUI, updating score, and programming buttons for each planet to set the appropriate value for gravity. I solved the problem of implementing a GUI through utilizing a YouTube channel named 'Bro Code' who has a 30 part mini-series on coding a GUI in java (https://www.youtube.com/watch?v=-IMys4PCkIA&t=92s&pp=ygUUQnJvIENvZGUgYnV0dG9uIGphdmE%3D), following his tutorials, I successfully implemented actionlisteners, buttons, and animation into my project. To solve the problem of updating the score I utilized a geeksForGeeks article for creating JLabels (https://www.geeksforgeeks.org/jlabel-java-swing/)
 * What I learned: In this program, I learned how to create a GUI, animation, buttons, and JLabels. I also learned that a programming project may seem initially impossible especially if it involves coding with concepts that have not been learned, however through enough consistent hard work, one can overcome these obstacles.
 */

public class LiamHoodBallThrowingSimulatorTester
{
    public static void main(String[] args)
    {
       int score = 0;
       //declares an integer variable named 'score' and sets it to 0
       
       LiamHoodBallThrowingSimulatorBall ball1 = new LiamHoodBallThrowingSimulatorBall(LiamHoodBallThrowingSimulatorBall.targetGen(), score);
       //instantiates a new object of class 'LiamHoodBallThrowingSimulator' named 'ball1' and passes the parameters 'targetGen()' and 'score'
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