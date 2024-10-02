package classroommanager.services;

import classroommanager.model.Student;
import classroommanager.model.Classroom;

public class StudentService {
    private ClassroomService classroomService;

    public StudentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public void addStudent(String studentId, String className) {
        if (classroomService.classroomExists(className)) {
            Classroom classroom = classroomService.getClassroom(className);
            classroom.addStudent(new Student(studentId));
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }
}
