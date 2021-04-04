# 13-1 ファイルシステムの操作と辞書によるライブラリ
## 13-1-1 Scripting ライブラリとは
## 13-1-2 Scripting ライブラリの構造
## 13-2-2 FileSystemObject オブジェクトの生成と操作
- FileSystemObject クラスのメンバー
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = .BuildPath(ThisWorkbook.Path, "hoge.txt")
                Debug.Print myPath 'C:\Users\ntaka\ファイルシステム\hoge.txt

                Debug.print .DriveExists("C") 'True
                Debug.print .FolderExists("C:\Users\ntaka\ファイルシステム") 'True
                Debug.print .FileExists(myPath) 'True

                Debug.Print .GetAbsolutePathName(myPath) 'C:\Users\ntake\ファイルシステム\hoge.txt

                Debug.Print .GetDriveName(myPath) 'C:
                Debug.Print .GetParentFolderName(myPath) 'C:\Users\ntaka\ファイルシステム
                Debug.Print .GetFileName(myPath) 'hoge.txt
                Debug.Print .GetBaseName(myPath) 'hoge
                Debug.Print .GetExtensionName(myPath) 'txt

                Debug.Print .GetTempName 'rad9C101.tmp
            End With
        End Sub
        ~~~
## 13-2-3 ドライブ / フォルダ / ファイルを取得する
- ドライブ / フォルダ / ファイルを取得する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Debug.Print .Drives.Count '2

                Debug.Print .GetDrive("C:").Path 'C:
                Debug.Print .GetDrive("C").Path 'C:

                Dim myPath As String: myPath = ThisWorkbook.Path
                Debug.Print .GetFolder(myPath).Name 'ファイルシステム
                Debug.Print .GetFolder(".").Name 'Documents
                Debug.Print .GetFolder("..").Name 'ntaka

                Dim fileName As String: fileName = "hoge.txt"
                Debug.Print .GetFile(myPath & "\" & fileName).Name 'hoge.txt
                Debug.Print .GetFile(.BuildPath(myPath, fileName)).Name 'hoge.txt
                Debug.Print .GetFile("..\ファイルシステム\hoge.txt").Name 'hoge.txt)
            End With
        End Sub
        ~~~
# 13-3 ドライブを操作する Driver クラス / Drive クラス
## 13-3-1 Drivers クラスとドライブの参照
- Drives コレクションからドライブを参照する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Debug.Print .Drives.Item("C:").Path 'C:
                Debug.Print .Drives("C").Path 'C:
                Debug.Print .Drives.Count '2

                Dim myDrive As Drive
                For Each myDrive In .Drives
                    Debug.Print myDrive.Path
                Next myDrive
            End With
        End Sub
        ~~~
## 13-3-2 Drive クラスとは
- Drive クラスのメンバー
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                With .GetDrive("C")
                    Debug.Print .DriveLetter 'C
                    Debug.Print .VolumeName 'Windows
                    Debug.Print .Path 'C:

                    Debug.Print .DriveType '2
                    Debug.Print .IsReady 'True
                    Debug.Print .SerialNumber 'シリアルナンバー

                    Debug.Print .TotalSize '254721126400
                    Debug.Print .AvailableSpace '154361606144
                    Debug.Print .FreeSpace '154361606144
                End With
            End With
        End Sub
        ~~~
# 13-4 フォルダを操作する Folders クラス / Folder クラス
## 13-4-1 Folders クラスとは
- Folders コレクションからフォルダを参照する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path
                Dim myFolders As Folders: Set myFolders = .GetFolder(myPath).SubFolders

                Debug.Print myFolders.Item("hoge").Name 'hoge
                Debug.Print myFolders("fuga").Name 'fuga
                Debug.Print myFolders.Count '2

                Dim myFolder As Folder
                For Each myFolder In myFolders
                    Debug.Print myFolder.Name
                Next myFolder
            End With
        End Sub
        ~~~
## 13-4-2 フォルダを作成する
- フォルダを作成する
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path
                Dim myFolders As Folders: Set myFolders = .GetFolder(myPath).SubFolders

                myFolders.Add"piyo"
                .CreateFolder myPath & "\foo"
            End With
        End Sub
        ~~~
## 13-4-3 Folder クラスとは
- Folder クラスのメンバー
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                With .GetFolder("C:\Users\ntaka\ファイルシステム")
                    Debug.Print .Name 'ファイルシステム
                    Debug.Print .Path 'C:\Users\ntaka\ファイルシステム

                    Debug.Print .Drive.Path 'C:
                    Debug.Print .ParentFolder.Path 'C:\Users\ntaka

                    Debug.Print .ShortName 'ファイ~1
                    Debug.Print .ShortPath 'C:\Users\ntaka\ファイ~1

                    Debug.Print .DateCreated '2019/07/02 9:41:38
                    Debug.Print .DateLastAccessed '2019/07/02 11:29:57
                    Debug.Print .DateLastModified '2019/07/02 11:29:57

                    Debug.Print .Attributes '16
                    Debug.Print .IsRootFolder 'False
                    Debug.Print .Size '16532
                    Debug.Print .Type 'ファイル フォルダー
                End With
            End With
        End Sub
        ~~~
## 13-4-4 サブフォルダ / ファイルを取得する
- SubFolders プロパティ / Files プロパティ
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FilesystemObject
                With .GetFolder("C:Users\ntaka\ファイルシステム")
                    Debug.Print .SubFolders.Count '4
                    Debug.Print .Files.Count '3
                End With
                With .GetDrive("C").RootFolder
                    Debug.Print .SubFolders.Count '15
                    Debug.Print .Files.Count '3
                End With
            End With
        End Sub
        ~~~
## 13-4-5 フォルダをコピーする / 移動する / 削除する
- Folder クラスのメソッドによるフォルダのコピー / 移動 / 削除
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myDestination As String
                myDestination = ThisWorkbook.Path & "\コピー移動先\"

                With .GetFolder("C:\Users\ntaka\ファイルシステム")
                    .SubFolders("hoge").Copy myDestination
                    .SubFolders("hoge").Move myDestination
                    .SubFolders("piyo").Delete
                End with
            End With
        End Sub
        ~~~
- FileSystemObject クラスのメソッドによるフォルダのコピー / 移動 / 削除
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path
                Dim myDestination As String: myDestination = myPath & "\コピー移動先\"

                .CopyFolder myPath & "\hoge", myDestination
                .CopyFolder myPath & "\f*", myDestination
                .DeleteFolder myPath & "\piyo"
            End With
        End Sub
        ~~~
## 13-4-6 テキストファイルを作成する
- テキストファイルをの作成
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path

                .GetFolder(myPath).CreateTextFile "hoge.txt"
                .CreateTextFile myPath & "\fuga.txt"
            End With
        End Sub
        ~~~
# 13-5 ファイルを操作する Files クラス / File クラス
## Files クラスとは
- Files コレクションからファイルを参照する
    - 標準モジュールMobule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path
                Dim myFiles As Files: Set myFiles = .GetFolder(myPath).Files

                Debug.Print myFiles.Item("hoge.txt").Name 'hoge.txt
                Debug.Print myFiles("fuga.txt").Name 'fuga.txt
                Debug.Print myFiles.Count '4

                Dim myFile As File
                For Each myFile In myFiles
                    Debug.Print myFile.Name
                Next myFile
            End With
        End Sub
        ~~~
## 13-5-2 File クラスとは
- File クラスのメンバー
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                With .GetFile("C:\Users\ntaka\ファイルシステム\hoge.txt")
                    Debug.Print .Name 'hoge.txt
                    Debug.Print .Path 'C:\Users\ntaka\ファイルシステム\hoge.txt

                    Debug.Print .Drive.Path 'C:
                    Debug.Print .ParentFolder.Path 'C:\Users\ntaka\ファイルシステム

                    Debug.Print .ShortName 'hoge.txt
                    Debug.Print .ShortPath 'C:\Users\ntaka\ファイ~1\hoge.txt

                    Debug.Print .DateCreated '2019/07/02 10:27:46
                    Debug.Print .DateLastAccessed '2019/07/02 10:29:53
                    Debug.Print .DateLastModified '2019/07/02 10:29:53

                    Debug.Print .Attributes '32
                    Debug.print .Size '0
                    Debug.Print .Type 'テキスト ドキュメント
                End With
            End With
        End Sub
        ~~~
## 13-5-3 ファイルの属性
- ファイル / フォルダの属性
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myAttributes As Long
                Dim myPath As String: myPath = ThisWorkbook.Path

                With .GetFolder(myPath)
                    Debug.Print .Name, .Attributes,
                    If .Attributes And Directory Then
                        Debug.Print "フォルダです"
                    Else
                        Debug.print "フォルダではありません"
                    End If
                End With
            End With

            With .GetFile(myPath & "\hoge.txt")
                Debug.Print .Name, .Attributes,
                If .Attributes And Readonly Then
                    Debug.Print "読み取り専用ですので解除します"
                    .Attributes = .Attributes Xor ReadOnly
                Else
                    Debug.Print "読み取り専用ではありませんので設定します"
                    .Attributes = .Attributes Or ReadOnly
                Enf If
            End With
        End Sub
        ~~~
## 13-5-4 ファイルをコピーする / 移動する / 削除する
- File クラスのメソッドによるファイルのコピー / 移動 / 削除
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myDestination As String
                myDestination = ThisWorkbook.Path & "\コピー移動先\"

                With .GetFolder("C:\Users\ntaka\ファイルシステム")
                    .Files("hoge.txt").Copy myDestination
                    .Files("fuga.txt").Move myDestination
                    .Files("piyo.txt").Delete
                End With
            End With
        End Sub
        ~~~
- FileSystemObject クラスのメソッドによるファイルのコピー / 移動 / 削除
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path
                Dim myDestination As String: myDestination = myPath & "\コピー移動先\

                .CopyFile myPath & "\hoge.txt", myDestination
                .MoveFile myPath & "\f*.txt", myDestination
                .DeleteFile myPath & "\piyo.txt"
            End With
        End Sub
        ~~~
## 13-5-5 テキストファイルを開く
- テキストファイルを開く
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path & "\hoge.txt"

                With .GetFile(myPath).OpenAsTextStream
                    Debug.Print .ReadLine 'Hello TextStream!
                    .Close
                End With

                With .OpenTextFile(myPath)
                    Debug.Print .ReadLine 'Hello TextStream!
                    .Close
                End With
            End With
        End Sub
        ~~~
# 13-6 テキストファイルを操作する TextStream クラス
## 13-6-1 TextStream クラスとは
- TextStream クラスのメンバー
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path & "\hoge.txt"
                With .OpenTextFile(myPath)
                    Debug.Print .AtEndOfLine 'False
                    Debug.Print .AtEndOfStream 'False
                    Debug.Print .Line '1
                    Debug.Print .Column '1

                    Debug.Print .ReadAll
                    Debug.Print .AtEndOfLine 'True
                    Debug.Print .AtEndOfStream 'True
                    Debug.Print .Line '2
                    Debug.Print .Column '26

                    .Close
                End With
            End With
        End Sub
        ~~~
## 13-6-2 テキストファイルから読み込む    
- テキストファイルからの読み込み
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path & "\hoge.txt"
                Debug.Print .Read(5) 'Hello
                Debug.Print .ReadLine 'TextStream!
                Debug.Print .ReadAll 'これはTextStreamオブジェクトのテストです
                .Close
            End With
        End Sub
        ~~~
- ReadLine メソッドによる行単位の読み込み
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path & "\hoge.txt"
                With .OpenTextFile(myPath)
                    Do Wile Not .AtEndOfStrem
                        Debug.Print .line, .ReadLine
                    Loop

                    .Close
                End With
            End With
        End Sub
        ~~~
- ReadAll メソッドによる全体の読み込み
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path & "\hoge.txt"
                With .OpenTextFile(myPath)
                    Dim values As Variant: values = Split(.ReadAll, vbCrLf)
                    Stop

                    .Close
                End With
            End With
        End Sub
        ~~~
## 13-6-3 テキストファイルに書き込む
- テキストファイルへの書き込み
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            With New FileSystemObject
                Dim myPath As String: myPath = ThisWorkbook.Path & "\fuga.txt"

                With .CreateTextFile(myPath)
                    .Write "Hello"
                    .Write "TextStream!"
                    .WriteLine
                    .WriteLine "テキストファイルへの書き込みです"
                    .Close
                End With

                With .OpenTextFile(myPath, ForAppending)
                    .WriteLine "テキストファイルへの追加書き込みです"
                    .Close
                End With
            End With
        End Sub
        ~~~
# 辞書を操作する Dictionary クラス
## 13-7-2 辞書の生成と操作
- 辞書の生成と操作
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim members As Dictionary: Set members = New Dictionary

            With members
                .Add "m01, "Bob"
                .Add "m02, "Tom"

                Debug.Print .Count '2
                Debug.print .Item("m01") 'Bob

                If .Exists("m01") Then .Remove "m01"
            End With

            members("m02") = "Tim"
            Debug.Print members("m02") 'Tim

            Stop
        End Sub
        ~~~
- 辞書で存在しないキーを参照する
    - 標準モジュールMOdule1
        ~~~
        Sub MySub()
            Dim members As Dictionary: Set members = New Dictionary

            members("m01") = "Bob"
            Debug.Print members("m01") 'Bob
            Debug.Print members("m02") '

            Stop
        End Sub
        ~~~
## 13-7-3 辞書のループ処理
- For Each~Next ステートメントによる辞書のループ
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim members As Dictionary: Set members = New Dictionary

            With members
                .Add "m01", "Bob"
                .Add "m02", "Tom"
                .Add "m03", "Ivy"
            End With

            Dim myKey As Variant
            For Each myKey In members
                Debug.Print myKey, members(myKey)
            Next myKey
        End Sub
        ~~~
- Keys メソッドと Item メソッドを使用した辞書のループ
    - 標準モジュールModule1
        ~~~
        Sub MySub()
            Dim members As Dictionary: Set members = New Dictionary
            With members
                .Add "m01", "Bob"
                .Add "m02", "Tom"
                .Add "m03", "Ivy"

                Dim iAs Long
                Dim myItems As Variant: myItems = .Items
                For i = LBound(myItems) To UBound(myItems)
                    Debug.Print i, myKeys(i), .Item(myKeys(i))
                Next i
            End With
        End Sub
        ~~~