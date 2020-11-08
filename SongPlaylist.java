/**
 *
 * @author Esther
 */
package songtree;

import static songtree.SongTree.ps;


public class SongPlaylist {
    Song root; //root of binary search tree
    
    
    public SongPlaylist(){
        root = null;
        
    }
    
    //checks if tree is empty
    public boolean isEmpty(){
        return root == null;
    }
    
    //adds song to binary search tree
    public void addSong (Song newSong){
        
        
        //if root empty - song is root
        if(root == null){
            root = newSong;
            
        }else{
            Song focusSong = root;
            Song parent;
            
            while(true){
                parent = focusSong;                
                
                if (newSong.songTitle.compareToIgnoreCase(focusSong.songTitle) < 0){
                    focusSong = focusSong.leftChild;
                    
                    if (focusSong == null){
                        parent.leftChild = newSong;
                        return;
                    }
                    
                }else{
                    focusSong = focusSong.rightChild;
                    
                    if (focusSong == null){
                        parent.rightChild = newSong;
                        return;
                        
                    }
                    
                }
            }
            
        }
        
    }
    
    //finds a song in the binary search tree
    public Song findSong(String songTitle){
        Song focusSong = root;
        
        while(focusSong.songTitle.compareToIgnoreCase(songTitle) != 0){
            
            if (songTitle.compareToIgnoreCase(focusSong.songTitle) < 0 ){
                focusSong = focusSong.leftChild;
                
            }else{
                focusSong = focusSong.rightChild;
                
            }
            if(focusSong == null)
                return null;
        }
        
        return focusSong;
    }
    
    //orders the binary search tree in order
    public void inOrderTraverseTree(Song focusSong){
        
        if (focusSong != null){
            inOrderTraverseTree(focusSong.leftChild);
            ps.println(focusSong);
            
            inOrderTraverseTree(focusSong.rightChild);
        }
            
        
    }
    
    //returns songs within the range of the firstSong and the lastSong 
    public Song subset (Song root, String firstSong, String lastSong){
        if (root != null){
            Song focusSong = root;
            
            if(firstSong.compareTo(focusSong.songTitle)<0){
                subset(focusSong.leftChild, firstSong, lastSong);
                
            }
            
            if((firstSong.compareTo(focusSong.songTitle)<= 0)&& 
                    (lastSong.compareTo(focusSong.songTitle)>= 0)){
                ps.println(focusSong);
                
            }
            
            if(lastSong.compareTo(focusSong.songTitle)> 0){
                subset(focusSong.rightChild, firstSong, lastSong);
                
            }
            
        }
        return root;
    }
    
    public void subset(String firstSong, String secondSong){
        subset(root, firstSong, secondSong);
        
    }
    
    
}
