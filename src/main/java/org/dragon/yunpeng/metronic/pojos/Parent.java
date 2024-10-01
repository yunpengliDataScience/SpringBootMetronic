package org.dragon.yunpeng.metronic.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Parent implements Serializable {
	private List<Child> children;

	public Parent() {
		// Initialize with 3 children for demonstration purposes
		children = new ArrayList<Child>();
		children.add(new Child());
		children.add(new Child());
		children.add(new Child());
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

}
