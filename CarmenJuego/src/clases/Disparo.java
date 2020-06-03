package clases;

import implementacion.Juego;
//import com.sun.prism.paint.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Disparo extends ObjetoJuego{
    private HashMap<String,Animacion> animaciones;
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;
    private String animacionActual;
    private int cantidadPuntos;
    private boolean capturado = false;
    
    
    
    public Disparo (int x, int y, String nombreImagen, int velocidad, String animacionActual, int cantidadPuntos) {
        super(x, y, nombreImagen, velocidad);
        this.animacionActual = animacionActual;
        this.cantidadPuntos = cantidadPuntos;
        animaciones = new HashMap<String, Animacion>();
        inicializarAnimaciones();
    }

 
    public void setAnimacionActual(String animacionActual) {
        this.animacionActual = animacionActual;
    }

    public String getAnimacionActual() {
        return animacionActual;
    }

    public Rectangle obtenerRectangulo(){
       return new Rectangle(x, y, 40, 40);    
    }
    
    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    public boolean isCapturado() {
        return capturado;
    }
    
    public void setCantidadPuntos(int cantidadPuntos) {
        this.cantidadPuntos = cantidadPuntos;
    }

    public int getCantidadPuntos() {
        return cantidadPuntos;
    }
    
    @Override
    public void pintar(GraphicsContext graficos){
        if(this.capturado)
         return;
       
        else
          graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen, altoImagen, x, y,40,40);
 
        //graficos.strokeRect(x, y, 45, 40);
    }
    
    
    @Override
    public void mover(){
         y-=velocidad;     
       
       
       
       if(y<0)
       capturado = true;
       
       
       
              
    }
    
    
    public void inicializarAnimaciones(){
        Rectangle coordenadasDisparo[] = {
        new Rectangle(0,0,40,40)
        };     
        Animacion animacionDisparo = new Animacion(animacionActual, 0.65,coordenadasDisparo);
        animaciones.put("none",animacionDisparo);
  
              
        
    }
    
    
    
    
    
    
    public void calcularFrame(double t){
        Rectangle coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);
        this.xImagen = (int)coordenadas.getX();
        this.yImagen = (int)coordenadas.getY();
        this.altoImagen = (int)coordenadas.getWidth();
        this.anchoImagen = (int)coordenadas.getHeight();
        
    }
    
    
        
    
    
}//CIERRE CLAS