package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.model.entity.Person;
import one.digitalinnovation.personapi.model.dto.request.PersonDTO;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.model.dto.response.MessageResponseDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class)))
                .thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedMessage = createExpectedResponse(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedMessage, successMessage);

    }

    private MessageResponseDTO createExpectedResponse(Long id) {
        return MessageResponseDTO.builder()
                .message("Updated Person with ID " + id)
                .build();
    }
}
