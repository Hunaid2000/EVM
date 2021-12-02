package application;
import java.util.*;

public class Party {
	private String Name;
	private Vector<Candidate> candidates;
	private int votes;
	
	public Party(String name) {
		Name = name;
		votes = 0;
		candidates = new Vector<Candidate>();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getTotalVotes() {
		int totalvotes = 0;
		for(int i=0;i<candidates.size();i++) {
			totalvotes += candidates.elementAt(i).getVotes();
		}
		return totalvotes;
	}
	
	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public Vector<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(Vector<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	public void addNewCandidate(Candidate candidate) {
		candidates.add(candidate);
	}
}
