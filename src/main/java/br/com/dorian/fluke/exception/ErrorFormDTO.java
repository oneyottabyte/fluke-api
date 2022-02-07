package br.com.dorian.fluke.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorFormDTO {

	private String campo;
	private String erro;
	
}
