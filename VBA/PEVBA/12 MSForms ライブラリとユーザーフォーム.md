# 12-1 ユーザーフォームを操作するライブラリ
## 12-1-1 MSFormsライブラリとは
## 12-1-2 MSForms ライブラリの構造とコントロール
## 12-1-3 ユーザーフォームのメンバーのありか
## 12-1-4 ユーザーフォームとコントロールのメンバー
# 12-2 ユーザーフォームを操作する
## 12-2-1 ユーザーフォームを読み込む / 表示する
- Load ステートメントによるユーザーフォームの表示
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Load UserForm1
            With UserForm1
                .Caption = "Hoge"
                .Height = 100
                .Width = 300
                .Show
            End With
        End Sub
        ~~~
- Initialize イベントによるユーザーフォームの初期設定
    - フォームモジュールUserForm1
        ~~~
        Private Sub UserForm_Initialize()
            With Me
                .Caption = "Hoge"
                .Height = 100
                .Widht = 300
            End With
        End Sub
        ~~~
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            UserForm1.Show
        End Sub
        ~~~
## 12-2-2 ユーザーフォームを非表示にする / 閉じる
- ユーザーフォームの非表示と開放
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With UserForm1
                .Show vbModeless
                Stop
                .Hide
                .BackColor = RGB(200, 250, 250)
                Stop
                .Show vbModeless
                Stop
            End With
            Unload UserForm1
        End Sub
        ~~~
- ユーザーフォームを閉じるときのイベント
    - フォームモジュールUserForm1
        ~~~
        Private Sub UserForm_QueryClose(Cancel As Integer, CloseMode As Integer)
            If MsgBox("本当に閉じても良いですか?",vbYesNo) = vbNo Then
                Cancel = 1
            End If
        End Sub
        ~~~
## 12-2-3 コントロールを取得する
- オブジェクト名によるコントロールの取得
    - フォームモジュールUserForm1
        ~~~
        Private Sub UserForm_Click()
            With Me
                Debug.Print .Label1.Caption
                Debug.Print .TextBox1.Value
                Debug.Print .CommandButton1.Name
            End With

            Debug.Print Label1.Caption
            Debug.Print TextBox1.Value
            Debug.Print CommandButton1.Name
        End Sub
        ~~~
- ActiveControl プロパティ・Controls プロパティ
    - フォームモジュールUserForm1
        ~~~
        Private Sub UserForm_DblClick(ByVal Cancel As MSForm.ReturnBoolean)
            Debug.Print ActiveControl.Name
            Debug.Print Controls.Count
        End Sub
        ~~~
# 12-3 コントロールを操作する
## 12-3-1 Controls クラスとコントロールの参照
- Controls コレクションからコントロールを参照する
    - 標準モジュールModule1
        ~~~
        With UserForm1
            With .Controls
                Debug.Print .Item(0).Name 'TextBox1
                Debug.Print .Item("Label1").Name 'Label1
            End With

            Debug.Print .Controls(0).Name 'TextBox1
            Debug.Print .Controls("Label1").Name 'Label1
            Debug.Print .Label1.Name 'Label1
        End Sub
        ~~~
- Controls コレクションのループ
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With UserForm1
                Dim c As Control
                For Each c In.Controls
                    Debug.Print c.Name
                Next c

                Dim i As Long
                For i = 0 To .Controls.Count -1
                    Debug.Print .Controls(i).Name
                Next i
            End With
        End Sub
        ~~~
- チェックボックスのみをループする
    - フォームモジュールUserForm2
        ~~~
        Private Sub CommandButton1_Click()
            With UserForm2
                Dim c As Control
                For Each c In .Controls
                    If TypeName(c) = "CheckBox" Then
                        Debug.Print c.Name, c.Value
                    End If
                Next c

                Dim i As Long
                For i = 1 To 4
                    Set c = .Controls("CheckBox" & i)
                    Debug.Print c.Name, c.Value
                Next i
            End With
        End Sub
        ~~~
## CommandButton コントロール
- コマンドボタンの Click イベント
    - フォームモジュールUserForm3
        ~~~
        Private Sub CommandButton1_Click()
            MsgBox TextBox1.Value & "が入力されました"
        End Sub
        ~~~
        ~~~
        Private Sub CommandButton2_Click()
            Unload Me
        End Sub
        ~~~
## Label コントロール
- ラベルの Click イベント
    - フォームモジュールUserForm4
        ~~~
        Private Sub Label1_Click()
            TextBox1.SetFocus
        End Sub
        ~~~
        ~~~
        Private Sub Label2_Click()
            TextBox2.SetFocus
        End Sub
        ~~~
## TextBox コントロール
- Exit イベントによるテキストボックスの入力判定
    - フォームモジュールUserForm5
        ~~~
        Private Sub TextBox2_Exit(ByVal Cancel As MSForms.ReturnBoolean)
            With TextBox2
                If Len(.Value) < 4 Or Not IsNumeric(.Value) Then
                Cancel = True
            End With
        End Sub
        ~~~
## 12-3-5 ComboBox コントロール
- コンボボックスにリストを設定する
    - フォームモジュールUserForm6
        ~~~
        Private Sub UserForm_Initialize()
            With ComboBox1
                .List = Array("Bob", "Tom", "Jay")
            End With
        End Sub
        ~~~
- コンボボックスに複数列のリストを設定
    - フォームモジュールUserForm6
        ~~~
        Private Sub UserForm_Initialize()
            With ComboBox1
                Dim lists As Variant: Lists = Sheet1.Range("A2:B42)
                .List = lists
                .ColumnCount = 2
                .BoundColumn = 2
                .TextColumn = 1
            End With
        End Sub
        ~~~
        ~~~
        Private Sub CommandButton1_Click()
            With ComboBox1
                Debug.Print .ListIndex, .Text, .Value
            End With
        End Sub
        ~~~
## 12-3-6 CheckBox コントロール / OptionButton コントロール
- チェックボックスとオプションボタンの Click イベント
    - フォームモジュールUserForm8
     ~~~
     Private Sub CheckBox1_Click()
        MsgBox createMessage(CheckBox1)
     End Sub
     ~~~
     ~~~
     Private Sub OptionButton1_Click()
        MsgBox createMessage(OptionButton1)
     End Sub
     ~~~
     ~~~
     Private Function createMessage(ByVal obj As Object) As String
        Dim msg As String: msg = ""
        msg = msg & obj.Caption & "の値が "
        msg = msg & obj.Value & " になりました"
        createMessage = msg
     End Function
     ~~~
- オプションボタンのイベントに応答するオブジェクトのクラス
    - クラスモジュールOptionButtonObject
        ~~~
        Private withEvents myOptionButton_ As MSForms.OptionButton
        ~~~
        ~~~
        Public Property Set SetOptionButton(newOptionButton As MSForms.OptionButton)
            Set myOptionButton_ = newOptionButton
        End Property
        ~~~
        ~~~
        Private Sub myOptionButton_Click()
            MsgBox createMessage(myOptionButton)
        End Sub
        ~~~
        ~~~
        Private Function createMessage(ByVal obj As Object) As String
            Dim msg As String: msg = ""
            msg = msg & obj.Caption & "の値が "
            msg = msg & obj.Value & " になりました"
            createMessage = msg
        End Function
        ~~~
- ユーザーフォーム初期化時の処理
    - フォームモジュールUserForm9
        ~~~
        Private optionButtons_ As Collection
        ~~~
        ~~~
        Private Sub UserForm_Initialize()
            Set optionButtons_ = New Collection
            Dim c As Control
            For Each c In Controls
                If TypeName(c) = "OptionButton" Then
                    Dim newOptionButton As OptionButtonObject
                    Set newOptionButton = New OptionButtonObjcet

                    Set newOptionButton.SetOptionButton = c
                    optionButton_.Add newOptionButton
                End If
            Next c
        End Sub
        ~~~