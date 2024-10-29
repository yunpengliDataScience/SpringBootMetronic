package org.dragon.yunpeng.metronic.pojos;

import java.io.Serializable;

public class UserAndFruit implements Serializable {

	private String user;
	private String fruit;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	@Override
	public String toString() {
		return "UserAndFruit [user=" + user + ", fruit=" + fruit + "]";
	}

}
