// ファイル操作用のscala.ioパッケージを読み込み
import scala.io.Source
// 各行の文字数の桁数を取得する処理：何度も使うので関数化
def widthOfLength(s:String) = s.length.toString.length
// 入力がある場合は処理開始
if(args.length > 0) {
    // ファイルを読み込んでリスト化する
    // getLinesがファイルの内容をイテレータ化してtoListでそれをリスト化
    val lines = Source.fromFile(args(0)).getLines.toList
    // reduceLeftが第1、第2要素から順に要素を二つずつ取り出して処理を行う
    // 第1、第2の次は第2、第3と比較していくことで一番長い行の文字数を取得
    val longestLine = lines.reduceLeft(
        (a, b) => if ( a.length > b.length) a else b
    )
    // 一番長い行の文字数が何桁あるかを取得
    val maxWidth = widthOfLength(longestLine)
    // 各行ごとに表示処理
    for (line <-lines) {
       // 各行の文字数桁にあわせてフォーマットして出力する
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + " | " + line)
    }
}
// 入力がない場合はエラーを出力して終了
else
    Console.err.println("please enter filename")
