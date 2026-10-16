package br.com.estudos.gameshelf.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import br.com.estudos.gameshelf.model.Jogo;
import br.com.estudos.gameshelf.repository.JogoRepository;

@Service
public class JogoService {

    private final JogoRepository repository;

    public JogoService(JogoRepository repository) {
        this.repository = repository;
    }

    public List<Jogo> listar(String busca) {
        if (busca == null || busca.isBlank()) {
            return repository.findAll();
        }

        return repository
            .findByTituloContainingIgnoreCaseOrDesenvolvedoraContainingIgnoreCase(
                busca,
                busca
            );
    }

    public Jogo buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Jogo não encontrado."
            ));
    }

    public void salvar(Jogo jogo) {
        repository.save(jogo);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}