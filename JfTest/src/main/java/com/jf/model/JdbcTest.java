package com.jf.model;

import java.io.Serializable;

/**
 * spring jdbctemplate model
 * @author jiafengma
 */
public class JdbcTest implements Serializable {

	private static final long serialVersionUID = 6482608869319056049L;
	
	private long id;
	private String name;
	private int status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString(){
		return "JdbcTest:id=" + id + "|name=" + name + "|status=" + status;
	}

}
