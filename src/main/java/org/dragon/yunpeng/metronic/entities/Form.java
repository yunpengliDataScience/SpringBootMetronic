package org.dragon.yunpeng.metronic.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "form")
//@XmlType(propOrder = { "name", "code", "field1", "field2", "items", "textArea" })
@Entity
@Table(name = "FORM")
public class Form implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String field1;

	private String field2;

	private String code;

	private String word;

	@XmlTransient
	@ManyToOne
	private Category category;

	@XmlTransient
	@ManyToOne
	private SubCategory subCategory;

	private String textArea;

	private String comments;

	@XmlTransient
	@ManyToMany
	@JoinTable(name = "FORM_ITEM", joinColumns = @JoinColumn(name = "FORM_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	private Set<Item> items;

	@Transient
	private List<String> codes;

	// @XmlElement
	@XmlTransient
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlElement
	public String getField1() {
		return field1;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	@XmlElement
	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	@XmlElement
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	@XmlTransient
	public List<String> getCodes() {
		return codes;
	}

	public void setCodes(List<String> codes) {
		this.codes = codes;
	}

	@XmlElement
	public String getTextArea() {
		return textArea;
	}

	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", name=" + name + ", field1=" + field1 + ", field2=" + field2 + ", code=" + code
				+ ", word=" + word + ", category=" + category + ", subCategory=" + subCategory + ", textArea="
				+ textArea + ", items=" + items + ", codes=" + codes + "]";
	}

}
