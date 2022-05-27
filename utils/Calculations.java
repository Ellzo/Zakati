package utils;

public final class Calculations {
	private static int prixOr;
	private static int prixArg;
	
	public static void setPrixOr(int prix) {
		prixOr = prix;
	}
	
	public static int getPrixOr() {
		return prixOr;
	}
	
	public static void setPrixArgent(int prix) {
		prixArg = prix;
	}
	
	public static int getPrixArgent() {
		return prixArg;
	}
	
	public static double calcZakatMonnaie(int montant) {
		if(montant < 85 * prixOr) {
			return 0;
		}else {
			return (montant * 2.5) / 100;
		}
	}
	
	public static double calcZakatTransCom(int marchandise, int monnaieEpargnee, int dettesEscomptees, int dettes) {
		int s = marchandise + monnaieEpargnee + dettesEscomptees - dettes;
		if(s < 85 * prixOr) {
			return 0;
		}else {
			return (s * 2.5) / 100;
		}
	}
	
	public static double calcZakatActOblBon(int valeurMarche, int num) {
		if(valeurMarche * num < 85 * prixOr) {
			return 0;
		}else {
			return ((valeurMarche * num) * 2.5) / 100;
		}
	}
	
	public static double calcZakatOr(int poidsOr24, int poidsOr21, int poidsOr18){
		double poidsNet = poidsOr24 + (24.0 / 24) * poidsOr21 + (24.0 / 18) * poidsOr18;
		if(poidsNet < 85) {
			return 0;
		}else {
			return ( poidsNet * prixOr * 2.5 ) / 100;
		}
	}

	public static double calcZakatArgent(int poids) {
		if(poids < 595) {
			return 0;
		}else {
			return (poids * prixArg * 2.5) / 100;
		}
	}
	
	private Calculations() {}
}
