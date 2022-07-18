package io.verificacion.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Personas {

	@SerializedName("list")
	private List<PersonasPeticion> list = null;

	public List<PersonasPeticion> getList() {
		return list;
	}

	public void setList(List<PersonasPeticion> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Personas [list=" + list + "]";
	}
	
}
