package clase16.parser;

public class FileBase {

	protected String fileContent;

	public FileBase(String fileContent) {
		if(fileContent != null) {
			this.fileContent = fileContent;
		}else {
			fileContent = "";//errores			
		}
	}

}
