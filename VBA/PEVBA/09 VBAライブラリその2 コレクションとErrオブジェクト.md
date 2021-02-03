# 9-1 VBA ライブラリで提供されるクラス
- VBA ライブラリの主なクラス
    |クラス|説明|
    |---|---|
    |Class **Collection**|コレクション表すオブジェクトを定義するクラス|
    |Class **ErrObject**|エラーを表すオブジェクトを定義するクラス   |
 # 9-2 クラクションを操作する Collectionクラス
 ## コレクションとは
 コレクションは、整数の番号と、文字列のラベルをお持つ入れ物を複数持つような構造になっています。それぞれの入れ物を**要素**といい、ユーザー定義型をのぞく任意のデータ型の値を格納できる。コレクションの要素の一つひとつをメンバーともいう。
 - Collection クラスのメンバー
    |メンバー|説明|
    |---|---|
    |Sub Add(*Item*,[*Key*],[*Before*],[*After*])|Collection オブジェクトに*Item*をメンバーとして追加する<br>インデックスの代わりに使用できるキー文字列を*Key*、追加する位置を*Before*または*After*のどちらかで指定する|
    |Function **Count**() As Long|Collection オブジェクト内の要素数を取得する|
    |Function **Item**(*Index*)|Collection オブジェクトのメンバーを取得する<br>*Index*にはインデックスを表す数値または、キー文字列を指定する<br>既定のメンバー|
    |Sub **Remove**(*Index*)|Collection オブジェクトからメンバーを削除する<br>*Index*にはインデックスを表す数値または、キー文字列を指定する|
## 9-2-2 コレクションの生成と操作
- Collection オブジェクト
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim persons As Collection: Set persons = New Collection

            With persons
                .Add "Bob", "m01"
                .Add "Tom", "m02"
                .Add "Ivy", "m03"
                .Add "Dan", Before:="m01"

                Debug.Print .Count '4
                Debug.Print .Item(1) 'Dan
                Debug.Print .Item("m02") 'Tom

                .Remove "m01"
                Debug.Print .Count '3
            End With
            'Debug.Print persons("m01") '実行時エラー
        End Sub
        ~~~
# 9-3 自作コレクションを作る
## 9-3-1 コレクションを持つクラス
