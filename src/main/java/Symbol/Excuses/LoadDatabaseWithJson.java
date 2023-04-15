package Symbol.Excuses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Symbol.Excuses.entity.Excuse;
import Symbol.Excuses.repository.ExcuseRepository;

@Configuration
public class LoadDatabaseWithJson {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabaseWithJson.class);
	
	@Autowired
	ExcuseRepository repo;
	
	@Bean
	CommandLineRunner initDatabase(ExcuseRepository repository) {
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			try {
				InputStream inputStream = new FileInputStream(new File("src/main/resources/data.json"));
				try {
					List<Excuse> excuses = objectMapper.readValue(inputStream, new TypeReference<List<Excuse>>() {
					});
					for(Excuse excuse: excuses) {
						log.info("Preloaded " + excuse + "...");
						repo.save(excuse);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		};
	}
}