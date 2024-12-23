package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO  studentDAO) {
        return runner -> {
//           createStudent(studentDAO);
             createMultipleStudents(studentDAO);
        };
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
//       create the student objects
        System.out.println("Creating 3 student objects:.....");
        Student tempStudent1 = new Student("OMAR", "MOHAMED", "omar@mohamed.com");
        Student tempStudent2 = new Student("YOUSSEF", "MOHAMED", "youssef@mohamed.com");
        Student tempStudent3 = new Student("HANA", "AHMED", "hana@ahmed.com");

//        save the student objects to the DB
        System.out.println("Saving the student objects...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

//        Display the IDs of the saved student objects
        System.out.println("Saved students. Generated IDs: " +
                tempStudent1.getId() + " , " +
                tempStudent2.getId() + " , " +
                tempStudent3.getId());
    }

    private void createStudent(StudentDAO studentDAO) {
//        create the student object
        System.out.println("Creating a new student object");
        Student tempStudent = new Student("KOKO", "YOUSSEF", "koko@youssef.com");

//        save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

//        Display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }


}
