package ar.com.educacionit.services.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import ar.com.educacionit.services.exceptions.ParseException;

public class CSVFileParserTestCase {

	@Test
	public void when_nullfilename_then_throw_exception() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CSVFileParser(null);
		});
	}

	@Test
	public void when_blankfilename_then_throw_exception() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CSVFileParser("");
		});
	}

	@Test
	public void when_file_doesnot_exists_then_() {
		assertThrows(ParseException.class, () -> {
			new CSVFileParser("c:/bla/bla").parse();
		});
	}

	@Test
	public void when_create_doesexist() {
		assertNotNull(new CSVFileParser("C:/bla/bla"));
	}

	@Test
	public void when_fileexists_then_verify_size() throws ParseException {
		CSVFileParser parser = new CSVFileParser("C:\\desarrollo\\educationit\\bootcamp\\argentina\\archivo.csv");
		Collection<Producto> list = parser.parse();
		assertEquals(2,list.size());
	}
	
	@Test
	public void when_xlsx_fileexists_then_verify_size() throws ParseException {
		XLSXFileParser parser = new XLSXFileParser("C:\\desarrollo\\educationit\\bootcamp\\argentina\\archivo.xlsx");
		Collection<Producto> list = parser.parse();
		assertEquals(2,list.size());
	}
}
