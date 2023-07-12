package mx.ipn.upiicsa.poo.planeta;

public class Main {
    public static void main(String[] args) {
        double densidad;
        Planeta p1 = new Planeta("Mercurio", 0, 330200, 608300, 48794, 57, true);
        p1.monstrarDatos();
        TipoPlaneta tipo1 = TipoPlaneta.TERRESTE;
        if (tipo1 == TipoPlaneta.TERRESTE) {
            System.out.println("Es un planeta terrestre");
            densidad = p1.masa / p1.volumen;
            System.out.println("Su densidad es: " + densidad);
            System.out.println("Es un planeta interior al sistema solar");
        }
        System.out.println("\n");
        Planeta p2 = new Planeta("Júpiter", 92,1899000,1431300,142984,2,false);
        p2.monstrarDatos();
        TipoPlaneta tipo2 = TipoPlaneta.GASEOSO;
        if(tipo2 == TipoPlaneta.GASEOSO){
            System.out.println("Es un planeta gaseoso");
            densidad = p2.masa / p2.volumen;
            System.out.println("Su densidad es: " + densidad);
            System.out.println("Es un planeta exterior al sistema solar");
        }
    }
}