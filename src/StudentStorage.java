import java.util.HashMap;

public class StudentStorage {
    private HashMap<String, Student> storage;

    public StudentStorage() {
        storage = new HashMap<>();
    }

    public void addStudent(String data) throws StudentException {
        try {
            String[] components = data.split("\\s+");
            String name = components[0] + " " + components[1];
            storage.put(name, new Student(name, components[3], components[2]));
        } catch (ArrayIndexOutOfBoundsException err) {
            throw new StudentException("Error. Invalid command format...\n" +
                    "For command help, use the command: help");
        }
    }

    public void listStudent() throws StudentException {
        if (storage.size() != 0) storage.values().forEach(System.out::println);
        else
            throw new StudentException("The list is empty...");
    }

    public void removeStudent(String name) throws StudentException {
        Student student = storage.get(name);

        if (storage.size() == 0) throw new StudentException("The list is empty...");
        else if (student != null) storage.remove(name);
        else throw new StudentException("Error. Student: " + name + ". Not on the list...");

    }

    public Student getStudentByName(String name) throws StudentException {

        Student student = storage.get(name);

        if (storage.size() == 0) throw new StudentException("The list is empty...");
        else if (student != null) return student;
        else throw new StudentException("Error. Student: " + name + ". Not on the list...");
    }

    public int getCount() {
        return storage.size();
    }
}