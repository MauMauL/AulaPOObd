package sistema.beans;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Autor;
import sistema.modelos.Fornecedor;
import sistema.service.AutorService;
import sistema.service.FornecedorService;

public class AutorDataModel  extends ListDataModel<Autor> implements SelectableDataModel<Autor>
{
private AutorService servico = new AutorService();
	
	public AutorDataModel()
	{
		
	}

	public AutorDataModel(List <Autor> list)
	{
	   super(list);	
	}

	
	@Override
	public Autor getRowData(String rowKey) {
		
		for(Autor a: servico.getAutores())
		   if(Integer.parseInt(rowKey) ==  a.getCodigo())
			   return a;
		
		return null;
	}

	@Override
	public Object getRowKey(Autor autor) {
		return autor.getCodigo();
	}
	
}
