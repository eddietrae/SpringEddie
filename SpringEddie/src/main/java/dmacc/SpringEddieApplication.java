package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Dog;
import dmacc.controller.BeanConfig;
import dmacc.repository.DogRepository;

@SpringBootApplication
public class SpringEddieApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringEddieApplication.class, args);
	}
	@Autowired
	DogRepository repo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		//Using an existing bean
		Dog c = appContext.getBean("dog", Dog.class);
		c.setName("Doge");
		repo.save(c);
		//Creating abean to use –not managed by Spring
		Dog d = new Dog("Sandra");
		repo.save(d);
		List<Dog> allMyDogs = repo.findAll();
		for(Dog dog: allMyDogs) {
			System.out.println(dog.toString());
		}
		((AbstractApplicationContext) appContext).close();
	}
}
