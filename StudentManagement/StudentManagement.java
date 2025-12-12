import java.util.*;

// ---- STUDENT ------
class Student {
    private String id, name;
    private int marks;

    public Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() { return id; }
    public int getMarks() { return marks; }

    public String getRole() { return "Undergrad"; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + marks + ") " + getRole();
    }
}

// ----- GRAD STUDENT -------
class GraduateStudent extends Student {

    private String area;

    public GraduateStudent(String id, String name, int marks, String area) {
        super(id, name, marks);
        this.area = area;
    }

    @Override
    public String getRole() {
        return "Grad (" + area + ")";
    }
}

// ------ HONOR STUDENT --------
class HonorStudent extends Student {

    private String area;

    public HonorStudent(String id, String name, int marks, String area) {
        super(id, name, marks);
        this.area = area;
    }

    @Override
    public String getRole() {
        return "Honor (" + area + ")";
    }
}

// ---------------- GENERIC REPOSITORY ----------------
class Repository<T extends Student> {
    private Map<String, T> data = new HashMap<>();

    public void save(String id, T obj) {
        data.put(id, obj);
    }

    public T find(String id) {
        return data.get(id);
    }

    public void delete(String id) {
        data.remove(id);
    }

    public T getTopper() {
    T best = null;

    for (T s : data.values()) {
        if (best == null || s.getMarks() > best.getMarks()) {
            best = s;
        }
    }
    return best;
}


}



// ---------------- MAIN ----------------
public class StudentManagement {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("S1", "Yash", 75));
        list.add(new Student("S2", "Shubham", 89));

        list.add(new GraduateStudent("G1", "Ansh", 79, "CSE"));

        Repository<Student> repo = new Repository<>();

        for (Student s : list) {
            repo.save(s.getId(), s);
        }

        //ALL STUDENTS
        System.out.println("ALL STUDENTS:");
        list.forEach(System.out::println);


        //LOOKUP S2
        System.out.println("\nLOOKUP S2:");
        Student s = repo.find("S2");
        System.out.println( s!=null ? s : "not found");


        //REMOVE < 80
        Iterator<Student> it   = list.iterator();
        while(it.hasNext()){
                Student st = it.next();

                if(st.getMarks()<80){
                    it.remove();
                    repo.delete(st.getId());
                }
        }

        System.out.println("\nAFTER REMOVAL: ");
        list.forEach(System.out:: println);

        //

    }
}
