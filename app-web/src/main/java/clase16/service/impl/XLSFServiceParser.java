package clase16.service.impl;

import clase16.parser.IParser;
import clase16.parser.impl.XSLFileParser;
import clase16.service.FileService;
import clase16.type.XSL;

public class XLSFServiceParser implements FileService {

	private IParser<XSL> parser; 
	
	public XLSFServiceParser(String file) {
		this.parser = new XSLFileParser(file);
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
