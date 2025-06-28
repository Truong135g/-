import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentIOクラス
 * 学生情報のリストをファイルに保存・読み込みを行うクラス
 * 
 * @author truongngocdantruong
 */
public class StudentIO {
    // 学生情報を保存するファイル名
    private static final String STUDENT_FILE_NAME = "student.txt";

    /**
     * 学生リストをファイルに書き込むメソッド
     * 
     * @param studentList 保存する学生のリスト
     */
    public void write(List<Student> studentList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            // ファイル出力ストリームを作成
            fos = new FileOutputStream(new File(STUDENT_FILE_NAME));
            // オブジェクト出力ストリームでオブジェクトを書き込む
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
        } catch (FileNotFoundException e) {
            // ファイルが見つからない場合の例外処理
            e.printStackTrace();
        } catch (IOException e) {
            // 入出力例外の処理
            e.printStackTrace();
        } finally {
            // ストリームを安全にクローズ
            closeStream(fos);
            closeStream(oos);
        }
    }

    /**
     * ファイルから学生リストを読み込むメソッド
     * 
     * @return ファイルから読み込んだ学生リスト。失敗した場合は空リストを返す
     */
    public List<Student> read() {
        List<Student> studentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            // ファイル入力ストリームを作成
            fis = new FileInputStream(new File(STUDENT_FILE_NAME));
            // オブジェクト入力ストリームでオブジェクトを読み込む
            ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            // ファイルが見つからない場合の例外処理
            e.printStackTrace();
        } catch (IOException e) {
            // 入出力例外の処理
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // 読み込んだクラスが見つからない場合の例外処理
            e.printStackTrace();
        } finally {
            // ストリームを安全にクローズ
            closeStream(fis);
            closeStream(ois);
        }
        return studentList;
    }

    /**
     * InputStreamを安全に閉じるメソッド
     * 
     * @param is 閉じるInputStream
     */
    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * OutputStreamを安全に閉じるメソッド
     * 
     * @param os 閉じるOutputStream
     */
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
