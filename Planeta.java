package mx.ipn.upiicsa.poo.planeta;

public class Planeta {
    String nombre = null;
    int cantidad_satelites = 0;
    double masa = 0;
    double volumen = 0;
    int diametro = 0;
    int distanciasol = 0;
    boolean observableasimplevista = false;

    public Planeta(String _nombre, int _cantidad_satelites, double _masa, double _volumen, int _diametro, int _distanciasol, boolean _observableasimplevista){
        nombre = _nombre;
        cantidad_satelites = _cantidad_satelites;
        masa = _masa;
        volumen = _volumen;
        diametro = _diametro;
        distanciasol = _distanciasol;
        observableasimplevista = _observableasimplevista;
    }
    public void monstrarDatos(){
        System.out.println("El nombre del planeta es: "+nombre);
        System.out.println("La cantidad de satelites es: "+cantidad_satelites);
        System.out.println("Su masa en kilometros es es: "+masa);
        System.out.println("Su volumen en kilometros es: "+volumen);
        System.out.println("Su diámetro en  kilometros es: "+diametro);
        System.out.println("Su distancia media al sol en millones de kilometros es: "+distanciasol);
        System.out.println("Es observable a simple vista: "+observableasimplevista);
    }

}
