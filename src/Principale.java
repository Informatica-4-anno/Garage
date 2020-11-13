import java.util.Scanner;

// Programma per gestire un piccolo garage
// Il garage possiede 10 posti
// in ogni posto può essere parcheggiata un'auto
// I posti sono numerati da 1 a 10
// Per ogni auto parcheggiata serve memorizzare: Targa, Marca, Modello, CF del proprietario.
// Operazioni:
//   1 - vedere se ci sono posti liberi o no.  -- OK
//   2 - inserire una nuova auto (auto entra)  
//        a - trovare il primo posto libero    -- OK
//        b - Inserire l'auto
//               b1 - creare l'auto
//               b2 - valorizzare l'auto
// 
//   3 - togliere un'auto (auto esce)
//   4 - data la targa di un'auto trovare il numero del parcheggio

//  --- ALGORITMO ---
// 
//   I posti auto sono rappresentati attraverso ARRAY di 10 elementi
//
//   +---------------------+--------------------+
//   |  |Targa   |         | Targa              |
//   |  |Marca   |         | Marca              |
//   |  |Modello |         | Modello            |   (array di auto) 
//   |  |CF      |         | CF                 |
//   +---------------------+--------------------+
//
// 
//   Un posto è libero se contiene null


public class Principale {
    // 
	// Conta il numero di posti liberi nel parcheggio contando i valori null
	//
	// La variabile v (parametro) è il nostro vettore di auto.
	// Il vettore di Auto è dichiarato nel main quindi locale e visibile 
	// solo nel main!!
	// Per accedere al vettore di Auto (ovvero il parcheggio) devo passarlo
	// come parametro al metodo.
	public static int contaPostiLiberi(Auto[] v) {
		int conta=0;
		for (int i=0;i<v.length;i++) 
			if (v[i]==null) conta++;
		return conta;
	}
	
	// Restituisce la posizione del primo posto libero (null) nell'array
	// se non ci sono posti libero restituisce -1
	public static int trovaPostoLibero(Auto[] v) {
		for (int i=0;i<v.length;i++) {
			if (v[i]==null) return i;
		}
		return -1;
	}
	
	public static int inserisciAuto(Auto[] v, int pos) {
				
		Scanner in = new Scanner(System.in);
		
		
		if ( pos >=0 && pos <10 && v[pos]==null ) {
			v[pos] = new Auto();
			System.out.println("Inserisci i dati dell'auto:");
			System.out.print(" -- targa: "); v[pos].targa=in.next();
			System.out.print(" -- marca: "); v[pos].marca=in.next();
			System.out.print(" -- modello: "); v[pos].modello=in.next();
			System.out.print(" -- CF Proprietario: "); v[pos].cf=in.next();
		    return pos;	
		}
		return -1;
	}
	
	public static void cancellaAuto(Auto[] v, int pos) {
		
		if ( pos >=0 && pos <10 ) v[pos]=null;
	}
	
	
	public static void main(String[] args) {
		Auto[] parcheggio = new Auto[10];
		
		// Vuoto il parcheggio
		for (int i=0; i<parcheggio.length;i++) {
			parcheggio[i]=null;			
		}

		
		System.out.println("Nel parcheggio ci sono: "+contaPostiLiberi(parcheggio));
		int posto=inserisciAuto(parcheggio, trovaPostoLibero(parcheggio));
		System.out.println("Auto inserita al posto: "+posto);
		posto=inserisciAuto(parcheggio, posto);
		System.out.println("Auto inserita al posto: "+posto);
		System.out.println("Nel parcheggio ci sono: "+contaPostiLiberi(parcheggio));
	}
}
