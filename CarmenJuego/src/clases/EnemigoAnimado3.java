package clases;

import java.util.HashMap;
import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class EnemigoAnimado3 {
	private int ancho;
	private int alto;
	private String indiceImagen;
	private boolean capturado;
	private static int velocidad;
	public static String animacionActual;
	private HashMap<String, Animacion> animaciones;
	private int x;
	private int y;
	private double anchoImagen;
	private double altoImagen;
	private double xImagen;
	private double yImagen;
	
	
	public EnemigoAnimado3(int x, int y, int ancho, int alto, String indiceImagen, int velocidad, String animacionActual, boolean capturado) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.indiceImagen = indiceImagen;
		this.capturado = capturado;
		EnemigoAnimado3.velocidad = velocidad;
		EnemigoAnimado3.animacionActual=animacionActual;
		inicializarAnimaciones();
	}
	
	public void inicializarAnimaciones() {
		animaciones = new HashMap<String, Animacion>();
		Rectangle coordenadasMover[]= {
	
				new Rectangle(287, 23, 42, 64),
				new Rectangle(230, 23, 44, 63),
				new Rectangle(174, 23, 47, 63),
				new Rectangle(121, 24, 46, 62),
				new Rectangle(71, 24, 43, 62),
				new Rectangle(28, 24, 39, 63),
				
				new Rectangle(286, 95, 40, 63),
				new Rectangle(232, 94, 40, 63),
				new Rectangle(176, 93, 45, 64),
				new Rectangle(126, 92, 43, 64),
				new Rectangle(73, 92, 42, 66),
				new Rectangle(26, 93, 41, 66)
		};
		
		
		Animacion animacionMover = new Animacion("mover",0.1,coordenadasMover);
		animaciones.put("mover",animacionMover);
     }
	
	
	public void mover(){
		if (Juego.derecha)
			this.x-=velocidad;
	}
	
	
	public void actualizarAnimacion(double time) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrameActual(time);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	
	}
	
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x-=2, this.y,
				this.anchoImagen, this.altoImagen
		);
    }
	
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public boolean isCapturado() {
		return capturado;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public String getIndiceImagen() {
		return indiceImagen;
	}

	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}

	public static int getVelocidad() {
		return velocidad;
	}

	public static void setVelocidad(int velocidad) {
		EnemigoAnimado3.velocidad = velocidad;
	}

	public static String getAnimacionActual() {
		return animacionActual;
	}

	public static void setAnimacionActual(String animacionActual) {
		EnemigoAnimado3.animacionActual = animacionActual;
	}

	public HashMap<String, Animacion> getAnimaciones() {
		return animaciones;
	}

	public void setAnimaciones(HashMap<String, Animacion> animaciones) {
		this.animaciones = animaciones;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	
	
}
