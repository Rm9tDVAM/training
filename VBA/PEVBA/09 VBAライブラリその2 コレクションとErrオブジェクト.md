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
- コレクションの要素となるクラスPerson
    - クラスモジュールPerson
        ~~~
        Public Id As String
        Public FirstName As String
        Public Age As Long
        ~~~
- Personsクラス
    - クラスモジュールPersons
        ~~~
        Public Item As Collection
        ~~~
        ~~~
        Private Sub Class_Initialize()
            Set Item = New Collection
        End Sub
        ~~~
        ~~~
        Public Sub Add(ByVal newId As String, ByVal newName As String, ByVal newAge As Long)
            Dim p As Person: Set p = New Person
            With p
                .Id = newId
                .FirstName = newName
                .Age = newAge
            End With

            Items.Add p, newId
        End Sub
        ~~~
- Person コレクションの動作確認
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim myPersons As Persons: Set myPersons = New Persons
            With myPersons
                .Add "m01", "Bob", 25
                .Add "m02", "Tom", 32
                .Add "m03", "Ivy", 28
                Debug.Print .Items(1).FirstName 'Bob
                Debug.Print .Items("m02").Age '32
            End With
        End Sub
        ~~~
## 9-3-3 列挙メソッドを追加する
- 自作コレクションに列挙メソッドを追加する
    - Persons.cls
        ~~~
        Public Function NewEnum() As IEnumVARIANT
        Attribute NewEnum.VB_UserMemId = -4
            Set NewEnum = items_.[_NewEnum]
        End Function
        ~~~
- Persons コレクションのループ
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim myPersons As Persons: Set myPersons = New Persons
            With myPersons
                .Add "m01", "Bob", 25
                .Add "m02", "Tom", 32
                .Add "m03", "Ivy", 28
            End With

            Dim p As Person
            For Each p In myPersons
                Debug.Print p.FirstName, p.Age
            Next p
        End Sub
        ~~~
# 9-4 エラーを表すオブジェクト ErrObject クラス
## 9-4-1 Err オブジェクトとは
実行時エラーに関する情報を含むオブジェクトとそのメンバーを提供するクラス
- Errobject クラスのメンバー
    |メンバー|説明|
    |---|---|
    |Propety **Description** As String|エラーの説明|
    |Propety **HelpContext** As Long|ヘルプファイルのトピックのコンテキストID|
    |Property **HelpFile** As String|ヘルプファイルのパス|
    |Property **Number** As Long|エラーを識別するための数値、エラー番号<br>既定のメンバー|
    |Property **Source** As String|エラーが発生したオブジェクトまたはアプリケーション名|
    |Sub **Clear()**|Errオブジェクトのすべてのプロパティをクリアする|
    |Sub **Raise**(Number As Long, [Source], [Descriptin], [HelpFile], [HelpContext])|Numberで表す実行時エラーを発生させる|
- Err オブジェクト
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            On Error GoTo ErrorHandler

            With Err
                .Clear
                .Raise 11
            End With
            
        Exit Sub

        ErrorHandler:
            With Err
                Dim title As String: title = "エラーが発生しました"

                Dim m As String: m = ""
                m = m & "エラー番号:" & .Number & vbNewLine
                m = m & "エラー内容:" & .Descriptin & vbNewLine
                m = m & vbNewLine
                m = m & "ヘルプを参照するには、「ヘルプ」ボタンをクリックしてください。"

                MsgBox m, vbExclamation + vbMsgBoxHalpButton, title, .HelpFile, .HelpContext
            End With
        End Sub
        ~~~
