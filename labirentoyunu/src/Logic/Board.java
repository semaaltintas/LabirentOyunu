
package Logic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Gui.Map;
import Gui.Player;

public class Board extends JPanel implements ActionListener{
    JFrame f=new JFrame();
    private Timer timer;
    private Map m;
    private Player p;
    private boolean win=false;
    private String Message="";
    private Font font=new Font("Serif",Font.BOLD,60);
    public Board(){
        m= new Map();
        p=new Player();
        addKeyListener(new Al());
        setFocusable(true);
        timer=new Timer(25,this);
        timer.start();
    }
   
    public void actionPerformed(ActionEvent e){
        if(m.getMap(p.getTileX(), p.getTileY()).equals("9")){
            Message="Winner";
            win=true;
        }
        repaint();
    }
    public void paint(Graphics g){
        super.paint(g);
        if(!win){
        for(int y=0;y<11;y++){
            for(int x=0;x<11;x++){
                if(m.getMap(x, y).equals("9")){
                    g.drawImage(m.getFinish(), x*60, y*60, null);
                }
                if(m.getMap(x, y).equals("0")){
                    g.drawImage(m.getBlack(), x*60, y*60, null);
                }
                if(m.getMap(x, y).equals("1")){
                    g.drawImage(m.getWall(), x*60, y*60, null);
                }
            }
        }
        }
        if(win){
           g.drawImage(m.getSon(), WIDTH, WIDTH, this);
           g.setColor(Color.orange);
           g.setFont(font);
           g.drawString(Message, 150, 200);
        }
        g.drawImage(p.getPlayer(),p.getTileX()*60,p.getTileY()*60,null);
    }
    class Al extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int keycode=e.getKeyCode();
            if(keycode == KeyEvent.VK_W){
                if(!m.getMap(p.getTileX(), p.getTileY()-1).equals("1"))
                {p.move(0, -1);}
            }
            if(keycode == KeyEvent.VK_S){
                if(!m.getMap(p.getTileX(), p.getTileY()+1).equals("1"))
                {p.move(0, 1);}
            }
            if(keycode == KeyEvent.VK_A){
                if(!m.getMap(p.getTileX()-1, p.getTileY()).equals("1"))
                {p.move(-1, 0);}
            }
            if(keycode == KeyEvent.VK_D){
                if(!m.getMap(p.getTileX()+1, p.getTileY()).equals("1"))
                {p.move(1, 0);}
            }
        }
        public void keyRelased(KeyEvent e){
            
        }
        public void keyTyped(KeyEvent e){
            
        }
    }
}
