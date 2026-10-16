package br.com.estudos.gameshelf.controller;

import br.com.estudos.gameshelf.model.Jogo;
import br.com.estudos.gameshelf.service.JogoService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jogos")
public class JogoController {

    private final JogoService service;

    public JogoController(JogoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(
            @RequestParam(required = false) String busca,
            Model model) {

        model.addAttribute("jogos", service.listar(busca));
        model.addAttribute("busca", busca == null ? "" : busca);

        return "jogos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("jogo", new Jogo());

        return "jogos/formulario";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("jogo", service.buscarPorId(id));

        return "jogos/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(
            @Valid @ModelAttribute("jogo") Jogo jogo,
            BindingResult resultado) {

        if (resultado.hasErrors()) {
            return "jogos/formulario";
        }

        service.salvar(jogo);

        return "redirect:/jogos";
    }

    @PostMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);

        return "redirect:/jogos";
    }
}