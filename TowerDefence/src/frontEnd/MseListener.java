package frontEnd;

import java.awt.*;
import java.awt.event.*;

public class MseListener implements MouseListener, MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		Scene.mse = new Point(e.getX(), e.getY());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Scene.mse = new Point(e.getX(), e.getY());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getX() > Scene.Width - 50) {
			if (e.getY() > Scene.Height - 50) {
				Scene.save();
			}
		}
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
