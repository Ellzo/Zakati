package utils;

import java.awt.Dimension;

public final class Consts {
	
	/**
	 * Strings
	 */
	public static final String TITLE = "Calcul de la Zakat";
	public static final String ZAKAT_MONNAIE = "Zakat de la monnaie";
	public static final String ZAKAT_TRANS_COM = "Zakat des transactions commerciales";
	public static final String ZAKAT_ACT = "Zakat des actions";
	public static final String ZAKAT_OBL = "Zakat des obligations";
	public static final String ZAKAT_BON = "Zakat des bons de caisse";
	public static final String ZAKAT_OR = "Zakat de l’or";
	public static final String ZAKAT_ARG = "Zakat de l’argent";
	public static final String ZAKAT_TOTALE = "Zakat Totale";
	
	public static final String UNIT = "DA";
	public static final String START = "Commencer";
	public static final String NEXT = "Prochain";
	public static final String GO_HOME = "Aller au menu principale";
	public static final String CALC = "Calculer";
	public static final String NOTE = "Note";
	
	public static final String ENTRER_MONTANT = String.format("Enter votre montant en %s: ", UNIT);
	public static final String VAL_MARCH = String.format("Valeur de la marchandise en %s: ", UNIT);
	public static final String MON_EPARGNE = String.format("Monnaie épargnée en %s: ", UNIT);
	public static final String DET_ESCOMPTE = String.format("Dettes escomptées en %s: ", UNIT);
	public static final String DET_NON_LIQUIDE = String.format("Dettes non liquidés en %s: ", UNIT);
	public static final String VAL_ACT = String.format("Valeur de l'action en %s: ", UNIT);
	public static final String NUM_ACT = "Nombre des actions: ";
	public static final String VAL_OBL = String.format("Valeur de l'obligation en %s: ", UNIT);
	public static final String NUM_OBL = "Nombre des obligations: ";
	public static final String VAL_BON = String.format("Valeur du bons en %s: ", UNIT);
	public static final String NUM_BON = "Nombre des bons: ";
	public static final String OR_24 = "Poids de l'or de 24 carats en gramme: ";
	public static final String OR_21 = "Poids de l'or de 21 carats en gramme: ";
	public static final String OR_18 = "Poids de l'or de 18 carats en gramme: ";
	public static final String POIDS_ARG = "Poids de l'argent en gramme: ";
	public static final String ZAKAT_TYPE_MONTANT = "La montant de cette Zakat est: ";
	public static final String ZAKAT_TOTALE_MONTANT = "Montant totale de la Zakat est: ";

	public static final String PRIX_OR = "Prix d'un seul gramme d'or de 24 carats: ";
	public static final String PRIX_ARG = "Prix d'un seul gramme d'orargent: ";
	
	public static final String TEMPS_VERS = "Temps du versement pour chaque type de Zakat est aprés une année hégire révolue";
	
	/**
	 * Integers
	 */
	public static final int MARGIN = 15;
	public static final int PRIX_OR_INIT = 8140;
	public static final int PRIX_ARG_INIT = 102;
	
	public static final int ACT_PANEL = 541;
	public static final int OBL_PANEL = 11;
	public static final int BON_PANEL = 946;
	
	/**
	 * Dimensions
	 */
	public static final Dimension FIELD_DIMEN = new Dimension(250, 36);
	
	
	private Consts() {}
}
