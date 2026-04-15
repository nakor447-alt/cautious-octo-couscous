import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Анна", "A-101", 1, Arrays.asList(4, 5, 4, 3)));
        students.add(new Student("Иван", "B-202", 2, Arrays.asList(2, 3, 2, 2)));
        students.add(new Student("Мария", "A-101", 1, Arrays.asList(5, 5, 4, 5)));
        students.add(new Student("Петр", "B-202", 2, Arrays.asList(3, 3, 3, 4)));
        students.add(new Student("Ольга", "C-303", 3, Arrays.asList(4, 4, 4, 4)));

        System.out.println("До удаления:");
        for (Student s : students) {
            System.out.println(s);
        }

        removePoorStudents(students);

        System.out.println("\nПосле удаления:");
        for (Student s : students) {
            System.out.println(s);
        }

        promoteStudents(students);

        System.out.println("\nПосле перевода:");
        for (Student s : students) {
            System.out.println(s);
        }

        Set<Student> studentSet = new HashSet<>(students);
        printStudents(studentSet, 2);
    }

    public static void removePoorStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getAverageGrade() < 3.0) {
                iterator.remove();
            }
        }
    }

    public static void promoteStudents(List<Student> students) {
        for (Student s : students) {
            if (s.getAverageGrade() >= 3.0) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("\nСтуденты на " + course + " курсе:");
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
}