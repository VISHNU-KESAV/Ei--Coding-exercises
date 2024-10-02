package classroommanager.services;

import classroommanager.model.Assignment;
import classroommanager.model.Classroom;
import classroommanager.model.Student;

public class AssignmentService {
    private ClassroomService classroomService;

    public AssignmentService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        if (classroomService.classroomExists(className)) {
            Classroom classroom = classroomService.getClassroom(className);
            classroom.addAssignment(new Assignment(assignmentDetails));
            System.out.println("Assignment for " + className + " has been scheduled.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        if (classroomService.classroomExists(className)) {
            Classroom classroom = classroomService.getClassroom(className);
            for (Student student : classroom.getStudents()) {
                if (student.getId().equals(studentId)) {
                    System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
                    return;
                }
            }
            System.out.println("Student " + studentId + " is not enrolled in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }
}
