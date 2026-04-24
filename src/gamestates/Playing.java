package gamestates;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import finalGame.GameMatch;
import finalGame.GamePanel;
import finalGame.MatchInfoDisplay;
import finalGame.champion.Champion;
import finalGame.champion.HitBox;
import finalGame.combatArena.Location;

public class Playing extends State implements Statemethot{
	
	public HitBox enemy;
	public Champion player1;
	public Location arena;
	public GameMatch gameMatch;
	
	boolean startKey = true;
	
	public Playing(GamePanel game) {
		super(game);
	}
	
	public void intClasses() {
		//Hitbox del enemy para probar el sistema de colisiones
		enemy = new HitBox(400, 400-250, 250, 100, Color.pink, HitBox.enemy); 
		
		//Instancia de la clase "Champion", para que el jugador controle
		player1 = new Champion(game, game.keyH, enemy); 
//		Champion player1 = new Champion(this, keyH); 
		
		//Instancia de la clase "Location", que guarda la informacion de la arena de combate
		arena = new Location(game, game.keyH); 
		
		gameMatch = new GameMatch();
		
		MatchInfoDisplay matchUI = new MatchInfoDisplay(); 
			
		//Varibale que guarda la salud del jugador para usarlo en la GUI o para saber cuando este sea derrotado
		int healthPlayer1 = player1.health;
		
		
	}
	
		@Override
		public void update() {
			
			if(startKey) {
				this.onStart();
				startKey = false;
			}
			
			
//			arena.update();
//			player1.update();
			
		}


		@Override
		public void draw(Graphics2D g2) {
			g2.setColor(Color.RED);
			g2.fillOval(game.screenWidth/2, game.screenHeight/2, 10, 10);
			arena.draw(g2);
//			player1.draw(g2);
//			
//		    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
//			g2.setColor(enemy.color);
//			g2.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
//			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
////			g2.fillRect(0, 200, 500, 500);
//			g2.dispose();
//			
		}


		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mousePressed(MouseEvent e) {
			
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
		
		public Champion getChampion() {
			return player1;
		}

		@Override
		public void onStart() {
			this.intClasses();
			
		}
		
}
