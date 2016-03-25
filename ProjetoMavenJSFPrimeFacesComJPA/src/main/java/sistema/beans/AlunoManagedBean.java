package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;


import sistema.modelos.Aluno;
import sistema.service.AlunoService;

@ManagedBean
@SessionScoped
public class AlunoManagedBean {
	
	private Aluno aluno = new Aluno();
	private Aluno alunoSelecionado;
	private AlunoService service = new AlunoService();
	
	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}
	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}
	public void onRowSelect(SelectEvent event) {
	     System.out.println("Evento Select: alunoSelecionado : " +  (Aluno) event.getObject());
	}
	
	public void onRowUnselect(SelectEvent event) {
		System.out.println("Evento UnSelect " +  (Aluno) event.getObject());
			 
    }
	public void salvar()
	{
		service.salvar(aluno);
		aluno = new Aluno();
		
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return service.getAlunos();
	}
	public void remove(Aluno aluno)
	{
		service.removeAluno(aluno);
	}

	
	
	

}
