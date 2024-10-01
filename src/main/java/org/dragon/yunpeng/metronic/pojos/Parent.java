package org.dragon.yunpeng.metronic.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Parent implements Serializable {
	private String name;

	private List<Child> children;

	public Parent() {
		String name = "Parent";
		// Initialize with 3 children for demonstration purposes
		children = new ArrayList<Child>();

		for (int i = 0; i < 4; i++) {
			Child child = new Child();
			child.setTitle("Child " + i);
			children.add(child);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

}
