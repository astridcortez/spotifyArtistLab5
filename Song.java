/**
 *
 * @author Esther
 */
package songtree;


public class Song {
    String songTitle;
    int streamCount;
    String artistName;
    int artistAverage;
    
    Song leftChild;
    Song rightChild;
    
    // empty constructor
    public Song(){
        this.songTitle = null;
        this.streamCount = 0;
        this.artistName = null;
        this.artistAverage = 0;
        leftChild = null;
        rightChild = null;
    }
    
    //constructor with arguements
    public Song (String songTitle, String artistName, int streamCount){
        this.songTitle = songTitle;
        this.streamCount = streamCount;
        this.artistName = artistName;
        this.artistAverage = streamCount;
        leftChild = null;
        rightChild = null;
        
    }
    
    //sets song title
    public void setSongTitle(String songTitle){
        this.songTitle = songTitle;
        
    }
    
    //returns song title
    public String getSongTitle(){
        return this.songTitle;

    }
    
    //sets the stream count
    public void setStreamCount (int streams){
        this.streamCount = streams;
        
    }
    
    //returns the stream count
    public int getStreamCount(){
        return this.streamCount;
        
    }
    
    //sets the artist name
    public void setArtistName(String name){
        this.artistName = name;
        
    }
    
    //returns the artist name
    public String getArtistName(){
        return this.artistName;
        
    }
    
    /*
    public void setArtistAverage(Song obj) {
        this.artistAverage = (this.streamCount + obj.streamCount) / 2;
        
     }*/
    
    //compares two song titles
    public int compareTo(Song obj) {
        return this.songTitle.compareToIgnoreCase(obj.songTitle);
        
 }
    
    //returns string with information
    @Override
    public String toString(){
        return this.songTitle + " by " + this.artistName + " has streamed " + 
                this.streamCount;
        
    }
    
    
}

