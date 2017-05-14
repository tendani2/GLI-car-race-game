package za.co.gli.model;



/**
 * Car object
 * @author Tendani Munyai
 *
 */
public class Car implements Comparable<Car>{
	
	/** Acceleration - car performance when acceleration. */
	private Integer acceleration;
	/** Top speed of a car - top speed of the car. */
	private Integer topSpeed;
	/** corner performance of a car - car performance on the corner. */
	private Integer corner;
	/** totalAccelerations - sum of car. */
	private Integer totalAcceleration;
	/** Car registration - uniquely identifies the car. */
	private String registration;
	
	public Car(){}
	/**
	 * 
	 * @param acceleration
	 * @param topSpeed
	 * @param corner
	 */
	public Car(	Integer acceleration, 
				Integer topSpeed, 
				Integer corner) {
		
		this.acceleration = acceleration;
		this.topSpeed = topSpeed;
		this.corner = corner;
	}
	
	
	/**
	 * 
	 * @param acceleration
	 * @param topSpeed
	 * @param corner
	 * @param registration
	 */
	public Car(	Integer acceleration, 
				Integer topSpeed, 
				Integer corner, 
				String registration) {
		
		this.acceleration = acceleration;
		this.topSpeed = topSpeed;
		this.corner = corner;
		this.registration = registration;
	}
	/**
	 * 
	 * @param acceleration
	 * @param topSpeed
	 * @param corner
	 * @param totalAcceleration
	 */
	public Car(	Integer acceleration, 
				Integer topSpeed, 
				Integer corner, 
				Integer totalAcceleration) {
		
		this.acceleration = acceleration;
		this.topSpeed = topSpeed;
		this.corner = corner;
		this.totalAcceleration = totalAcceleration;
	}
	/**
	 * Gets acceleration
	 * @return acceleration
	 */
	public Integer getAcceleration() {
		return acceleration;
	}
	/**
	 * Sets acceleration
	 * @param acceleration
	 */
	public void setAcceleration(Integer acceleration) {
		this.acceleration = acceleration;
	}
	/**
	 * Gets top speed
	 * @return topSpeed
	 */
	public Integer getTopSpeed() {
		return topSpeed;
	}
	/**
	 * Sets top speed
	 * @param topSpeed
	 */
	public void setTopSpeed(Integer topSpeed) {
		this.topSpeed = topSpeed;
	}
	/**
	 * Gets corner
	 * @return corner
	 */
	public Integer getCorner() {
		return corner;
	}
	/**
	 * Sets corner
	 * @param corner
	 */
	public void setCorner(Integer corner) {
		this.corner = corner;
	}
	/**
	 * Gets total acceleration.
	 * @return
	 */
	public Integer getTotalAcceleration() {
		return totalAcceleration;
	}
	/**
	 * Sets totalAcceleration
	 * @param totalAcceleration
	 */
	public void setTotalAcceleration(Integer totalAcceleration) {
		this.totalAcceleration = totalAcceleration;
	}
	/**
	 * Gets registration
	 * @return registration
	 */
	public String getRegistration() {
		return registration;
	}
	/**
	 * Sets registration
	 * @param registration
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
	@Override
	public int compareTo(Car o) {
		if(this.totalAcceleration > o.totalAcceleration){
			return -1;
		}
		else if(this.totalAcceleration < o.totalAcceleration){
			return 1;
		}
		return 0;
	}
	@Override
	public String toString() {
		return "Car [acceleration=" + acceleration + ", topSpeed=" + topSpeed + ", corner=" + corner
				+ ", totalAcceleration=" + totalAcceleration + ", registration=" + registration + "]";
	}
}
