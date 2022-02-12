package br.com.dorian.fluke.util.config;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class CheckExpiration {
	
	public static String isExpiration(LocalDate fimVigencia) {
		String str;
	    LocalDate today = LocalDate.now(); 
		if (fimVigencia.compareTo(today) < 0) {
			long dias = DAYS.between(fimVigencia, today);
		    str = "Vencido a "+ dias + " dia(s)!";
		    return str;
		} else {
			long dias = DAYS.between(today, fimVigencia);
			str = "Ainda não Venceu! Vencerá em " + dias + " dia(s)!";
			return str;
		}
	}
}
