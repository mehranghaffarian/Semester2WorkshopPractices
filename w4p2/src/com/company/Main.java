package com.company;

import java.util.Locale;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * performs the program
 * @mehran
 * */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection pop = new MusicCollection();
        MusicCollection favorite = new MusicCollection();

        Musics music1 = new Musics("shakira", "Desktop/music1", 1998);
        Musics music2 = new Musics("jenifer", "Desktop/music2", 1999);
        Musics music3 = new Musics("reza sadeghi", "Desktop/music3", 2015);
        Musics music4 = new Musics("mehran", "Desktop/music4", 2002);
        Musics music5 = new Musics("mammad", "Desktop/music5", 2010);

        rock.addFile(music1);
        pop.addFile(music2);
        jazz.addFile(music3);
        country.addFile(music4);
        favorite.addFile(music5);

        ArrayList<MusicCollection> collections = new ArrayList<>();

        collections.add(0, rock);
        collections.add(0, pop);
        collections.add(0, jazz);
        collections.add(0, country);
        collections.add(4, favorite);

        int choice = 1;

       while(choice != 0){
           System.out.println("if you want to exit any time enter 0\nif you want to observe the music collections enter 1\nif you want to search for a song enter 2");
           choice = scan.nextInt();

           if (choice == 0)
               return;

           else if (choice == 1) {
               System.out.println("choose from bellow:\n1. Rock\n2. Pop\n3. Jazz\n4. Country\n5. Favorites");
               int choiceCollection = scan.nextInt();

               if (choiceCollection == 0)
                   return;

               choiceCollection--;

               System.out.println("choose from bellow:\n1. add a music\n2. remove a music\n3. play a music\n4. add a music to your favorite songs\n5. stop playing a music\n6. print the list");
               choice = scan.nextInt();

               if (choice == 0)
                   return;

               collections.get(choiceCollection).listAllFiles();

               if (choice == 1) {
                   System.out.println("please enter the singer name, file address and file publish year respectively");
                   scan.nextLine();

                   Musics music = new Musics(scan.nextLine(), scan.nextLine(), scan.nextInt());

                   collections.get(choiceCollection).addFile(music);

                   System.out.println("the song added successfully");
               } else if (choice == 2) {
                   System.out.println("please choose from above");
                   choice = scan.nextInt() - 1;

                   collections.get(choiceCollection).removeFile(choice);

                   System.out.println("the song is removed successfully if input is valid");
                   choice = 2;
               } else if (choice == 3) {
                   System.out.println("choose from above");
                   choice = scan.nextInt();

                   collections.get(choiceCollection).startPlaying(choice - 1);
                   choice = 3;
               } else if (choice == 4) {
                   System.out.println("if you want to add a song to your favorite songs just enter the index of the collection and song respectively\nif not enter -1 twice");
                   choiceCollection = scan.nextInt();
                   choice = scan.nextInt();

                   if (choice == 0 || choiceCollection == 0)
                       return;

                   if (choiceCollection > 0 && choiceCollection <= collections.size() && choice > 0 && choice <= collections.get(choiceCollection - 1).getNumberOfFiles()) {
                       favorite.addFile(collections.get(choiceCollection - 1).getMusic(choice - 1));

                       System.out.println("the song added successfully");
                   }
               } else if (choice == 5) {
                   collections.get(choiceCollection).stopPlaying();
               } else if (choice != 6)
                   System.out.println("the input is not valid");
           }

           else if(choice == 2){
               System.out.println("please enter the song singer name, address or publish year");
               scan.nextLine();

               String str = scan.nextLine().toLowerCase(Locale.ROOT);

               boolean isFound = false;

               for (int i = 0;i < collections.size();i++){
                   for (int j = 0;j < collections.get(i).getNumberOfFiles();j++){
                       if(collections.get(i).getMusic(j).getAddress().toLowerCase(Locale.ROOT).contains(str)){
                           isFound = true;

                           System.out.println(i == 0 ? "Rock" : (i == 1 ? "Pop" : (i == 2 ? "Jazz" : (i == 3 ? "Country" : "Favorite"))) + "\nthe song is as bellow:");
                           collections.get(i).listFile(j);
                       }
                       if(collections.get(i).getMusic(j).getSingerName().toLowerCase(Locale.ROOT).contains(str)){
                           isFound = true;

                           System.out.println(i == 0 ? "Rock" : (i == 1 ? "Pop" : (i == 2 ? "Jazz" : (i == 3 ? "Country" : "Favorite"))) + "\nthe song is as bellow:");
                           collections.get(i).listFile(j);
                       }
                       if(String.valueOf(collections.get(i).getMusic(j).getPublishYear()).contains(str)){
                           isFound = true;

                           System.out.println(i == 0 ? "Rock" : (i == 1 ? "Pop" : (i == 2 ? "Jazz" : (i == 3 ? "Country" : "Favorite"))) + "\nthe song is as bellow:");
                           collections.get(i).listFile(j);
                       }
                   }
               }
               if(!isFound)
                   System.out.println("the song is not found");
           }
           else
               System.out.println("the input is invalid");
       }
    }
}
