package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController// Indica que essa classe é um controller REST → responde requisições HTTP (JSON)
@RequestMapping("medicos")// Define o caminho base da API → tudo aqui começa com /medicos
public class MedicosController {// Declaração da classe do controller

    @Autowired// Diz para o Spring injetar automaticamente uma instância do repository

    private MedicoRepository repository;// Repositório responsável por acessar o banco de dados (CRUD de médicos)


    @PostMapping// Mapeia requisições HTTP do tipo POST → usado para criar dados

    @Transactional// Garante que a operação será executada dentro de uma transação no banco

    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {// Método para cadastrar médico // @RequestBody → pega os dados do corpo da requisição (JSON) // @Valid → valida os dados com base nas anotações da classe DTO

        repository.save(new Medico(dados));// Cria um novo objeto Medico usando os dados recebidos // e salva no banco de dados
    }


    @GetMapping// Mapeia requisições GET → usado para buscar dados

    public Page<DadosLIstagenMedico> Listar( // Método que retorna uma lista paginada de médicos

            @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        // Define paginação padrão:
        // size = 10 → 10 registros por página
        // sort = nome → ordena pelo nome
        // Pageable → objeto que o Spring usa para controlar paginação

        return repository.findAllByAtivoTrue(paginacao)// Busca no banco apenas médicos com "ativo = true", aplicando paginação

                .map(DadosLIstagenMedico::new);// Converte cada Medico em um DTO (DadosLIstagenMedico)
    }


    @PutMapping// Mapeia requisições PUT → usado para atualizar dados

    @Transactional// Garante que a atualização será feita em uma transação

    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){// Método para atualizar um médico// Recebe dados do corpo da requisição e valida

        Medico medico = repository.getReferenceById(dados.id());// Busca uma referência do médico pelo ID (não faz SELECT imediato)

        medico.atualizarInformacoes(dados);// Atualiza os dados do médico com base no DTO recebido
    }


    @DeleteMapping("/{id}")// Mapeia requisições DELETE com um parâmetro na URL (ex: /medicos/1)

    @Transactional// Garante que a exclusão será feita em transação

    public void excluir(@PathVariable Long id){// Método para excluir médico// @PathVariable → pega o ID direto da URL

        Medico medico = repository.getReferenceById(id);// Busca a referência do médico pelo ID

        medico.excluir();// Marca o médico como excluído (provavelmente um delete lógico)
    }
}
