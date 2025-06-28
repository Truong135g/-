import java.util.Scanner;

/**
 * Mainクラス
 * メインプログラムのエントリーポイントを提供し、
 * 学生管理システムのメニュー操作を制御するクラス
 * 
 * @author truongngocdantruong
 */
public class Main {
    // コンソール入力用スキャナー
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;  // ユーザーのメニュー選択を保存
        boolean exit = false;  // 終了フラグ
        StudentManager studentManager = new StudentManager(); // 学生管理オブジェクト作成
        int studentId;

        // メニュー表示
        showMenu();

        while (true) {
            choose = scanner.nextLine(); // ユーザー入力待ち

            switch (choose) {
                case "1":
                    // 学生を追加
                    studentManager.add();
                    break;
                case "2":
                    // 学生IDを入力して編集
                    studentId = studentManager.inputId();
                    studentManager.edit(studentId);
                    break;
                case "3":
                    // 学生IDを入力して削除
                    studentId = studentManager.inputId();
                    studentManager.delete(studentId);
                    break;
                case "4":
                    // GPAで学生をソート
                    studentManager.sortStudentByGPA();
                    break;
                case "5":
                    // 名前で学生をソート
                    studentManager.sortStudentByName();
                    break;
                case "6":
                    // 学生リストを表示
                    studentManager.show();
                    break;
                case "0":
                    // 終了処理
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    // 無効な入力時のメッセージ
                    System.out.println("無効です！以下のメニューから操作を選択してください：");
                    showMenu();
                    continue;  // 次のループへ
            }

            if (exit) {
                // 終了フラグが立っていたらループ抜ける
                break;
            }

            // メニュー再表示
            showMenu();
        }
    }

    /**
     * メニューをコンソールに表示するメソッド
     */
    public static void showMenu() {
        System.out.println("-----------メニュー------------");
        System.out.println("1. 学生を追加する。");
        System.out.println("2. IDで学生を編集する。");
        System.out.println("3. IDで学生を削除する。");
        System.out.println("4. GPAで学生を並び替える。");
        System.out.println("5. 名前で学生を並び替える。");
        System.out.println("6. 学生を表示する。");
        System.out.println("0. 終了。");
        System.out.println("-----------------------------");
        System.out.print("選択してください: ");
    }
}
