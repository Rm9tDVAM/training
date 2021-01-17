# パスワード設定されたエクセルファイルを開く
- 読み取りパスワードを指定して開く
    ~~~
    Dim openExcelFile As Workbook
    Set openExcelFile = Workbooks.Open(filePath, Password:="test")
    ~~~
- 書き込みパスワードを指定して開く
    ~~~
    Dim openExcelFile As Workbook
    Set openExcelFile = Workbooks.Open(filePath, WriteResPassword:="test")
    ~~~
- 両方指定
    ~~~
    Dim openExcelFile As Workbook
    Set openExcelFile = Workbooks.Open(filePath, Password:"test", WriteResPassword:="test")
    ~~~
# リンクを更新しないでマクロVBAブックを開く
- UpdatelinkをFalseにする
    ~~~
    Sub Updatelink()
        Workbooks.Open Filename:=ThisWorkbook.Path & "sample.xlsx", UpdateLinks:=False
    End Sub
   ~~~
# ブックを開く
- sample 1
    ~~~
    Sub MySub()
        Workbooks.Open "C:\Book1.xlsx"
    End Sub
    ~~~
- sample 2
    ~~~
    Sub MySub()
        Workbooks.Open Filename:="C:\Book1.xlsx"
    End Sub
    ~~~