package finalGame;

import java.awt.*;
import javax.swing.*;
import gamestates.*;

public class GamePanel extends JPanel implements Runnable{
	

	
	//Niputidea quesesto
	private static final long serialVersionUID = 1L;
	
	
	//Escala deseada para el tamaño de la venta
	final double scale = 1; 
	
	//Tamaño base para la ventana
	final int size = 500; 

	
	//Define el ancho y alto final de la ventana, basado en la escala y el tamaño.
	public final int screenWidth = (int) (size * scale * 1.5); // En el ancho multiplicamos por 1.5
	public final int screenHeight = (int) (size * scale);      // para que la ventana tenga proporcion de 1:1.5
	
	//FPS
	int FPS = 24; //Frame rate al que se dibujara el juego en la pantalla
	
	int oneSecondInNano = 1000000000;
	
	
	
	//Este objeto maneja los inputs del jugador
	public KeyHandler keyH = new KeyHandler(this); 
	
	//La neta no me acuerdo bien que hace esto, me toca investigarlo bien, pero venia en el tutorial asi que lo inclui
	Thread gameThread; 
	
	
	
	public Playing playing = new Playing(this);
	public GameMenu menu = new GameMenu(this);
	
	
	
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
		
		//Pablo AQUI espero no explote
		switch(Gamestate.state) {
		case MENU:
			menu.update();
			break;
		case PLAYING:
			playing.update(); 
			break;
		case PAUSE:
			break;
		default:
			break;
		
		}
		
	}
	
	//Dibuja elementos en pantalla, principalmente basados en la informacion actualizada por el metodo Update
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		//PABLO HERE	
		switch(Gamestate.state) {
		case MENU:
			menu.draw(g2);
			break;
		case PLAYING:
			playing.draw(g2);
			break;
		case PAUSE:
			break;
		default:
			break;
		
		}
		
	

		
	}

}
