package Symbol.Excuses.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import Symbol.Excuses.ExcuseModelAssembler;
import Symbol.Excuses.ExcuseNotFoundException;
import Symbol.Excuses.entity.Excuse;
import Symbol.Excuses.repository.ExcuseRepository;

@RestController
public class ExcuseController {

	@Autowired
	private ExcuseRepository repository;
	private final ExcuseModelAssembler assembler;

	public ExcuseController(ExcuseRepository repository, ExcuseModelAssembler assembler) {
		this.repository = repository;
		this.assembler = assembler;
	}

	@GetMapping("/excuse")
	public CollectionModel<EntityModel<Excuse>> getAllExcuses() {
		List<EntityModel<Excuse>> excuse = repository.findAll().stream().map(assembler::toModel)
				.collect(Collectors.toList());

		return CollectionModel.of(excuse, linkTo(methodOn(ExcuseController.class).getAllExcuses()).withSelfRel());
	}

	@GetMapping("/excuse/{httpCode}")
	public EntityModel<Excuse> getExcuseByHttpCode(@PathVariable int httpCode) {
	    Excuse excuse = repository.findById(httpCode)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Excuse not found"));

	    return assembler.toModel(excuse);
	}

	@PostMapping("/excuse")
	public ResponseEntity<?> ajoutExcuse(@RequestBody Excuse nouvelleExcuse) {
		EntityModel<Excuse> entityModel = assembler.toModel(repository.save(nouvelleExcuse));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
	}

	@PutMapping("/excuse/{httpCode}")
    public ResponseEntity<?> modifierExcuse(@RequestBody Excuse nouvelleExcuse, @PathVariable int httpCode) {
    	Excuse updatedExcuse = repository.findById(httpCode)
                .map(excuse -> {
                	excuse.setMessage(nouvelleExcuse.getMessage());
                	excuse.setTag(nouvelleExcuse.getTag());
                    return repository.save(excuse);
                })
                .orElseGet(() -> {
                	nouvelleExcuse.setHttpCode(httpCode);
                    return repository.save(nouvelleExcuse);
                });
        EntityModel<Excuse> entityModel = assembler.toModel(updatedExcuse);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

	@DeleteMapping("/excuse/{httpCode}")
	public ResponseEntity<?> SupprimerExcuse(@PathVariable int httpCode) {
		repository.deleteById(httpCode);
		return ResponseEntity.noContent().build();
	}
}