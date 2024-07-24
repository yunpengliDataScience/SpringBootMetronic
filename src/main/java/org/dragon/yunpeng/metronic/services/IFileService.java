package org.dragon.yunpeng.metronic.services;

import java.io.IOException;
import java.util.List;

import org.dragon.yunpeng.metronic.pojos.XMLFile;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

	byte[] saveFile(MultipartFile file, String fileName) throws IOException;

	String getFileUploadDirectory();

	List<XMLFile> getFileList();

}
