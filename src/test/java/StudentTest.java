import org.junit.jupiter.api.Test;

import lab11.builder.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testStudentBuilder() {
        Student student = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .gender("Male")
                .email("john.doe@example.com")
                .age(20)
                .course("Mathematics")
                .course("Physics")
                .build();

        assertEquals("John", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals("Male", student.getGender());
        assertEquals("john.doe@example.com", student.getEmail());
        assertEquals(20, student.getAge());
        assertEquals(List.of("Mathematics", "Physics"), student.getCourses());
    }

    @Test
    void testEqualsAndHashCode() {
        Student student1 = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .gender("Male")
                .email("john.doe@example.com")
                .age(20)
                .course("Mathematics")
                .build();

        Student student2 = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .gender("Male")
                .email("john.doe@example.com")
                .age(20)
                .course("Mathematics")
                .build();

        assertEquals(student1, student2);
        assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    void testToString() {
        Student student = Student.builder()
                .firstName("Alice")
                .lastName("Smith")
                .gender("Female")
                .email("alice.smith@example.com")
                .age(22)
                .course("Biology")
                .course("Chemistry")
                .build();

        String toStringOutput = student.toString();
        assertTrue(toStringOutput.contains("Alice"));
        assertTrue(toStringOutput.contains("Smith"));
        assertTrue(toStringOutput.contains("Female"));
        assertTrue(toStringOutput.contains("alice.smith@example.com"));
        assertTrue(toStringOutput.contains("22"));
        assertTrue(toStringOutput.contains("Biology"));
        assertTrue(toStringOutput.contains("Chemistry"));
    }
}

