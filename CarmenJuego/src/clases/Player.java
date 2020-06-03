package clases;

import java.io.Serializable;

public class Player implements Serializable{

	private static String nombrePlayer;
	private static int vidas;
	
	public Player(String nombrePlayer, int puntuacion) {
		this.nombrePlayer = nombrePlayer;
		this.vidas = puntuacion;
	}

	public Player() {}
	
	public static String getNombrePlayer() {
		return nombrePlayer;
	}
	public void setNombre(String nombrePlayer) {
		this.nombrePlayer = nombrePlayer;
	}
	public static int getPuntuacion() {
		return vidas;
	}
	public void setPuntuacion(int puntuacion) {
		this.vidas = puntuacion;
	}
	
	public static String toCSV() {
		return getNombrePlayer()+","+getPuntuacion()+"\n";
	}

	
}

