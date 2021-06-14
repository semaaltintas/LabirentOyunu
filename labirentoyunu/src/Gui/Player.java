
package Gui;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author FERİDE ÇOLAK
 */

public class Player {
    private int tileX,tileY;
    private Image player;
    public Player(){
        ImageIcon img=new ImageIcon("Images/pembe6.gif");
        player=img.getImage();
        tileX=0;
        tileY=1;
    }
    public Image getPlayer(){
        return player;
    } 
    public int getTileX(){
        return tileX;
    }    
    public int getTileY(){
        return tileY;
    }
    public void move( int dx, int dy){
        tileX +=dx;
        tileY +=dy;
    }
    
}
