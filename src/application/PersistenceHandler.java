package application;

import javafx.collections.ObservableList;

public abstract class PersistenceHandler {
	public PersistenceHandler() {
		
	}
	public abstract void SaveVoter(Voter voter);
	public abstract void SaveCandidate(Candidate candidate);
	public abstract void SaveParty(Party party);
	public abstract void UpdateVotes(Candidate candidate);
	public abstract void UpdateVotes(Party party);
	public abstract ObservableList<Candidate> getCandidatesRecords();
	public abstract ObservableList<String> getCandidateschoices();
	public abstract ObservableList<Party> getPartyRecords();
	public abstract ObservableList<Voter> getVotersRecords();
}
