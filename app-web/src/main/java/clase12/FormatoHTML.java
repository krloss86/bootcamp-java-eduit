package clase12;

public class FormatoHTML extends FormatoBase implements Formateable {

	public FormatoHTML(Dato dato) {
		super(dato);
	}

	@Override
	public void formatear() {
		String html = "<html>";
		html =  html + "<p>id:" + super.getDato().getId() + "</p>";
		html =  html +"<p>descripcion:" + super.getDato().getDescripcion() + "</p>";
		html =  html +"</html>";
		System.out.println(html);
	}

}
