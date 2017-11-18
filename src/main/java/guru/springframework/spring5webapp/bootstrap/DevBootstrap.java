package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.repositories.AuthorRepository;
import guru.springframework.spring5webapp.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    public DevBootstrap() {
    }

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Stephan
        Author stephan = new Author("Stephan", "Stephans");
        Book firstBook = new Book("Domain Driven Design","1234", "PP Publisher");
        stephan.getBooks().add(firstBook);
        firstBook.getAuthors().add(stephan);

        authorRepository.save(stephan);
        bookRepository.save(firstBook);

        //Dominique
        Author dominique = new Author("Dominique", "Clarkson");
        Book secondBook = new Book("Spring with Hibernate","15364", "PP Publisher");
        stephan.getBooks().add(secondBook);
        secondBook.getAuthors().add(dominique);

        authorRepository.save(dominique);
        bookRepository.save(secondBook);
    }

}
