package Symbol.Excuses.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LabelController {
	
	// Juste pour un label, pas besoin de faire 4 classes et avoir de la dette technique pour rien, quand une liste fais l'affaire.
	List<String> labels = Arrays.asList("label1", "label2", "label3", "label4", "label5");

	// READ
	@GetMapping("/labels")
	public List<String> getLabels() {
		return labels;
	}
}