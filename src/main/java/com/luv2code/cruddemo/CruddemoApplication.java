package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO  studentDAO) {
        return runner -> {
//            createStudent(studentDAO);

            createMultipleStudents(studentDAO);

//            readStudent(studentDAO);

//            queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);

//            updateStudent(studentDAO);

//           deleteStudent(studentDAO);


//            deleteAllStudents(studentDAO);
            
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {

        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAllStudents();
        System.out.println("Deleted " + numRowsDeleted + " rows");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studenId = 3000;
        System.out.println("Deleting student with id: " + studenId);
        studentDAO.delete(studenId);
    }

    private void updateStudent(StudentDAO studentDAO) {
//        retrieve the student based on the id: PK
        int studentId = 3;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

//        change the first name to "MENA"
        System.out.println("Updating the student...");
        myStudent.setFirstName("MENA");
        myStudent.setLastName("HASSAN");
        myStudent.setEmail("mena@hassan.com");

//        update the student
        studentDAO.update(myStudent);

//        display the updated student
        System.out.println("Updated Student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
//        get a List os students
        List<Student> theStudents = studentDAO.findByLastName("MOHAMED");

//        display the list of the students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
//        get a List of students
        List<Student> theStudents = studentDAO.findALl();

//        display the list of the students
        for(Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
//        create a student object
        System.out.println("Creating a new student object: ....");
        Student tempStudent = new Student("MEMO", "HASSAN", "memo@hassan.com");

//        save the student object
        System.out.println("Saving the student object: ....");
        studentDAO.save(tempStudent);

//        display id of the saved student
        int theId = Integer.parseInt(tempStudent.getId());
        System.out.println("Saved student. Generated id: " + theId);

//        retrieve the student based on the id
        System.out.println("Retrieving the student based on the id: "   + theId);
        Student myStudent = studentDAO.findById(theId);

//        Display the found student
        System.out.println("Found student: " + myStudent);

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
