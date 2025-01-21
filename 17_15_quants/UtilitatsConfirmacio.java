/* Funcion que comprueba una respuesta y retorna true o false */
public class UtilitatsConfirmacio {
	public static boolean respostaABoolean(String resposta) {
		if (null == resposta) {
			return false;
		}
		resposta = resposta.toLowerCase();
		if (resposta.equals("s") || resposta.equals ("y")) {
			return true;
		}
		if (resposta.equals("sí") || resposta.equals("yes")) {
			return true;
		}
		if (resposta.equals("si") || resposta.equals("vale") || resposta.equals("yeah")) {
			return true;
		}
		return false;
	}
}
