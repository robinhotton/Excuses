package Symbol.Excuses;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import Symbol.Excuses.controller.ExcuseController;
import Symbol.Excuses.entity.Excuse;

@Component
public class ExcuseModelAssembler implements RepresentationModelAssembler<Excuse, EntityModel<Excuse>>{

	@Override
	public EntityModel<Excuse> toModel(Excuse excuse) {
		 return EntityModel.of(excuse,
	                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExcuseController.class).getExcuseByHttpCode(excuse.getHttpCode())).withSelfRel(),
	                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ExcuseController.class).getAllExcuses()).withRel("Excuse"));
	}
}