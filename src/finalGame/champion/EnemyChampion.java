package finalGame.champion;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

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
	
	
	public int x = 50;
	int y = (int)(floorHeight - height);
	
	Image currentSprite;
	BufferedImage [] sprites;
	int spriteCounter = 0;
	boolean spriteKey = true;
	
	HitBox hurtBox = new HitBox();
	HitBox currentHitbox = new HitBox();
	
	HitBox hitBoxMask;
	Champion player;
	int stillnesCounter = 0;
	int playerCurrentXpos;
	int playerPreviousXPos;
	
	
	int health = 100;
	
	boolean isAttacking;
	int attackCounter = 0;
	int attackAnticipation = 50;
	
	
	String resourceFolder = "src\\finalGame\\champion\\champion_RES";
	
	float  distToOponent;
	float desiredDist;
	int movementFactor;
	
	
	Timer timer = new Timer();
	TimerTask task = new TimerTask() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	};



	
	
	//ENEMY STATE MACHINE
	enum STATE {
		IDLE,
		PURSUE,
		RETREAT,
		ATTACK,
	}
	
	STATE currentState = STATE.IDLE;
	
	enum PLAYER_STATE {
		IDLE, 
		APROCHING,
		ATTACKING,
		RETREATING,
	}
	
	PLAYER_STATE currentPlayerState = PLAYER_STATE.IDLE;
	
	
	final static int IDLE_SALTO = 0;
	final static int IDLE_NORMAL = 1;
	final static int ATAQUEALTO_SALTO = 2;
	final static int ATAQUEALTO_NORMAL = 3;
	final static int ATAQUEBASICO_SALTO = 4;
	final static int ATAQUEBASICO_NORMAL = 5;
	final static int ATAQUEBAJO_SALTO = 6;
	final static int ATAQUEBAJO_NORMAL = 7;
	final static int ARNOLD_GUAPO = 8;
	
	
	

	public EnemyChampion(GamePanel gp, KeyHandler keyH) {
		super(gp, keyH);
		
		getChampionSprite();
		hurtBox = new HitBox(x + 7, y + 10, ((rawHeight - 55)/scale), ((rawWidth - 150)/scale), Color.yellow, HitBox.player);
		
	}
	
	public EnemyChampion(GamePanel gp, KeyHandler keyH, Champion player) {
		super(gp, keyH);
		
		this.hitBoxMask = player.championBox;
		this.player = player;
		this.playerPreviousXPos = player.x;
		
		getChampionSprite();
		hurtBox = new HitBox(x + 7, y + 10, ((rawHeight - 55)/scale), ((rawWidth - 150)/scale), Color.yellow, HitBox.player);

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
		
		this.player = champion;
		this.hitBoxMask = champion.championBox;
		
	}
	
	
	public void update() {
		
		checkPlayerState();
		System.out.println(currentPlayerState);
		
		if (y < (floorHeight - height)) {
			onFloor = false;
		} else {
			onFloor = true;
		}
		
		movementManager();

		
	}
	
	public void draw(Graphics2D g2) {
		AlphaComposite alcom;
		

		//DrawSprite
		alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
		g2.setComposite(alcom);
		g2.drawImage(currentSprite, x, y, null);
		
		
		//Draw character HurtBox
		g2.setPaint(Color.yellow);
        alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f);
        g2.setComposite(alcom);
		g2.fillRect(hurtBox.x, hurtBox.y, hurtBox.width, hurtBox.height);
	
		
		g2.setPaint(new Color(0, 72, 255));
        alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.25f);
        g2.setComposite(alcom);
		g2.fillRect(currentHitbox.x, currentHitbox.y, currentHitbox.width, currentHitbox.height);
		
		

	}
		
	
	void spriteManager() {
		
		
	}

	void movementManager() {
		
		distToOponent = Math.abs(this.x - player.x);
		desiredDist = (float)(this.width * 1.5);
		
		
		hurtBox.x = x + 7;
		hurtBox.y = y + 10;
		
		if (onFloor) {
			currentSprite = sprites[EnemyChampion.IDLE_NORMAL].getScaledInstance(width, height, 0);
		} else {
			currentSprite = sprites[EnemyChampion.IDLE_SALTO].getScaledInstance(width, height, 0);
		}
		
		this.behavior1();
		


	}
	
	void actionManager() {
		
//		hurtBox = new HitBox(x + 7, y + 10, ((rawHeight - 55)/scale), ((rawWidth - 150)/scale), Color.yellow, HitBox.player);
		
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
	
	void behavior1() {
		
		if (player != null) {
			
			switch (currentState){
			case IDLE:
					if (health > 50) {
						if (distToOponent > desiredDist) {
							currentState = STATE.PURSUE;
						}
					} else {
						if (distToOponent < desiredDist) {
							currentState = STATE.RETREAT;
						}
					}
					
					
					if (distToOponent < (float)(this.width)) {
						currentState = STATE.ATTACK;
					}
				
				
				break;
			case PURSUE:
					if (distToOponent < desiredDist) {
						currentState = STATE.IDLE;	
					}
					
					movementFactor = this.signOf(player.x - this.x) * speed;
					this.x += movementFactor;
					
				break;
			case RETREAT:
				
					if (distToOponent > desiredDist) {
						currentState = STATE.IDLE;
					}
					
					movementFactor = this.signOf(player.x - this.x) * speed;
					this.x -= movementFactor;
				
				break;
			case ATTACK:
				
				this.normalAttack();
				currentState = STATE.RETREAT;
					
				break;
			default:
				break;
				
			}
			
			
			
		}
		
	}
	
	enum STATES_2 {
		EN_GARDE,
		ATTACK,
		RETREAT,
		RECOVERING;
		
	}
	
	STATES_2 currentState_2 = STATES_2.EN_GARDE;
	
	
	void behavior2() {
		
		int direction = 1;
		
		switch(currentState_2) {
		case EN_GARDE:
			
			if (stillnesCounter > 50) {
				currentState_2 = STATES_2.ATTACK;
			}
			
			
			
			
			break;
		case ATTACK:
			break;
		case RECOVERING:
			break;
		case RETREAT:
			break;
		default:
			break;
		
		}
	}
	
	private int signOf(float num) {
		  int operation;
		  operation = (int) (num/(Math.abs(num))); 

		  return operation;
		}
	
	void normalAttack() {
		if (onFloor) {
			currentSprite = sprites[EnemyChampion.ATAQUEBASICO_NORMAL].getScaledInstance(width, height, 0);
		} else {
			currentSprite = sprites[EnemyChampion.ATAQUEBASICO_SALTO].getScaledInstance(width, height, 0);
		}
		

	}
	
	void checkPlayerState() {
		
		playerCurrentXpos = player.x;
		
		int playerDirection = playerCurrentXpos - playerPreviousXPos;
		
		final int FORWARD = 1;
		final int BACKWARDS = -1;
		
		if (playerDirection > FORWARD) {
			currentPlayerState = PLAYER_STATE.APROCHING;
		} else if (playerDirection < BACKWARDS) {
			currentPlayerState = PLAYER_STATE.RETREATING;
		} else {
			currentPlayerState = PLAYER_STATE.IDLE;
		}
		
		
		if (currentPlayerState == PLAYER_STATE.IDLE) {
			stillnesCounter ++;
		} else {
			stillnesCounter = 0;
		}
		
		

		
		playerPreviousXPos = player.x;
		
	}



}
