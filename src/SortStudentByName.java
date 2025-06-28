 
import java.util.Comparator;
 
/**
 * SortStudentByName class
 * 
 * @author truongngocdantruong
 */
public class SortStudentByName implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getNamae().compareTo(student2.getNamae());
    }
}