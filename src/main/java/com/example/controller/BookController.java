package com.example.controller;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String index() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String findAll(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book-list";
    }

    @GetMapping("/books/view/{id}")
    public String findById(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookRepository.findById(id).get());
        return "book-view";
    }

    @GetMapping("/books/form")
    public String getEmptyForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @GetMapping("/books/edit/{id}")
    public String getFormEdit(Model model, @PathVariable Long id) {
        if(bookRepository.existsById(id)) {
            bookRepository.findById(id).ifPresent(b -> model.addAttribute("book", b));
            return "book-form";
        } else {
            return "redirect:/books";
        }

    }

    @PostMapping("/books/create")
    public String create(@ModelAttribute Book book) {
        if(book.getId() != null) {
            // Actualizar - guardando los campos que queramos
            // Opcion 1 -> bookRepository.existsById(book.getId()))
            bookRepository.findById(book.getId()).ifPresent(b -> {
                b.setAuthor(book.getAuthor());
                b.setPrice(book.getPrice());
                b.setTitle(book.getTitle());
                bookRepository.save(b);
            });

        } else {
            // Crear
            // Aquí se haría alguna comprobacion (que no exista el id)
            bookRepository.save(book);
        }

        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        // Si existe lo borra
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        }
        return "redirect:/books";
    }

}
