package br.com.estudos.gameshelf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudos.gameshelf.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    List<Jogo>
    findByTituloContainingIgnoreCaseOrDesenvolvedoraContainingIgnoreCase(
        String titulo,
        String desenvolvedora
    );
}