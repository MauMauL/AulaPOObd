package sistema.beans;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@ManagedBean
@ViewScoped
public class ProfessorManagedBean 
{

	private Professor professor = new Professor();
	private ProfessorService service = new ProfessorService();
	private List<Professor> professores;
	
	public void salvar()
	{
		service.salvar(professor);
		if (professores != null)
		{
			professores.add(professor);
		}
		professor = new Professor();		
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public void remove(Professor professor)
	{
		service.removeProfessor(professor);
		professores.remove(professor);
	}
	public void onRowEdit(RowEditEvent event) {

		Professor p = ((Professor) event.getObject());
		service.editaProfessor(p);
	}
	public List<Professor> getProfessores() {
		if (professores == null)
		{
			professores = service.getProfessores();
		}

		return professores;
	}
	
}
