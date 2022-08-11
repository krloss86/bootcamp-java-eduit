package ar.com.educacionit.services.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ar.com.educacionit.services.exceptions.ParseException;

public class XLSXFileParser extends BaseFile implements IParser<Collection<ArticuloDTO>> {

	public XLSXFileParser(String filePath) {
		super(filePath);
	}

	@Override
	public Collection<ArticuloDTO> parse() throws ParseException {
		Collection<ArticuloDTO> list = new ArrayList<>();
		
		//Workbook
		
		//Sheet
		
		//Row
		
		//Cell
		File file = super.getFile();
		
		try(
			InputStream is = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(is); 
			) {
			
			//primer hoja
			Sheet sheet1 = workbook.getSheetAt(0);//pedimos la primer hoja 
			
			Iterator<Row> itRows = sheet1.iterator();//row
			
			Row row = itRows.next();
			
			while(itRows.hasNext()) {
				row = itRows.next();
				
				Iterator<Cell> itCells = row.cellIterator();
				
				while(itCells.hasNext()) {
					ArticuloDTO p = productoFromCell(itCells);
					list.add(p);
				}
			}
			
			return list;
		}catch (IOException fnfe) {
			fnfe.printStackTrace();
			throw new ParseException("No se ha podido convertir el archico: " + file.getPath(),fnfe);
		}
	}

	private ArticuloDTO productoFromCell(Iterator<Cell> itCells) {
		
		ArticuloDTO p = new ArticuloDTO();
		
		while(itCells.hasNext()) {
			Cell cell = itCells.next();
	
			switch (cell.getColumnIndex()) {
				case 0: //id
					p.setId((long)cell.getNumericCellValue());
					break;
				case 1: //nombre
					p.setTitle(cell.getStringCellValue());
					break;
				case 2: //codigo
					p.setCode(""+cell.getNumericCellValue());
					break;
				case 3: //precio
					p.setPrice(cell.getNumericCellValue());
					break;
				default:
					break;
				}
		}
		
		return p;
	}

}
