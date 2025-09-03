package com.ti2;

public class Filme {
	private int codigo;
	private String titulo;
	private String anolancamento;
	private String genero;
	
	public Filme() {
		this.codigo = -1;
		this.titulo = "";
		this.anolancamento = "";
		this.genero = "";
	}
	
	public Filme(int codigo, String titulo, String anolancamento, String genero) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.anolancamento = anolancamento;
		this.genero = genero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnolancamento() {
		return anolancamento;
	}

	public void setAnolancamento(String anolancamento) {
		this.anolancamento = anolancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", titulo=" + titulo + ", anolancamento=" + anolancamento + ", genero=" + genero + "]";
	}	
}
