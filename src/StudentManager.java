import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * StudentManager クラス
 * 学生の追加・編集・削除・表示・ソートを管理するクラス
 * 
 * @author truongngocdantruong
 */
public class StudentManager {
    // 入力用スキャナー（コンソール入力）
    public static Scanner scanner = new Scanner(System.in);
    // 学生リスト
    private List<Student> studentList;
    // ファイル入出力用のStudentIOオブジェクト
    private StudentIO studentIO;

    /**
     * コンストラクタ
     * StudentIOを初期化し、ファイルから学生リストを読み込む
     */
    public StudentManager() {
        studentIO = new StudentIO();
        studentList = studentIO.read();
    }

    /**
     * 学生を追加するメソッド
     * 学生IDはリストサイズ＋１で自動設定
     */
    public void add() {
        int id = (studentList.size() > 0) ? (studentList.size() + 1) : 1;
        System.out.println("学生ID = " + id);
        String namae = inputNamae();
        byte nenrei = inputNenrei();
        String juusho = inputJuusho();
        float gpa = inputGpa();
        // 新しい学生オブジェクトを作成してリストに追加
        Student student = new Student(id, namae, nenrei, juusho, gpa);
        studentList.add(student);
        // ファイルに保存
        studentIO.write(studentList);
    }

    /**
     * 指定したIDの学生を編集するメソッド
     * @param id 編集対象の学生ID
     */
    public void edit(int id) {
        boolean isExisted = false;
        for (Student student : studentList) {
            if (student.getId() == id) {
                isExisted = true;
                // 新しい値を入力してセット
                student.setNamae(inputNamae());
                student.setNenrei(inputNenrei());
                student.setJuusho(inputJuusho());
                student.setGpa(inputGpa());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("ID = %d の学生が存在しません。\n", id);
        } else {
            // 編集後、ファイルに保存
            studentIO.write(studentList);
        }
    }

    /**
     * 指定したIDの学生を削除するメソッド
     * @param id 削除対象の学生ID
     */
    public void delete(int id) {
        Student target = null;
        for (Student student : studentList) {
            if (student.getId() == id) {
                target = student;
                break;
            }
        }
        if (target != null) {
            // リストから削除
            studentList.remove(target);
            // ファイルに保存
            studentIO.write(studentList);
        } else {
            System.out.printf("ID = %d の学生が存在しません。\n", id);
        }
    }

    /**
     * 名前で学生リストをソートするメソッド
     */
    public void sortStudentByName() {
        Collections.sort(studentList, new SortStudentByName());
    }

    /**
     * GPAで学生リストをソートするメソッド
     */
    public void sortStudentByGPA() {
        Collections.sort(studentList, new SortStudentByGPA());
    }

    /**
     * 学生一覧を表示するメソッド
     */
    public void show() {
        if (studentList.isEmpty()) {
            System.out.println("学生リストは空です。");
            return;
        }
        // ヘッダー表示
        System.out.format("%5s | %20s | %5s | %20s | %10s%n", 
              "ID", "名前", "年齢", "住所", "GPA");
        // 各学生の情報を整形して表示
        for (Student student : studentList) {
            System.out.format("%5d | %20s | %5d | %20s | %10.2f%n", 
                student.getId(), student.getNamae(), student.getNenrei(), 
                student.getJuusho(), student.getGpa());
        }
    }

    /**
     * 学生IDをコンソールから入力するメソッド
     * @return 入力された学生ID
     */
    public int inputId() {
        System.out.print("学生IDを入力してください：");
        while (true) {
            try {
                int id = Integer.parseInt(scanner.nextLine().trim());
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("無効です！もう一度学生IDを入力してください：");
            }
        }
    }

    /**
     * 学生の名前を入力するメソッド
     * @return 入力された名前
     */
    private String inputNamae() {
        System.out.print("学生の名前を入力してください：");
        return scanner.nextLine().trim();
    }

    /**
     * 学生の住所を入力するメソッド
     * @return 入力された住所
     */
    private String inputJuusho() {
        System.out.print("学生の住所を入力してください：");
        return scanner.nextLine().trim();
    }

    /**
     * 学生の年齢を入力するメソッド（0〜100の範囲チェックあり）
     * @return 入力された年齢
     */
    private byte inputNenrei() {
        System.out.print("学生の年齢を入力してください：");
        while (true) {
            try {
                byte age = Byte.parseByte(scanner.nextLine().trim());
                if (age < 0 || age > 100) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.out.print("無効です！もう一度年齢を入力してください：");
            }
        }
    }

    /**
     * 学生のGPAを入力するメソッド（0.0〜10.0の範囲チェックあり）
     * @return 入力されたGPA
     */
    private float inputGpa() {
        System.out.print("学生のGPAを入力してください：");
        while (true) {
            try {
                float gpa = Float.parseFloat(scanner.nextLine().trim());
                if (gpa < 0.0f || gpa > 10.0f) {
                    throw new NumberFormatException();
                }
                return gpa;
            } catch (NumberFormatException ex) {
                System.out.print("無効です！もう一度GPAを入力してください：");
            }
        }
    }

    /**
     * 学生リストを取得するゲッター
     * @return 学生リスト
     */
    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     * 学生リストを設定するセッター
     * @param studentList セットする学生リスト
     */
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
