package za.co.gli.game;

import org.apache.log4j.Logger;

import za.co.gli.service.CarRacingService;

public class Application {
	private static final Logger LOG = Logger.getLogger(Application.class);
	
	public static void main(String args[]) {
		LOG.debug("Enter main.");
		
		if(args.length == 0){
			System.out.println("Usage : java -jar car-race-game-0.0.1-SNAPSHOT.java");
			return;
		}
		
		CarRacingService race = new CarRacingService();
		race.race(args[0]);
		
		LOG.debug("Exit main.");
	}
}
