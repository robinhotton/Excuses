package Symbol.Excuses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Symbol.Excuses.entity.Excuse;
import Symbol.Excuses.repository.ExcuseRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ExcuseService {

	@Autowired
	private ExcuseRepository excuseRepository;

	// CREATE
	public Excuse createExcuse(Excuse excuse) {
		return excuseRepository.save(excuse);
	}

	// READ
	public List<Excuse> getAllExcuses() {
		return excuseRepository.findAll();
	}

	public Excuse getExcuseByHttpCode(int httpCode) {
		return excuseRepository.findById(httpCode).orElse(null);
	}

	// UPDATE
	public Excuse updateExcuse(int httpCode, Excuse newExcuse) {
		Excuse existingExcuse = excuseRepository.findById(httpCode)
				.orElseThrow(() -> new EntityNotFoundException("Excuse not found"));
		existingExcuse.setTag(newExcuse.getTag());
		existingExcuse.setMessage(newExcuse.getMessage());
		return excuseRepository.save(existingExcuse);
	}

	// DELETE
	public void deleteExcuseById(int httpCode) {
		excuseRepository.deleteById(httpCode);
	}
}