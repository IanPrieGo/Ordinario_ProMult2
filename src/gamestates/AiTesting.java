package gamestates;

import java.awt.*;
import java.awt.event.*;
import finalGame.*;
import finalGame.champion.*;
import finalGame.combatArena.Location;

public class AiTesting extends State implements Statemethot{
	
	Champion player;
	EnemyChampion enemy;
	Location arena;
	
	 public AiTesting(GamePanel game) {
		super(game);
		
		enemy = new EnemyChampion(game, game.keyH);
		player = new Champion(game, game.keyH);
		
		enemy.setEnemy(player);
		player.setEnemy(enemy);
		
		
		arena = new Location(game, game.keyH); 
		
	}

	 @Override
	 public void update() {
		arena.update();
		player.update();
		enemy.update();
		
		
	 }

	 @Override
	 public void draw(Graphics2D g2) {
		 	arena.draw(g2);
			player.draw(g2);
			enemy.draw(g2);
			
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
	 public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	 }

		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println(pressed);
			
			int code = e.getKeyCode();
			
			if (code == KeyEvent.VK_W) {
				game.keyH.upPressed = true;
//				System.out.println(pressed);
			}
			if (code == KeyEvent.VK_A) {
				game.keyH.leftPressed = true;
//				System.out.println(pressed);
			}
			if (code == KeyEvent.VK_S) {
				game.keyH.downPressed = true;
//				System.out.println(pressed);
			}
			if (code == KeyEvent.VK_D) {
				game.keyH.rightPressed = true;
//				System.out.println(pressed);
			}
			if (code == KeyEvent.VK_SPACE) {
				game.keyH.spacePressed = true;
//				System.out.println(pressed);
			}
			
			
			if (code == KeyEvent.VK_I) {
				game.keyH.highAtk = true;
				game.keyH.attackKeyReleased = false;
				game.keyH.attackKeyPressed = true;
			}
			if (code == KeyEvent.VK_J) {
				game.keyH.basicAtk = true;
				game.keyH.attackKeyReleased = false;
				game.keyH.attackKeyPressed = true;
			}
			if (code == KeyEvent.VK_K) {
				game.keyH.lowAtk = true;
				game.keyH.attackKeyReleased = false;
				game.keyH.attackKeyPressed = true;
			}
			if (code == KeyEvent.VK_L) {
				game.keyH.longAtk = true;
				game.keyH.attackKeyReleased = false;
				game.keyH.attackKeyPressed = true;
			}
			
		}


		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println(released);
			
			int code = e.getKeyCode();
			
			if (code == KeyEvent.VK_W) {
				game.keyH.upPressed = false;
//				System.out.println(released);
			}
			if (code == KeyEvent.VK_A) {
				game.keyH.leftPressed = false;
//				System.out.println(released);
			}
			if (code == KeyEvent.VK_S) {
				game.keyH.downPressed = false;
//				System.out.println(released);
			}
			if (code == KeyEvent.VK_D) {
				game.keyH.rightPressed = false;
//				System.out.println(released);
			}
			if (code == KeyEvent.VK_SPACE) {
				game.keyH.spacePressed = false;
//				System.out.println(released);
			}
			
			if (code == KeyEvent.VK_I) {
				game.keyH.highAtk = false;
				game.keyH.attackKeyReleased = true;
				game.keyH.attackKeyPressed = false;
			}
			if (code == KeyEvent.VK_J) {
				game.keyH.basicAtk = false;
				game.keyH.attackKeyReleased = true;
				game.keyH.attackKeyPressed = false;
			}
			if (code == KeyEvent.VK_K) {
				game.keyH.lowAtk = false;
				game.keyH.attackKeyReleased = true;
				game.keyH.attackKeyPressed = false;
			}
			if (code == KeyEvent.VK_L) {
				game.keyH.longAtk = false;
				game.keyH.attackKeyReleased = true;
				game.keyH.attackKeyPressed = false;
			}
			
		} 

	 @Override
	 public void onStart() {
		// TODO Auto-generated method stub
		
	 }

}
