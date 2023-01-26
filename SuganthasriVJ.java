package SuganthasriVJ;
import robocode.*;

/**
 * SuganthasriVJ - a robot by (Suganthasri)
 */
public class SuganthasriVJ extends JuniorRobot
{
	
	public void run() {
	
		setColors(orange, blue, white, yellow, black);

		// Robot always tries to go forward and then turn right
		while(true) {			
			ahead(50);
			turnRight(20);
			ahead(75);
			turnRight(10);
			ahead(90);
			turnRight(15);
			ahead(75);
			turnRight(25);
			ahead(25);
		}
	}

	public void onScannedRobot() {
	
		out.println("I see my enemy"); 
		out.println("Opennent: " + scannedDistance + ", " + scannedAngle + ", " + scannedBearing);
		//Opennent: show how much distanc
		int scannedDistance_ = scannedDistance;
		
		turnGunTo(scannedAngle + scannedVelocity/2); //scans opponent's speed
		
		if (scannedDistance_ < 75) {
		ahead(10);
		turnGunTo(scannedAngle);
		fire(1);
		}
		if (scannedDistance_ < 150) {
		ahead(10);
		turnGunTo(scannedAngle);
		fire(2);
		}
		else {
		ahead(10);
		turnGunTo(scannedAngle);
		fire(1.5);
		}	
	}

	public void onHitByBullet() {
		
		turnGunTo(scannedAngle);
		turnTo(scannedAngle); //Try to follow the enemy and shot them
		fire(1);
	}
	
	public void onHitWall() {
		// turns right and goes back
		turnRight(45);
		back(30);
	}	
}
