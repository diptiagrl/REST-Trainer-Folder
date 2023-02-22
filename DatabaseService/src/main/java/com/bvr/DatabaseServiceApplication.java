package com.bvr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DatabaseServiceApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(DatabaseServiceApplication.class);
	
	
	@Autowired
	private BookRepository repository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("DB APPLICATION STARTED"  );
		
		repository.save(new Book("Apache Spark"));
		repository.save(new Book("Scala"));
		repository.save(new Book("Python"));
		repository.save(new Book("GoLang"));
		repository.save(new Book("Java"));
		repository.save(new Book("Javascript"));
		repository.save(new Book("Kotlin"));
		
		
		System.out.println("");
		
		System.out.println("\n Find all Records ");
		
		repository.findAll().forEach(x -> System.out.println(x));

	
		System.out.println("");
		
		System.out.println("\n Find by id Record ");
		
		repository.findById(4L).ifPresent(x -> System.out.println(x));
		
		
		System.out.println("");
		
		System.out.println("\n Find By Name Records ");
		
		repository.findByName("Java").forEach(x -> System.out.println(x));

		
		System.out.println("");
		
		System.out.println("\n Update Records ");
		
		repository.findById(52L).ifPresent(x -> {
			System.out.println(x);
			x.setName("Python - pySpark");
			repository.save(x);
		});
		
		
		System.out.println("\n Delete by Book Id");
		
		Book bookToDelete = repository.findById(4L).get();
		
		System.out.println("Book To Delete : " + bookToDelete.getName());
		
		repository.delete(bookToDelete);
		
		
	}
	
	

}
