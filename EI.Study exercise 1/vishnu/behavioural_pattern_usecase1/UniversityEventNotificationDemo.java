import java.util.ArrayList;
import java.util.List;

interface Student {
    void update(String event);
}

class CseStudent implements Student {
    private String name;

    public CseStudent(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name + " (CSE) received event notification: " + event);
    }
}

class EceStudent implements Student {
    private String name;

    public EceStudent(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name + " (ECE) received event notification: " + event);
    }
}
class MechStudent implements Student {
    private String name;

    public MechStudent(String name) {
        this.name = name;
    }

    @Override
    public void update(String event) {
        System.out.println(name + " (Mechanical) received event notification: " + event);
    }
}
class NotificationService {
    private List<Student> students = new ArrayList<>();
    private String latestEvent;
    
    public void subscribe(Student student) {
        students.add(student);
    }

    public void unsubscribe(Student student) {
        students.remove(student);
    }

    public void notifyStudents() {
        for (Student student : students) {
            student.update(latestEvent);
        }
    }

    public void setLatestEvent(String event) {
        this.latestEvent = event;
        notifyStudents();
    }
}


public class UniversityEventNotificationDemo {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();

        Student cseStudent1 = new CseStudent("Arun");
        Student cseStudent2 = new CseStudent("Divya");
        Student eceStudent1 = new EceStudent("Ravi");
        Student eceStudent2 = new EceStudent("Priya");
        Student mechStudent1 = new MechStudent("Rahul");
        Student mechStudent2 = new MechStudent("Sneha");

    
        notificationService.subscribe(cseStudent1);
        notificationService.subscribe(cseStudent2);
        notificationService.subscribe(eceStudent1);
        notificationService.subscribe(eceStudent2);
        notificationService.subscribe(mechStudent1);
        notificationService.subscribe(mechStudent2);

        notificationService.setLatestEvent("Amrita Fest: Cultural Extravaganza on 1st October!");

        notificationService.unsubscribe(cseStudent2);

        notificationService.setLatestEvent("Tech Talk: AI and ML Trends on 5th October!");
    }
}
