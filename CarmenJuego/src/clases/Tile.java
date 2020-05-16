package clases;

import implementacion.Juego;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Tile extends ObjetoJuego{
	private int xImagen;
	private int yImagen;
	private int tipoTile;
	private int tipoTile2;
	private int x2;
	
	
	public Tile(int tipoTile,int x, int y, String nombreImagen, int velocidad, int ancho, int alto) {
		super(x, y, nombreImagen, velocidad);
		this.alto = alto;
		this.ancho = ancho;
		this.x2 = this.ancho+this.x;
		
		switch(tipoTile) {
		case 1:
			this.xImagen = 490;
			this.yImagen = 210;
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
		case 5:
			this.xImagen=420;
			this.yImagen=489;
			break;
		case 6:
			this.xImagen=350;
			this.yImagen=558;
			break;
		case 7:
			this.xImagen=350;
			this.yImagen=698;
			break;
		case 8:
			this.xImagen=279;
			this.yImagen=210;
			break;
		case 9:
			this.xImagen=560;
			this.yImagen=838;
			break;
		case 10:
			this.xImagen=140;
			this.yImagen=557;
			break;
		case 11:
			this.xImagen = 70;
			this.yImagen = 418;
			break;
		case 12:
			this.xImagen=140;
			this.yImagen=209;
			break;
		case 13:
			this.xImagen=70;
			this.yImagen=141;
			break;
		case 14:
			this.xImagen=138;
			this.yImagen=135;
			break;
		case 15:
			this.xImagen=420;
			this.yImagen=489;
			break;
		case 16:
			this.xImagen=350;
			this.yImagen=558;
			break;
		case 17:
			this.xImagen=350;
			this.yImagen=698;
			break;
		case 18:
			this.xImagen=279;
			this.yImagen=210;
			break;
		case 19:
			this.xImagen=560;
			this.yImagen=838;
			break;
		case 20:
			this.xImagen=355;
			this.yImagen=223;
			break;
		}
		
		switch(tipoTile2) {
		case 11:
			this.xImagen = 331;
			this.yImagen = 66;
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
			if(JugadorAnimado.yestatica>700) {
			y-=700;
		}}
		
		if (Juego.arriba) {
			if(JugadorAnimado.yestatica<0) {
				y+=700;
			
	}}
		
	}

	

	
	


	
}
