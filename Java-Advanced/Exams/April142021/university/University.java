package Exams.April142021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount(){
        return students.size();
    }

    public String registerStudent(Student student){
        if(students.contains(student)){
            return "Student is already in the university";
        }else if(students.size()==capacity){
            return "No seats in the university";
        }else{
            students.add(student);
        }
        return String.format("Added student %s %s",student.getFirstName(),student.lastName);
    }

    public String dismissStudent(Student student){
        if(students.contains(student)){
            students.remove(student);
            return String.format("Removed student %s %s",student.firstName,student.lastName);

        }
        return "Student not found";    }

    public Student getStudent(String firstName, String lastName){
        Student student = null;
        for (Student student1 : students) {
            if(student1.firstName.equals(firstName) && student1.lastName.equals(lastName)){
                student=student1;
                break;
            }
        }

        return student;
    }

    public String getStatistics(){
        StringBuilder toPrint = new StringBuilder();
        for (Student student : students) {
            toPrint.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", student.firstName,student.lastName,student.bestSubject));
            toPrint.append(System.lineSeparator());
        }

        return toPrint.toString();
    }
}
