package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * @version last version
 * @author Mehran Ghaffarian
 * */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        VotingSystem polls = new VotingSystem();
        Voting poll = new Voting(1, "What is the best day of the week?");

        polls.creatVoting(poll);

        poll.createChoice("Saturday");
        poll.createChoice("Sunday");
        poll.createChoice("Monday");
        poll.createChoice("Tuesday");
        poll.createChoice("Wednesday");
        poll.createChoice("Thursday");
        poll.createChoice("Friday");

        System.out.println("Please enter your first name and last name respectively.");
        String userFirstName = scan.nextLine();
        String userLastName = scan.nextLine();

        Person user = new Person(userFirstName, userLastName);

        int choice = 1;

        while (choice != -3){
            System.out.println("-3. exit\n-2. votes\n-1. results\n0. create a new poll.");
            polls.printListOfVotings();

            choice = scan.nextInt();

            if(choice == -2){
                polls.printListOfVotings();

                choice = scan.nextInt();

                polls.getVoting().get(choice - 1).printVotes();
            }
            else if(choice == -1){
                polls.printListOfVotings();

                choice = scan.nextInt();

                polls.getVoting().get(choice - 1).printResult();
            }
            else if(choice == 0){
                System.out.println("Please enter the 1 if you want to have multiple answers in your voting or enter 0 to be able to vote for only one choice.");
                choice = scan.nextInt();

                System.out.println("Please enter the question of the voting.");
                scan.nextLine();
                String question = scan.nextLine();

                Voting newVoting = new Voting(choice, question);
                polls.creatVoting(newVoting);

                System.out.println("Please enter the number of the choices you want to have.");
                choice = scan.nextInt();

                while (choice-- != 0) {
                    System.out.println("Please enter your choice.");
                    String voteChoice = scan.nextLine();

                    if(voteChoice.equals(""))
                        voteChoice = scan.nextLine();

                    if (newVoting.getPolls().containsKey(voteChoice)) {
                        System.out.println("You have added before.");
                        choice++;
                    }
                    else
                        newVoting.createChoice(voteChoice);
                }
                System.out.println("Choices added successfully.");
                choice = 1;
            }
            else if(choice != -3 && !polls.getVoting().get(choice - 1).getVoters().contains(user)){
                Voting current = polls.getVoting().get(choice - 1);

                ArrayList<String> choices = new ArrayList<>(current.getPolls().keySet());
                int index = 1;

                System.out.println(current.getType() == 1 ? "Multiple answer type." : "One answer type.");
                for(String voteChoices : current.getPolls().keySet())
                    System.out.println(index++ + ". " + voteChoices);

                if(current.getType() == 0){
                    System.out.println("Choose only one choice or enter 0 to have a random answer.");
                    choice = scan.nextInt();

                    if(choice > 0 && choice < choices.size()){
                        ArrayList<String> answers = new ArrayList<>();
                        answers.add(choices.get(choice - 1));

                        current.vote(user, answers);
                    }
                    else if(choice == 0){
                        ArrayList<String> answers = new ArrayList<>();
                        Random rand = new Random();

                        answers.add(choices.get(rand.nextInt(choices.size())));

                        current.vote(user, answers);
                    }
                }
                else{
                    System.out.println("Please enter the number of choices you want to vote for.");
                    choice = scan.nextInt();

                    ArrayList<String> answers = new ArrayList<>();

                    while (choice-- != 0) {
                        System.out.println("Choose an index:");
                        int voteChoice = scan.nextInt();

                        if(voteChoice > 0 && voteChoice <= choices.size() && !answers.contains(choices.get(voteChoice - 1)))
                            answers.add(choices.get(voteChoice - 1));

                        else {
                            choice++;
                            System.out.println("Wrong answer.");
                        }
                    }
                    current.vote(user, answers);
                    System.out.println("Vote submitted successfully.");
                }
                choice = 1;
            }
        }
    }
}