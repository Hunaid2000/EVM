package application;

public class Candidate {
	private String CNIC, Name, PartyName;
	private int Votes;
	
	public Candidate(String cnic, String name, String pname) {
		CNIC = cnic;
		Name = name;
		PartyName = pname;
		Votes = 0;
	}

	public String getCNIC() {
		return CNIC;
	}

	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPartyName() {
		return PartyName;
	}

	public void setPartyName(String partyName) {
		PartyName = partyName;
	}

	public int getVotes() {
		return Votes;
	}

	public void setVotes(int votes) {
		Votes = votes;
	}
	
}
