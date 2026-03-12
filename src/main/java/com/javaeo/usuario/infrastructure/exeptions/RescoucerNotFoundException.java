package com.javaeo.usuario.infrastructure.exeptions;

public class RescoucerNotFoundException extends RuntimeException{

    public RescoucerNotFoundException(String mensagem){
		super(mensagem);
	}

	public RescoucerNotFoundException(String mensagem, Throwable throwable){
		super(mensagem, throwable);
	}
}
