package edu.espe.springlab.service;

import edu.espe.springlab.domain.Student;
import edu.espe.springlab.dto.StudentRequestData;
import edu.espe.springlab.repository.StudentRepository;
import edu.espe.springlab.service.impl.StudentServiceImpl;
import edu.espe.springlab.web.advice.ConflictException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest //Solo esta anotación, no @DataJpaTest
public class StudentServiceTest {

    @Autowired
    private StudentServiceImpl service;

    @Autowired
    private StudentRepository repository;

    @Test
    void shouldNotAllowDuplicateEmail() {
        // Crear estudiante existente
        Student existing = new Student();
        existing.setFullName("Existing");
        existing.setEmail("Duplicate@example.com");
        existing.setBirthDate(LocalDate.of(2000, 10, 10));
        existing.setActive(true);
        repository.save(existing);

        // Crear request con email duplicado
        StudentRequestData req = new StudentRequestData();
        req.setFullName("Test User");
        req.setEmail("Duplicate@example.com");
        req.setBirthDate(LocalDate.of(2000, 10, 10));

        // Esperar que el servicio lance ConflictException
        assertThatThrownBy(() -> service.create(req))
                .isInstanceOf(ConflictException.class);
    }
}
