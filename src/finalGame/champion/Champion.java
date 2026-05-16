package finalGame.champion;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import finalGame.*;

public class Champion extends GameObject{
	
	
	//Variables en Uso
	public float floorHeight = 400;

	int power = 5;
	int speed = 5;	
	int jumpStrength = 0;
	boolean onFloor = true;
	
	int scale = 4;
	int rawHeight = 700;
	int rawWidth = 500;
	
	public int height = rawHeight / scale;
	int width = rawWidth / scale;
	
	
	public int x = 50;

	public int y = (int)(floorHeight - height);
	
	Image currentSprite;
	BufferedImage [] sprites;
	int currentSpriteIndex = 1;
	int spriteCounter = 0;
	boolean spriteKey = true;
	boolean staticAnimation = false;
	
	HitBox championBox = new HitBox(x + 7, y + 10, ((rawHeight - 55)/scale), ((rawWidth - 150)/scale), Color.yellow, HitBox.player);
	HitBox currentHitbox = new HitBox();
	
	HitBox hitBoxMask;
	EnemyChampion enemy;
	
	public int health = 0;
	public int enemyHealth = 100;
	
	boolean isAttacking;
	boolean isBlocking;
	
	String resourceFolder = "src\\finalGame\\champion\\champion_RES";
	
	//Orientation Constants
	final boolean FACING_LEFT = true;
	final boolean FACING_RIGHT =  false;
	
	//Sprite Index Constants
	final int SPRITE_IDLE = 1;
	final int SPRITE_ATAQUE_ESPECIAL = 3;
	final int SPRITE_ATAQUE_NORMAL = 5;
	final int SPRITE_BLOQUEO = 9;
	
	
	
	
	
	
	// Variables sin Utilizar
	String NAME;
	String FACTION;
	int comboCounter;
	int dealtDamageCounter;
	boolean attackLanded;
	boolean ultReady;
	int ultCharge;

	private boolean justAttacked;
	

	
	public Champion(GamePanel gp, KeyHandler keyH, HitBox hitBoxMask) {
		super(gp, keyH);
		
		this.hitBoxMask = hitBoxMask;
		
		getPlayerSprite();
		championBox = new HitBox(x + 7, y + 10, ((rawHeight - 55)/scale), ((rawWidth - 150)/scale), Color.yellow, HitBox.player);

	}
	
	public Champion(GamePanel gp, KeyHandler keyH, EnemyChampion enemy) {
		super(gp, keyH);
		
		this.hitBoxMask = enemy.hurtBox;
		this.enemy = enemy;
		
		getPlayerSprite();
		championBox = new HitBox(x + 7, y + 10, ((rawHeight - 55)/scale), ((rawWidth - 150)/scale), Color.yellow, HitBox.player);

	}
	
	public Champion(GamePanel gps, KeyHandler keyHs) {
		super(gps, keyHs);
		
		System.out.println(this.keyHan);
		
//		this.hitBoxMask = enemy.championBox;
		
		getPlayerSprite();
		championBox = new HitBox(x + 7, y + 10, ((rawHeight - 55)/scale), ((rawWidth - 150)/scale), Color.yellow, HitBox.player);

	}
	
	
	
	public void getPlayerSprite() {
		
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
				// Bloque Salto [8]
				resourceFolder + "\\DumSprites_Bloqueo_Salto.png",
				// Bloqueo Normal [9]
				resourceFolder + "\\DumSprites_Bloqueo_Normal.png",
				// Arnold [10]
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
	
	public void setEnemy(EnemyChampion champion) {
		
		this.enemy = champion;
		this.hitBoxMask = champion.hurtBox;
		
	}
	
	public void update() {
			
		actionManager();
		animationPlayer();
				

//		System.out.println(spriteCounter);
//		System.out.println("Attack Key Pressed: " + keyHan.attackKeyPressed);
//		System.out.println("Sprite Key: " + spriteKey);aw
		
		
	}
	
	public void draw(Graphics2D g2) {
		
		
//		currentSprite = sprites[1].getScaledInstance(width, height, 0);
		
		
		
		g2.drawImage(currentSprite, x, y, null);
		
        AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f);
        g2.setComposite(alcom);
        
        g2.setPaint(new Color(0, 72, 255));
		g2.fillRect(championBox.x, championBox.y, championBox.width, championBox.height);
		
		g2.setPaint(Color.red);
		g2.fillRect(currentHitbox.x, currentHitbox.y, currentHitbox.width, currentHitbox.height);
		
		//PlayerHP
		
		
//		g2.dispose();
		
	}
	

	void movementManager() {
		//MOVMENT MANAGER
		if (y < (floorHeight - height)) {
			
			y += 10;
			onFloor = false;
			
		} else {
			
			onFloor = true;
		}		
		
		
		if (keyHan.upPressed && onFloor) {
			
			jumpStrength = 25;
		}
		
		y-= jumpStrength;
		
		
		x += ((keyHan.rightPressed ? speed:0) - (keyHan.leftPressed ? speed:0));
		
		
		if (jumpStrength > 0) {
			
			jumpStrength -= 2;
			
		} else if (jumpStrength < 0) {
			
			jumpStrength = 0;
		}
		
		
		championBox.x = x + 7;
		championBox.y = y + 10;
		
		
		
	}
	

	
	void actionManager() {
		
		movementManager();
		
		System.out.println(keyHan.normalAttack);
		
		
		if (keyHan.normalAttack) {
			
			normalAttack();
			playAnimation(SPRITE_ATAQUE_NORMAL);
			
		}
		
		if (keyHan.block) {
			
			isBlocking = true;
			playAnimation(SPRITE_BLOQUEO);
			
		} else {
			isBlocking = false;
		}

		
		if (keyHan.specialAttack) {
			
			specialAttack();
			playAnimation(SPRITE_ATAQUE_ESPECIAL);
			
		}
		
		if (spriteCounter <= 9) {
			currentHitbox = new HitBox();
		}
		
		checkAttackCollision();
		
		
	}
	


	void animationPlayer(){
		
		if (spriteCounter > 0) {
			spriteCounter -=2;
		} 

		if (!keyHan.attackKeyPressed) {
			spriteKey = true;
			staticAnimation = false;
		}
		
		if (spriteCounter <= 0 && staticAnimation != true) {
			
			if (onFloor) {
				currentSprite = sprites[SPRITE_IDLE].getScaledInstance(width, height, 0);
			} else {
				currentSprite = sprites[SPRITE_IDLE - 1].getScaledInstance(width, height, 0);

			}
			
		}
		
		
		
	}
	
	void playAnimation(int spriteIndex) {
		
		if (!onFloor) {
			spriteIndex -=1;
		}
		
		if (spriteKey) {
			
			if (spriteIndex == SPRITE_BLOQUEO) {
				currentSprite = sprites[spriteIndex].getScaledInstance(width, height, 0);
				staticAnimation = true;
				
			} else {
				currentSprite = sprites[spriteIndex].getScaledInstance(width, height, 0);
				spriteCounter = 10;
				spriteKey = false;
				currentSpriteIndex = spriteIndex;
			}
			
			
			
		
		}
	}
	
	void checkAttackCollision() {
		if (currentHitbox.intersects(hitBoxMask)) {
			
			System.out.println("HitDetected");
			
			enemy.health -= 10;
			
			
			
		}
	}
	
	
	void normalAttack() {
		currentHitbox = new HitBox(x + width -30, y + 50, 20, 30, Color.red);
			
	}
	
	void block() {
		isBlocking = true;
				
	}

	void specialAttack() {
		currentHitbox = new HitBox(x + 85, y + 10, 30, 20, Color.red);
				
	}

//	void setConfiguration() {
//		
//	}
//	
//	void movementController() {
//		
//	}
//	

//	
//	void lowAttack() {
//		
//	}
//	
//	void highAttack() {
//		
//	}
//	
//	void distanceAttack() {
//		
//	}
//	
//	void specialAttack() {
//		
//	}
//	
//	void ultimateAttack() {
//		
//	}
	
//	boolean getOrientation() {
//		
//		
//		if (keyHan.rightPressed) {
//			return FACING_RIGHT;
//		} else if (keyHan.leftPressed){
//			return FACING_LEFT;
//		}
//		return (Boolean) null;
//		
//	}

}
