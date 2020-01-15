package com.vinnijr.gestaocontatos.model;

public enum Canal {
	CELULAR("Celular"), 
	EMAIL("Email"),
	FIXO("Fixo"); 

	private String label;

	private Canal(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}


}
