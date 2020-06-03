package implementacion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//hola
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import clases.Disparo;
import clases.EnemigoAnimado1;
import clases.EnemigoAnimado2;
import clases.EnemigoAnimado3;
import clases.Fondo;
import clases.Item;
import clases.JugadorAnimado;
import clases.Player;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Juego extends Application{
	protected static final boolean finJuego = false;
	private GraphicsContext graficos;
	private Group root;
	private Scene escena;
	private Canvas lienzo;
	//private Jugador jugador;
	private JugadorAnimado jugadorAnimado;
	private Fondo fondo;
	public static boolean arriba;
	public static boolean abajo;
	public static boolean izquierda;
	public static boolean derecha;
	public static HashMap<String, Image> imagenes;
	private Item item;
	private Item item1;
	private Item item2;
	private Item item3;
	private Item item4;
	private Item item5;
	private Item item6;
	private Item item7;
	private Item item8;
	private Item item9;
	private Item item10;
	private Item item11;
	private Item item12;
	private Item item13;
	private Item item14;
	private Item item15;
	private Item item16;
	private Item item17;
	private Item item18;
	private Disparo disp;
	private Tile tile;
	private static ArrayList<Player> jugadores;
	 public static ArrayList<Disparo> cuetazos;
	private static int puntuacion;
	private static int vida;
	
	private Boolean booleano;
	int randomx,randomy,randomyy;
	int randomxV,randomyV,randomyyV;
		
	//private Tile tile;
	private ArrayList<Tile> tiles;
	private ArrayList<Tile> tile2;
	private ArrayList<EnemigoAnimado1> enemigos1;
	private ArrayList<EnemigoAnimado2> enemigos2;
	private ArrayList<EnemigoAnimado3> enemigos3;
	
	private int tilemap[][] = {
			{9,9,9,9,9,9,9,9,9,9,9},
			{9,9,0,0,0,0,0,0,0,9,9},
			{9,9,0,0,0,21,0,0,0,9,9},
			{9,9,0,19,17,17,17,18,0,9,9},
			{9,9,0,0,0,0,0,0,0,9,9},
			{9,9,0,0,0,0,0,20,0,9,9},
			{9,9,0,0,20,0,0,0,0,9,9},
			{9,9,0,0,0,0,0,0,0,9,9},
			{9,9,17,17,18,0,22,0,0,9,9},
			{9,9,0,0,0,0,20,0,0,9,9},
			{10,10,0,0,0,0,0,0,0,10,10},
			{10,10,0,0,0,0,0,14,0,10,10},
			{10,10,0,15,0,0,0,0,0,10,10},
			{10,10,0,0,0,14,0,0,0,10,10},
			{10,10,0,0,0,0,0,0,0,10,10},
			{10,10,13,0,0,0,0,14,0,10,10},
			{10,10,11,11,11,12,0,0,0,10,10},
			{10,10,0,0,0,0,0,0,0,10,10},
			{10,10,0,0,0,0,0,14,0,10,10},
			{10,10,0,0,14,0,0,0,0,10,10},
			{9,9,0,0,0,0,0,0,0,9,9},
			{9,9,0,7,4,4,4,6,0,9,9},
			{9,9,0,0,0,0,0,0,5,9,9},
			{9,9,0,0,0,0,0,7,4,9,9},
			{9,9,8,0,0,0,0,0,0,9,9},
			{9,9,4,4,4,6,0,0,0,9,9},
			{9,9,0,0,0,0,0,0,0,9,9},
			{9,9,2,2,2,2,2,2,2,9,9},
			{9,9,1,1,1,1,1,1,1,9,9},
			{9,9,9,9,9,9,9,9,9,9,9},
					
		
	};
	
	private int tilemap2[][]= {
			
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,9,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,11,0,0,0,0,0,0,0},
			{0,11,0,0,0,0,0,0,0},
			{0,11,0,0,0,0,0,0,0},
			{0,11,0,0,0,0,0,0,0},
			{0,11,0,0,0,0,0,0,0},
			{0,11,0,0,0,0,0,0,0},
			{0,11,0,11,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,11,0,0,0,0,0,0,0},
			
	};
			
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		gestionEventos();
		ventana.setScene(escena);
		ventana.setTitle("Excalibur");
		ventana.show();
		cicloJuego();

	}
	
	public void inicializarComponentes() {
		imagenes = new HashMap<String,Image>();
		
		
		
		enemigos1=new ArrayList<EnemigoAnimado1>();
		for (int z=0;z<30;z++) {
			randomyyV=(int)(Math.random()*3+1);
			randomxV=(int)(Math.random()*26000+3000);
			if (randomyyV==1)
				randomyV=14;
			if (randomyyV==2)
				randomyV=140;
			if (randomyyV==3)
				randomyV=288;
			enemigos1.add(new EnemigoAnimado1(randomxV,randomyV,0,0,"enemigo1",6,"mover", false));
		}
		enemigos2=new ArrayList<EnemigoAnimado2>();
		for (int z=0;z<30;z++) {
			randomyyV=(int)(Math.random()*3+1);
			randomxV=(int)(Math.random()*26000+3000);
			if (randomyyV==1)
				randomyV=74;
			if (randomyyV==2)
				randomyV=284;
			if (randomyyV==3)
				randomyV=494;
			enemigos2.add(new EnemigoAnimado2(randomxV,randomyV,0,0,"enemigo2",4,"mover",false));
		}
		
		enemigos3=new ArrayList<EnemigoAnimado3>();
		for (int z=0;z<30;z++) {
			randomyyV=(int)(Math.random()*3+1);
			randomxV=(int)(Math.random()*26000+3000);
			if (randomyyV==1)
				randomyV=75;
			if (randomyyV==2)
				randomyV=285;
			if (randomyyV==3)
				randomyV=495;
			enemigos3.add(new EnemigoAnimado3(randomxV,randomyV,0,0,"enemigo3",4,"mover",false));
		}
		
		
		
		
		
		
		
		cargarImagenes();
		jugadorAnimado = new JugadorAnimado(240, 300, "personaje", 3, 3,"descanso");
		fondo = new Fondo(0,0,"fondo-bosque","fondo-bosque2",3);
		inicializarTiles();
		item = new Item(270,20, "item",0, 1);
		item1 = new Item(360,20, "item",0, 1);
		item2 = new Item(460,20, "item",0, 1);
		item3 = new Item(520,160, "item",0, 1);	
		item4 = new Item(308,-100, "item",0, 1);
		item5 = new Item(515,-170 , "item",0, 1);
		item6 = new Item(515,-388, "item",0, 1);
		item7 = new Item(380,-525, "item",0, 1);
		item8 = new Item(220,-320, "item",0, 1);
		item9 = new Item(520,-662, "item",0, 1);	
		item10 = new Item(290,-320, "item",0, 1);
		item11 = new Item(360,-320, "item",0, 1);
		item12 = new Item(170,-880, "item",0, 1);
		item13 = new Item(220,-880, "item",0, 1);
		item14 = new Item(273,-880, "item",0, 1);
		item15 = new Item(310,-1020, "item",0, 1);
		item16 = new Item(518,-1090, "item",0, 1);
		item17 = new Item(285,-1230, "item",0, 1);
		item18 = new Item(460,-1230, "item",0, 1);
		
		
		
		
	
		
		
		root = new Group();
		escena = new Scene(root, 770,700);
		lienzo = new Canvas(770,700);
		root.getChildren().add(lienzo);
		graficos = lienzo.getGraphicsContext2D();
	}	
	
	
	
	public void cargarImagenes() {
		imagenes.put("fondo-bosque",new Image("fondo-bosque.jpg"));
		imagenes.put("fondo-bosque2",new Image("fondo-bosque2.jpg"));
		imagenes.put("tilemap",new Image("tilemap.png"));
		imagenes.put("tilemap2",new Image("tilemap2.png"));
		imagenes.put("personaje", new Image("sailormoon.png"));
		imagenes.put("item", new Image("item.png"));
		imagenes.put("enemigo1", new Image("enemigo1.png"));
		imagenes.put("enemigo2", new Image("enemigo2.png"));
		//imagenes.put("enemigo3", new Image("enemigo3.png"));
		imagenes.put("shot",new Image("shot.png"));
		
		
	}
	
	
	
	
	
	public void pintar() {
		//graficos.fillRect(0,0,100,100);
		fondo.pintar(graficos);
		if(jugadorAnimado.muere()) {
			JOptionPane.showMessageDialog(null, "sus puntos son: "+jugadorAnimado.getVidas());
			System.exit(0);
			}
		
		//tile.pintar(graficos);
		for(int i=0;i<tiles.size();i++) 
		tiles.get(i).pintar(graficos);

		
		for(int i=0;i<tile2.size();i++) 
		tile2.get(i).pintar(graficos);
		jugadorAnimado.pintar(graficos);
	
		item.pintar(graficos);
		item1.pintar(graficos);
		item2.pintar(graficos);
		item3.pintar(graficos);
		item4.pintar(graficos);
		item5.pintar(graficos);
		item6.pintar(graficos);
		item7.pintar(graficos);
		item8.pintar(graficos);
		item9.pintar(graficos);
		item10.pintar(graficos);
		item11.pintar(graficos);
		item12.pintar(graficos);
		item13.pintar(graficos);
		item14.pintar(graficos);
		item15.pintar(graficos);
		item16.pintar(graficos);
		item17.pintar(graficos);
		item18.pintar(graficos);
		
		
		
		
		
		graficos.fillText("Vidas: " + jugadorAnimado.getVidas(), 20, 20);
		
		
		
		for (int z=0;z<enemigos1.size();z++)
			enemigos1.get(z).pintar(graficos);
		
		for (int i=0;i<enemigos2.size();i++)
			enemigos2.get(i).pintar(graficos);
		
		//for (int i=0;i<enemigos3.size();i++)
		//	enemigos3.get(i).pintar(graficos);
		
		
	}

	
	
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {

			//Este metodo se ejecuta aproximadamente 60 veces por segundo 60FPS
			@Override
			public void handle(long tiempoActual) {
				double t = (tiempoActual - tiempoInicial) / 1000000000.0;
				actualizarEstado(t);
				pintar();
			}
			
		};
		
		animationTimer.start();//Empieza el ciclo de juego
	}
	
	public void actualizarEstado(double t) {
		jugadorAnimado.verificarColisionesItem(item);
		jugadorAnimado.verificarColisionesItem(item1);
		jugadorAnimado.verificarColisionesItem(item2);
		jugadorAnimado.verificarColisionesItem(item3);
		jugadorAnimado.verificarColisionesItem(item4);
		jugadorAnimado.verificarColisionesItem(item5);
		jugadorAnimado.verificarColisionesItem(item6);
		jugadorAnimado.verificarColisionesItem(item7);
		jugadorAnimado.verificarColisionesItem(item8);
		jugadorAnimado.verificarColisionesItem(item9);
		jugadorAnimado.verificarColisionesItem(item10);
		jugadorAnimado.verificarColisionesItem(item11);
		jugadorAnimado.verificarColisionesItem(item12);
		jugadorAnimado.verificarColisionesItem(item13);
		jugadorAnimado.verificarColisionesItem(item14);
		jugadorAnimado.verificarColisionesItem(item15);
		jugadorAnimado.verificarColisionesItem(item16);
		jugadorAnimado.verificarColisionesItem(item17);
		jugadorAnimado.verificarColisionesItem(item18);
		
		
		//if(booleano==true) {
			
			//disparar(240,300);
		//}
		
		
		jugadorAnimado.calcularFrame(t);
		jugadorAnimado.mover();
		fondo.mover();
		//jugadorAnimado.actualizarVidas();
		
		
		for(int z=0;z<enemigos1.size();z++) {
			enemigos1.get(z).mover();
        	enemigos1.get(z).actualizarAnimacion(t);
		}
		
		for (int i=0;i<enemigos1.size();i++)
			jugadorAnimado.verificarColisiones3(enemigos1.get(i));	
		
		for(int z=0;z<enemigos2.size();z++) {
			enemigos2.get(z).mover();
			enemigos2.get(z).actualizarAnimacion(t);
		}
		for (int i=0;i<enemigos2.size();i++)
			jugadorAnimado.verificarColisiones4(enemigos2.get(i));
		
		for(int z=0;z<enemigos3.size();z++) {
			enemigos3.get(z).mover();
			enemigos3.get(z).actualizarAnimacion(t);
		}
		for (int i=0;i<enemigos3.size();i++)
			jugadorAnimado.verificarColisiones5(enemigos3.get(i));
		
		for(int i= 0; i<tiles.size() ; i++) {
		 tiles.get(i).mover();    
		}
		
		
		for(int i= 0; i<tile2.size() ; i++) {
	     tile2.get(i).mover();    
		 }
		
		
		
		
		item.mover();
		item1.mover();
		item2.mover();
		item3.mover();
		item4.mover();
		item5.mover();
		item6.mover();
		item7.mover();
		item8.mover();
		item9.mover();
		item10.mover();
		item11.mover();
		item12.mover();
		item13.mover();
		item14.mover();
		item15.mover();
		item16.mover();
		item17.mover();
		item18.mover();
		
		
		
		
	}
	
	
	
	
	
	//private void disparar(int x,int y) {
		//Disparo disparos = new Disparo();
		
	//}

	public void inicializarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0;i<tilemap.length;i++) {
			for(int j=0;j<tilemap[i].length;j++) {
				if (tilemap[i][j]!=0) {
					this.tiles.add(new Tile(tilemap[i][j],j*70,(i*70)-1400,"tilemap",0,70,70));
				
			}
			
		}
		
	}
	
	     tile2 = new ArrayList<Tile>();
	    for(int i=0;i<tilemap2.length;i++) {
		    for(int j=0;j<tilemap2[i].length;j++) {
			    if (tilemap2[i][j]!=0) {
				    this.tile2.add(new Tile(tilemap2[i][j],i*135,j*141,"tilemap2",2,135,141));
			
		    }
		 
	    }
 	
     }
}
	
	
		
	public void gestionEventos() {
		//escena.setOnKeyPressed(new Evento());
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			//El metodo handle se ejecuta cada vez que presiono una tecla.
			@Override
			public void handle(KeyEvent evento) {
				switch(evento.getCode().toString()) {
					case "RIGHT":
						derecha = true;
						jugadorAnimado.setDireccion(1);
						jugadorAnimado.setAnimacionActual("correr");
						break;
					case "LEFT":
						izquierda = true;
						jugadorAnimado.setDireccion(-1);
						jugadorAnimado.setAnimacionActual("correr");
						break;
					case "UP":
						arriba = true;
						jugadorAnimado.setDireccion(1);
						jugadorAnimado.setAnimacionActual("arriba");
						break;
					case "DOWN":
						abajo = true;
						jugadorAnimado.setDireccion(1);
						jugadorAnimado.setAnimacionActual("abajo");
						break;
					case "SPACE":
						//jugador.setVelocidad(15);
						jugadorAnimado.setVelocidad(15);
					//	EnemigoAnimado1.setVelocidad(15);
					//	EnemigoAnimado2.setVelocidad(15);
						booleano = true;					
	
						break;
				}
			}
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			//Este metodo se ejecuta cuando se suelta una tecla
			@Override
				public void handle(KeyEvent evento) {
					switch(evento.getCode().toString()) {
					case "RIGHT":
						derecha = false;
						jugadorAnimado.setAnimacionActual("descanso");
						break;
					case "LEFT":
						izquierda = false;
						jugadorAnimado.setAnimacionActual("descanso");
						break;
					case "UP":
						arriba = false;
						break;
					case "DOWN":
						abajo = false;
						break;
					case "SPACE":
						jugadorAnimado.setVelocidad(5);
						EnemigoAnimado1.setVelocidad(10);
						EnemigoAnimado2.setVelocidad(10);
						
						break;
				}
			}
			
		});
	}
	
	
	//public void actualizarVidas() {
		//int vidas = 0;
		//if(vidas==0) {
			//System.out.println("haz perdido");
		//}
		
	//}
	

}













