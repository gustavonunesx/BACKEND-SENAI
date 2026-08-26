package br.com.aweb.sistema_aluno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aweb.sistema_aluno.model.Aluno;
import br.com.aweb.sistema_aluno.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    //buscar todos os alunos
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    //buscar aluno por id
    public Aluno getAlunoById(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    //salvar aluno
    public Aluno saveAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    //atualizar aluno
    public Aluno updateAluno(Long id, Aluno aluno) {
        Aluno existingAluno = alunoRepository.findById(id).orElse(null);
        if (existingAluno != null) {
            existingAluno.setNome(aluno.getNome());
            existingAluno.setEmail(aluno.getEmail());
            existingAluno.setDataNascimento(aluno.getDataNascimento());
            existingAluno.setCurso(aluno.getCurso());
            return alunoRepository.save(existingAluno);
        }
        return null;
    }

    //excluir aluno
    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
