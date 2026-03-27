package finalGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
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
	
	public String pressedKey = "No Key Pressed Yet";
	
	public String pressed = "key pressed :D";
	public String released = "key released :D";
	
	
	public boolean test = true;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
//		System.out.println(pressed);
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = true;
//			System.out.println(pressed);
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = true;
//			System.out.println(pressed);
		}
		if (code == KeyEvent.VK_S) {
			downPressed = true;
//			System.out.println(pressed);
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = true;
//			System.out.println(pressed);
		}
		if (code == KeyEvent.VK_SPACE) {
			spacePressed = true;
//			System.out.println(pressed);
		}
		
		
		if (code == KeyEvent.VK_I) {
			highAtk = true;
			attackKeyReleased = false;
			attackKeyPressed = true;
		}
		if (code == KeyEvent.VK_J) {
			basicAtk = true;
			attackKeyReleased = false;
			attackKeyPressed = true;
		}
		if (code == KeyEvent.VK_K) {
			lowAtk = true;
			attackKeyReleased = false;
			attackKeyPressed = true;
		}
		if (code == KeyEvent.VK_L) {
			longAtk = true;
			attackKeyReleased = false;
			attackKeyPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
//		System.out.println(released);
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W) {
			upPressed = false;
//			System.out.println(released);
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
//			System.out.println(released);
		}
		if (code == KeyEvent.VK_S) {
			downPressed = false;
//			System.out.println(released);
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
//			System.out.println(released);
		}
		if (code == KeyEvent.VK_SPACE) {
			spacePressed = false;
//			System.out.println(released);
		}
		
		if (code == KeyEvent.VK_I) {
			highAtk = false;
			attackKeyReleased = true;
			attackKeyPressed = false;
		}
		if (code == KeyEvent.VK_J) {
			basicAtk = false;
			attackKeyReleased = true;
			attackKeyPressed = false;
		}
		if (code == KeyEvent.VK_K) {
			lowAtk = false;
			attackKeyReleased = true;
			attackKeyPressed = false;
		}
		if (code == KeyEvent.VK_L) {
			longAtk = false;
			attackKeyReleased = true;
			attackKeyPressed = false;
		}
		
	}

}
