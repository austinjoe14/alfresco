package src.com.jwt.struts.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class BusForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	// required variables for bus
	private String busName;
	private int busId;
	private String busType;
	private String busNumber;
	private int seats;
	private int seatNumber;
	private String routeId;
	private String type;
	private String startingPoint;
	private String endPoint;
	private String day;
	private String date;
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	private List<BusForm> list;
	private String route;
	private String time;
	private int ticketId;
	private int ticketRate;
	private int totalseats;
	/**
	 * @return the totalseats
	 */
	public int getTotalseats() {
		return totalseats;
	}
	/**
	 * @param totalseats the totalseats to set
	 */
	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	private String userName;
	private int age;
	private int contact;
	private String email;
	private int passengerId;
	private String gender;
	/**
	 * @return the busName
	 */
	public String getBusName() {
		return busName;
	}
	/**
	 * @param busName the busName to set
	 */
	public void setBusName(String busName) {
		this.busName = busName;
	}
	/**
	 * @return the busId
	 */
	public int getBusId() {
		return busId;
	}
	/**
	 * @param busId the busId to set
	 */
	public void setBusId(int busId) {
		this.busId = busId;
	}
	/**
	 * @return the busType
	 */
	public String getBusType() {
		return busType;
	}
	/**
	 * @param busType the busType to set
	 */
	public void setBusType(String busType) {
		this.busType = busType;
	}
	/**
	 * @return the busNumber
	 */
	public String getBusNumber() {
		return busNumber;
	}
	/**
	 * @param busNumber the busNumber to set
	 */
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	/**
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}
	/**
	 * @return the seatNumber
	 */
	public int getSeatNumber() {
		return seatNumber;
	}
	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	/**
	 * @return the routeId
	 */
	public String getRouteId() {
		return routeId;
	}
	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the startingPoint
	 */
	public String getStartingPoint() {
		return startingPoint;
	}
	/**
	 * @param startingPoint the startingPoint to set
	 */
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	/**
	 * @return the endPoint
	 */
	public String getEndPoint() {
		return endPoint;
	}
	/**
	 * @param endPoint the endPoint to set
	 */
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	/**
	 * @return the date
	 */
	
	/**
	 * @return the list
	 */
	public List<BusForm> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<BusForm> list) {
		this.list = list;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the ticketId
	 */
	public int getTicketId() {
		return ticketId;
	}
	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	/**
	 * @return the ticketRate
	 */
	public int getTicketRate() {
		return ticketRate;
	}
	/**
	 * @param ticketRate the ticketRate to set
	 */
	public void setTicketRate(int ticketRate) {
		this.ticketRate = ticketRate;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the contact
	 */
	public int getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(int contact) {
		this.contact = contact;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the passengerId
	 */
	public int getPassengerId() {
		return passengerId;
	}
	/**
	 * @param passengerId the passengerId to set
	 */
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}
	/**
	 * @param route the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusForm [busName=" + busName + ", busId=" + busId + ", busType=" + busType + ", busNumber=" + busNumber
				+ ", seats=" + seats + ", seatNumber=" + seatNumber + ", routeId=" + routeId + ", type=" + type
				+ ", startingPoint=" + startingPoint + ", endPoint=" + endPoint + ", day=" + day + ", date=" + date
				+ ", list=" + list + ", route=" + route + ", time=" + time + ", ticketId=" + ticketId + ", ticketRate="
				+ ticketRate + ", userName=" + userName + ", age=" + age + ", contact=" + contact + ", email=" + email
				+ ", passengerId=" + passengerId + ", gender=" + gender + "]";
	}
	
	
	

}
