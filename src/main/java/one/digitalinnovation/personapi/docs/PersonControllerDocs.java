package one.digitalinnovation.personapi.docs;

import io.swagger.annotations.*;
import one.digitalinnovation.personapi.model.dto.request.PersonDTO;
import one.digitalinnovation.personapi.model.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.util.exception.PersonNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(value = "Person API")
public interface PersonControllerDocs {

    @ApiOperation(value = "POST")
    @ApiResponse(code = 201, message = "Created Person with ID {id}")
    MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO);

    @ApiOperation(value = "GET")
    @ApiResponse(code = 200, message = "JSON of List<PersonDTO>")
    List<PersonDTO> listAll();

    @ApiOperation(value = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "JSON of a Person"),
            @ApiResponse(code = 404, message = "Person not found with ID {id}")
    })
    PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException;

    @ApiOperation(value = "PUT")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Updated Person with ID {id}"),
            @ApiResponse(code = 404, message = "Person not found with ID {id}")
    })
    MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO)
            throws PersonNotFoundException;

    @ApiOperation(value = "DELETE")
    @ApiResponses({
            @ApiResponse(code = 204, message = ""),
            @ApiResponse(code = 404, message = "Person not found with ID {id}")
    })
    void deleteById(@PathVariable Long id) throws PersonNotFoundException;
}
