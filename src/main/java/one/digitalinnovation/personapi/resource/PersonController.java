package one.digitalinnovation.personapi.resource;

import one.digitalinnovation.personapi.docs.PersonControllerDocs;
import one.digitalinnovation.personapi.model.dto.request.PersonDTO;
import one.digitalinnovation.personapi.util.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.service.PersonService;
import one.digitalinnovation.personapi.model.dto.response.MessageResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController implements PersonControllerDocs {

    private PersonService personService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> listAll() {
        return personService.listAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO)
            throws PersonNotFoundException {

        return personService.updateById(id, personDTO);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
