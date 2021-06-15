
package Business;

import javax.swing.*;
import Logic.Board;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author FERİDE ÇOLAK
 * @author Sema Altıntaş
 */
public class Labirentoyunu {

    public static void main(String[] args) {
        Labirentoyunu labirentoyunu = new Labirentoyunu();
        playMusic("Music/PembePanter.wav");
        
    }
    public Labirentoyunu(){
        JFrame f=new JFrame();
        f.setTitle("Maze Game");
        f.add(new Board());
        f.setSize(675, 700);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void playMusic(String filepath){
            InputStream music;
            try{
                music = new FileInputStream (new File(filepath));
                AudioStream audios = new AudioStream (music);
                AudioPlayer.player.start(audios);
            
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
  
    
}
