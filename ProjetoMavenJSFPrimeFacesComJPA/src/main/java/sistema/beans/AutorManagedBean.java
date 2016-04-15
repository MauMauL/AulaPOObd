package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;
import sistema.beans.AutorDataModel;
import sistema.modelos.Autor;
import sistema.modelos.Livro;
import sistema.service.AutorService;

@ManagedBean
@ViewScoped
public class AutorManagedBean 
{
	private Autor autor = new Autor();
	private Autor autorSelecionado;
    private AutorService servico = new AutorService();
    private List <Autor> autores;
    
    public Autor getAutorSelecionado() {
		return autorSelecionado;
	}

	/**
	 * @param autorSelecionado the autorSelecionado to set
	 */
	public void setAutorSelecionado(Autor autorSelecionado) {
		this.autorSelecionado = autorSelecionado;
	}

	public void salvar()
	{
		servico.salvar(autor);
		
		if(autores != null)
			autores.add(autor);
		
		
		autor = new Autor();
		
	}
	
	public DataModel<Autor> getAutores()
	{
		if(autores == null)
			autores = servico.getAutores();
		
		return new AutorDataModel(autores);
	}
	
	
	public Autor getAutor() {
		return autor;
	}

	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List <Livro> getLivrosAutor()
	{
		if(autorSelecionado != null)
		{
			return servico.pesquisarLivrosAutor(autorSelecionado);
		}
		else
			return null;
	}
	
	
	public void onRowEdit(RowEditEvent event) {

		Autor a = ((Autor) event.getObject());
		servico.alterar(a);
	}

}
