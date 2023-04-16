package Symbol.Excuses.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LabelController {

	@GetMapping("/labels")
	public List<String> getLabels() {
		return new ArrayList<>(Arrays.asList("label1", "label2", "label3", "label4", "label5"));
	}
}
