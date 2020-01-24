## 移動系
- gg：先頭
- G：最終
-  w/b：単語単位
- ^：行頭
- $：行末
- f：文字まで移動、；で次に移動
- %：対応するかっこに移動
- CTRL+f / b：画面単位で移動
## 選択系
- v：文字単位
- V：行単位
- CTRL+v：矩形単位
- gg V G：全選択
## 編集系
- x：削除
- dd：行削除
- yy：行コピー
- p：貼付け
## 検索系
- /：検索
- n：検索単語を下方向に検索
- N：検索単語を上方向に検索
- *：今カーソルがある位置の単語を下方向に検索
- #：今カーソルがある位置の単語を下方向に検索
##置換系
- s/abc/ABC：その行の最初の一致した単語を置換
- s/abc/ABC/g：その行の全ての一致した単語を置換
- %s/abc/ABC/g：全体から一致した単語を置換
## その他
- u：undo
- CTRL+r：redo
- .：直前の操作を繰り返す
- gg V G =：全体のインデントを揃える
- CTRL+n：補完
## ウインドウの分割
- sp：ウィンドウの横分割
- vp：ウィンドウの縦分割
- CTRL+w+w：ウィンドウの移動
- close：ウィンドウの閉じる
## タブの操作
- tabnew：新しいタブを開く
- tabe file.txt：新しいタブでファイルを開く
- gt：次のタブへ移動
- tabclose：タブを閉じる
- vi -p file.txt file.txt：複数のファイルを同時に開く
- tabdo %s/abc/ABC\g：全てのタブの全体から一致した単語を置換
## テキストオブジェクト操作
- c / d / y：chenge / delete / insert
- i / a：inner / all
- t / “ / ) / ]：
> Written with [StackEdit](https://stackedit.io/).