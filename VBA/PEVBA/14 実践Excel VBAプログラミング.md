# 14-1  名簿管理ツールの開発
## 14-1-1 名簿管理ツールの概要
## 14-1-2 プロジェクトの構成と開発手順
## 14-1-3 ドキュメンテーションコメント
- ドキュメンテーションコメント
    - 標準モジュールModule1
        ~~~
        '**
        '* 長方形の面積を計算して返す
        '*
        '* @param x {Long} 縦の長さ(cm)
        '* @param y {Long} 横の長さ(cm)
        '* @return {Long} 面積(平方cm)
        '*
        Function GetArea(ByVal x As Long, ByVal y As Long) As Long
            GetArea = x * y
        End Function
        ~~~
# 14-2 データベースを準備する
## 14-2-1 データを1つにまとめる
## 14-2-2 テーブル化する
## 14-2-3 ID を付与する
## 14-2-4 データの削除について
## 14-2-5 データベースとは
# 14-3 クラスを作成する
## 14-3-1 データをプロパティとして定義する
- クラス Person のデータをプロパティとして定義
    - クラスモジュール Person
        ~~~
        Public Id As Long
        public Name As String
        public Gender As String
        public Birthday As Date
        public Active As Boolean
        ~~~
## 14-3-2 インスタンスに初期値を設定する
- クラス Person の初期値を設定するメソッド
    - クラスモジュールPerson
        ~~~
        '**
        '* Person クラスのインスタンスに初期値を設定する
        '* 
        '* @param myRange {Range} 設定するレコードのセル範囲
        '*
        public Sub Initialize(ByVal myRange As Range)
            Id = myRange(eid).Value
            Name = myRange(eName).Value
            Gender = myRange(eGender).Value
            Birthday = myRange(eBirthday).Value
            Active = myRange(eActive).Value
        End Sub
        ~~~
- フィールド番号を表す列挙型の定義
    - シートモジュールSheet1
        ~~~
        Enum eFieldsSheet1
            eId = 1
            eName
            eGender
            eBirthday
            eActive
        End Enum
        ~~~
- インスタンスの生成と初期設定の動作確認
    - 標準モジュールmodule1
        ~~~
        Sub MySub()
            Dim p As Person: Set p = New Person
            p.Initialize Sheet1.ListObjects(1).ListRows(1).Range

            Stop
        End Sub
        ~~~
- 14-3-3 プロパティを定義する
    - クラスモジュールPerson
        ~~~
        '**
        '* Person クラスの年齢を取得する
        '*
        '* @return {Long} 年齢
        '*
        Public Property Get Age() As Long
            Dim myAge As Long
            myAge = DateDiff("yyyy", Me.Birthday, date)

            If Date < DateSerial(Year(Now), Month(Me.Birthday), Day(Me.Birthday)) Then>
                myAge = myAge - 1
            End If

            Age = myAge
        End Property
        ~~~
# 14-4 シートモジュールの処理を作る
## 14-4-1 コレクションを定義する
- コレクションの定義
    - シートモジュールSheet1
        ~~~~
        Public Persons As Collection
        Public MaxId As Long 'IDの最大値
        ~~~~
## 14-4-2 データの読み書きをする処理を作る
- データの読み書き
    - シートモジュールSheet1
        ~~~
        '**
        '* テーブル上のデータを Person コレクション として格納する
        '*
        Public SUb LoadData()
            Set Persons = New Collection

            With ListObjects(1)
                Dim myRow As ListRow
                For Each myRow In .ListRows
                    Dim p As Person: Set p = New Person
                    p.initialize myRow.Range
                    Persons.Add p, CStr(p.Id) 'キーはString型
                Next myRow

                MaxId = .ListRows.Count
            End With
        End Sub
        ~~~
        ~~~
        '**
        '* Personsコレクションのデータをテーブルに適用する
        '*
        Public Sub ApplyData()
            With ListObjects(1)
                If .ListRows.Count > 0 Then .DataBodyRange.EntireRow.Delete

                Dim p As Person
                For Each p In Persons
                    Dim values As Variant
                    values = Array(p.Id, p.Name, p.Gender, p.Birthday, p.Active)
                Next p

                MaxId = .ListRows.Count
            End With
        End Sub
        ~~~
- データの読み書きの確認
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                .LoadData

                With .Persons(1)
                    .Name = "横尾 勤"
                    .Birthday = #3/30/1988#
                    .Active = True
                End With

                .ApplyData
            End With
        End Sub
        ~~~
# 14-5 ユーザーフォームを作成する
## 14-5-1 コントロールを配置する
## 14-5-2 ユーザーフォームの表示する
- ユーザーフォームの表示
    - 標準モジュールModule1
        ~~~
        '**
        '* ユーザーフォーム UserForm1 を表示する
        '* (Sheet1 のコントロールボタン「名簿管理」にマクロを登録)
        '*
        Sub ShowUserForm()
            UserForm1.Show vbModeless
        End Sub
        ~~~
## 14-5-3 ユーザーフォームの初期化時の処理
- ユーザーフォームの初期化時の処理
    - フォームモジュールUserForm1
        ~~~
        '**
        '* イベントプロシージャ: UserForm_Initialize
        '*
        Private Sub UserForm_Initialize()
            Call Sheet1.LoadData
            Call LoadIdList
        End Sub
        ~~~
        ~~~
        '**
        '* コンボボックス ComboBoxId のリストを読み込む
        '*
        Private Sub LoadIdList()
            With Sheet1.ListObjects(1)
                If .ListRows.Count > 1 Then
                    Dim lists As Variant: lists = .ListColumns(1).DataBodyRange
                End If
            End With

            ComboBoxId.AddItem "New"
        End Sub
        ~~~
## 14-5-4 ユーザーフォームにデータを表示する
- コンボボックスの値が変更されたときのイベントプロシージャ
    - フォームモジュールUserForm1
        ~~~
        '**
        '* イベントプロシージャ: ComboBoxId_Change
        '*
        Private Sub ComboBoxId_Change()
            With ComboBOxId
                If IsValidId Then
                    If IsNumeric(.Value) Then
                        Call LoadFields(.Value)
                    Else
                        Call ClearFields
                    End IF
                End If
            End With
        End Sub
        ~~~
- コンボボックスの値が適正かどうか判定する
    - フォームモジュールUserForm1
        ~~~
        '**
        '* コンボボックス ComboBoxId の値が適正かどうか
        '*
        '* @return {Boolean} コンボボックス ComboBoxId の値が1以上 ID の最大値以下、または"New"かどうか
        '*
        Private Property Get IsValidId() As Boolean
            IsValidId = False
            With ComboBoxID
                If (.Value > 0 And .Value <= Sheet1.MaxId) Or (.Value = "New"") Then IsValidId = True
            End With
        End Property
        ~~~
- 各コントロールにデータを呼び出す
    - フォームモジュールUserForm1
    ~~~
    '**
    '* 各コントロールの値として指定した ID のレコードのデータを呼び出す
    '*
    '* @param myId {Long} 呼び出すレコードの ID
    '*
    Private Sub LoadFields(ByVal myId As Long)
        With Sheet1.Persons.Item(myID)
            ComboBoxId.Value = myId
            TextBoxName.Value = .Name
            Call SetGender(.Gender)
            TextBoxBirthday.Value = .Birthday
            LabelAge.Caption = .Age
            CheckBoxActive.Value = .Active
        End With
    End Sub
    ~~~
    ~~~
    '**
    '* 性別を表す文字列("男"または"女")をもとにオプションの値を設定する
    '*
    '* @param myGender {String} 性別を表す文字列
    '*
    '*
    Private Sub SetGender(ByVal myGender As String)
        OptionButtonFemale.Value = True
        If myGender = "男" Then OptionButtonMale.Value = Then
    End Sub
    ~~~
- 各コントロールの値をクリアする
    - フォームモジュールUserForm1
        ~~~
        '**
        '* 各コントロールの値をクリアする
        '*
        Private Sub ClearFields()
            TextBoxName.Value = ""
            OptionButtonMale.Value = True
            TextBoxBirthday.Value = ""
            LabelAge.Caption = ""
            CheckBoxActive.Value = True
        End Sub
        ~~~
## 14-5-5 レコードを更新 / 追加する
- レコードを更新する・追加する
    - シートモジュールSheet1
        ~~~
        '**
        '* Persons コレクションの Person オブジェクトを更新する
        '*
        '* @param p {Person} 更新する Person オブジェクト
        '*
        Public Sub UpdatePerson(p As Person)
            With Person(p.Id)
                .Id = p.Id
                .Name = p.Name
                .Gender = p.Gender
                .Birthday = p.Birthday
                .Active = p.Active
            End With

            Call ApplyData
        End Sub
        ~~~
        ~~~
        '**
        '* Persons コレクションに Person オブジェクトを追加する
        '*
        '* @param p {Person} 追加する Person オブジェクト
        '*
        Public Sub AddPerson(p As Person)
            Persons.Add p, CStr(p.Id)
            Call ApplyData
        End Sub
        ~~~
- レコードの更新と追加を確認する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                .LoadData

                Dim p As Person: Set p = New Person
                With p
                    .Id = 1
                    .Name = "横尾 勤"
                    .Gender = "男"
                    .Birthday = #3/30/1988#
                    .Active = True
                End With

                .UpdatePerson p

                p.Id = .MaxId + 1
                .Addperson p
            End With
        End Sub
        ~~~
## 14-5-6 ボタンクリックで処理を呼び出す
- データの更新または追加をする
    - フォームモジュールUserForm1
        ~~~
        '**
        '* イベントプロシージャ: CommandButtonUpdate_Click
        '*
        Private Sub CommandButtonUpdate_Click()
            If CheckFields Then
                Dim p As Person: Set p = New Person
                p.Name = TextBox Name.Text
                p.Birthday = TextBoxBirthday.Value
                p.Gender = "女"
                If OptionButtonMale.Value = True Then p.Gender = "男"
                p.Active = CheckBoxActive.Value

                If ComboBoxId.Value = "New" Then
                    p.Id = Sheet1.MaxId + 1
                    Call Sheet1.AddPerson(p)
                Else
                    p.Id = ComboBoxId.Value
                    Call Sheet1.UpdatePerson(p)
                End IF

                Call LoadFields(p.Id)
                Call LoadIdList
            End IF
        End Sub
        ~~~
- 各コントロールの値をチェックする
    - フォームモジュールUserForm1
        ~~~
        '**
        '* 各コントロールの値が正しく入力されているかどうかを判定する
        '*
        '* @return {Boolean} すべてのコントロールの値が正しく入力されているかどうか
        '*
        Private Function CheckField() As Boolean
            CheckFields = True

            If Not IsValidId Then
                MsgBox "「ID」は1以上IDの最大値以下の数値または""New""を入力してください", vbInformation
                CheckFields = False
            End If

            If Len(TextBoxName.Text) = 0 Then
                MsgBox "「名前」に入力してください", vbInformation
                CheckFields = False
            End If

            If Not IsDate(TextBoxBirthday.Value) Then
                MsgBox "「誕生日」に日付を入力してください", vbInformation
                CheckFields = False
            End If
        End Function
        ~~~
## 14-5-7 ユーザーフォームを閉じる
- ユーザーフォームを閉じる
    - フォームモジュールUserForm1
        ~~~
        '**
        '* イベントプロシージャ: CommandButtonClose_Click
        '*
        Private Sub CommandButtonClose_Click()
            Unload Me
        End Sub
        ~~~
# 14-6 運用を想定する
## 14-6-1 シートの保護をする
- テーブルの更新時に保護を解除する
    - シートモジュールSheet1
        ~~~
        '**
        '* Persons コレクションのデータをテーブルに適用する
        '*
        Public Sub ApplyData()
            Me.Unprotect "hogehoge"

            With ListObjects(1)
                If .ListRows.Count > 0 Then .DataBodyRange.EntireRow.Delete

                Dim p As Person
                For Each As Person
                    Dim values As Variant
                    values = Array(p.Id, p.Name, p.Gender, p.Birthday, p.Active)
                Next p

                MaxId = .ListRows.Count
            End With

            Me.Protect "hogehoge", AllowFiltering:=True
        End Sub
        ~~~
## 14-6-2 オートフィルターを解除する
- テーブル更新時にオートフィルターの解除をする
    - シートモジュールSheet1
        ~~~
        '**
        '* Persons コレクションのデータをテーブルに適用する
        '*
        Public Sub ApplyData()
            ListObject(1).ShowAutoFilter = False
            Mu.Unprotect "hogehoge"

            With ListObjcet(1)
                If .ListRows.Count > 0 Then .DataBodyRange.EntireRow.Delete

                Dim values As Variant
                For Each p In Persons
                    values = Array(p.Id, p.Name, p.Gender, p.Birthday, p.Active)
                    .ListRows.Add.Range = values
                Next p

                MaxId = .ListRows.Count
            End With

            Me.Protect "hogehoge", AllowFiltering:=True
            ListObject(1).ShowAutoFilter = True
        End Sub
        ~~~
## 14-6-3 マクロの高速化をする
- テーブル更新の実行速度を測定する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim start As date: start = Time

            Call ShowUserForm
            Call Sheet1.ApplyData
            Unload UserForm1

            Dim finish As Date: finish = Time
            Debug.Print Minute(finish - start) * 60 + Second(finish - start)
        End Sub
        ~~~
- 2次元配列によるテーブルの更新
     - シートモジュールSheet1
        ~~~
        '**
        '* Persons コレクションのデータをテーブルに適用する
        '*
        Public Sub ApplyData()
            ListObject(1).ShowAutoFilter = False
            Me.unprotect "hogehoge"

            With ListObjects(1)
                If .ListRows.Count > 0 Then .DataBodyRange.EntireRow.Delete

                MaxId = Persons.Count
                Dim values() As Variant: ReDim values(1 To MaxId, 1 To 5)

                Dim p As Person
                For Each p In Persons
                    values(p.Id, eId) = p.Id
                    values(p.Id, eName) = p.Name
                    values(p.Id, eGender) = p.Gender
                    values(p.Id, eBirthday) = p.Birthday
                    values(p.Id, eActive) = p.Active
                Next p

                Dim baseRange As Range: Set baseRange = .Range(1, 1).Offset(1)
            End With

            Me.Protect "hogehoge", AllowFiltering:=True
            ListObjects(1).ShowAutoFilter = True
        End Sub
        ~~~