package Symbol.Excuses.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Cette classe représente la configuration de l'application Web. Elle
 * implémente l'interface WebMvcConfigurer pour personnaliser la configuration
 * de Spring MVC.
 * 
 * 
 * Elle définit une méthode addCorsMappings qui ajoute des règles de CORS
 * (Cross-Origin Resource Sharing) pour autoriser les requêtes provenant
 * d'origines différentes.
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	/**
	 * Cette méthode ajoute des règles de CORS pour autoriser les requêtes provenant
	 * de l'origine "http://localhost:3000" avec les méthodes "GET", "POST", "PUT"
	 * et "DELETE". Elle autorise également l'envoi de cookies dans les requêtes.
	 * 
	 * @param registry un objet CorsRegistry qui permet d'ajouter des règles de CORS
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:3000")
				.allowedMethods("GET", "POST", "PUT", "DELETE").allowCredentials(true);
	}
}