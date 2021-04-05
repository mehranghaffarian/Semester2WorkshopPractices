package com.company;

import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<Musics> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        player = new MusicPlayer();
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * @param music The file to be added.
     */
    public void addFile(Musics music) {files.add(files.size(), music);}

    /**
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles() {return files.size();}

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index){
        if(validIndex(index)){
            Musics music = files.get(index);
            System.out.println("music address: " + music.getAddress() + ", music singer name: " + music.getSingerName() + ", music publish year: " + music.getPublishYear());
        }
    }

    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles()
    {
        for(int i = 0 ;i < files.size();i++) {
            System.out.printf("%d. ", i + 1);
            listFile(i);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index){
        if(validIndex(index))
        files.remove(index);
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index){
        if (validIndex(index))
        player.startPlaying(files.get(index).getAddress());
    }

    /**
     * Stop the player.
     */
    public void stopPlaying() {player.stop();}

    /**
     * @return Musics the required music
     * */
    public Musics getMusic(int index){return  files.get(index);}

    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index)
    {
        if(index >= 0 && index < files.size())
            return true;
        else{
            System.out.println("the index is invalid");
            return false;
        }
    }
}