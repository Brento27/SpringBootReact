package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String...args) throws Exception {
		this.userRepository.save(new User("Brent", "Lombaard", "lombaardbrent@gmail.com"));
		this.userRepository.save(new User("Zoë", "Lombaard", "lombaardzoe@gmail.com"));
		this.userRepository.save(new User("Zandri", "Lombaard", "lombaardzandri@gmail.com"));
		this.userRepository.save(new User("Zelda", "Lombaard", "lombaardzelda@gmail.com"));
		this.userRepository.save(new User("Franco", "Lombaard", "lombaardfranco@gmail.com"));
		this.userRepository.save(new User("Jan", "Lombaard", "lombaardjan@gmail.com"));
		this.userRepository.save(new User("Jean", "Lombaard", "lombaardjean@gmail.com"));
	}

}
