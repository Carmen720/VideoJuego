package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Fondo extends ObjetoJuego{
	private String nombreImagen2;
	private int y2;
	public Fondo(int x, int y, String nombreImagen,String nombreImagen2, int velocidad) {
		super(x, y, nombreImagen, velocidad);
		this.nombreImagen2=nombreImagen2;
		this.ancho = (int)Juego.imagenes.get("fondo-bosque").getWidth();
		this.alto = (int)Juego.imagenes.get("fondo-bosque").getHeight();
		this.y2 = -1*this.alto+this.y;
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(this.nombreImagen), this.x, this.y, 630,944,this.x,this.y,800,1000);
		graficos.drawImage(Juego.imagenes.get(this.nombreImagen2),this.x, this.y2,630 ,944,this.x,this.y2,800,1000);

	}

	@Override
	public void mover() {
		//if (y >= 1*alto) {//y<=500
		//	y=-alto;
		//}
	   // if (y2 >= 1*alto) {
			y2=-alto;
		//}
		//if (Juego.abajo) {
		//	if(JugadorAnimado.yestatica>700) {
		//	y-=700;
		//	y2-=700;
		//}}
		
		//if (Juego.arriba) {
		//	if(JugadorAnimado.yestatica<0) {
		//	y+=700;
		//	y2+=700;
		//}}
		if(Juego.arriba) {
			if(y<=(-1*alto)) {
				y=alto;
			}
			if(y2<=(-1*alto)) {
				y2= alto;
			}
			
		if(Juego.abajo) {
			if(y>=(alto)) {
				y= (-1*alto);
			}
			if(y2>=(alto)) {
              y2= (-1*alto);		
			}
			
	}
		}
  }
}
