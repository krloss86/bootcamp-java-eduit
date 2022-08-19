package ar.com.educacionit.web.enums;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
public class PDFAction implements IExportable {

	@Override
	public String exportar(Collection<Serializable> datos) {
		
		//obtener el jasper
		
		//armar los datos que son parametros
		Map<String,Object> params = new HashMap<>();
		params.put("USERNAME", "CARLOS");
		
		//armar los datos de la lista > field
		String fileName;
		try {
			String pathFile = "/reports/articulos-error.jasper";
			
			fileName = this.getClass().getResource(pathFile).toURI().getPath();
			
			FileInputStream fis = new FileInputStream(new File(fileName));
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(datos);

			JasperPrint jasperPrint = JasperFillManager.fillReport(fis,params,beanColDataSource);
			
			System.out.println(jasperPrint.getName());
			//llenar el jasper
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return ""; 
	}

}
