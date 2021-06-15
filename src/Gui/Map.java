
package Gui;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author FERİDE ÇOLAK
 * @author Sema Altıntaş
 */

public class Map {
    private Scanner m;
    private String Map[]=new String[11];
    private Image black;
    private Image wall;
    private Image finish;
    private Image son;
    public Map(){
        ImageIcon img=new ImageIcon("Images/black6.png");
        black=img.getImage();
        img =new ImageIcon("Images/wall6.png");
        wall=img.getImage();
        img =new ImageIcon("Images/finish6.jpg");
        finish=img.getImage();
        img =new ImageIcon("Images/son.png");
        finish=img.getImage();
        openFile();
        readFile();
        closeFile();
    }
    public Image getBlack(){
        return black;
    }
    public Image getSon(){
        return son;
    }
    public Image getWall(){
        return wall;
    }
    public Image getFinish(){
        return finish;
    }
    public String getMap(int x,int y){
        String index=Map[y].substring(x,x+1);
        return index;
    }
    public void openFile(){
        try{//hesaplanmak istenen ifade
            m=new Scanner(new File("Maps/Map.txt"));
        }catch(FileNotFoundException e){/*hata tespit edilince çıkacak mesaj*/
            System.out.println("error loading map");
        }
    }
    public void readFile(){
        while(m.hasNext()){
            for(int i=0;i<11;i++){
                Map[i]=m.next();
            }
        }
    }
    public void closeFile(){
        m.close();
    }
}
