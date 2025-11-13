package edu.espe.springlab.repository;

import edu.espe.springlab.domain.Student;
import edu.espe.springlab.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("Debe guardar y buscar un estudiante por email correctamente")
    void shouldSaveAndFindStudentByEmail() {
        // Crear objeto estudiante
        Student s = new Student();
        s.setFullName("Test User");
        s.setEmail("test@example.com");
        s.setBirthDate(LocalDate.of(2000, 10, 10));
        s.setActive(true);

        // Guardar en el repositorio
        studentRepository.save(s);

        // Buscar por email
        var result = studentRepository.findByEmail("test@example.com");

        // Verificar resultados
        assertThat(result).isPresent();
        assertThat(result.get().getFullName()).isEqualTo("NombreIncorrecto");
    }
}
