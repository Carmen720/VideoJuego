package clases;

import java.util.ArrayList;
import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends ObjetoJuego{
	private int vidas;
	private HashMap<String, Animacion> animaciones;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private int direccion=1;
	
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
				new Rectangle(5, 134, 30, 64),
				new Rectangle(49, 137, 31, 63),
				new Rectangle(94, 135, 30, 63),
				new Rectangle(138, 136, 30, 63),
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
		

		Animacion animacionCorrer = new Animacion(0.05,coordenadasCorrer);
		animaciones.put("correr", animacionCorrer);
		
		Rectangle coordenadasDescanso[] = {
				new Rectangle(4, 2, 37, 64),
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
		Animacion animacionDescanso = new Animacion(0.1, coordenadasDescanso);
		animaciones.put("descanso",animacionDescanso);
		
		Rectangle coordenadasAbajo[] = {
				new Rectangle(4, 2, 37, 64),
				new Rectangle(51, 4, 31, 63),
				new Rectangle(95, 2, 33, 64),
				new Rectangle(141, 3, 29, 64),
				//new Rectangle(214, 309, 28, 69),
				//new Rectangle(265, 309, 28, 69),
				//new Rectangle(214, 309, 28, 69),
				//new Rectangle(162, 309, 30, 68),
				//new Rectangle(111, 309, 31, 68),
				//new Rectangle(54, 309, 37, 68)
		};
		Animacion animacionAbajo = new Animacion(0.1, coordenadasAbajo);
		animaciones.put("abajo",animacionAbajo);
		
		Rectangle coordenadasArriba[] = {
				new Rectangle(5, 201, 35, 64),
				new Rectangle(51, 203, 31, 63),
				new Rectangle(95, 210, 33, 64),
				new Rectangle(139, 203, 29, 64),
				//new Rectangle(214, 309, 28, 69),
				//new Rectangle(265, 309, 28, 69),
				//new Rectangle(214, 309, 28, 69),
				//new Rectangle(162, 309, 30, 68),
				//new Rectangle(111, 309, 31, 68),
				//new Rectangle(54, 309, 37, 68)
		};
		Animacion animacionArriba = new Animacion(0.1, coordenadasArriba);
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
		if (x>700)
			x=-80;
		
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
}
