 
import java.io.Serializable;
 
/**
 * Student class
 * 
 * @author truongngocdantruong
 */
public class Student implements Serializable {
    private int id;        //学生番号
    private String namae;  //学生の名前
    private byte nenrei;   //学生の年齢
    private String juusho; //学生の住所
    /* 学生の平均点数 */
    private float gpa;
 
    public Student() {
    }

    public Student(int id, String namae, byte nenrei, String juusho, float gpa) {
        this.id = id;
        this.namae = namae;
        this.nenrei = nenrei;
        this.juusho = juusho;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamae() {
        return namae;
    }

    public void setNamae(String namae) {
        this.namae = namae;
    }

    public byte getNenrei() {
        return nenrei;
    }

    public void setNenrei(byte nenrei) {
        this.nenrei = nenrei;
    }

    public String getJuusho() {
        return juusho;
    }

    public void setJuusho(String juusho) {
        this.juusho = juusho;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
    @Override
    public String toString() {
        return String.format("ID: %d, 名前: %s, 年齢: %d, 住所: %s, GPA: %.2f", 
            id, namae, nenrei, juusho, gpa);
}


 
}