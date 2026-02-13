package study;

/**
*
* 本課題では、例外処理（try-catch-finally）の基本的な使い方を学んでいきましょう。
* 次のプログラムは、文字列を数値に変換して表示する処理です。
* ただし、文字列が数値でない場合にエラーが発生してしまいます。
* このプログラムに try-catch-finally を追加して、
* エラーが発生してもアプリが止まらずにメッセージを出力するように修正してください。
*
* 課題要件
* Integer.parseInt(str) の行で例外が発生します。
* その処理を try-catch で囲み、NumberFormatException をキャッチしてください。
* 例外が発生したときは「数値に変換できませんでした。」と表示してください。
* 最後に finally ブロックを追加し、「このブロックは必ず実行されます。」と表示してください。
*
*
*/

public class Task4_15 {
 
    public static void main(String[] args) {
        System.out.println("処理を開始します。");

        //① 適切な位置にtry-catch-finallyを追加して下さい。また、課題要件を満たす内容のエラーメッセージをコンソールに出力して下さい。
        String str = "PivoTech"; 
        // 数値に変換できない文字列
        try{
        int num = Integer.parseInt(str); 
        System.out.println("変換結果：" + num);
        }catch(NumberFormatException e){  
		    System.out.println("数値に変換できませんでした。");
		}
    finally {
        System.out.println("このブロックは必ず実行されます。");
    }


        System.out.println("処理を終了します。");
    }
}