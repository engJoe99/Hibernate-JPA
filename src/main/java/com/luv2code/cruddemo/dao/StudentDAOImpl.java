package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

//    define field for entity manager
    private EntityManager entityManager;

//    inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


//    define save method -- save the student to the DB
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

//    define find by id method -- retrieve a student from the DB
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

//    define findAll method -- retrieve all students from the DB
    @Override
    public List<Student> findALl() {
//        create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);

//        return the query results
        return theQuery.getResultList();
    }


// define a findByLastName method -- retrieve specific students from the DB
    @Override
    public List<Student> findByLastName(String theLastName) {
//        create a query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                                    "From Student where lastName= :theData", Student.class);

//        set query parameters
        theQuery.setParameter("theData", theLastName);

//        return query results
        return theQuery.getResultList();
    }

//    define update method -- update the student founded by id
    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

//    define delete method -- delete the student founded by id
    @Override
    @Transactional
    public void delete(Integer id) {
//        retrive the studemt
        Student tempStudent = entityManager.find(Student.class, id);

//        delete the student
        entityManager.remove(tempStudent);
    }


//    define a method to delete all students
    @Override
    @Transactional
    public int deleteAllStudents() {

        int numRowsDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return numRowsDeleted;
    }



}
