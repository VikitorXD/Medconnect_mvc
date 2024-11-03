package br.com.medconnect.MEDCONNECT.controller;


import br.com.medconnect.MEDCONNECT.model.Produto;
import br.com.medconnect.MEDCONNECT.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Produto prod, Model model) {
        return "produto/cadastrar"; // Retorna a view de cadastro
    }

    @PostMapping("cadastrar")
    public String cadastroProduto(@Valid Produto prod, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "produto/cadastrar"; // Retorna à página de cadastro se houver erro
        }
        produtoRepository.save(prod);
        redirectAttributes.addFlashAttribute("mensagem", "SEU PRODUTO FOI CADASTRADO!");
        return "redirect:/produto/listar"; // Redireciona para a lista de produtos após cadastro
    }

    @GetMapping("editar/{id}") // Corrigido o mapeamento
    public String editar(@PathVariable("id") Long id, Model model) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto inválido: " + id));
        model.addAttribute("produto", produto);
        return "produto/editar"; // Retorna a view de edição
    }

    @PostMapping("editar") // Corrigido o mapeamento
    public String editarProduto(@ModelAttribute Produto produto) {
        produtoRepository.save(produto); // Salva o produto atualizado
        return "redirect:/produto/listar"; // Redireciona para a lista de produtos
    }

    @PostMapping("remover")
    @Transactional
    public String remover(Long codigo, RedirectAttributes redirectAttributes) {
        produtoRepository.deleteById(codigo);
        redirectAttributes.addFlashAttribute("mensagem", "Produto removido com sucesso!");
        return "redirect:/produto/listar"; // Redireciona para a lista após remoção
    }

    @GetMapping("listar")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produto/listar"; // Retorna a view de listagem
    }
}
