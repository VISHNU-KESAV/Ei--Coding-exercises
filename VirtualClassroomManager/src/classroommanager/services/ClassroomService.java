package classroommanager.services;

import classroommanager.model.Classroom;

import java.util.HashMap;
import java.util.Map;

public class ClassroomService {
    private Map<String, Classroom> classrooms;

    public ClassroomService() {
        classrooms = new HashMap<>();
    }

    public void addClassroom(String className) {
        if (!classroomExists(className)) {
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been created.");
        } else {
            System.out.println("Classroom " + className + " already exists.");
        }
    }

    public boolean classroomExists(String className) {
        return classrooms.containsKey(className);
    }

    public Classroom getClassroom(String className) {
        return classrooms.get(className);
    }
}
