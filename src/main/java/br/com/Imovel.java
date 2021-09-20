package br.com;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Imovel extends PanacheEntity{
	
	@Column(length = 100)
	public Double preco;
	
	@Column
	public String descricao;

	@Column
	public String cidade;
}
