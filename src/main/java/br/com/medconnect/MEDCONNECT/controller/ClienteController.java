package br.com.medconnect.MEDCONNECT.controller;

import br.com.medconnect.MEDCONNECT.model.Cliente;
import br.com.medconnect.MEDCONNECT.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para exibir o formulário de cadastro
    @GetMapping("cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/cadastrar";
    }

    // Método para salvar o novo cliente
    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Cliente cliente, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "cliente/cadastrar";
        }
        clienteRepository.save(cliente);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
        return "redirect:/cliente/listar";
    }


    @GetMapping("listar")
    public String listar(Model model, @ModelAttribute("mensagem") String mensagem) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "cliente/listar";
    }


    @PostMapping("remover")
    @Transactional
    public String remover(@RequestParam Long idCliente, RedirectAttributes redirectAttributes) {
        clienteRepository.deleteById(idCliente);
        redirectAttributes.addFlashAttribute("mensagem", "Cliente removido com sucesso!");
        return "redirect:/cliente/listar";
    }
}
