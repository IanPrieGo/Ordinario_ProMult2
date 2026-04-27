package finalGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gamestates.Gamestate;

public class KeyHandler implements KeyListener, MouseListener{
		
	public String pressedKey = "No Key Pressed Yet";
	
	public String pressed = "key pressed :D";
	public String released = "key released :D";
	
	public GamePanel gp;
	
	
	
	public boolean upPressed = false;
	public boolean downPressed = false;
	public boolean leftPressed = false;
	public boolean rightPressed = false;
	public boolean basicAtk = false;
	public boolean highAtk = false;
	public boolean longAtk = false;
	public boolean lowAtk = false;
	public boolean attackKeyReleased = false;
	public boolean attackKeyPressed = false;
	public boolean spacePressed = false;
	
	public boolean test = true;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (Gamestate.state) {
		case MENU:
			break;
		case PAUSE:
			break;
		case PLAYING:
			this.gp.playing.keyPressed(e);
			break;
		default:
			break;
		
		}

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (Gamestate.state) {
		case MENU:
			break;
		case PAUSE:
			break;
		case PLAYING:
			this.gp.playing.keyReleased(e);
			break;
		default:
			break;
		
		}
		

		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
