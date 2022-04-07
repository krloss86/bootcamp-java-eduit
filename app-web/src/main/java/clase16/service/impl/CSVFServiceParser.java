package clase16.service.impl;

import clase16.parser.IParser;
import clase16.parser.impl.CSVFileParser;
import clase16.service.FileService;
import clase16.type.CSV;

public class CSVFServiceParser implements FileService{

	private IParser<CSV> parser;
	
	public CSVFServiceParser(String file) {
		this.parser = new CSVFileParser(file);
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
