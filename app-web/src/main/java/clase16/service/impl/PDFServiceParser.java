package clase16.service.impl;

import clase16.parser.IParser;
import clase16.parser.impl.PDFFileParser;
import clase16.service.FileService;
import clase16.type.PDF;

public class PDFServiceParser implements FileService {
	
	private IParser<PDF> parser;
	
	public PDFServiceParser(String file) {
		this.parser = new PDFFileParser(file);
	}

	@Override
	public boolean validate() { 
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

}
