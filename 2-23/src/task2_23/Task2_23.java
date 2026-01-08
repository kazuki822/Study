package task2_23;

import java.util.ArrayList;

import constants.Constants;
import language.Student;
import person.Person;
        
        
public class Task2_23 {

    public static void main(String[] args) {
        //Personクラスのインスタンスを格納するArrayListクラス型の変数persons
        ArrayList<Person> persons = new ArrayList<Person>(); 
        
        //①Personクラスの変数名「yamada」というインスタンスを作成して下さい。
        //引数には1:山田太郎 2:Java を入れて下さい。
        //また「Java」は、Constants.javaのものを扱って下さい。

        //ここに解答
        Person yamada = new Person("山田太郎", Constants.LANGUAGE_JAVA );
        // ② ①で作成した「yamada」を、ArrayListクラス型の変数personsに追加して下さい。

        //ここに解答
        persons.add(yamada);

        //③作成した変数「yamada」を利用し名前を表示して下さい。

        //ここに解答
        System.out.println(yamada.getName());
        
        //④Personクラスの変数名「ishitani」というインスタンスを作成して下さい。
        //引数には1:石谷花子 2:HTML を入れて下さい。
        //また「HTML」は、Constants.javaのものを扱って下さい。
        
        //ここに解答
        Person ishitani = new Person("石谷花子", Constants.LANGUAGE_HTML);
        
        //⑤ ④で作成した「ishitani」を、ArrayListクラス型の変数personsに追加して下さい。
        
        //ここに解答
        persons.add(ishitani);
        //⑥作成した変数「ishitani」を利用し学んでいる言語を表示して下さい。

        //ここに解答
        System.out.println(ishitani.getLanguage());
        //⑦ ArrayList「persons」に追加されたすべての人をfor文を使用して順番に取り出し、
        //「〇〇が△△を学んでいます」という形式で出力して下さい。
        // 出力には、Studentクラスのインスタンスを作成し、studyLanguage()メソッドを呼び出して実行するして下さい。
        //※for文 または 拡張for文 のどちらを使っても構いません。
        
        //ここに解答
        for (Person person : persons) {
            Student student = new Student(person.getName(), person.getLanguage());
            student.studyLanguage();
    }
    }
}