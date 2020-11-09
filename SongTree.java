/**
 *
 * @author Esther
 * @since 11/3/2020
 * @version 1.0
 */
package songtree;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SongTree {
    static SongPlaylist list = new SongPlaylist();
    public static PrintStream ps;
    
    public static void main(String[] args) throws Exception{
        
        ps = new PrintStream ("results.txt"); // sending all output to a file named results
        String [] fileNames = {"week1.txt", "week2.txt", "week3.txt",
                "week4.txt"};
       
        int columns = 5;
        int rows = 800;
        int row=0;
        
        String [] songList = new String [800] ;
        String [] artistList = new String [800];
        int [] streamList = new int [800];
        
        String [][] myList = new String [rows][columns]; //creates a string with 5 columns, 2400 rows
        //String fileName = fileNames[0];
        
        for (int i = 0; i < fileNames.length ; i++){
            String myFile = fileNames[i];
            Scanner sc = new Scanner (new File(myFile));
            
            row = populateArray(myList, row, myFile, songList, artistList, streamList);
            
        }
        makeBinarySearchTree(songList, artistList, streamList); //make binary search tree
        
    }
    
    //populates the songList array, artistList array, streamList array based on the fiels we have
    public static int populateArray(String [][] myList, int row, String fileName, String [] songList, String [] artistList, int [] streamList)throws Exception{ 
            
        File myFile = new File (fileName);
        Scanner sc = new Scanner (myFile);//takes in the csv file
        String line = "";
            
        
            while(sc.hasNextLine()){   
                line = sc.nextLine();
                String[] values = line.split(",(?=([^\"]|\"[^\"]*\")*$)");
                /*gets rid of unecessary quotes etc 
                */
                
                for(int i = 0; i < 5; i++){
                
                    myList[row][i] = values[i];                    
                    
                }
                songList[row] = values [1]; //populates songList array
                artistList[row] = values [2]; //populates the artistList array
                streamList[row] = Integer.parseInt(values[3]);//populates the streamList array
                
                row = row+1;
                
                
            }
        
            
            return row;
        }    
    //takes in three arrays and makes the binary search tree and prints it out
    public static void makeBinarySearchTree( String [] songList,
            String [] artistList, int [] streamList){
            for (int i = 0; i < 800; i++) {
                Song newSong = new Song(songList[i], artistList[i], streamList[i]);
                
                list.inOrderTraverseTree(newSong);
                
            }
            
        
    }
    
}
