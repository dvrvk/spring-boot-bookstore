package com.example;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(App.class, args);
		var repo = context.getBean(BookRepository.class);

		List<Book> books = List.of(
				new Book(null, "El Quijote", "Miguel de Cervantes", 19.99),
				new Book(null, "Cien Años de Soledad", "Gabriel García Márquez", 24.99),
				new Book(null, "Don Juan Tenorio", "José Zorrilla", 14.99),
				new Book(null, "La Casa de Bernarda Alba", "Federico García Lorca", 12.99),
				new Book(null, "La Sombra del Viento", "Carlos Ruiz Zafón", 18.99)
		);

		repo.saveAll(books);
	}

}
