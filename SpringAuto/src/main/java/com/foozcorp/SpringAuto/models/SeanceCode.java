package com.foozcorp.SpringAuto.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "seanceCode")
public class SeanceCode extends AuditModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String lieu;

	@NotNull
	@Max(value = 35)
	@Min(value = 5)
	private Integer nbrPlace;

	@NotNull
	private String nom;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_seances", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "seance_id"))
	private List<User> userList;

	public SeanceCode() {
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Integer getNbrPlace() {
		return nbrPlace;
	}

	public void setNbrPlace(Integer nbrPlace) {
		this.nbrPlace = nbrPlace;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SeanceCode [id=");
		builder.append(id);
		builder.append(", lieu=");
		builder.append(lieu);
		builder.append(", nbrPlace=");
		builder.append(nbrPlace);
		builder.append(", nom=");
		builder.append(nom);
		builder.append("]");
		return builder.toString();
	}

}
