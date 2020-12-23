
public class oraculo {

	public static void main(String[]args) {
		double descuento;
		int edad=0;
		int distancia=0;
		if(edad<18 && distancia >50 ) {
			descuento = 0.2;
		}else {
			descuento = 15;
		}
		if(edad > 65 && distancia > 100) {
			descuento = 0.5;
		}else 
			descuento = 0.4;
		
	}
	
}
