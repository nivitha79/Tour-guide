package Hello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Hello.sqlDemo;
import Hello.LocationDetails;

public class LocationDao {

	private final String selectQuery = "select id,name,address,lat,lng,city from locations where city=?";

	public List<LocationDetails> getLocationByCity(String city) {
		List<LocationDetails> locationDetails = new ArrayList<>();
		try(Connection connection = sqlDemo.getCon();PreparedStatement stmt = connection.prepareStatement(selectQuery)) {
			stmt.setString(1, city);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				LocationDetails locationDetail = new LocationDetails(rs.getInt("id"), rs.getString("name"), rs.getString("city"), rs.getString("lat"), rs.getString("lng"),
						rs.getString("address"));
				locationDetails.add(locationDetail);
			}
			return locationDetails;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
