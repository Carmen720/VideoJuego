package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Tile extends ObjetoJuego{
	private int xImagen;
	private int yImagen;
	private int tipoTile;
	private int x2;
	
	
	public Tile(int tipoTile,int x, int y, String nombreImagen, int velocidad, int ancho, int alto) {
		super(x, y, nombreImagen, velocidad);
		this.alto = alto;
		this.ancho = ancho;
		this.x2 = this.ancho+this.x;
		
		switch(tipoTile) {
			case 1:
				this.xImagen = 350;
				this.yImagen = 344;
				break;
			case 2:
				this.xImagen=420;
				this.yImagen=558;
				break;
			case 3:
				this.xImagen=350;
				this.yImagen=697;
				break;
			case 4:
				this.xImagen=280;
				this.yImagen=558;
				break;
			case 6:
				this.xImagen=350;
				this.yImagen=487;
				break;
			case 7:
				this.xImagen=350;
				this.yImagen=558;
				break;
			case 5:
				this.xImagen=350;
				this.yImagen=558;
				break;
			case 10:
				this.xImagen=279;
				this.yImagen=210;
				break;
			case 20:
				this.xImagen=560;
				this.yImagen=838;
				break;
		}
	}
	
	public int getxImagen() {
		return xImagen;
	}
	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}
	public int getyImagen() {
		return yImagen;
	}
	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}
	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,ancho,alto,x,y,ancho,alto);
		
	}
	@Override
	public void mover() {
		if (Juego.abajo) {
			y-=velocidad;
			
		}
		
		if (Juego.arriba) {
			y+=velocidad;
			
	}
		
	}
	
}
