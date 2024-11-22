package br.com.ProjetoOasis.controller;

import br.com.ProjetoOasis.model.Cliente;
import br.com.ProjetoOasis.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Exibe o formulário de cadastro
    @GetMapping("cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/cadastrar";
    }

    // Salva um novo cliente
    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(
            @Valid Cliente cliente,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "cliente/cadastrar";
        }

        clienteRepository.save(cliente);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
        return "redirect:/cliente/cadastrar";
    }

    // Lista todos os clientes
    @GetMapping("listar")
    public String listar(Model model, @ModelAttribute("mensagem") String mensagem) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "cliente/listar";
    }

    // Remove um cliente
    @PostMapping("remover")
    @Transactional
    public String remover(
            @RequestParam Long idCliente,
            RedirectAttributes redirectAttributes) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        if (cliente.isPresent()) {
            clienteRepository.deleteById(idCliente);
            redirectAttributes.addFlashAttribute("mensagem", "Cliente removido com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("erro", "Cliente não encontrado para remoção.");
        }

        return "redirect:/cliente/listar";
    }

    // Exibe o formulário de edição de um cliente
    @GetMapping("editar/{idCliente}")
    public String editar(
            @PathVariable Long idCliente,
            Model model,
            RedirectAttributes redirectAttributes) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "cliente/editar";
        } else {
            redirectAttributes.addFlashAttribute("erro", "Cliente não encontrado para edição.");
            return "redirect:/cliente/listar";
        }
    }

    // Atualiza os dados de um cliente
    @PostMapping("editar")
    @Transactional
    public String editar(
            @Valid Cliente cliente,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "cliente/editar";
        }

        clienteRepository.save(cliente);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente atualizado com sucesso!");
        return "redirect:/cliente/listar";
    }
}
