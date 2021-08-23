package com.oracle.hackacloud.ms.restaurantes.model;

public class MensagemErro {
	
	private String mensagem;
	private String detalhe;
	
	public MensagemErro(String mensagem, String detalhe) {
		super();
		this.mensagem = mensagem;
		this.detalhe = detalhe;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

}
