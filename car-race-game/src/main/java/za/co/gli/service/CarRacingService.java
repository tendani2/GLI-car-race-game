package za.co.gli.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import za.co.gli.game.Application;
import za.co.gli.model.Car;
import za.co.gli.model.Track;
import za.co.gli.util.GameUtils;
import za.co.gli.util.InvalidDataException;
import za.co.gli.util.ReadConfig;

public class CarRacingService {
	/** Race track */
	private Track track;
	/** Config location */
	private String configUrl;
	/** List of cars */
	private List<Car> cars;
	/** Total acceleration. */
	private List<Integer> totals;
	/** Logger */
	private static final Logger LOG = Logger.getLogger(CarRacingService.class);

	/**
	 * Initialize
	 */
	private void init() {
		LOG.debug("Enter Initialising variables.");
		
		this.cars = new ArrayList<Car>();
		this.totals = new ArrayList<Integer>();
		
		LOG.debug("Exit Initialising variables.");
	}

	/**
	 * Start racing.
	 */
	public void race(String configUrl) {
		LOG.debug("Enter race(String configUrl.");
		
		this.init();
		// Set config url.
		this.configUrl = configUrl;
		
		// Read from config file.
		this.readConfig();

		for (Car car : this.cars) {
			try {
				race(car);
			} catch (InvalidDataException e) {
				System.out.println(e.getMessage());
			}
		}
		this.win();
		
		LOG.debug("Enter race(String configUrl.");
		
	}

	/**
	 * Race a car.
	 * 
	 * @param car
	 * @throws InvalidDataException 
	 */
	private void race(Car car) throws InvalidDataException {
		LOG.debug("Enter race(Car car) throws InvalidDataException");
		
		int accelerate = 0;
		int sum = 0;
		final char STRAIGHT = '0';
		final char CORNER   = '1';

		for (int i = 0; i < track.getTrack().length(); i++) {
			// If straight
			if (track.getTrack().charAt(i) == STRAIGHT) {
				// If top speed not reached, accelerate.
				accelerate += car.getAcceleration();
				if (accelerate < car.getTopSpeed()) {
					LOG.debug(car.getRegistration() +" is accelerating on a straight line : TOP SPEED REACHED == FALSE");
					
					this.totals.add(accelerate);
				} else {
					LOG.debug(car.getRegistration() +" is accelerating on a straight line : TOP SPEED REACHED == TRUE");
					
					accelerate = car.getTopSpeed();
					this.totals.add(accelerate);
				}
			} else if(track.getTrack().charAt(i) == CORNER){
				LOG.debug(car.getRegistration() +" is on the corner.");
				
				accelerate = car.getCorner();
				this.totals.add(accelerate);
			}
			else {
				LOG.error("Invad characters in track data.");
				throw new InvalidDataException("Invad characters in track data.");
			}
		}
		
		// Get totals
		sum = GameUtils.sum(totals);
		// Reset totals.
		this.totals = new ArrayList<>();
		car.setTotalAcceleration(sum);
		
		LOG.debug("Enter race(Car car) throws InvalidDataException");
	}

	/**
	 * Check who won.
	 */
	private void win() {
		for (Car car : this.cars) {
			this.totals.add(car.getTotalAcceleration());
		}
		
		GameUtils.sort(cars);
		
		System.out.println("------------------ Race results ----------------------");
		for(Car car : this.cars){
			System.out.println(car.getRegistration() + " total : "+ car.getTotalAcceleration());
		}
		System.out.println();
		System.out.println(cars.get(0).getRegistration() +" won the race.");
		
	}

	/**
	 * Read config file.
	 */
	private void readConfig() {
		LOG.debug("Enter readConfig");
		
		Properties prop = null;

		try {
			prop = ReadConfig.getPropValues(this.configUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Car A attributes from config file.
		this.cars.add(new Car(Integer.valueOf(prop.getProperty("car.a.acceleration")),
				Integer.valueOf(prop.getProperty("car.a.top.speed")),
				Integer.valueOf(prop.getProperty("car.a.cornering")), "Car A"));

		// Car A attributes from config file.
		this.cars.add(new Car(Integer.valueOf(prop.getProperty("car.b.acceleration")),
				Integer.valueOf(prop.getProperty("car.b.top.speed")),
				Integer.valueOf(prop.getProperty("car.b.cornering")), "Car B"));

		// Car A attributes from config file.
		this.cars.add(new Car(Integer.valueOf(prop.getProperty("car.c.acceleration")),
				Integer.valueOf(prop.getProperty("car.c.top.speed")),
				Integer.valueOf(prop.getProperty("car.c.cornering")), "Car C"));

		// Car A attributes from config file.
		this.cars.add(new Car(Integer.valueOf(prop.getProperty("car.d.acceleration")),
				Integer.valueOf(prop.getProperty("car.d.top.speed")),
				Integer.valueOf(prop.getProperty("car.d.cornering")), "Car D"));

		// Get track from config file.
		this.track = new Track(prop.getProperty("track"));
		
		LOG.debug("Exit readConfig");
	}
}
