package service;

import java.io.File;

public interface SingleUpload {
	String upload(File file,String savePath,String fileName);
}
