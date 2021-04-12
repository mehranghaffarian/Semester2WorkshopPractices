package com.company;

import java.util.ArrayList;
/**
 * a class which manages the whole votings
 * */
public class VotingSystem {
    private ArrayList<Voting> voting = new ArrayList<>();
    /**
     * @return the list of voting
     * */
    public ArrayList<Voting> getVoting() {return voting;}
    /**
     * new voting is aded
     * @param question of the new voting
     * @param type of the new voting
     * */
    public void creatVotnig(int type, String question){voting.add(new Voting(type, question));}
    /**
     * @param poll is created as a new voting
     * */
    public void creatVoting(Voting poll){voting.add(poll);}
    /**
     * the list of whole votings is printed
     * */
    public void printListOfVotings(){
        int i = 1;

        for (Voting votingToPrint : voting)
            System.out.println(i++ + ". " + votingToPrint.getQuestion());
    }
}