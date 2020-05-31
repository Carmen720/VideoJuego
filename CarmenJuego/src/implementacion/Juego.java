package implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import clases.EnemigoAnimado1;
import clases.Fondo;
import clases.Item;
import clases.JugadorAnimado;
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
	private Tile tile;
	int randomx,randomy,randomyy;
	int randomxV,randomyV,randomyyV;
		
	//private Tile tile;
	private ArrayList<Tile> tiles;
	private ArrayList<Tile> tile2;
	private ArrayList<EnemigoAnimado1> enemigos1;

	private int tilemap[][] = {
			{9,9,9,9,9,9,9,9,9,9,9},
			{9,9,0,0,0,0,0,0,0,9,9},
			{9,9,0,0,0,0,0,0,0,9,9},
			{9,9,0,0,4,4,4,0,0,9,9},
			{9,9,0,0,0,0,0,0,0,9,9},
			{9,9,0,0,0,0,0,0,0,9,9},
			{9,9,0,0,0,0,4,4,4,9,9},
			{9,9,0,0,0,0,0,0,0,9,9},
			{9,9,4,4,0,0,0,0,0,9,9},
			{9,9,0,0,0,0,0,0,0,9,9},
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
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {

			//Este metodo se ejecuta aproximadamente 60 veces por segundo 60FPS
			@Override
			public void handle(long tiempoActual) {
				double t = (tiempoActual - tiempoInicial) / 1000000000.0;
				//System.out.println(t);
				actualizarEstado(t);
				pintar();
			}
			
		};
		
		animationTimer.start();//Empieza el ciclo de juego
	}
	
	public void actualizarEstado(double t) {
		//jugador.mover();
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
		jugadorAnimado.calcularFrame(t);
		jugadorAnimado.mover();
		fondo.mover();
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
		
	}
	
	public void inicializarComponentes() {
		imagenes = new HashMap<String,Image>();
		cargarImagenes();
		jugadorAnimado = new JugadorAnimado(240, 317, "personaje", 3, 0,"descanso");
		fondo = new Fondo(0,0,"fondo-bosque","fondo-bosque2",3);
		inicializarTiles();
		item = new Item(270,20, "item",0, 1);
		item1 = new Item(360,20, "item",0, 1);
		item2 = new Item(460,20, "item",0, 1);
		item3 = new Item(520,150, "item",0, 1);
		item4 = new Item(200,-315, "item",0, 1);
		item5 = new Item(260,-315, "item",0, 1);
		item6 = new Item(320,-315, "item",0, 1);
		item7 = new Item(200,-315, "item",0, 1);
		item8 = new Item(310,-100, "item",0, 1);
		item9 = new Item(460,20, "item",0, 1);
		item10 = new Item(520,150, "item",0, 1);
		item11 = new Item(200,-315, "item",0, 1);
		item12 = new Item(260,-315, "item",0, 1);
		
		
		
		root = new Group();
		escena = new Scene(root, 770,700);
		lienzo = new Canvas(770,700);
		root.getChildren().add(lienzo);
		graficos = lienzo.getGraphicsContext2D();
	}
	
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
	public void cargarImagenes() {
		imagenes.put("fondo-bosque",new Image("fondo-bosque.jpg"));
		imagenes.put("fondo-bosque2",new Image("fondo-bosque2.jpg"));
		imagenes.put("tilemap",new Image("tilemap.png"));
		imagenes.put("tilemap2",new Image("tilemap2.png"));
		imagenes.put("personaje", new Image("sailormoon.png"));
		imagenes.put("item", new Image("item.png"));
		
	}
	
	public void pintar() {
		//graficos.fillRect(0,0,100,100);
		fondo.pintar(graficos);
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
		//item9.pintar(graficos);
		//item10.pintar(graficos);
		//item11.pintar(graficos);
		//item12.pintar(graficos);
		graficos.fillText("Vidas: " + jugadorAnimado.getVidas(), 20, 20);
		
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
						break;
				}
			}
			
		});
	}
	
	

}













