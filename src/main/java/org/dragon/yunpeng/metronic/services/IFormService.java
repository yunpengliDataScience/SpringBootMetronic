package org.dragon.yunpeng.metronic.services;

import java.io.InputStream;
import java.util.List;

import org.dragon.yunpeng.metronic.entities.Form;

public interface IFormService {

	List<String> readCodeFromFile();

	void exportData();

	List<Form> getAllForms();

	Form getForm(Long id);

	void deleteForm(Long id);

	Form saveForm(Form form);

	String exportDataToString();

	Form unmarshallXML(InputStream xmlInputStream);

}
