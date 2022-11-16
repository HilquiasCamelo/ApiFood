package com.hilquiascamelo.models.enums;

public enum UserType {

	USER(1, "USER_CLIENT"),
	EMPLOYEE(2, "USER_EMPLOYEE"),
	MANAGER(3, "USER_MANAGER"),
	DIRECTOR(4, "USER_MANAGER");

	private int cod;
	private String descricao;

	private UserType(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao () {
		return descricao;
	}

	public static UserType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (UserType x : UserType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}