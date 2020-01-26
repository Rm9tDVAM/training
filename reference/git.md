# GitHub Command
1. ファイル更新したら
	1. `git add .` or `git add [file name]`
		-	Stageに上げる
	2. `git commit -m"[comment]"`
		- Stageに上げた内容をCommitとして保存
			- 間違えた場合は`git --amend`して削除する
	3. `git checkout master`
		- master branchに移動する
	4. `git merge [branch name]`
		- branchをmasterに統合する
	5. `git push`
		- ローカルリポジトリをリモートに反映する
1. branch操作
	- `git branch`
		- branch一覧の表示
	- `git branch -d [branch name]`
		- branch削除
	- `git branch -b [branch name] branch [branch name]`
		- branchを作成して移動
	- `git checkout [branch name]`
		- branchを移動する
1. status確認など
	- `git status`
		- ステータスの表示
	- `git diff`
		- 差分の表示
	- `git diff HEAD`
		- 差分の表示
			> 今回commitした変更点が見れる
	- `git graph`
		- commit履歴の表示
			> :が表示される場合はリターンキーで1行、スペースキーで複数行表示する
			>> (end)が表示される場合は**q**で抜ける
	- `git reflog`
		- commit履歴の表示
1. Git管理を始めるには
	- `git clone [url]`
		- リモートからローカルにダウンロードする
			> GitHub上でforkして自分のリポジトリに持ってきてからCloneする場合もある
			>> forkして開発した場合は、fork元にpullrequestして問題なければmargしてもらう
	- `git init`
		- ローカルリポジトリを作成する
## 参考
[図解Git](https://marklodato.github.io/visual-git-guide/index-ja.html).
- コミットオブジェクトは実際にはgit initしたディレクトリ以下の**スナップショット**
- gitコマンドの中にはコミットオブジェクトを差分っぽく扱うものがあるが、実際には対象コミットオブジェクトとその直前のコミットオブジェクトの**差分を見ている**
