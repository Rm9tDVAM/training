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
        Sub MySub()
            Dim wb As Workbook: Set wb = Workbooks.Open("Hoge.xlsx")
            Debug.Print wb.Name 'Hoge.xlsx

            With Workbooks.Open( _
                Application.DefaultFilePath & "\Fuga.xlsx", _
                Password:="hogehoge", _
                WriteResPasword:="fugafuga")

                Debug.Print .Name 'Fuga.xlsx
            End With
        End Sub
        ~~~
## 11-3-4 Workbook クラスとは
- Workbook クラスの主なプロパティ
    |メンバー|読み取り専用|説明|
    |---|---|---|
    |Property **Charts** As Sheets|〇|ブックのすべてのグラフシートを表す Sheets コレクション|
    |Property **FullName** As String|〇|パスも含めたブック名を表す文字列|
    |Property **HasPassword** As Boolean|〇|ブックに読み取りパスワードが設定されているかどうかを表すブール値|
    |Property **HasVBProject** As Boolean|〇|ブックにVBAプロジェクトが含まれるかどうかを表すブール値|
    |Property **IsAddin** As Boolean||ブックがアドインとして実行されているかどうかを表すブール値|
    |Property **Name** As String|〇|ブックを表す文字列|
    |Property **Parent** As Object|〇|親オブジェクト|
    |Property **Password** As String||ブックを開くためのパスワードを表す文字列|
    |Property **Path** As String|〇|ブックが保存されているフォルダパスを表す文字列|
    |Property **ReadOnly** As Boolean|〇|ブックが読み取り専用で開いているかどうかを表すブール値|
    |Property **ReadOnlyRecommended** As Boolean||ブックを開く際に読み取り専用を推奨するかどうかを表すブール値|
    |Property **Saved** As Boolean||ブックが最終保存状態かどうかを表すブール値|
    |Property **Sheets** As Sheets|〇|ブックのすべてのシートを表す Sheets コレクション|
    |Property **Worksheets** As Sheets|〇|ブックのすべてのワークシートを表す Sheets コレクション|
- Workbook クラスの主なメソッド
    |メンバー|説明|
    |---|----|
    |Sub **Activate**()|ブックに関連付けられている最初のウィンドウをアクティブにする|
    |Sub **Close**([*SaveChanges*],[*Filename*],[*RouteWorkbook*]|ブックを閉じる|
    |Sub **ExportAsFixedFormat**(*Type As XIFixedFormatType*,[*Filename*],[*Quality*],[*IncludeDocProperties*],[*IgnorePrintAreas*],[*From*],[*To*],[*OpenAfterPublish*],[*FixedFormatExtClassPtr*],[*Workldentity*])|ブックをPDFまたはXPS形式でエクスポートする|
    |Sub **PrintOut**([*From*],[*To*],[*Copies*],[*Preview*],[*ActivePrinter*],[*PrintToFile*],[*Collate*],[*PrToFileName*],[*IgnorePrintAreas*])|ブックを印刷する|
    |Sub **PrintPreview**([*EnableChanges*])|ブックの印刷プレビューを表示する|
    |Sub **Protect**([*Password*],[*Structure*])|ブックを保護する|
    |Sub **Save**()|ブックを保存する|
    |Sub **SaveAs**([*Filename*],[*FileFormat*],[*Password*],[*WriteResPassword*],[*ReadOnlyRecommended*],[*CreateBackup*],[*AccessMode As XlSaveAsAccessMode = xlNoChange*],[*ConflictResolution*],[*AddToMru*],[*TextCodepage*],[*TextVisualLayout*],[*Local*],[*Workldentity*])|ブックを別ファイルとして保存する|
    |Sub **SaveCopyAs**(*Filename*)|ブックのコピーを保存する|
    |Sub **Unprotect**([*Password*])|ブックの保護を解除する|
- Workbook クラスのメンバー
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With ThisWorkbook
                Debug.Print .Name 'Fuga.xlsm
                Debug.Print .Path '保存されているフォルダパス
                Debug.Print .FullName 'フルパスを含むファイル名

                Debug.Print .HasPassword 'True
                Debug.Print .Password '********

                Debug.Print .ReadOnly 'False
                Debug.Print .ReadOnlyRecommended 'False
                Debug.Print .Saved 'True
                Debug.Print .HasVBProject 'True
            End With
        End Sub
        ~~~
## 11-3-5 シートを取得する
- シートをコレクションとして取得する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With ThisWorkbook
                Debug.Print .Sheets.Count '3
                Debug.Print .Worksheets.Count '2
                Debug.Print .Charts.Count '1
            End With
        End Sub
        ~~~
- Worksheets プロパティと Worksheets コレクション
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With ThisWorkbook
                Debug.Print TypeName(.Worksheets) 'Sheets

                Dim mySheets As Worksheets
                Set mySheets = .Worksheets '実行時エラー「型が一致しません」
            End With
        End Sub
        ~~~
## 11-3-6 ブックを保存する/閉じる
- Workbook クラスの SaveAs メソッドの引数
    |パラメーター|説明|
    |---|---|
    |*FileName*|保存するブックのファイル名|
    |*FileFormat*|ファイルを保存するときに使用するファイル形式を列挙型 XlFileFormat のメンバーから指定する。規定値は既存ファイルの場合は最後に指定したファイル形式、新規ファイルの場合は使用されている Excel のバージョン形式となる|
    |*Password*|ファイルの読み取りパスワードを文字列で指定する|
    |*WriteResPassword*|ファイルの書き込みパスワードを表す文字列を指定する|
    |*ReadOnlyRecommended*|ファイルを開く際に読み取り専用を推奨するメッセージを非表示にするかどうかをブール値で指定する|
    |*CreateBackup*|バックアップファイルを作成するかどうかをブール値で指定する|
    |*Accessmode*|ブックのアクセスモードを列挙型 XlSaveAsAccessMode のメンバーから指定する<br>xlNochange:アクセスモードを変更しない(規定値)<br>xlExclusive:排他モード<br>xlShared:共有モード|
    |*ConflictResolution*|ブックを保存するときの競合の解決方法を列挙型 XlSaveConflictResolution のメンバーから指定する<br>xlUserResolution:競合を解決するためのダイアログ ボックスを表する(規定値)<br>xlLocalSessionChanges:ローカル ユーザーの変更を自動的に受け入れる<br>xlOtherSessionChanges:他のユーザーの変更を自動的に受け入れる|
    |*AddToMru*|ブックを最近使用したファイルの一覧に追加するかどうかをブール値で指定する|
    |*TextCodepage*|使用しない|
    |*TextVisualLayout*|使用しない|
    |*Local*|Excel の言語設定に合わせるかどうかをブール値で指定する。規定値はFalseで、その場合は VBA の言語設定で保存される|
- ブックを保存する/閉じる
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            with ThisWorkbook
                Sheet1.Range("A1").Value = "Hoge"

                .Save

                Dim fileName As String: fileName = "Hoge_" & Format(Date, "yyyymmdd") & ".xlsm"
                .SaveCopyAs fileName

                Application.DisplayAlerts = False
                .SaveAs "Hoge.xlsx", xlWorkbookDefault
                Application.DisplayAlerts = True
                Sheet1.Range("A1").Value = "Fuga"

                .Close SaveChanges:=True, fileName:="Fuga.xlsx"
            End With
        End Sub
        ~~~
## 11-3-7 ブックを印刷する / PDF 出力する
## 11-3-8 ブックを保護する
## 11-3-9 ブックの情報を取得する
## 11-3-10 Workbook オブジェクトから取得できるオブジェクト
## Workbook クラスのイベント
- Workbook クラスの主なイベント
    |メンバー|説明|
    |---|---|
    |Event **Activate**()|ブックがアクティブになったとき|
    |Event **AddinInstall**()|ブックがアドインとして組み込まれたとき|
    |Event **AddinUninstall**()|ドックのアドイン組み込みが解除されたとき|
    |Event **AfterSave**(*Success As Boolean*)|ブックを保存した後<br>引数 *Success* は保存が成功したかどうかを表すブール値|
    |Event **BeforeClose**(*Cancel As Boolean*)|ブックを閉じる前|
    |Event **BeforePrint**(*Cancel As Boolean*)|ブックを印刷する前|
    |Event **BeforeSave**(*SaveAsUI As Boolean*, *Cancel As Boolean*|ブックを保存する前<br>引数 *SaveAsUI* は名前を付けて保存かどうかを表すブール値|
    |Event **Deactivate**()|ブックが非アクティブになったとき|
    |Event **NewSheet**(*Sh As Object*)|ブックに新しいシートを作成したとき|
    |Event **Open**()|ブックを開いたとき|
    |Event **SheetActivate**(*Sh As Object*)|シートがアクティブになったとき|
    |Event **SheetBeforeDelete**(*Sh As Object*)|シートが削除される前|
    |Event **SheetBeforeDoubleClick**(*Sh As Object*, *Target As Range*, *Cancel As Boolean*)|シートがダブルクリックされたとき|
    |Event **SheetBeforeRightClick**(*Sh As Object*, *Target As Range*, *Cancel As Boolean*)|シートが右クリックされたとき|
    |Event **SheetCalculate**(*Sh As Object*)|シートが再計算されたとき|
    |Event **SheetChange**(*Sh As Object*, *Target As Range*)|シートのセルが変更されたとき|
    |Event **SheetDeactivate**(*Sh As Object*)|シートが非アクティブになったとき|
    |Event **SheetFollowHyperlink**(*Sh As Object*, *Target As Hyperlink*)|シートのハイパーリンクをクリックしたとき<br>引数 Hyperlink は対象の Hyperlink オブジェクト|
    |Event **SheetSelectionChange**(*Sh As Object*, *Target As Range*)|シートの選択範囲が変更されたとき|
    |Event **WindowActivate**(*Wn As Window*)|ウィンドウがアクティブになったとき|
    |Event **WindowDeactivate**(*Wn As Window*)|ウィンドウが非アクティブになったとき|
    |Event **WindowResize**(*Wn As Window*)|ウィンドウのサイズを変更したとき|
- Application イベントの引数
    |引数|説明|
    |---|---|
    |*Sh*|イベントの対象の Worksheet オブジェクトまたは Chart オブジェクト|
    |*Target*|イベントの対象の Range オブジェクト|
    |*Win*|イベントの対象の Window オブジェクト|
    |*Cancel*|イベント操作を中止するかどうかを表すブール値|
- Workbook オブジェクトのイベント
    - ブックモジュールThisWorkbook
        ~~~
        Private Sub Workbook_BeforeClose(Cancel As Boolean)
            If Sheet1.Range("A1").Value = "" Then
                MsgBox "ブックを閉じる前にA1セルを入力してください"
                Cancel = True
            End If
        End Sub
        ~~~
# 11-4 シートを操作する Worksheet クラス / Sheets クラス
## 11-4-1 シートを表すコレクションとオブジェクト
- Sheets クラスの主なプロパティ
    |シートの種類|コレクション|オブジェクト|
    |---|---|---|
    |シート|Sheets|-|
    |ワークシート|Worksheets|Worksheet|
    |グラフシート|Charts|Chart|
## 11-4-2 Sheets クラスとは
- Sheets クラスの主なプロパティ
    |メンバー|読み取り専用|説明|
    |---|---|---|
    |Property **Count** As Long|〇|コレクションに含まれるオブジェクトの数|
    |Property **_Default**(*Index*) As Object|〇|既定のメンバー<br>コレクションの要素のうち *Index* で参照される単一のオブジェクト|
    |Property **Item**(*Index*) As Object|〇|コレクションの要素のうち *Index* で参照される単一のオブジェクト|
    |Property **Parent** As Object|〇|親オブジェクト|
    |Property **Visible** As Variant||コレクションを表示するかどうかを表すブール値|
- Sheets クラスの主なメソッド
    |メンバー|説明|
    |---|---|
    |Function **Add**([*Before*], [*After*], [*Count*], [*Type*]) As Object|シートを作成する|
    |Sub **Copy**([*Before*], [*After*])|シートのコレクションをコピーする|
    |Sub **Delete**()|シートのコレクションを削除する|
    |Sub **Move**([*Before*], [*After*])|シートのコレクションを移動する|
    |Sub **PrintOut**([*From*], [*To*], [*Copies*], [*Preview*], [*ActivePrinter*], [*PrintToFile*], [*Collate*], [*PrToFileName*], [*IgnorePrintAreas*])|シートのコレクションを印刷する|
    |Sub **PrintPreview**([*EnableChanges*])|シートのコレクションを印刷プレビューする|
    |Sub **Select**([*Replace*])|シートのコレクションを選択する|
## 11-4-3 シートを参照する
- Sheets コレクションからシートを参照する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With ThisWorkbook
                Debug.Print .Sheets.Item(1).Name 'Sheet1
                Debug.Print .Sheets.[_Default](1).Name 'Sheet1
                Debug.Print .Sheets(1).Name 'Sheet1
                Debug.Print .Sheets(2).Name 'グラフ1

                Debug.Print .Worksheets(1).Name 'Sheet1
                Debug.Print .Charts(1).Name 'グラフ1

                Debug.Print .Sheets("Sheet1").Name 'Sheet1
                Debug.Print .Sheets("グラフ1").Name 'グラフ1

                Debug.Print .Sheets(Array("Sheet1", "グラフ1")).Count '2
                Debug.Print .Sheets(Array(1, 2)).Count '2
            End With
        End Sub
        ~~~
- Sheets コレクションのループ
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With ThisWorkbook
                Dim sh As Object
                For Each sh In .Sheets
                    Debug.Print sh.Name
                Next sh
                Debug.Print

                For Each sh In .Worksheets
                    Debug.Print sh.Name
                Next sh

                Dim i As Long
                For i = 1 To .Sheets.Count
                    Debug.Print i, .Sheets(i).Name
                Next i
            End With
        End Sub
        ~~~
## 11-4-4 シートを追加する
- シートの追加
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With ThisWorkbook.Sheets
                Dim ws As Worksheet: Set ws = .Add
                ws.Name = "Hoge"
                Debug.Print ws.Name 'Hoge

                .Add(After:=.Item(.Count)).Name = "Fuga"
                Debug.Print ActiveSheet.Name 'Fuga
            End With
        End Sub
        ~~~
## 11-4-5 Worksheet クラスとは
- Worksheet クラスの主なプロパティ
    |メンバー|読み取り専用|説明|
    |---|---|---|
    |Property **Cells** As Range|〇|ワークシートのすべてのセルを表す Range オブジェクト|
    |Property **Columns** As Range|〇|ワークシートのすべての列を表す Range オブジェクト|
    |Property **Index** As Long|〇|ワークシートのコレクション内でのインデックス番号(すなわち並び順)|
    |Property **Name** As String||ワークシートのシート名|
    |Property **Next** As Object|〇|次のシートを表すオブジェクト|
    |Property **Parent** As Object|〇|親オブジェクト|
    |Property **Previous** As Object|〇|前のシートを表すオブジェクト|
    |Property **Range**(*Cell1*, [*Cell2*]) As Range|〇|*Cell1* および *Cell2* で指定したセルまたはセル範囲を表す Range オブジェクト|
    |Property **Rows** As Range|〇|ワークシートのすべての行を表す Range オブジェクト|
    |Property **Type** As XlSheetType|〇|シートの種類|
    |Property **UsedRange** As Range|〇|ワークシートの使用されている範囲を表す Range オブジェクト|
    |Property **Visible** As XlSheetVisibility|〇|ワークシートを表示するかどうかを表す列挙型 XlSheetVisibility の値<br>xlSheetVisible:表示する<br>xlSheetHidden:非表示でユーザーが再表示できる<br>xlSheetVeryHidden:非表示でユーザーが再表示できない|
- Worksheet クラスの主なメソッド
    |メンバー|説明|
    |---|---|
    |Sub **Activate**()|ワークシートをアクティブにする|
    |Sub **Calculate**()|ワークシートに対して計算を実行する|
    |Sub **Copy**([*Before*], [*After*])|ワークシートにコピーする|
    |Sub **Delete**()|ワークシートを削除する|
    |Sub **ExportAsFixedFormat**(*Type As XlFixedFormatType*, [*Filename*], [*Quality*], [*IncludeDocProperties*], [*IgnorePrintAreas*], [*From*], [*To*], [*OpenAfterPublish*], [*FixedFormatExtClassPtr*], [*Workldentity*])|ワークシートを PDF または XPS 形式でエクスポートする|
    |Sub **Move**([*Before*], [*After*])|ワークシートを移動する|
    |Sub **Paste**([*Destination*], [*Link*])|ワークシートにクリップボードの内容を貼り付ける|
    |Sub **PasteSpecial**([*Format*], [*Link*], [*DisplayAslcon*], [*IconFileName*], [*IconIndex*], [*IconLabel*], [*NoHTMLFormatting*])|ワークシートにクリップボードの内容を Format で指定した形式で貼り付ける|
    |Sub **PrintOut**([*From*], [*To*], [*Copies*], [*Preview*], [*ActivePrinter*], [*PrintToFile*], [*Cllate*], [*PrToFileName*], [*IgnorePrintAreas*])|ワークシートを印刷する|
    |Sub **PrintPreview**([*EnableChanges*])|ワークシートの印刷プレビューを表示する|
    |Sub **Protect**([*Password*], [*DrawingObjects*], [*Contents*], [*Scenarios*], [*UserInterfaceonly*], [*AllowFormattingCells*], [*AllowFormattingColumns*], [*AllowFormattingRows*], [*AllowInsertingColumns*], [*AllowInsertingRows*], [*AllowInsertingHyperlinks*], [*AllowDeletingColumns*], [*AllowDeletingRows*], [*AllowSorting*], [*AllowFiltering*], [*AllowUsingPivotTables*])|ワークシートを保護する|
    |Sub **SaveAs**(*Filename As String*, [*FileFormat*], [*Password*], [*WriteResPassword*], [*ReadOnlyRecommended*], [*CreateBackup*], [*AddToMru*], [*TextCodepage*], [*TextVisualLayout*], [*Local*])|ワークシートを別のファイルに保存する|
    |Sub **Select**[(*Replace*)]|ワークシートを選択する|
    |Sub **Unprotect**([*Password*])|ワークシートの保護を解除する|
- Worksheet クラスのメンバー
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                Debug.Print .Name 'Sheet1
                Debug.Print .Index '2
                Debug.Print .Type '-4167: xlWorksheet
                Debug.Print .Visible '-1: xlSheetVisible

                Debug.Print .Parent.Name 'Book1
                Debug.Print .Next.Name 'Fuga
                Debug.Print .Previous.Name 'Hoge
            End With
        End Sub
        ~~~
## 11-4-6 ワークシートからセル範囲を取得する
- Range プロパティによるセル範囲の取得
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                Debug.Print .Range("A1").Address '$A$1
                Debug.Print .Range("A1:E3").Address '$A$1:$E$3
                Debug.Print .Range("A1,E3").Address '$A$1,$E$3
                'Debug.Print .Range("A1 E3").Address '実行時エラー

                Debug.Print .Range("A1:E3, C3:D5").Address '$A$1:$E$3,$C$3:$D$5
                Debug.Print .Range("A1:E3 C3:D5").Address '$C$3:$D$3

                Debug.Print .Range("A:B").Address '$A:$B
                Debug.Print .Range("1:2").Address '$1:$2

                Debug.Print .Range("Hoge").Address '$B$2
                Debug.Print .Range("Fuga").Address '$D$4:$F$6

                Debug.Print .Range("A1", "E3").Address '$A$1:$E$3
                Debug.Print .Range(.Range("A1"), .Range("E3")).Address '$A$1:$E$3
            End With
        End Sub
        ~~~
## 11-4-7 ワークシートから全体のセル範囲を取得する
- Cells プロパティ / Rows プロパティ / Columns プロパティ
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                Debug.Print .Cells.Address '$1:$1048576
                Debug.Print .Cells.CountLarge '1719869184
                Debug.Print .Cells(1).Address '$A$1
                Debug.Print .Cells(1, 1).Address '$A$1

                Debug.Print .Rows.Address '$1:$1048576
                Debug.Print .Rows.CountLarge '1048576
                Debug.Print .Rows(1).Address '$1:$1
                'Debug.Print .Rows(1, 1).Address '※実行時エラー

                Debug.Print .Columns.Address '$1:$1048576
                Debug.Print .Columns.CountLarge '16384
                Debug.Print .Columns(1).Address '$A:$A
                'Debug.print .Columns(1, 1).Address '※実行時エラー
            End With
        End Sub
        ~~~
- 3タイプの Range オブジェクト
    |内容|.Cells|.Rows|.Columns|
    |---|---|---|---|
    |範囲|全て|全て|全て|
    |要素数|セル数|行数|列数|
    |(1)|A1セル|1行目|1列目|
    |(1, 1)|A1セル|(実行時エラー)|(実行時エラー)|
## 11-4-8 ワークシートをアクティブにする / 選択する
- Active メソッドと Select メソッド
    ~~~
    Sheet1.Select 'Sheet1を選択
    Sheet2.Select Replace:=False 'Sheet2も選択
    Sheet3.Activate 'Sheet3をアクティブ→Sheet1、Sheet2の選択が解除
    Sheet2.Select Replace:=False 'Sheet2も選択
    ~~~
- 複数シートの選択
    ~~~
    ThisWorkbook.Sheets.Select '全てのシートを選択
    Sheet3.Activate 'Sheet3をアクティブ→他のシートの選択解除
    ThisWorkbook.Sheets(Array(1, 2)).Select 'Sheet1, Sheet2を選択
    ~~~
## 11-4-9 ワークシートをコピーする / 移動する / 削除する
- Copy メソッド / Move メソッド / Delete メソッド
    ~~~
    Sheet1.Copy After:=ThisWorkbook.Sheets(ThisWorkbook.Sheets.Count) 'Sheet1をコピーする
    ActiveSheet.Move Before:=Sheet1 '新しいシートが移動する
    Sheet1.Delete 'Sheet1を削除する
    ~~~
## 11-4-10 ワークシートを保護する
## 11-4-11 Worksheet オブジェクトから取得できるオブジェクト
## 11-4-12 Worksheet クラスのイベント
- Worksheet クラスの主なイベント
    |メンバー|説明|
    |---|---|
    |Event **Activate**()|シートがアクティブになったとき|
    |Event **BeforeDelete**()|シートが削除される前|
    |Event **BeforeDoubleClick**(*Target As Range*, *Cancel As Boolean*)|シートがダブルクリックされたとき|
    |Event **BeforeRightClick**(*Target As Range*, *Cancel As Boolean*)|シートが右クリックされたとき|
    |Event **Calculate**()|シートが再計算されたとき|
    |Event **Change**(*Target As Range*)|シートのセルが変更されたとき|
    |Event **Deactivate**()|シートが非アクティブになったとき|
    |Event **FollowHyperlink**(*Target As Hyperlink*)|シートのハイパーリンクをクリックしたとき引数 *Hyperlink* は対象の Hyperlink オブジェクト|
    |Event **SelectionChange**(*Target As Range*)|シートの選択範囲が変更されたとき|
- Worksheet オブジェクトのイベント
    - シートモジュールSheet1
        ~~~
        Private Sub Worksheet_Change(ByVal Target As Range)
            If Not Intersect(Target, Range("A1:C3")) Is Nothing Then
                MsgBox("指定のセル範囲の値が変更されました")
            End If
        End Sub
        ~~~
# 11-5 セル範囲を操作する Range クラス
## 11-5-1 Range クラスとは
- Range クラスの主なプロパティ
- Range クラスの主なメソッド
- Range クラスのメンバー
## 11-5-2 セル範囲のアドレスを取得する
- Range クラスの Address プロパティの引数
- Address プロパティ
## 11-5-3 セル範囲からセル範囲を取得する
- セル範囲のタイプ別要素数
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1.Range("A1:C2")
                Debug.Print .Cells.Count '6
                Debug.Print .Rows.Count '2
                Debug.Print .Columns.Count '3
            End With
        End Sub
        ~~~
- セル範囲のタイプ別ループ処理
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim r As Range
            With Sheet1.Range("A1:C2")
                For Each r In .Cells
                    Debug.Print r.Address(False, False); " "; 'A1 B1 C1 A2 B2 C2
                Next r
                Debug.Print

                For Each r In .Rows
                    Debug.Print r.Address(False, False); " "; 'A1:C1 A2:C2
                Next r
                Debug.Print

                For Each r In .Columns
                    Debug.Print r.Address(False, False); " "; 'A1:A2 B1:B2 C1:C2
                Next r
                Debug.Print
            End With
        End Sub
        ~~~
## 11-5-4 セル範囲から要素を取得する
- セル、行範囲、列範囲を参照する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                Debug.Print .Cells(2, 2).Address '$B$2
                Debug.Print .Row(2).Address '$2:$2
                Debug.Print .Columns(2).Address '$B:$B
            End With
        End Sub
        ~~~
- 範囲外のセル、行範囲、列範囲のアクセスする
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1.Range("A1:C2")
            Debug.Print .Cells(7).Address '$A$3
            Debug.Print .Cells(3, 4).Address '$D$3
            Debug.Print .Rows(3).Address '$A$3:$C$3
            Debug.Print .Columns(4).Address '$D$1:$D$2
        End Sub
        ~~~
## 11-5-5 セル範囲の領域を取得する
- Areas プロパティと Areas コレクション
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1.Range("A1:B2, D1:F3")
                Debug.Print .Areas.Count '2
                Debug.Print .Areas(1).Address '$A$1:$B$2
                Debug.Print .Areas(2).Address '$D$1:$F$3
                Debug.Print .Areas.Parent.Address '$A$1:$B$2, $D$1:$F$3

                Dim r As Range
                For Each r In .Areas
                    Debug.Print r.Address, '$A$1:$B$2 $D$1:$F$3
                Next r
            End With
        End Sub
        ~~~
## 11-5-6 さまざまなセル範囲の参照
- 列挙型 XlDirection のメンバー
    |メンバー|値|説明|ショートカットキー|
    |---|---|---|---|
    |xlUp|-4162|上方向|[Ctrl] + [↑]|
    |xlDown|-4121|下方向|[Ctrl] + [↓]|
    |xlToLeft|-4159|左方向|[Ctrl] + [←]|
    |xlToRight|-4161|右方向|[Ctrl] + [→]|
- 表の最終行の行番号 / 最終列の列番号を求める
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1.Range("B2:D5")
                Debug.Print .Offset(2, 1).Address '$C$4:$E$7
                Debug.Print .Offset(0, -1).Address '$A$2:$C$5
                Debug.Print .Resize(5, 4).Address '$B$2:$E$6
                Debug.Print .Resize(1).Address '$B$2:$D$2
            End With

            With Sheet1.Range("B2")
                Debug.Print .CurrentRegion.Address '$B$2:$D$5
                Debug.Print .End(xlDown).Address '$B$5
                Debug.Print .End(xlToRight).Address '$D$2
                Debug.Print .EntireRow.Address '$2:$2
                Debug.Print .EntireColumn.Address '$B:$B
            End With
        End Sub
        ~~~
- 列挙型 XlCellType
    |メンバー|値|説明|
    |---|---|---|
    |xlCellTypeAllFormatConditions|-4172|条件付き書式が設定されているセル|
    |xlCellTypeAllValidation|-4174|入力規則が設定されているセル|
    |xlCellTypeBlandks|4|空白セル|
    |xlCellTypeComments|-4144|メモが含まれているセル|
    |xlCellTypeFormulas|11|使用されているセル範囲内の最後のセル|
    |xlCellTypeSameFormatConditions|-4173|同じ条件付き書式が設定されているセル|
    |xlCellTypeSameValidation|-4175|同じ入力規則が設定されているセル|
    |xlCellTypeVisible|12|すべての可視セル|
- 列挙型 XlSpecialCellValue のメンバー
    |メンバー|値|説明|
    |---|---|---|
    |xlErrors|16|エラーのあるセル|
    |xlLogical|4|論理値のあるセル|
    |xlNumbers|1|数値のあるセル|
    |xlTextValues|2|文字列のあるセル|
- SpecialCells メソッドによるセル範囲の参照
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1.Range("B2").CurrentRegion
                Debug.Print .SpecialCells(xlCellTypeBlanks).Address '$D$4,$C$5:$D$5
                Debug.Print .SpecialCells(xlCellTypeLastCell).Address '$D$5
                Debug.Print .SpecialCells(xlCellTypeBlanks).Address '$$:$$
                Debug.Print .SpecialCells(xlCellTypeConstants).Address '$D$2:$D$3,$C$2:$C$4,$B$2:$B$5
                Debug.Print .SpecialCells(xlCellTypeConstants, xlNumbers).Address '$C$3:$C$4
            End With
        End Sub
        ~~~
## 11-5-7 セルの値を取得する / 設定する
- Value プロパティによる値の設定
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim v As Variant
            With Sheet1
                v = .Range("B3").Value
                Debug.Print v 'Bob
                .Range("B7").Value = v

                v = .Range("B2:D5").Value
                Stop
                .Range("F2").Resize(UBound(v), UBound(v, 2)).Value = v
            End With
        End Sub
        ~~~
## セルの数式を取得する / 設定する
- Formula プロパティ・FormulaR1C1 プロパティ
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim v As Variant
            With Sheet1
                Debug.Print .Range("E3").Fromula '=IF(D3="apple", TRUE)
                Debug.Print .Range("E3").FromulaR1C1 '=IF(RC[-1]="apple", TRUE)

                v = .Range("E3:E5").Formula
                Stop

                .Range("F3:F5").FormulaR1C1 = "=DATEDIF(RC[-3], TODAY(), ""Y"")"
            End With
        End Sub
        ~~~
## 11-5-9 セル範囲を編集する
- Copy メソッドと Cut メソッド
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                .Range("B2:B5").Copy .Range("F2")
                .Range("B7:D10").Cut .Range("F7")
            End With
        End Sub
        ~~~
- 列挙型 XlPasteType のメンバー
    |メンバー|値|説明|
    |---|---|---|
    |xlPasteAll|-4104|すべて (規定値)|
    |xlPasteFormulas|-4123|数式|
    |xlPasteValues|-4163|値|
    |xlPasteFormats|-4122|書式|
    |xlPasteComments|-4144|メモ|
    |xlPasteValidation|6|入力規則|
    |xlPasteAllUsingSourceTheme|13|コピー元のテーマを使用してすべて貼り付け|
    |xlPasteAllExceptBorders|7|罫線を除くすべて|
    |xlPasteColumnWidths|8|列幅|
    |xlPasteFormulasAndNumberFormats|11|数式と数値の書式|
    |xlPasteValuesAndNumberFormats|12|値と数値の書式|
    |xlPasteAllMergingConditionalFormats|14|すべての統合されている条件付き書式|
- 列挙型 XlPasteSpecialOperation のメンバー
    |メンバー|値|説明|
    |---|---|---|
    |xlPasteSpecialOperationNone|-4142|演算をしない (規定値)|
    |xlPasteSpecialOperationAdd|2|加算|
    |xlPasteSpecialOperation|3|減算|
    |xlPasteSpecialOperation|4|乗算|
    |xlPasteSpecialOperation|5|除算|
- PasteSpecial メソッド
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                .Range("B2:D5").Copy
                .Range("F2").PasteSpecial xlPasteFormats
                .Range("F7").PasteSpecial xlPasteValues, Transpose:=True
            End With
        End Sub
        ~~~
## 11-5-10 セル範囲をクリアする
- Clear メソッド / ClearContents メソッド / ClearFormats メソッド
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                .Range("B2:D5").Clear
                .Range("F2:H5").ClearContents
                .Range("J2:L5").ClearFormats
            End With
        End Sub
        ~~~
- ワークシート全体をクリアする
    ~~~
    Sheet1.Cells.Clear
    ~~~
## 11-5-11 セル範囲を挿入 / 削除する
- 列挙型 XlInsertShiftDirection のメンバー
    |メンバー|値|説明|
    |---|---|---|
    |xlShiftDown|-4121|下方向にシフトする|
    |xlShiftToRight|-4161|右方向にシフトする|
- 列挙型 XlInsertFormatOrigin のメンバー
    |メンバー|値|説明|
    |---|---|---|
    |xlFormatFromLeftOrAbove|0|隣接した左または↑のセル範囲の書式を適用する (規定値)|
    |xlFormatFromRightOrBelow|1|隣接した右または下のセル範囲の書式を適用する|
- 列挙型 XlDeleteShiftDirection のメンバー
    |メンバー|値|説明|
    |---|---|---|
    |xlShiftToLeft|-4159|左方向にシフトする|
    |xlShiftUp|-4262|上方向にシフトする|
- Insert メソッド / Delete メソッド
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim v As Variat
            With Sheet1
                .Range("B4:D4").Delete
                .Rows("4:5").Insert
                .Columns("D").Insert
            End With
        End Sub
        ~~~
## 11-5-12 セル範囲をソートする
- Sort メソッドの引数
    |パラメーター|説明|
    |---|---|
    |*Key1 ~ Key3*|並び替えの1~3番目のキーとなるフィールドを Range オブジェクトまたはセル範囲を表す文字列で指定する|
    |*Order1 ~ Order3*|Key1 ~ Key3 で指定したフィールドの順序を列挙型XlSortOrder のメンバーから指定する<br>xlAscending:昇順(規定値)<br>xlDescending:降順|
    |*Header*|最初の行をヘッダー行として扱うかどうかを列挙型 XlYesNoGuess のメンバーから指定する<br>xlNo:ヘッダーとして扱わない(規定値)<br>xlYes:ヘッダーとして扱う<br>xlGuess:Excelが自動で判定する|
    |*OrderCustom*|ユーザー設定の並び替え順のリスト内の番号を示す、1から始まる整数を指定する|
    |*MatchCase*|大文字小文字を区別するかどうかを表すブール値を指定する|
    |*Orientation*|並び替えの方法を列挙型 XlSortMethod のメンバーから指定する<br>xlPinYin:ふりがな順で並び替える(規定値)<br>xlStroke:総画数で並び替える|
    |*DataOption1 ~ DataOption3*|*Key1 ~ Key3* で指定したフィールドのテキストを並び替える列挙型 XlSortDataOption のメンバーから指定する<br>xlSortNormal:数値データとテキストデータを個別に並び替える(規定値)<br>xlSortTextAsNumbers:テキストデータを数値データとして並び替える|
- Sort メソッド
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With Sheet1
                .Rnage("B2").CurrentRegion.Sort _
                    Key1:=.Range("D2"), Order1:=xlDescending, _
                    Key2:=.Range("C2"), Order2:=xlAscending, _
                    Header:=xlYes
            End With
        End Sub
        ~~~
## 11-5-13 セルの値を検索する / 置換する
- Find メソッドの引数
    |パラメーター|説明|
    |---|---|
    |*What*|検索する値を指定する|
    |*After*|指定した単一セルを表す Range オブジェクトの後から検索を開始する。省略時は、対象セル範囲の左上隅の後のセルから検索を開始する|
    |||
    |||
    |||
    |||