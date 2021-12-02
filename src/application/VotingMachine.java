package application;
import java.util.*;

import javafx.collections.ObservableList;

public class VotingMachine {
	private Vector<Party> parties;
	private Vector<Voter> voters;
	public PersistenceHandler dbHandler;
	private final static VotingMachine INSTANCE = new VotingMachine();
	
	private VotingMachine() {
		parties = new Vector<Party>();
		voters = new Vector<Voter>();
		dbHandler = new MySQLHandler();
		ObservableList<Candidate> candidatesrecords = dbHandler.getCandidatesRecords();
		ObservableList<Party> partyrecords = dbHandler.getPartyRecords();		
		for(int i=0;i<partyrecords.size();i++) {
			parties.add(partyrecords.get(i));
			for(int j=0;j<candidatesrecords.size();j++) {
				if(partyrecords.get(i).getName().equals(candidatesrecords.get(j).getPartyName())) {
					partyrecords.get(i).getCandidates().add(candidatesrecords.get(j));
				}				
			}
		}
		
	}
	
	public static VotingMachine getInstance() {
	    return INSTANCE;
	  }

	public Vector<Party> getParties() {
		return parties;
	}

	public void setParties(Vector<Party> parties) {
		this.parties = parties;
	}

	public Vector<Voter> getVoters() {
		return voters;
	}

	public void setVoters(Vector<Voter> voters) {
		this.voters = voters;
	}
	
	public void addNewParty(Party party) {
		parties.add(party);
		dbHandler.SaveParty(party);
	}
	
	public void addNewCandidate(String pname, Candidate candidate) {
		for(int i=0;i<parties.size();i++) {
			if(parties.elementAt(i).getName().equals(pname)) {
				parties.elementAt(i).addNewCandidate(candidate);
				dbHandler.SaveCandidate(candidate);
				return;
			}
		}
		System.out.println("Party not Found!");
	}
	
	public void addNewVoter(Voter voter) {
		voters.add(voter);
		dbHandler.SaveVoter(voter);
	}
	
	public void CastVote(Candidate candidate) {
		for(int i=0;i<parties.size();i++) {
			for(int j=0;j<parties.elementAt(i).getCandidates().size();j++) {
				if(parties.elementAt(i).getCandidates().elementAt(j).getCNIC().equals(candidate.getCNIC())) {
					parties.elementAt(i).getCandidates().elementAt(j).setVotes(parties.elementAt(i).getCandidates().elementAt(j).getVotes() + 1);
					dbHandler.UpdateVotes(parties.elementAt(i).getCandidates().elementAt(j));
					parties.elementAt(i).setVotes(parties.elementAt(i).getTotalVotes());
					dbHandler.UpdateVotes(parties.elementAt(i));
					return;
				}
			}
			
		}
	}
}
