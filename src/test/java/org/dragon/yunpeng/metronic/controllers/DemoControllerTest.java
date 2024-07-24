package org.dragon.yunpeng.metronic.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.dragon.yunpeng.metronic.entities.Form;
import org.dragon.yunpeng.metronic.services.IFileService;
import org.dragon.yunpeng.metronic.services.IFormService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoControllerTest {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IFormService formService;
	
	@MockBean
	private IFileService fileService;

	@Test
	public void testListForms() throws Exception {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

		MockHttpSession session = new MockHttpSession();
		List<Form> formList = new ArrayList<Form>();

		when(formService.getAllForms()).thenReturn(formList);
		this.mockMvc.perform(get("/forms").session(session)).andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("pages/formList"))
				.andExpect(model().attributeExists("forms"));
		
		verify(formService, times(1)).getAllForms();
	}
	
	@Test
	public void testImportValidXML() throws Exception {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n"
				+ "<formList>\r\n"
				+ "    <form>\r\n"
				+ "        <id>5</id>\r\n"
				+ "        <name>Yunpeng Li</name>\r\n"
				+ "        <code>AAAAAA</code>\r\n"
				+ "        <field1>aaa</field1>\r\n"
				+ "        <field2>bbb</field2>\r\n"
				+ "        <textArea>aaaa</textArea>\r\n"
				+ "    </form>\r\n"
				+ "    <form>\r\n"
				+ "        <id>6</id>\r\n"
				+ "        <name>TFR From1</name>\r\n"
				+ "        <code>BBBBBB</code>\r\n"
				+ "        <field1>F1</field1>\r\n"
				+ "        <field2>F2</field2>\r\n"
				+ "        <textArea>AAABBCCC</textArea>\r\n"
				+ "    </form>\r\n"
				+ "</formList>";
		
		byte[] bytes=xml.getBytes();
		
		when(fileService.saveFile(any(), any())).thenReturn(bytes);
		
		// Create a mock file to upload
        MockMultipartFile file = new MockMultipartFile("file", "test.xml",
                "text/xml", xml.getBytes());

        // Perform a multipart file upload request
        mockMvc.perform(multipart("/forms/importXML")
                .file(file))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("pages/xmlImportExportDemo"))
                .andExpect(model().attributeExists("successMessage"))
                .andExpect(model().attributeExists("xmlText"));
		
	}
	
	@Test
	public void testImportInValidXML() throws Exception {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\r\n"
				+ "<formList>\r\n"
				+ "    <form>\r\n"
				+ "        <id>5</id>\r\n"
				+ "        <name>Yunpeng Li</name>\r\n"
				+ "        <code>AAAAAA</code>\r\n"
				+ "        <field1>aaa</field1>\r\n"
				+ "        <field2>bbb</field2>\r\n"
				+ "        <textArea>aaaa</textArea>\r\n"
				+ "    </form>\r\n"
				+ "    <form>\r\n"
				+ "        <id>6</id>\r\n"
				+ "        <name>TFR From1</name>\r\n"
				+ "        <code>BBBBBB</code>\r\n"
				+ "        <field1>F1</field1>\r\n"
				+ "        <field2>F2</field2>\r\n"
				+ "        <textArea>AAABBCCC</textArea>\r\n"
				+ "    </form>\r\n"
				+ "xyz";
		
		byte[] bytes=xml.getBytes();
		
		when(fileService.saveFile(any(), any())).thenReturn(bytes);
		
		// Create a mock file to upload
        MockMultipartFile file = new MockMultipartFile("file", "test.xml",
                "text/xml", xml.getBytes());

        // Perform a multipart file upload request
        mockMvc.perform(multipart("/forms/importXML")
                .file(file))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("pages/xmlImportExportDemo"))
                .andExpect(model().attributeExists("errorMessage"));
		
	}
}
