package com.foozcorp.SpringAuto.models;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private int nbrStreet;
	private String street;
	private String city;
	private String zipCode;
	private String country;

	public Address() {
		super();
	}

	public int getNbrStreet() {
		return nbrStreet;
	}

	public void setNbrStreet(int nbrStreet) {
		this.nbrStreet = nbrStreet;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [nbrStreet=");
		builder.append(nbrStreet);
		builder.append(", street=");
		builder.append(street);
		builder.append(", city=");
		builder.append(city);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", country=");
		builder.append(country);
		builder.append("]");
		return builder.toString();
	}

}
