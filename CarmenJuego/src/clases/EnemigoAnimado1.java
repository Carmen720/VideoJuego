package clases;
//Hola

import java.util.HashMap;
import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class EnemigoAnimado1 {
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
	
	
	public EnemigoAnimado1(int x, int y, int ancho, int alto, String indiceImagen, int velocidad, String animacionActual, boolean capturado) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.indiceImagen = indiceImagen;
		this.capturado = capturado;
		EnemigoAnimado1.velocidad = velocidad;
		EnemigoAnimado1.animacionActual=animacionActual;
		inicializarAnimaciones();
	}
	
	public void inicializarAnimaciones() {
		animaciones = new HashMap<String, Animacion>();
		Rectangle coordenadasMover[]= {
	
				new Rectangle(298, 6, 59, 65),
				new Rectangle(238, 6, 60, 66),
				new Rectangle(179, 6, 59, 66),
				new Rectangle(120, 6, 59, 66),
				new Rectangle(62, 6, 58, 66),
				new Rectangle(5, 6, 57, 66),
				
				new Rectangle(303, 77, 56, 65),
				new Rectangle(240, 78, 57, 66),
				new Rectangle(180, 79, 57, 67),
				new Rectangle(118, 78, 58, 66),
				new Rectangle(59, 78, 59, 66),
				new Rectangle(0, 78, 59, 66),
				
				new Rectangle(297, 146, 61, 66),
				new Rectangle(236, 146, 61, 66),
				new Rectangle(176, 146, 61, 66),
				new Rectangle(119, 146, 58, 66),
				new Rectangle(61, 146, 57, 66),
				new Rectangle(1, 146, 60, 66)
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
		EnemigoAnimado1.velocidad = velocidad;
	}

	public static String getAnimacionActual() {
		return animacionActual;
	}

	public static void setAnimacionActual(String animacionActual) {
		EnemigoAnimado1.animacionActual = animacionActual;
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
