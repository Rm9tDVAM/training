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
- OnTime メソッドと Wait メソッド
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Application.OnTime Now + TimeSerial(0, 0, 3), "ShowMessage"
        End Sub
        ~~~
        ~~~
        Private Sub ShowMessage()
            MsgBox "時間になりました"
            Application.Wait Now + TimeSerial(0, 0, 3)
            MsgBox "3秒待機しました"
        End Sub
        ~~~
## 11-2-10 ワークシート関数を使用する
- WorksheetFunction オブジェクトによる MAX 関数と MIN 関数
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                Dim rng As Range: Set rng = .Range("A1:A10")
                Debug.Print WorksheetFunction.Max(rng)
                Debug.Print WorksheetFunction.Min(rng)
            End With
        End Sub
        ~~~
- WorksheetFunction オブジェクトによる ROUND 関数
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            '偶数丸め
            Debug.Print 2.4, Round(2.4) '2.4 2
            Debug.Print 2.5, Round(2.5) '2.5 2
            Debug.Print 2.6, Round(2.6) '2.6 3

            '四捨五入
            With WorksheetFunction
                Debug.Print 2.4, .Round(2.4, 0) '2.4 2
                Debug.Print 2.5, .Round(2.5, 0) '2.5 3
                Debug.Print 2.6, .Round(2.6, 0) '2.6 3
            End With
        End Sub
        ~~~
- Evaluate メソッドの引数 Name の種類
    |名前|説明|
    |---|---|
    |数式|ワークシート関数も含む数式の結果|
    |セル範囲|A1スタイルによる表現でRangeオブジェクト|
    |定義された名前|名前を定義したオブジェクト|
- Evaluate メソッド
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            [B1].Value = 123
            Evaluate("B2").Value = 456

            Debug.Print [B1].Value '123
            Debug.Print Evaluate("B2") '456

            Debug.Print [MAX(Sheet1!A1:A10)] '範囲の最大値79
            Debug.Print Evaluate("MAX(Sheet1!A1:A10)") '範囲の最大値79

            Debug.Print [ROUND(2.5, 0)] '3
            Debug.Print Evaluate("ROUND(2.5, 0)") '3

            Debug.Print [Fuga].Address '$E$3:$F$5
            Debug.Print Evaluate("Fuga").Address '$E$3:$F$5

            Debug.Print TypeName([楕円 1]) 'Oval
            Debug.Print TypeName(Evaluate("楕円 1")) 'Oval
        End Sub
        ~~~
## 11-2-11 Application オブジェクトから取得できるオブジェクト
- Application クラスのオブジェクトを取得する主なプロパティ
    |メンバー|グローバル|読み取り専用|説明|
    |---|---|---|---|
    |Property **CommandBars** As CommandBars|〇|〇|すべてのコマンドバー(ツールバーやショートカットメニューなど)を表す CommandBars コレクション|
    |Property **FileDialog**(*fileDialogType As MsoFileDialogType*) As FileDialog||〇|ファイルダイアログを表す FileDialog オブジェクト|
    |Property **VBE** As VBE|---|〇|VBE を表す VBE オブジェクト|
    |Property **Windows** As Windows|〇|〇|すべてのウィンドウを表す Windows コレクション|
## 11-2-12 Application クラスのイベント
- Application クラスの主なイベント
    |イベント|説明|
    |---|---|
    |Event **NewWorkbook**(*Wb As Workbook*)|新しいブックを作成したとき|
    |Event **SheetActivate**(*Sh As Object*)|シートがアクティブになったとき|
    |Event **SheetBeforeDefete**(*Sh As Object*)|シートが削除される前|
    |Event **SheetBeforeDoubleClick**(*Sh As Object, Target As Range, Cancel As Boolean*)|シートがダブルクリックされたとき|
    |Event **SheetBeforeRightClick**(*Sh As Object, Target As Range, Cancel As Boolean*)|シートが→クリックされたとき|
    |Event **SheetCalculate**(*Sh As Object*)|シートが再計算されたとき|
    |Event **SheetChange**(*Sh As Object, Target As Range*)|シートのセルが変更されたとき|
    |Event **SheetDeactivate**(*Sh As Object*)|シートが日アクティブになったとき|
    |Event **SheetFollowHyperlink**(*Sh As Object, Target As Hyperlink*)|シートのハイパーリンクをクリックしたとき引数 *Hyperlink* は対象の Hyperlink オブジェクト|
    |Event **SheetSelectionChange**(*Sh As Object, Target As Range*)|シートの選択範囲が変更されたとき|
    |Event **WindowActivate**(*Wb As Workbook, Wn As Windwo*)|ウィンドウがアクティブになったとき|
    |Event **WindowDeactivate**(*Wb As Workbook, Wn As Window*)|ウィンドウが非アクティブになったとき|
    |Event **WindowResize**(*Wb As Workbook, Wn As Window*)|ウィンドウのサイズを変更したとき|
    |Event **WorkbookActivate**(*Wb As Workbook*)|ブックがアクティブになったとき|
    |Event **WorkbookAddinInstall**(*Wb As Workbook*)|ブックがアドインとして組み込まれたとき|
    |Event **WorkbookAddinUninstall**(*Wb As Workbook*)|ブックのアドイン組み込みが解除されたとき|
    |Event **WorkbookAfterSave**(*Wb As Workbook, Success As Boolean*)|ブックを保存した後<br>引数 Success は保存が成功したかどうかを表すブール値|
    |Event **WorkbookBeforeClose**(*Wb As Workbook, Cancel As Boolean*)|ブックを閉じる前|
    |Event **WorkbookBeforePrint**(*Wb As Workbook, Cancel As Boolean*)|ブックを印刷する前|
    |Event **WorkbookBeforeSave**(*Wb As Workbook, SaveAsUI As Boolean, Cancel As Boolean*)|ブックを保存する前<br>引数 *SaveAsUI* は名前を付けて保存かどうかを表すブール値|
    |Event **WorkbookDeactivate**(*Wb As Workbook*)|ブックが非アクティブになったとき|
    |Event **WorkbookNewSheet**(*wb As Workbook, Sh As Object*)|ブックに新しいシートを作成したとき|
    |Event **WorkbookOpen**(*Wb As Workbook*)|ブックを開いたとき|
- Application イベントの引数
    |引数|説明|
    |---|---|
    |*Wb*|イベントの対象の Workbook オブジェクト|
    |*Sh*|イベント対象の Worksheet オブジェクトまたは Chart オブジェクト|
    |*Target*|イベントの対象の Range オブジェクト|
    |*Win*|イベントの対象の Window オブジェクト|
    |*Cancel*|イベント操作を中止するかどうかを表すブール値|
- Application オブジェクトのイベント
    - クラスモジュールClass1
        ~~~
        Public WithEvent App As Application
        ~~~
        ~~~
        Private Sub App_NewWorkbook(ByVal Wb As Workbook)
            MsgBox "ブック" & Wb.Name & " が作成されました"
        End Sub
        ~~~
    - 標準モジュールMobule1
        ~~~
        Private c As Class1
        ~~~
        ~~~
        Sub InitializeApp()
            Set c = New Class1
            Set c.App = Application
        End Sub
        ~~~
        ~~~
        Sub MySub()
            Workbooks.Add
        End Sub
        ~~~
# 11-3 ブックを操作する Workbooks クラス / Workbook クラス
## 11-3-1 Workbooks クラスとは
- Workbooks クラスの主なプロパティ
    |メンバー|読み取り専用|説明|
    |---|---|---|
    |Property **Count** As Long|〇|コレクションに含まれるオブジェクトの数|
    |Property **_Default**(*index*) As Workbook|〇|既定のメンバー<br>コレクションの要素のうち *Index* で参照される単一のオブジェクト|
    |Property **Item**(*Index*) As Object|〇|コレクションの要素のうち *Index* で参照される単一のオブジェクト|
    |Property **Parent** As Object|〇|親オブジェクト|
- Workbooks クラスの主なメソッド
    |メンバー|説明|
    |---|---|
    |Function **Add**([*Template*]) As Workbook|新しいブックを作成する|
    |Function **Open**(*Filename As String*, [*UpdateLinks*], [*ReadOnly*], [*Format*], [*Password*], [*WriteResPassword*], [*IgnoreReadOnlyRecommended], [*Origin*], [*Delimiter*], [*Editable*], [*Notify*], [*Notify*], [*Converter*], [*AddToMru*], [*Local*], [*CorrupLoad*] As Workbook)|*Filename* で指定するブックを開く|
## 11-3-2 ブックを参照する
- Workbooks コレクションからブックを参照する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Debug.Print Workbooks.Item(1).Name 'Book1
            Debug.Print Workbooks.[_Default](1).Name 'Book1
            Debug.Print Workbooks(1).Name 'Book1

            Debug.Print Workbooks("Book1").Name 'Book1
            Debug.Print Workbooks("Book2.xlsx").Name 'Book2.xlsx
        End Sub
        ~~~
- Workbooks コレクションのループ
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim wb As Workbook
            For Each wb In Workbooks
                Debug.Print wb.Name
            Next wb

            Dim i As Long
            For i = 1 To Workbooks.Count
                Debug.Print i, Workbooks(i).Name
            Next i
        End Sub
        ~~~
## 11-3-3 ブックを作成する/開く
- 列挙型 XIWBATemplate のメンバー
    |メンバー|値|説明|
    |---|---|---|
    |xlWBATChart|-4109|グラフシート|
    |xlWBATExcel4IntlMacroSheet|4|Excel バージョン4 のマクロシート|
    |xlWBATExcel4MacroSheet|3|Excel バージョン 4 のインターナショナルマクロシート|
    |xlWBATWorksheet|-4167|ワークシート|
- 新しいブックを作成する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim wb As Workbook: Set wb = Workbooks.Add
            Debug.Print wb.Name

            With Workbooks.Add
                Debug.Print .Name
            End with
        End Sub
        ~~~
- Workbooks コレクションの Open メソッドの引数
    |パラメーター|説明|
    |---|---|
    |*FileName*|開くブックのファイル名|
    |*UpdateLinks*|ブックを開いた際に外部参照を更新するかどうかについて、3(更新する)または0(更新しない)を指定する|
    |*ReadOnly*|ブックを読み取り専用モードで開くかどうかをブール値で指定する|
    |*Format*|テキストファイルを開く際の区切り文字を1(タブ)、2(カンマ)、3(スペース)、4(セミコロン)、5(なし)、6(カスタム文字)から指定する|
    |*Password*|パスワード保護されたブックを開くのに必要なパスワードを文字列で指定する。省略時、パスワードが必要な場合は入力ダイアログが表示される|
    |*WriteResPassword*|書き込み保護されたブックに書き込みをするために必要なパスワードを指定する。省略時、パスワードが必要な場合は入力ダイアログが表示される|
    |*IgnoreReadOnly*<br>*Recommended*|読み取り専用を推奨するメッセージを非表示にするかどうかをブール値で指定する|
    |*Origin*|テキストファイルを開く際の、作成されたプラットフォームについて、列挙型 XlPlatform のメンバーから指定する。1(xlMacintosh)、2(xlMSDOS)、3(xlWindows)|
    |*Delimiter*|引数 *Format* 6(カスタム文字)の場合の区切り文字を文字列で指定する|
    |*Editable*|開くブックが Excel 4.0 のアドインでありウィンドウに表示する場合、または Excel テンプレートであり編集用で開く場合に True を設定する|
    |*Notify*|ファイルが読み取り/書き込みモードで開けない場合に、ファイルを通知リストに追加するかどうかをブール値で指定する|
    |*Converter*|ファイルを開くときに最初に実行するファイルコンバータのインデックスを指定する|
    |*AddToMru*|最近使用したファイルの一覧にブックを追加するかどうかをブール値で指定する|
    |*Local*|Excel の言語設定に合わせるかどうかをブール値で指定する。規定値は False で、その場合は VBA の言語設定で保存される|
    |*CorruptLoad*|ブックの読み込み方法を列挙型 XlCorruptLoad のメンバーから指定する。<br>規定値 xlNormalLoad(標準)、xlRepairFile(修復モード)、xlExtractData(データの抽出モード)|
- ブックを開く
    - 標準モジュールModule1
        ~~~
        ~~~