package fr.goat.utils;

/**
 * Genere les url avec l'action
 * @author clheriaud
 *
 */
public final class UrlGenerator {
	
	/**
	 * Methode generant une URL de la forme url_base + prefixe + action
	 * @param pAction
	 * @return
	 */
	public static String genererUrlAction(String pAction) {
		StringBuilder strBuilder = new StringBuilder(ConstantAPI.URL);
		strBuilder.append(ConstantAPI.PREFIX);
		strBuilder.append(pAction);
		return strBuilder.toString();	
	}
}
