package application;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MySQLHandler extends PersistenceHandler {
	public MySQLHandler() {}

	@Override
	public void SaveVoter(Voter voter) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers Loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
			System.out.println("Connection Established");
			
			Statement st1 = con.createStatement();
			st1.execute("use EVM");
			
			String sql = "INSERT INTO Voter VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, voter.getCNIC());
			statement.setString(2, voter.getName());
			statement.setString(3, voter.getContact());
			statement.setString(4, voter.getAddress());
			statement.setInt(5, voter.getAge());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Data Saved");
			}
			else {
				System.out.println("Data NOT Saved");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Loaded");
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}
		
	}

	@Override
	public void SaveCandidate(Candidate candidate) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers Loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
			System.out.println("Connection Established");
			
			Statement st1 = con.createStatement();
			st1.execute("use EVM");
			
			String sql = "INSERT INTO Candidate VALUES (?, ?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, candidate.getCNIC());
			statement.setString(2, candidate.getName());
			statement.setString(3, candidate.getPartyName());
			statement.setInt(4, candidate.getVotes());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Data Saved");
			}
			else {
				System.out.println("Data NOT Saved");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Loaded");
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}		
	}

	@Override
	public void SaveParty(Party party) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers Loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
			System.out.println("Connection Established");
			
			Statement st1 = con.createStatement();
			st1.execute("use EVM");
			
			String sql = "INSERT INTO Party VALUES (?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, party.getName());
			statement.setInt(2, party.getVotes());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Data Saved");
			}
			else {
				System.out.println("Data NOT Saved");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Loaded");
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}
	}
	
	public ObservableList<String> getCandidateschoices() {
		ObservableList<Candidate> candidates = getCandidatesRecords();
		ObservableList<String> candidateschoices = FXCollections.observableArrayList();
		for(int i=0;i<candidates.size();i++) {
			String str = candidates.get(i).getPartyName() + "-" + candidates.get(i).getCNIC() + "-" + candidates.get(i).getName();
			candidateschoices.add(str);
		}
		return candidateschoices;
	}
	
	public ObservableList<Candidate> getCandidatesRecords() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers Loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
			System.out.println("Connection Established");
			
			Statement st1 = con.createStatement();
			st1.execute("use EVM");
			
			String sql = "SELECT * FROM CANDIDATE";
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			ObservableList<Candidate> candidates = getCandidatesObjects(rs);
			con.close();
			return candidates;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Loaded");
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}
		return null;
	}
	
	private ObservableList<Candidate> getCandidatesObjects(ResultSet rs) {
		try {
			ObservableList<Candidate> candidates = FXCollections.observableArrayList();
			while (rs.next()) {
				Candidate candidate = new Candidate(rs.getString("cnic"), rs.getString("name"), rs.getString("partyname"));
				candidate.setVotes(rs.getInt("votes"));
				candidates.add(candidate);
			}
			return candidates;
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}
		return null;
	}
	
	public ObservableList<Voter> getVotersRecords() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers Loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
			System.out.println("Connection Established");
			
			Statement st1 = con.createStatement();
			st1.execute("use EVM");
			
			String sql = "SELECT * FROM Voter";
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			ObservableList<Voter> voters = getVotersObjects(rs);
			con.close();
			return voters;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Loaded");
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}
		return null;
	}
	
	private ObservableList<Voter> getVotersObjects(ResultSet rs) {
		try {
			ObservableList<Voter> voters = FXCollections.observableArrayList();
			while (rs.next()) {
				Voter voter = new Voter(rs.getString("cnic"), rs.getString("name"), rs.getString("contact"), rs.getString("address"), rs.getInt("age"));
				voters.add(voter);
			}
			return voters;
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}
		return null;
	}
	
	public ObservableList<Party> getPartyRecords() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers Loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
			System.out.println("Connection Established");
			
			Statement st1 = con.createStatement();
			st1.execute("use EVM");
			
			String sql = "SELECT * FROM PARTY";
			PreparedStatement statement = con.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();
			ObservableList<Party> parties = getPartyObjects(rs);
			con.close();
			return parties;
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Loaded");
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}
		return null;
	}
	
	private ObservableList<Party> getPartyObjects(ResultSet rs) {
		try {
			ObservableList<Party> parties = FXCollections.observableArrayList();
			while (rs.next()) {
				Party party = new Party(rs.getString("name"));
				party.setVotes(rs.getInt("votes"));
				parties.add(party);
			}
			return parties;
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}
		return null;
	}

	@Override
	public void UpdateVotes(Candidate candidate) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers Loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
			System.out.println("Connection Established");
			
			Statement st1 = con.createStatement();
			st1.execute("use EVM");
			
			String sql = "UPDATE Candidate SET votes = ? WHERE cnic = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, candidate.getVotes());
			statement.setString(2, candidate.getCNIC());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Data Updated");
			}
			else {
				System.out.println("Data NOT Updated");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Loaded");
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}
	}

	@Override
	public void UpdateVotes(Party party) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drivers Loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","12345");
			System.out.println("Connection Established");
			
			Statement st1 = con.createStatement();
			st1.execute("use EVM");
			
			String sql = "UPDATE PARTY SET votes = ? WHERE name = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, party.getVotes());
			statement.setString(2, party.getName());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Data Updated");
			}
			else {
				System.out.println("Data NOT Updated");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not Loaded");
		}
		catch (SQLException e) {
			System.out.println("Connection not Established");
		}
		
	}

}
