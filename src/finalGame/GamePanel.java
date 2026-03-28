package finalGame;

import java.awt.*;
import javax.swing.*;

import finalGame.champion.*;
import finalGame.combatArena.*;

public class GamePanel extends JPanel implements Runnable{	
	
	//Niputidea quesesto
	private static final long serialVersionUID = 1L;
	
	
	
	//Escala deseada para el tamaño de la venta
	final double scale = 1; 
	
	//Tamaño base para la ventana
	final int size = 500; 

	
	//Define el ancho y alto final de la ventana, basado en la escala y el tamaño.
	final int screenWidth = (int) (size * scale * 1.5); // En el ancho multiplicamos por 1.5
	final int screenHeight = (int) (size * scale);      // para que la ventana tenga proporcion de 1:1.5
	
	//FPS
	int FPS = 24; //Frame rate al que se dibujara el juego en la pantalla
	
	int oneSecondInNano = 1000000000;
	
	
	
	//Este objeto maneja los inputs del jugador
	KeyHandler keyH = new KeyHandler(); 
	
	//La neta no me acuerdo bien que hace esto, me toca investigarlo bien, pero venia en el tutorial asi que lo inclui
	Thread gameThread; 
	
	//Hitbox del enemy para probar el sistema de colisiones
	HitBox enemy = new HitBox(400, 400-250, 250, 100, Color.pink, HitBox.enemy); 
	
	//Instancia de la clase "Champion", para que el jugador controle
	Champion player1 = new Champion(this, keyH, enemy); 
//	Champion player1 = new Champion(this, keyH); 
	
	//Instancia de la clase "Location", que guarda la informacion de la arena de combate
	Location arena = new Location(this, keyH); 
	
	MatchInfoDisplay matchUI = new MatchInfoDisplay(); 
	
	
	//Varibale que guarda la salud del jugador para usarlo en la GUI o para saber cuando este sea derrotado
	int healthPlayer1 = player1.health; 

	
	
	
	public GamePanel () { //Constructor del Panel principal del Juego

	//CONFIGURACION PANTALLA
	//	+Establece tamaño del panel(Cuando el JFrame padre no tenga Layout usar "setSize" en vez de "PreferredSize")
	this.setPreferredSize(new Dimension (screenWidth, screenHeight) );
	
	//	+Establece es colo del fondo del "Game Panel"
	this.setBackground (Color.black);
	
	//	+Esatblece algo que la vea aun no se que es, toca investigar seniore ☝️🤓
	this.setDoubleBuffered (true);
	
	//	+Permite al panel ser enfocable, para que pueda escuchar los inputs del usuario
	this.setFocusable(true);
	
	//	+Pide de manera automatica el enfoque para el panel, aunque no parece estar funcionando bien
	this.requestFocusInWindow(true);
	
	//	+La neta no recuerdo, creo que era pa que el KeyHandler pueda registrar teclas como "Tab" por ejemplo
	this.setFocusTraversalKeysEnabled(false);
	
	//	+Establece el Layout como Nulo/Absoluto dentro del panel
	this.setLayout(null);
	
	//	+Permite al panel utilizar la instancia "keyH" de la clase "KehHandler" para registrar los Inputs del usuario
	this.addKeyListener(keyH);
	
	
	
	
	
	//Crea un panel para representar una barra de vida, aunque ahora no funciona, puede que haya un problema 
	// de compatibilidad al integrar JPanels y PaintComponent, hay que checar eso
	JPanel healthBar = new JPanel();
	healthBar.setPreferredSize(new Dimension(500,500));
	healthBar.setLocation(0, 0);
	healthBar.setBackground(Color.yellow);
	this.add(healthBar);
	
	
	//Misma situacion que el JPanel "healthBar", pero pruebo el metodo setBounds()
	//en vez de setPreferredSize() y setLocation; pero sigue sin funcionar
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(10, 10, 230, 37);
	panel_1.setBackground(Color.black);
	this.add(panel_1);
	
	
	}
	
	//Metodo que inicia el Thread del Juego, repito, ni idea quesesto, hay que investigar lptm
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	//Meotodo de ejecuccion heredado de la interfaz "Runnable", el cual se implemente como loop de juego.
	//Es necesario usarlo?, ni idea pero eso decia el tuto asi que yo hice caso
	@Override
	public void run() {
		
		//Esta variable define el intervalo que se tiene que esperar para volver a ejecutar el programa,
		// dividindo 1nanosegundo, entre el frame rate deseado
		//NO ENTIENDO COMO FUNCIONAAAAAAAA AYUDAAAAAA
		double drawInterval = oneSecondInNano/FPS; //0.01666 Secs
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;	
			lastTime = currentTime;
			
			//Pruebas para ver como funciona esto
//			System.out.println("Current Time: "+ currentTime);
//			System.out.println("Last Time: "+ lastTime);
//			System.out.println("Current Time minus Last Time: "+ (currentTime-lastTime));
//			System.out.println("Delta: "+ delta);
//			System.out.println("==============================");
//			System.out.println();
			
			if (delta >= 1) {
				// UPDATE: Update info & data
				update();
				
				// DRAW: Draws the grpahics whith new info & data
				repaint();
				
				delta--;
				
			}
					
		}
		
	}
	
	//Metodo que actualiza la informacion de posiciones, velocidad, estados, etc...
	public void update() {
		
		arena.update();
		player1.update();
		matchUI.update();
		
	}
	
	//Dibuja elementos en pantalla, principalmente basados en la informacion actualizada por el metodo Update
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
	
		arena.draw(g2);
		player1.draw(g2);
		matchUI.draw(g2);
		
	
      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f));
		g2.setColor(enemy.color);
		g2.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
		
//		g2.fillRect(0, 200, 500, 500);
		
		g2.dispose();
		
	}

}
