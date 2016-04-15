package sistema.beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sistema.modelos.Autor;
import sistema.service.AutorService;

@FacesConverter("converterAutor")
public class AutorConverter implements Converter 
{
	private AutorService servico = new AutorService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Autor a : servico.getAutores())
				 if(a.getNome().equals(value))
				  	return a;
					
		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object autor) {
		if (autor == null || autor.equals("")) {
			return null;
		} else {
			return ((Autor) autor).getNome();

		}
	}
}
