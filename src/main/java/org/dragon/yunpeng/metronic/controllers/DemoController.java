package org.dragon.yunpeng.metronic.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dragon.yunpeng.metronic.entities.Category;
import org.dragon.yunpeng.metronic.entities.Form;
import org.dragon.yunpeng.metronic.entities.Item;
import org.dragon.yunpeng.metronic.entities.SubCategory;
import org.dragon.yunpeng.metronic.pojos.FormListDto;
import org.dragon.yunpeng.metronic.pojos.XMLFile;
import org.dragon.yunpeng.metronic.repositories.CategoryRepository;
import org.dragon.yunpeng.metronic.repositories.ItemRepository;
import org.dragon.yunpeng.metronic.repositories.SubCategoryRepository;
import org.dragon.yunpeng.metronic.services.IFileService;
import org.dragon.yunpeng.metronic.services.IFormService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.StringReader;

@Controller
public class DemoController {

	Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private IFormService formService;

	@Autowired
	private IFileService fileService;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/")
	public String redirect() {

		return "pages/home";
	}

	@GetMapping("/forms")
	public String listForms(Model model) {
		model.addAttribute("forms", formService.getAllForms());

		return "pages/formList";
	}

	@GetMapping("/forms/dynamicFormEditList")
	public String dynamicFormEditList(Model model) {

		FormListDto formListDto = new FormListDto();
		formListDto.setForms(formService.getAllForms());

		model.addAttribute("formListDto", formListDto);

		return "pages/dynamicFormEditList";
	}

	@GetMapping("/forms/export")
	public String exportForms(Model model) {

		formService.exportData();

		model.addAttribute("forms", formService.getAllForms());
		return "pages/formList";
	}

	@GetMapping("/forms/uppyFileUpload")
	public String importXML(Model model) {

		return "pages/uppyFileUpload";
	}

	@GetMapping("/forms/fileUpload")
	public String fileUpload(Model model) {

		return "pages/fileUpload";
	}

	@GetMapping("/forms/xmlImportExportDemo")
	public String xmlImportExportDemo(Model model) {

		List<XMLFile> xmlFileList = fileService.getFileList();

		model.addAttribute("files", xmlFileList);

		return "pages/xmlImportExportDemo";
	}

	private boolean isValidXml(MultipartFile file) {

		boolean isValidXML = false;
		// Read the contents of the MultipartFile
		String xmlContent;
		try {
			xmlContent = new String(file.getBytes());
			// Parse the contents as XML
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setErrorHandler(null); // Disable error handler to prevent exceptions from being thrown
			InputSource inputSource = new InputSource(new StringReader(xmlContent));
			builder.parse(inputSource);

			// If parsing is successful, return true
			isValidXML = true;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (SAXException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		return isValidXML;

	}

	@PostMapping("/forms/importXML")
	public String importXML(@RequestParam("file") MultipartFile file, Model model) {

		// Logic to handle file upload

		if (!file.isEmpty()) {
			System.out.println("Received file: " + file.getOriginalFilename());
			System.out.println("File size: " + file.getSize());

			// Get the file name
			String fileName = file.getOriginalFilename();

			// Test if file is a valid XML
			boolean isValidXML = isValidXml(file);

			if (!isValidXML) {
				model.addAttribute("errorMessage", "File (" + fileName + ") is not a valid XML file.");
			} else {

				try {

					byte[] fileBytes = fileService.saveFile(file, fileName);

					model.addAttribute("successMessage", "File (" + fileName + ") is imported successfully.");

					String fileContent = new String(fileBytes, StandardCharsets.UTF_8);
					model.addAttribute("xmlText", fileContent);

					System.out.println(fileContent);

				} catch (IOException e) {
					e.printStackTrace();
					logger.error(e.getMessage(), e);

					model.addAttribute("errorMessage", "Importing file (" + fileName + ") failed.");
				}
			}

		} else {
			System.out.println("No file received.");

			model.addAttribute("warnMessage", "No file received.");
		}

		List<XMLFile> xmlFileList = fileService.getFileList();
		model.addAttribute("files", xmlFileList);

		return "pages/xmlImportExportDemo";
	}

	@GetMapping("/forms/download/{fileName}")
	public ResponseEntity<Resource> downloadFileFromLocal(@PathVariable String fileName) {

		Path path = Paths.get(fileService.getFileUploadDirectory() + fileName);
		Resource resource = null;
		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@PostMapping("/forms/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {

		// Logic to handle file upload

		if (!file.isEmpty()) {
			System.out.println("Received file: " + file.getOriginalFilename());
			System.out.println("File size: " + file.getSize());

			String UPLOAD_FOLDER = fileService.getFileUploadDirectory();

			// Get the file name
			String fileName = file.getOriginalFilename();

			try {

				// Create Path object
				Path path = Paths.get(UPLOAD_FOLDER + fileName);
				// Save the file
				Files.write(path, file.getBytes());

				model.addAttribute("successMessage", "File (" + fileName + ") is uploaded successfully.");

			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);

				model.addAttribute("errorMessage", "Uploading file (" + fileName + ") failed.");
			}

		} else {
			System.out.println("No file received.");

			model.addAttribute("warnMessage", "No file received.");
		}
		return "pages/fileUpload";
	}

	@PostMapping("/forms/uploadFromModal")
	public String uploadFileFromModal(@RequestParam("file") MultipartFile file, Model model) {

		// Logic to handle file upload

		if (!file.isEmpty()) {
			System.out.println("Received file: " + file.getOriginalFilename());
			System.out.println("File size: " + file.getSize());

			String UPLOAD_FOLDER = fileService.getFileUploadDirectory();

			// Get the file name
			String fileName = file.getOriginalFilename();

			try {

				// Create Path object
				Path path = Paths.get(UPLOAD_FOLDER + fileName);
				// Save the file
				Files.write(path, file.getBytes());

				// TODO
				Form newForm = formService.unmarshallXML(file.getInputStream());
				if (newForm != null) {
					formService.saveForm(newForm);
				}

				model.addAttribute("successMessage", "File (" + fileName + ") is uploaded successfully.");

			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);

				model.addAttribute("errorMessage", "Uploading file (" + fileName + ") failed.");
			}

		} else {
			System.out.println("No file received.");

			model.addAttribute("warnMessage", "No file received.");
		}
		return "pages/modalPage";
	}

	@PostMapping("/forms/importFromModal")
	public String importFromModal(@RequestParam("file") MultipartFile file, Model model) {

		// Logic to handle file upload

		if (!file.isEmpty()) {
			System.out.println("Received file: " + file.getOriginalFilename());
			System.out.println("File size: " + file.getSize());

			// Get the file name
			String fileName = file.getOriginalFilename();

			try {

				// TODO
				Form newForm = formService.unmarshallXML(file.getInputStream());
				if (newForm != null) {
					formService.saveForm(newForm);
				}

				model.addAttribute("successMessage", "File (" + fileName + ") is imported successfully.");

			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);

				model.addAttribute("errorMessage", "Importing file (" + fileName + ") failed.");
			}

		} else {
			System.out.println("No file received.");

			model.addAttribute("warnMessage", "No file received.");
		}

		return "redirect:/forms";
	}

	@GetMapping("/forms/new")
	public String newForm(Model model, HttpServletRequest request) {

		List<String> codes = formService.readCodeFromFile();

		Form form = new Form();
		form.setCodes(codes);

		List<Item> itemList = itemRepository.findAll();
		model.addAttribute("itemList", itemList);

		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);

		List<SubCategory> subCategories = subCategoryRepository.findAll();
		model.addAttribute("subCategories", subCategories);

		List<String> words = formService.readWordsFromFile();
		model.addAttribute("words", words);

		model.addAttribute("form", form);
		return "pages/formDetail";
	}
	
	@GetMapping("/forms/horizontal")
	public String newHorizontalForm(Model model, HttpServletRequest request) {

		return "pages/formHorizontal";
	}

	@PostMapping("/forms/save")
	public String saveForm(@ModelAttribute Form form, BindingResult result) {

		if (result.hasErrors()) {
			return "form-detail";
		}

		formService.saveForm(form);
		return "redirect:/forms";
	}

	@PostMapping("/forms/saveAll")
	public String saveAllForms(@ModelAttribute FormListDto formListDto, BindingResult result) {

		List<Form> forms = formListDto.getForms();

		for (Form form : forms) {
			formService.saveForm(form);
		}
		return "redirect:/forms/dynamicFormEditList";
	}

	@GetMapping("/forms/edit/{id}")
	public String editForm(@PathVariable Long id, Model model) {
		Form form = formService.getForm(id);

		List<String> codes = formService.readCodeFromFile();
		form.setCodes(codes);

		model.addAttribute("form", form);

		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("categories", categories);

		List<SubCategory> subCategories = subCategoryRepository.findAll();
		model.addAttribute("subCategories", subCategories);

		List<Item> itemList = itemRepository.findAll();
		model.addAttribute("itemList", itemList);

		List<String> words = formService.readWordsFromFile();
		model.addAttribute("words", words);

		return "pages/formDetail";
	}

	@GetMapping("/forms/delete/{id}")
	public String deleteForm(@PathVariable Long id) {
		formService.deleteForm(id);
		return "redirect:/forms";
	}

	@GetMapping("/forms/delete2/{id}")
	public String deleteForm2(@PathVariable Long id) {
		formService.deleteForm(id);
		return "redirect:/forms/dynamicFormEditList";
	}

	@GetMapping("/forms/export-xml")
	public ResponseEntity<byte[]> exportXmlFile() {
		// Generate XML content
		String xmlContent = generateXmlContent();

		// Convert XML content to bytes
		byte[] xmlBytes = xmlContent.getBytes();

		// Set headers for the response
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.setContentDispositionFormData("filename", "exported_data.xml");

		// Return response entity with XML content and headers
		return new ResponseEntity<>(xmlBytes, headers, HttpStatus.OK);
	}

	// Method to generate XML content (replace with your own logic)
	private String generateXmlContent() {

		return formService.exportDataToString();
	}

	@GetMapping("/forms/modalPage")
	public String modalPage(Model model, HttpServletRequest request) {

		return "pages/modalPage";
	}

	@GetMapping("/forms/samplePage")
	public String samplePage(Model model, HttpServletRequest request) {

		return "pages/samplePage";
	}
}
