package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@ManagedBean
@SessionScoped
public class ProfessorManagedBean 
{

	private Professor professor = new Professor();
	private ProfessorService service = new ProfessorService();
	private Professor professorSelecionado;
	
	public Professor getProfessorSelecionado() {
		return professorSelecionado;
	}
	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}
	public void onRowSelect(SelectEvent event) {
	     System.out.println("Evento Select: professorSelecionado : " +  (Professor) event.getObject());
	}
	
	public void onRowUnselect(SelectEvent event) {
		System.out.println("Evento UnSelect " +  (Professor) event.getObject());
			 
    }
	public void salvar()
	{
		service.salvar(professor);
		professor = new Professor();		
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() {
		return service.getProfessores();
	}
	
	public void remove(Professor professor)
	{
		service.removeProfessor(professor);
		
	}
	
	
}
