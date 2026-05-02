package finalGame.champion;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import finalGame.*;

public class EnemyChampion extends GameObject{
	
	//Variables en Uso
	float floorHeight = 400;

	int power = 5;
	int speed = 5;	
	int jumpStrength = 0;
	boolean onFloor = true;
	
	int scale = 4;
	int rawHeight = 700;
	int rawWidth = 500;
	
	int height = rawHeight / scale;
	int width = rawWidth / scale;
	
	
	int x = 50;
	int y = (int)(floorHeight - height);
	
	Image currentSprite;
	BufferedImage [] sprites;
	int spriteCounter = 0;
	boolean spriteKey = true;
	
	HitBox championBox = new HitBox(x + 7, y + 10, ((rawHeight - 55)/scale), ((rawWidth - 150)/scale), Color.yellow, HitBox.player);
	HitBox currentHitbox = new HitBox();
	
	HitBox hitBoxMask;
	Champion enemy;
	
	int enemyHealth = 100;
	
	boolean isAttacking;
	
	
	String resourceFolder = "src\\finalGame\\champion\\champion_RES";
	

	public EnemyChampion(GamePanel gp, KeyHandler keyH) {
		super(gp, keyH);
		
		getChampionSprite();
		
	}
	
	public EnemyChampion(GamePanel gp, KeyHandler keyH, Champion enemy) {
		super(gp, keyH);
		
		this.hitBoxMask = enemy.championBox;
		this.enemy = enemy;
		
		getChampionSprite();
	}
	
	public void getChampionSprite() {
		
		String [] spritesPaths = {
				// Idle Salto [0]
				resourceFolder + "\\DumSprites_Idle_Salto.png",
				// Idle Normal [1]
				resourceFolder + "\\DumSprites_Idle_Normal.png",
				// Ataque Alto Salto [2]
				resourceFolder + "\\DumSprites_AtaqueAlto_Salto.png",
				// Ataque Alto Normal [3]
				resourceFolder +"\\DumSprites_AtaqueAlto_Normal.png",
				// Ataque Basico Salto [4]
				resourceFolder + "\\DumSprites_AtaqueBasico_Salto.png",
				// Ataque Basico Normal [5] 
				resourceFolder + "\\DumSprites_AtaqueBasico_Normal.png",
				// Ataque Bajo Salto [6]
				resourceFolder + "\\DumSprites_AtaqueBajo_Salto.png",
				// Ataque Bajo Normal [7]
				resourceFolder + "\\DumSprites_AtaqueBajo_Normal.png",
				// Arnold [8]
				resourceFolder + "\\ArnoldGuapo.png"
		};
		
		sprites = new BufferedImage[spritesPaths.length];
		
		
		for (int i = 0; i < spritesPaths.length; i++) {
			
			try {
				sprites[i] = ImageIO.read(new File(spritesPaths[i]));
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error on Sprite [" + i + "]");
			}
		}
	}
	
	
	public void setEnemy(Champion champion) {
		
		this.enemy = champion;
		this.hitBoxMask = champion.championBox;
		
	}
	
	
	public void update() {
		
		movementManager();
		actionManager();
		spriteManager();
		
	}
	
	public void draw(Graphics2D g2) {
		AlphaComposite alcom;
		
//		currentSprite = sprites[1].getScaledInstance(width, height, 0);
		
		
		alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
		g2.setComposite(alcom);
		g2.drawImage(currentSprite, x, y, Color.red, null);
		
		g2.setPaint(new Color(0, 72, 255));
        alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f);
        g2.setComposite(alcom);
		g2.setColor(currentHitbox.color);
		g2.fillRect(currentHitbox.x, currentHitbox.y, currentHitbox.width, currentHitbox.height);

		
	}
		
	
	void spriteManager() {
		
//		if (spriteCounter > 0) {
//			spriteCounter -=2;
//		} 
//
//		if (keyHan.attackKeyPressed && spriteKey) {
//			spriteCounter = 12; 
//			spriteKey = false;
//		}
//		
//		if (!keyHan.attackKeyPressed) {
//			spriteKey = true;
//		}
//		
		if (onFloor) {
			currentSprite = sprites[1].getScaledInstance(width, height, 0);
			
//			if (spriteCounter > 0) {
//				if(keyHan.highAtk) { //ACTION EXECUTIONER
//					currentSprite = sprites[3].getScaledInstance(width, height, 0);
//				}
//				if(keyHan.basicAtk) {
//					currentSprite = sprites[5].getScaledInstance(width, height, 0);
//				}
//				if(keyHan.lowAtk) {
//					currentSprite = sprites[7].getScaledInstance(width, height, 0);
//				}
//				isAttacking = true;
//			}
//			if(keyHan.longAtk) {
//				currentSprite = sprites[8].getScaledInstance(width, height, 0);
//			}
			
		} else {
			currentSprite = sprites[0].getScaledInstance(width, height, 0);
			
//			if (spriteCounter > 0) {
//				if(keyHan.highAtk) { //ACTION EXECUTIONER
//					currentSprite = sprites[2].getScaledInstance(width, height, 0);
//				}
//				if(keyHan.basicAtk) {
//					currentSprite = sprites[4].getScaledInstance(width, height, 0);
//				}
//				if(keyHan.lowAtk) {
//					currentSprite = sprites[6].getScaledInstance(width, height, 0);
//				}
//				isAttacking = true;
//			}
//			if(keyHan.longAtk) {
//				currentSprite = sprites[8].getScaledInstance(width, height, 0);
//			}
		}


		
	}

	void movementManager() {
		//MOVMENT MANAGER
//		if (y < (floorHeight - height)) {
//			
//			y += 10;
//			onFloor = false;
//			
//		} else {
//			
//			onFloor = true;
//		}		
//		
//		
//		if (keyHan.upPressed && onFloor) {
//			
//			jumpStrength = 25;
//		}
//		
//		y-= jumpStrength;
//		
//		
//		x += ((keyHan.rightPressed ? speed:0) - (keyHan.leftPressed ? speed:0));
//		
//		
//		if (jumpStrength > 0) {
//			
//			jumpStrength -= 2;
//			
//		} else if (jumpStrength < 0) {
//			
//			jumpStrength = 0;
//		}
	}
	
	void actionManager() {
		
//		championBox = new HitBox(x + 7, y + 10, ((rawHeight - 55)/scale), ((rawWidth - 150)/scale), Color.yellow, HitBox.player);
//		
//		if (keyHan.basicAtk && spriteCounter > 9) {
//			currentHitbox = new HitBox(x + width -30, y + 50, 20, 30, Color.red);
//			
//		} else if (keyHan.highAtk && spriteCounter > 9) {
//			currentHitbox = new HitBox(x + 85, y + 10, 30, 20, Color.red);
//			
//		} else if (keyHan.lowAtk && spriteCounter > 9) {
//			currentHitbox = new HitBox(x + 82, y + 95, 27, 27, Color.red);
//			
//		} else {
//			currentHitbox = new HitBox();
//		}
//		
//		if (currentHitbox.intersects(hitBoxMask)) {
//			
//			System.out.println("HitDetected");
//			
//			if (keyHan.basicAtk) {
//				enemyHealth -= power;
//			}
//			if (keyHan.highAtk) {
//				enemyHealth -= power * 3;
//			}
//			if (keyHan.lowAtk) {
//				enemyHealth -= power * 2;
//			}
//			
//		}	
		
	}



}
