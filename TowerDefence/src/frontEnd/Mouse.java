package frontEnd;

import java.awt.*;  
import backEnd.Map;

import java.awt.event.*;  
@SuppressWarnings("serial")
public class Mouse extends Frame implements MouseListener{  
    Map map;
    Mouse(){  
        
    }  
    Mouse(Map map){
    	this.map = map;
    }
    public void mouseClicked(MouseEvent e) {  
       if (true) { // add restraint here later to ensure it's the save button
    	   map.export("save_temp.txt");
       }
    }  
    public void mouseEntered(MouseEvent e) {  
        
    }  
    public void mouseExited(MouseEvent e) {  
        
    }  
    public void mousePressed(MouseEvent e) {  
        
    }  
    public void mouseReleased(MouseEvent e) {  
       
    }  
    
    
	public static void main(String[] args) {  
	    new Mouse();  
	}  
}  

