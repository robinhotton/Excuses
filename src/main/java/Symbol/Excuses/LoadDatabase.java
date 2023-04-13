package Symbol.Excuses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Symbol.Excuses.entity.Excuse;
import Symbol.Excuses.repository.ExcuseRepository;

@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(ExcuseRepository repository) {
		return args -> {
			repository.save(new Excuse(701, "Inexcusable", "Meh"));
			repository.save(new Excuse(702, "Inexcusable", "Emacs"));
			repository.save(new Excuse(703, "Inexcusable", "Explosion"));
			repository.findAll().forEach(excuse -> log.info("Preloaded " + excuse));
		};
	}
}