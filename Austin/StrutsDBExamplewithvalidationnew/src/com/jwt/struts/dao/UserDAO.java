package com.jwt.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.jwt.struts.form.BusForm;
import com.jwt.struts.form.LoginForm;
import com.jwt.struts.form.UserForm;

public class UserDAO {

	public boolean loginData(String userName, String passWord, Connection connection) throws SQLException {
		try {
			// DBOperation();
			LoginForm form = new LoginForm();
			System.out.println("in dao " + userName);
			PreparedStatement preparedStatement = connection
					.prepareStatement("select username,password,role_id from login_table  where username=? and password=?");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, passWord);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				form.setUsername(resultSet.getString("username"));
				form.setPassword(resultSet.getString("password"));
				form.setRole(resultSet.getInt("role_id"));
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("SQL statement is not executed!" + ex);
		}
		return false;
	}

	public void insertData(UserForm registerForm, Connection connection) throws Exception {
		try {

			try {
				// DBOperation();
				Statement st = connection.createStatement();
				int value = st
						.executeUpdate("INSERT INTO USER_DETAILS(FIRST_NAME,LAST_NAME,USER_NAME,PASSWORD,EMAIL,PHONE) "
								+ "VALUES('" + registerForm.getFirstName() + "','" + registerForm.getLastName() + "','"
								+ registerForm.getUserName() + "','" + registerForm.getPassword() + "','"
								+ registerForm.getEmail() + "','" + registerForm.getPhone() + "')");
				System.out.println("1 row affected" + value);
			} catch (SQLException ex) {
				System.out.println("SQL statement is not executed!" + ex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BusForm> getBusData(Connection connection) throws Exception {
		List<BusForm> list = new ArrayList<BusForm>();
		try {
			// DBOperation();
			System.out.println("in dao ");

			PreparedStatement preparedStatement = connection.prepareStatement(
					"select bus_id,bus_name,bus_type,seats,bus_no from bus_details");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				BusForm form = new BusForm();
				form.setBusId(resultSet.getInt("bus_id"));
				form.setBusName(resultSet.getString("bus_name"));
				form.setBusType(resultSet.getString("bus_type"));
				form.setSeats(resultSet.getInt("seats"));
				form.setBusNumber(resultSet.getString("bus_no"));
				list.add(form);
				System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean addNewBus(BusForm busForm, Connection connection, String time) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"Insert into bus_details(bus_name,bus_type,bus_no) values(?,?,?)");
			preparedStatement.setString(1, busForm.getBusName());
			preparedStatement.setString(2, busForm.getBusType());
			preparedStatement.setString(3, busForm.getBusNumber());
			
			System.out.println("1 row affected in bus_details");
			
			PreparedStatement preparedStatementOne = connection.prepareStatement(
					"Insert into bus_route_mapping(bus_no,route_id,type,time,day) values(?,?,?,?,?)");
			preparedStatementOne.setString(1, busForm.getBusNumber());
			preparedStatementOne.setString(2, busForm.getRoute());
			preparedStatementOne.setString(3, busForm.getType());
			preparedStatementOne.setString(4, time);
			preparedStatementOne.setString(5, busForm.getDay());
			
			preparedStatement.executeUpdate();
			preparedStatementOne.executeUpdate();
			System.out.println("1 row affected in bus_route_mapping");
			
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL statement is not executed!" + e);
		}
		return false;

	}

	public boolean deleteBus(BusForm busForm, Connection connection) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM BUS_DETAILS WHERE BUS_NO=?");
			preparedStatement.setString(1, busForm.getBusNumber());
			System.out.println(busForm.getBusNumber()+"ghjd");
			int value=preparedStatement.executeUpdate();
			System.out.println(value);
			System.out.println("1 row affected");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL statement is not executed!" + e);
		}
		return false;
	}
	
	public boolean editBus(BusForm busForm, Connection connection) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update bus_details set bus_name=?,bus_type=?,bus_no=?,seats=? where bus_id=?");
			preparedStatement.setString(1, busForm.getBusName());
			preparedStatement.setString(2, busForm.getBusType());
			preparedStatement.setString(3, busForm.getBusNumber());
			preparedStatement.setInt(4, busForm.getSeats());
			preparedStatement.setInt(5, busForm.getBusId());
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL statement is not executed!" + e);
		}
		return false;

	}

	public int getRole(String userName, Connection connection) {
		try {
			// DBOperation();
			LoginForm form = new LoginForm();
			System.out.println("in dao " + userName);
			PreparedStatement preparedStatement = connection
					.prepareStatement("select username,role_id from login_table  where username=?");
			preparedStatement.setString(1, userName);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				form.setUsername(resultSet.getString("username"));
				form.setRole(resultSet.getInt("role_id"));
				int role=resultSet.getInt("role_id");
				return role;
			}
		} catch (SQLException ex) {
			System.out.println("SQL statement is not executed!" + ex);
		}
		return 0;
	}

	public List<BusForm> getBus(String source, String end, Connection connection, String myDate) {
		List<BusForm> list = new ArrayList<BusForm>();
		try {
			// DBOperation();
			System.out.println("in dao ");
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select * from bus_details where bus_no in (select bus_no,route_id from bus_route_mapping where day=? and route_id=(select route_id from route where source=? and destination=?));");
			preparedStatement.setString(1, myDate);
			preparedStatement.setString(2, source);
			preparedStatement.setString(3, end);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet.toString());
			while (resultSet.next()) {
				BusForm form = new BusForm();
				form.setRoute(resultSet.getString("route_id"));
				form.setBusId(resultSet.getInt("bus_id"));
				form.setBusName(resultSet.getString("bus_name"));
				form.setBusType(resultSet.getString("bus_type"));
				form.setSeats(resultSet.getInt("seats"));
				form.setBusNumber(resultSet.getString("bus_no"));
				list.add(form);
				System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Integer> getFemaleSeats(Connection connection, Date date) {
		List<Integer> list = new ArrayList<Integer>();
		try {
			// DBOperation();
			System.out.println("in dao ");
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select seat_number from ticket_mapping where date=? and passenger_id in (select passenger_id from passenger_details where Gender='F');");
			java.util.Date doj = date;
			java.sql.Date DateOfJourney = new java.sql.Date(doj.getTime());
			preparedStatement.setDate(1, DateOfJourney);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet.toString());
			while (resultSet.next()) {
				list.add(resultSet.getInt("seat_number"));
			}
			System.out.println(list.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Integer> getMaleSeats(Connection connection, Date date) {
		List<Integer> list = new ArrayList<Integer>();
		try {
			// DBOperation();
			System.out.println("in dao ");
			PreparedStatement preparedStatement = connection.prepareStatement(
					"select seat_number from ticket_mapping where date=? and passenger_id in (select passenger_id from passenger_details where Gender='M');");
			java.util.Date doj = date;
			java.sql.Date DateOfJourney = new java.sql.Date(doj.getTime());
			preparedStatement.setDate(1, DateOfJourney);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet.toString());
			while (resultSet.next()) {
				list.add(resultSet.getInt("seat_number"));
			}
			System.out.println(list.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean bookSeats(List<Integer> id, List<String> list, Connection connection, String date, String busNumber) {
		try {
			PreparedStatement preparedStatement = null;
			for(int i=0;i<list.size();i++){
			preparedStatement = connection.prepareStatement(
					"insert into ticket_mapping(seat_number,passenger_id,bus_no,date) "
								+ "VALUES('" + list.get(i) + "','" + id.get(i) + "','" + busNumber + "','" + date + "')");
					System.out.println("seat added is "+ list.get(i) + "for " + id.get(i) + "on " +date);
					preparedStatement.executeUpdate();
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL statement is not executed!" + e);
		}
		return false;
		
	}

	public int getPassengerId(BusForm busForm, Connection connection) {
		try {
			// DBOperation();
			UserForm form = new UserForm();
			System.out.println("in dao " + busForm.getUserName());
			System.out.println("in dao " + busForm.getContact());
			PreparedStatement preparedStatement = connection
					.prepareStatement("select passenger_id from passenger_details  where name=? and contact=?");
			preparedStatement.setString(1, busForm.getUserName());
			preparedStatement.setInt(2, busForm.getContact());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				form.setPassengerId(resultSet.getInt("passenger_id"));
				int role=resultSet.getInt("passenger_id");
				return role;
			}
		} catch (SQLException ex) {
			System.out.println("SQL statement is not executed!" + ex);
		}
		return 0;
		
	}

	public List<Integer> insertPassengerDetails(Connection connection, List<BusForm> forms) {
		PreparedStatement preparedStatement;
		PreparedStatement preparedStatementforPid;
		Iterator<BusForm> iterator=forms.iterator();
		List<Integer> pid=new ArrayList<Integer>();
		while(iterator.hasNext()){
			BusForm passenger=new BusForm();
			passenger=iterator.next();
			String passengerName=passenger.getUserName();
			
		    String gender=  passenger.getGender();
		    int contact= passenger.getContact();
		    int age=passenger.getAge();
		    System.out.println(passengerName+"  "+gender+"  "+age+"  "+contact);
			try {
				preparedStatementforPid=connection.prepareStatement("select passenger_id from PASSENGER_DETAILS where name=? and age=? and gender=? and contact=?");
				preparedStatementforPid.setString(1, passengerName);
				preparedStatementforPid.setInt(2,age);
				preparedStatementforPid.setString(3,gender);
				preparedStatementforPid.setInt(4, contact);
				ResultSet rs1=preparedStatementforPid.executeQuery();
				System.out.println(rs1);
				if(rs1.next()){
					System.out.println(rs1.getInt("passenger_id"));
					System.out.println("already exists");
				}
				else{
				preparedStatement = connection.prepareStatement("INSERT INTO PASSENGER_DETAILS(NAME,AGE,GENDER,CONTACT) VALUES(?,?,?,?)");
				preparedStatement.setString(1,passengerName);
				preparedStatement.setInt(2,age);
				preparedStatement.setString(3,gender);
				preparedStatement.setInt(4,contact);
				preparedStatement.executeUpdate();
				}
				preparedStatementforPid=connection.prepareStatement("select passenger_id from PASSENGER_DETAILS where name=? and age=? and gender=? and contact=?");
				preparedStatementforPid.setString(1, passengerName);
				preparedStatementforPid.setInt(2,age);
				preparedStatementforPid.setString(3,gender);
				preparedStatementforPid.setInt(4, contact);
				ResultSet rs=preparedStatementforPid.executeQuery();
				while(rs.next()){
					pid.add(rs.getInt("passenger_id"));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		Iterator<Integer> it=pid.iterator();
		while(it.hasNext()){
			System.out.println("PID: "+it.next());
		}
		return pid;
	}
	public List<String> findPickupPoints(Connection connection, String busno, String day, String routeID) {
		List<String> pickupPoints=new ArrayList<String>();
		System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII"+busno+day+routeID);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select location from bus_route_mapping where bus_no=? and day=? and route_id=? and type in('source','pickup')");
			preparedStatement.setString(1, busno);
			preparedStatement.setString(2, day);
			preparedStatement.setString(3, routeID);
			ResultSet rs=preparedStatement.executeQuery();
			System.out.println("Pickup Points");
			while(rs.next()){
				pickupPoints.add(rs.getString("location"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return pickupPoints;
	}

	public List<String> findDroppingPoints(Connection connection, String busno, String day, String routeID) {
		List<String> dropPoints=new ArrayList<String>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select location from bus_route_mapping where bus_no=? and day=? and route_id=? and type in('drop','destination')");
			preparedStatement.setString(1, busno);
			preparedStatement.setString(2, day);
			preparedStatement.setString(3, routeID);
			ResultSet rs=preparedStatement.executeQuery();
			System.out.println("Dropping Points");
			while(rs.next()){
				dropPoints.add(rs.getString("location"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dropPoints;
	}
	
}