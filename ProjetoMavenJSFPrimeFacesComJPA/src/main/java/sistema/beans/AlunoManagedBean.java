package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import sistema.modelos.Aluno;
import sistema.service.AlunoService;

@ManagedBean
@ViewScoped
public class AlunoManagedBean {
	
	private Aluno aluno = new Aluno();
	private List<Aluno> alunos;
	private AlunoService service = new AlunoService();
	
	public void salvar()
	{
		service.salvar(aluno);
		
		if (alunos != null)
		{
			alunos.add(aluno);
		}
		aluno = new Aluno();
		
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public void remove(Aluno aluno)
	{
		service.removeAluno(aluno);
		alunos.remove(aluno);
	}
	public void onRowEdit(RowEditEvent event) {

		Aluno a = ((Aluno) event.getObject());
		service.editaAluno(a);
	}
	public List<Aluno> getAlunos() {
		if (alunos == null)
		{
			alunos = service.getAlunos();
		}

		return alunos;
	}
	
	
	

}
