package mz.com.library.domain;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "O Campo Autor é requerido")
	@Length(min = 3, max = 100, message = "O campo Autor deve ter entre 3 a 100 caracteres")
	private String autor;

	@NotEmpty(message = "O Campo Descrição é requerido")
	@Length(min = 3, max = 500, message = "O campo Título deve ter entre 3 a 100 caracteres")
	private String titulo;

	@NotEmpty(message = "O Campo localEd é requerido")
	@Length(min = 3, max = 100, message = "O campo localEd deve ter entre 3 a 100 caracteres")
	private String localEd;

	@NotEmpty(message = "O Campo Editora é requerido")
	@Length(min = 3, max = 100, message = "O campo Editora deve ter entre 3 a 100 caracteres")
	private String editora;

	@JsonIgnore // Evita a Serialização da classe
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Livro() {
		super();
	}

	public Livro(Integer id, String autor, String titulo, String localEd, String editora, Categoria categoria) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.localEd = localEd;
		this.editora = editora;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLocalEd() {
		return localEd;
	}

	public void setLocalEd(String localEd) {
		this.localEd = localEd;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return id == other.id;
	}

}
