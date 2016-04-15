package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Autor;

import sistema.modelos.Livro;

import sistema.service.AutorService;

import sistema.service.LivroService;



@ManagedBean
@ViewScoped

public class LivroManagedBean 
{

	private Livro livro = new Livro();
	private Autor autor;
    private LivroService livService = new LivroService();
    private AutorService autService = new AutorService();
    private List <Livro> livros;
    
	
	public void salvar()
	{
		autor.addLivro(livro);
		livro.setAutor(autor);
		livros.add(livro);
		
		livService.salvar(livro);
		
		livro = new Livro();
		autor = null;
		
	}
	
	
	
	public List <Autor> getAutores()
	{
		return autService.getAutores();
		
	}
	
	
	public Autor getAutor() {
		return autor;
	}


	public void remove(Livro livro)
	{
		livros.remove(livro);
		livService.remover(livro);
		
	}
	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public List<Livro> getLivros() {
		if(livros == null)
			livros = livService.getLivros();
		
		return livros;
	}
	
	
}
