package frontEnd;

import java.awt.*;
import java.awt.event.*;

public class MseListener implements MouseListener, MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		Scene.mse = new Point(e.getX() + (GUI.width - Scene.Width)/2, e.getY() + (GUI.height - Scene.Height)/2);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Scene.mse = new Point(e.getX() - (GUI.width - Scene.Width)/2, e.getY() - (GUI.height - Scene.Height)/2);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Scene.menu.click(e.getButton());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
