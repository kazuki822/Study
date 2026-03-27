public class Task4_27 {
	public static void main(String[] args) {
		String[] names = { "Aki", "Ken", "Mina" };

		try {
			System.out.println(names[3]); // エラーが発生する箇所
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("配列の範囲外アクセスが発生しました");
		} finally {
	        System.out.println("finallyの処理です");
	    }

		System.out.println("処理を続けます");
	}
}
/*
存在しない names[3] にアクセスしているためエラーが発生した。
対処方法
配列の範囲内（0〜2）でアクセスするように修正するか、try-catch を用いて例外を処理する。
*/