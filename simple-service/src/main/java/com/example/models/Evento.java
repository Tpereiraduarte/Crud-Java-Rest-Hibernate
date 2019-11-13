package com.example.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventos")
public class Evento {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Column(name = "data")
	private Calendar data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
}
