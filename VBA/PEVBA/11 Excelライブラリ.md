# 11-1 Excel ライブラリ
## 11-1-1 Excel ライブラリとは
Excelを操作するための機能を提供するライブラリ
- Excel ライブラリの主なクラス
    |クラス|説明|
    |---|---|
    |Class **Application**|Excelアプリケーション自体を表すクラス|
    |Class **ListColumn**|テーブル列を表すクラス|
    |Class **ListColumns**|テーブル列のコレクションを表すクラス|
    |Class **ListObject**|テーブルを表すクラス|
    |Class **ListObjects**|テーブルのコレクションを表すクラス|
    |Class **ListRow**|テーブル行を表すクラス|
    |Class **ListRows**|テーブル行のコレクションを表すクラス|
    |Class **Range**|セル、行、列、セル範囲を表すクラス|
    |Class **Sheets**|シートのコレクションを表すクラス|
    |Class **Workbook**|ブックを表すクラス|
    |Class **Workbooks**|ブックのコレクションを表すクラス|
    |Class **Worksheet**|ワークシートを表すクラス|
    |Class **WorksheetFunction**|VBAからExcelワークシート関数を呼び出す機能を提供するクラス|
## 11-1-2 Excel ライブラリの階層構造
## 11-1-3 Excel ライブラリのグローバルのメンバー
# 11-2 Excel アプリケーションを操作する
## 11-2-1 Application クラスとは
Excelのアプリケーション自体を操作するクラス
## 11-2-2 ブックを取得する
- ブックの取得
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Debug.Print ActiveWorkbook.Name 'Book1
            Debug.Print Workbooks.Count '1
        End Sub
        ~~~
## 11-2-3 シートやセル範囲を取得する
- Application クラスのシートやセル範囲を取得するプロパティ
    |取得する<br>オブジェクト|メンバー|説明|
    |---|---|---|
    |Range|Property **ActiveCell** As Range|アクティブなセルを表すRangeオブジェクト|
    |〃|Property **Cells** As Range|アクティブなシートのすべてのセルを表すRangeオブジェクト|
    |〃|Property **Columns** As Range|アクティブなワークシートのすべての列を表すRangeオブジェクト|
    |〃|Property **Range**(*Cell1*,[*Cell2*] As Range|アクティブなワークシートのCell1およびCell2で表すRangeオブジェクト|
    |〃|Property **Rows** As Range|アクティブなワークシートのすべての行を表すRangeオブジェクト|
    |〃|Property **Selection** As Object|現在選択されているオブジェクト|
    |Worksheet,<br>Chart|Property **ActiveSheet** As Object|アクティブシートを表すオブジェクト|
    |Sheet|Property **Chart** As Sheets|アクティブなブックのすべてのグラフシートを表すSheetsコレクション|
    |〃|Property **Sheets** As Sheets|アクティブなブックのすべてのシートを表すSheetsコレクション|
    |〃|Property **Worksheets** As Sheets|アクティブなブックのすべてのワークシートを表すSheetsコレクション|
- Selection プロパティとActiveCell プロパティ
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim obj As Object: Set obj = Selection

            If TypeName(obj) = "Range" Then
                Debug.Print obj.Address
            Else
                Debug.Print TypeName(obj)
            End IF

            Debug.Print ActiveCell.Address
        End Sub
        ~~~
- 11-2-4 セル範囲の交差/集合を求める
    - Intersect メソッドとUnion メソッド
        ~~~
        Sub MySub()
            With Sheet1
                Dim rng1 As Range: Set rng1 = .Range("C1:E5")
                Dim rng2 As Range: Set rng2 = .Range("B2:F4")
                Dim rng3 As Range: Set rng3 = .Range("A3:G3")
            End With
        End Sub

        With Union(rng1, rng2, rng3)
            .Select
            Debug.Print .Address '$C$1:$E$5,$B$2:$F$4,$A$3:$G$3
        End With
        Stop

        With Intersect(rng1, rng2, rng3)
            .Select
            Debug.Print .Address '$C$3:$E$3
        End With
        ~~~
## 11-2-4 ダイアログを操作する
- InputBox メソッドの引数 Type の値
    |値|説明|
    |---|---|
    |0|数式|
    |1|数値|
    |2|文字列(規定値)|
    |4|ブール値|
    |8|セル参照(Range オブジェクト|
    |16|エラー値(#N/A などの)|
    |64|値の配列|
- InputBox メソッド
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With.Sheet1
                .Range("A1").Value = Application.InputBox("数値を入力してください", Type:=1)
                .Range("A2").Value = Application.InputBox("文字列を入力してください")
                .Range("A3").Value = Application.InputBox("ブール値を入力してください", Type:=4)
                .Range("A4").FormulaLocal = _
                    Application.InputBox("数式を入力してください", Type:=0)
                .Range("A5").Value = _
                    Application.InputBox("セル範囲を入力してください", Type:=8).Address
            End With
        End Sub
        ~~~
## 11-2-6 ステータスバーを操作する
- ステータスバーの設定
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Application
                Dim oldStatusBar As Boolean: oldStatusBar = .DisplayStatusBar
                .DisplayStatusBar = True
                .StatusBar = "時間がかかる処理を実行しています"
                Stop
                .StatusBar = False
                .DisplayStatusBar = oldStatusBar
            End With
        End Sub
        ~~~
## 11-2-7 特定のメッセージを非表示にする
- シート削除のメッセージを非表示にする
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Application.DisplayAlerts = False

            With ThisWorkbook.Worksheets.Add
                .Name = "Hoge"
                .Delete
            End With

            Application.DisplayAlerts = True
        End Sub
        ~~~
## 11-2-8 アプリケーションの設定とマクロの高速化
- 列挙型 XlCalculation のメンバー
    |メンバー|値|説明|
    |---|---|---|
    |xlCalculationAutomatic|-4105|自動で計算する|
    |xlCalculationManual|-4135|手動で計算する|
    |xlCalculationSemiautomatic|2|テーブル以外自動で計算する|
- マクロの実行速度と高速化
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Sheet1.Cells.Clear
            Dim start As Date: start = Time

            With Application
                .Calculation = xlCalculationManual
                .EnableEvents = False
                .ScreenUpdating = False
            End With

            With Sheet1
                Dim i As Long
                For i = 1 To 300
                    .Cells(i, 1).Value = i
                    .Cells(i, 2).FormulaLocal = "=SUM("A1:A" & i & ")"
                    .Rows(i).Copy
                    Sheet2.Cells(i, 1).PasteSpecial
                Next i
            End With

            With Application
                .Calculation = xlCalculationAtutomatic
                .EnableEvents = True
                .ScreenUpdating = True
            End With

            Dim finish As Date: finish = Time
            Debug.Print Minute(finish - start) * 60 + Second(finish - start)
        End Sub
        ~~~
- マクロの高速化についての計測結果
    |パターン|Calculation<br>プロパティ|EnableEvents<br>プロパティ|ScreenUpdating<br>プロパティ|合計実行時間<br>[全てオンとの差]|
    |---|---|---|---|---|
    |全てオン|自動|True|True|147[0]|
    |計算モードのみ手動|手動|True|True|126[-21]|
    |イベント発生のみオフ|自動|False|True|140[-7]|
    |画面描画のみオフ|自動|True|False|66[-81]|
    |全てオフ|手動|False|False|59[-88]|
## 11-2-9 マクロの実行を時間で制御する
