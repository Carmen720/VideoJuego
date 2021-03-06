package clases;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import implementacion.Juego;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends ObjetoJuego{
	private int vidas;
	private int puntuacion = 0;
	
	private HashMap<String, Animacion> animaciones;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private int direccion=1;
	private int arp =0;
	private String ultimaAnimacion = "descanso";
	private Item item;
	private int orientacion = 1;
	public static int xestatica;
	public static int yestatica;
	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public JugadorAnimado(int x, int y, String nombreImagen, int velocidad, int vidas, String animacionActual) {
		super(x, y, nombreImagen, velocidad);
		this.vidas = vidas;
		this.animacionActual = animacionActual;
		animaciones = new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}
	
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	public void inicializarAnimaciones() {
		Rectangle coordenadasCorrer[]= {
				new Rectangle(1, 135, 36, 65),
				new Rectangle(45, 137, 37, 63),
				new Rectangle(90, 136, 38, 63),
				new Rectangle(133, 138, 39, 61),
			//	new Rectangle(204, 4, 36, 66),
			//	new Rectangle(253, 4, 36, 66),
			//	new Rectangle(306, 4, 32, 66),
		    //   new Rectangle(3, 89, 46, 69),
			//	new Rectangle(52, 89, 47, 69),
			//	new Rectangle(102, 90, 45, 64),
			//	new Rectangle(152, 90, 44, 64),
			//	new Rectangle(203, 91, 43, 63),
			//	new Rectangle(252, 91, 43, 63),
			//	new Rectangle(306, 91, 36, 66),
			//	new Rectangle(3, 177, 43, 66),
			//	new Rectangle(52, 177, 44, 67),
			//	new Rectangle(102, 178, 45, 63),
			//	new Rectangle(152, 177, 44, 64),
			//	new Rectangle(203, 178, 43, 63),
			//	new Rectangle(252, 178, 43, 63),
			//	new Rectangle(305, 178, 37, 65),
			//	new Rectangle(152, 90, 44, 64)//*
		};
		

		Animacion animacionCorrer = new Animacion(animacionActual, 0.05,coordenadasCorrer);
		animaciones.put("correr", animacionCorrer);
		
		Rectangle coordenadasDescanso[] = {
				new Rectangle(0, 204, 45, 62),
				//new Rectangle(54, 309, 37, 68),
				//new Rectangle(111, 309, 31, 68),
				//new Rectangle(162, 309, 30, 68),
				//new Rectangle(214, 309, 28, 69),
				//new Rectangle(265, 309, 28, 69),
				//new Rectangle(214, 309, 28, 69),
				//new Rectangle(162, 309, 30, 68),
				//new Rectangle(111, 309, 31, 68),
				//new Rectangle(54, 309, 37, 68)
		};
		Animacion animacionDescanso = new Animacion(animacionActual, 0.1, coordenadasDescanso);
		animaciones.put("descanso",animacionDescanso);
		
		Rectangle coordenadasAbajo[] = {
				new Rectangle(0, 4, 46, 62),
				new Rectangle(45, 4, 44, 62),
				new Rectangle(92, 3, 41, 62),
				new Rectangle(134, 5, 43, 61),
				//new Rectangle(214, 309, 28, 69),
				//new Rectangle(265, 309, 28, 69),
				//new Rectangle(214, 309, 28, 69),
				//new Rectangle(162, 309, 30, 68),
				//new Rectangle(111, 309, 31, 68),
				//new Rectangle(54, 309, 37, 68)
		};
		Animacion animacionAbajo = new Animacion(animacionActual, 0.1, coordenadasAbajo);
		animaciones.put("abajo",animacionAbajo);
		
		Rectangle coordenadasArriba[] = {
				new Rectangle(0, 204, 45, 62),
				new Rectangle(44, 206, 47, 57),
				new Rectangle(90, 205, 46, 60),
				new Rectangle(134, 204, 44, 59),
				//new Rectangle(214, 309, 28, 69),
				//new Rectangle(265, 309, 28, 69),
				//new Rectangle(214, 309, 28, 69),
				//new Rectangle(162, 309, 30, 68),
				//new Rectangle(111, 309, 31, 68),
				//new Rectangle(54, 309, 37, 68)
		};
		Animacion animacionArriba = new Animacion(animacionActual, 0.1, coordenadasArriba);
		animaciones.put("arriba",animacionArriba);
	}
	
	

	
	public void calcularFrame(double t) {
		Rectangle coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);
		this.xImagen = (int)coordenadas.getX();
		this.yImagen = (int)coordenadas.getY();
		this.anchoImagen = (int)coordenadas.getWidth();
		this.altoImagen = (int)coordenadas.getHeight();		
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, (direccion*anchoImagen) - 10, altoImagen);
	}
	//Se ejecuta por cada iteracion del ciclo de juego
	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen,altoImagen, x + (direccion==-1?anchoImagen:0), y, direccion*anchoImagen, altoImagen);//xImage, yImagen, anchoFragmento, altoFragmento, xPintar, yPintar, anchoPintar, altoPintar
		//graficos.setStroke(Color.RED);
		//graficos.strokeRect(x, y, anchoImagen - 10, altoImagen);
	}
	
	//Se ejecuta por cada iteracion del ciclo de juego
	@Override
	public void mover() {
	    xestatica = this.x;
	    yestatica = this.y;
		
		
		
		if (x>600)
			x=-80;
		if (y<0)
		   y=700;
		if(y>700)
			y=0;
		
		
		
		if (Juego.derecha)//Mover hacia la derecha
			x+=velocidad;
		
		if (Juego.izquierda)//Mover hacia la derecha
			x-=velocidad;
		
		if (Juego.arriba)
			y-=velocidad;
		
		if (Juego.abajo)
			y+=velocidad;
	}
	
	
	public String getAnimacionActual() {
		return animacionActual;
	}

	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}
	
	public void verificarColisionesItem(Item item) {
		if (!item.isCapturado() && this.obtenerRectangulo().getBoundsInLocal().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
			this.vidas += item.getCantidadVidas();
			item.setCapturado(true);
		}
			//System.out.println("Estan colisionando");
	}
	

	public void verificarColisiones3(EnemigoAnimado1 item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
			if (!item.isCapturado())
				this.vidas--;
			item.setCapturado(true);				
		}
	
	}
	public void verificarColisiones4(EnemigoAnimado2 item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
			if (!item.isCapturado())
				this.vidas--;
			item.setCapturado(true);
			
		}
	}
	public void verificarColisiones5(EnemigoAnimado3 item) {
		if (this.obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal())) {
			if (!item.isCapturado())
				this.vidas--;
			item.setCapturado(true);
			
			
		}
	}
	
	
	public boolean verificarColision (Tile tiles) {
		if (obtenerRectangulo().intersects(tiles.obtenerRectangulo().getBoundsInLocal()) ) {
			//no mover parametro de X e Y
			System.out.println(" Esta colisionando con una pared");
			if (Juego.derecha) {
				
				x-=velocidad;
				this.animacionActual = "descanso";
				//arp = 0;
							
			}
			
			if (Juego.izquierda) {
				if(true)
				x+= velocidad;
				this.animacionActual = "descanso";;
				this.orientacion = -1;
				arp = 60;
				
			}
			
			if (Juego.arriba) {
				y+= velocidad;
				this.animacionActual = "descanso";;
			}
			
			if (Juego.abajo) {
				y-= velocidad;
				this.animacionActual = "descanso";;
			}
			return true;
		}
		return false;
	}
	
	public boolean muere(){
        if (this.vidas <= 0)
            return true;
        return false;
    }



	
	
	
	 
		
	
}
