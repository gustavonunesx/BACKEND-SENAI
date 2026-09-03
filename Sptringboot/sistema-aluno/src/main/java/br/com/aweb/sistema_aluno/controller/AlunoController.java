package br.com.aweb.sistema_aluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aweb.sistema_aluno.model.Aluno;
import br.com.aweb.sistema_aluno.service.AlunoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    //listagem de alunos
    @GetMapping
    public String listAlunos(Model model) {
        model.addAttribute("alunos", service.getAllAlunos());
        return "aluno/list";
    }

    //retorna o formulário de cadastro de aluno
    @GetMapping("/new")
    public String showAlunoForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/form";
    }

    //retorna o formulário de edição de aluno
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Aluno aluno = service.getAlunoById(id);
        if (aluno == null) {
            return "redirect:/alunos";
        }
        model.addAttribute("aluno", aluno);
        return "aluno/form";
    }

    //salva um novo aluno ou atualiza um existente
    @PostMapping("/save")
    public String saveAluno(@Valid @ModelAttribute("aluno") Aluno aluno, BindingResult result) {
        if (result.hasErrors()) {
            return "aluno/form";
        }
        if (aluno.getId() != null) {
            service.updateAluno(aluno.getId(), aluno);
        } else {
            service.saveAluno(aluno);
        }
        return "redirect:/alunos";
    }

    //exclui um aluno
    @GetMapping("/delete/{id}")
    public String deleteAluno(@PathVariable Long id) {
        service.deleteAluno(id);
        return "redirect:/alunos";
    }
}
