package clase12;

public class FormatoPDF extends FormatoBase implements Formateable {

	public FormatoPDF(Dato dato) {
		super(dato);
	}

	@Override
	public void formatear() {
		System.out.println("formateando en pdf");
	}

}
