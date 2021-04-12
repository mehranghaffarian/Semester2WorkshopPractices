package com.company;

import ir.huri.jcal.JalaliCalendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/**
 * a class for each voting
 * */
public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters = new ArrayList<>();
    private HashMap<String, HashSet<Vote>> polls = new HashMap<>();

    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
    }
    /**
     * @return type
     * */
    public int getType() {return type;}
    /**
     * @return the choices and the votes for each of them
     * */
    public HashMap<String, HashSet<Vote>> getPolls() {return polls;}
    /**
     * @return the folks voted in the voting
     * */
    public ArrayList<Person> getVoters() {return voters;}
    /**
     * @return question
     * */
    public String getQuestion() {return question;}
    /**
     * @param person hwo has voted
     * @param votes are submitted
     * */
    public void vote(Person person, ArrayList<String> votes){
        if(type == 1)
            for(int i = 0;i < votes.size();i++)
                polls.get(votes.get(i)).add(new Vote(person, new JalaliCalendar().toString()));

        else
            polls.get(votes.get(0)).add(new Vote(person, new JalaliCalendar().toString()));

        voters.add(person);
    }
    /**
     * @param choice would be added to the voting
     * */
    public void createChoice(String choice){polls.put(choice, new HashSet<Vote>());}
    /**
     * the number of the votes for each choice would be printed
     * */
    public void printResult(){
        Iterator<String> answers = polls.keySet().iterator();

        while (answers.hasNext()){
            String result = answers.next();

            System.out.println(result + "  " + polls.get(result).size());
        }
    }
    /**
     * the vote details for each choice would be printed
     * */
    public void printVotes(){
        Iterator<String> answers = polls.keySet().iterator();

        while (answers.hasNext()){
            String result = answers.next();

            System.out.println(result);

            for(Vote vote : polls.get(result)) {
                System.out.printf("--");
                System.out.printf("name: %s, date: %s", vote.getPerson().toString(), vote.getDate());
            }
            System.out.println();
        }
    }
}