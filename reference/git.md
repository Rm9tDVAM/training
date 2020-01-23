# GitHub Command
1. ファイル更新したら
	1. `git add .` or `git add [file name]`
		-	Stageに上げる
	2. `git commit -m"[comment]"`
		- Stageに上げた内容をCommitとして保存
	3. `git checkout master`
		- master branchに移動する
	4. `git merge [branch name]`
		- branchをmasterに統合する
	5. `git push`
		- ローカルリポジトリをリモートに反映する
2. branch操作
	- `git branch`
		- branch一覧の表示
	- `git branch -d [branch name]`
		- branch削除
	- `git branch -b [branch name] branch [branch name]`
		- branchを作成して移動
	- `git checkout [branch name]`
		- branchを移動する
3. status確認など
	- `git status`
		- ステータスの表示
	- `git diff`
		- 差分の表示
	- `git graph`
		- commit履歴の表示
	- `git reflog`
		- commit履歴の表示
1. Git管理を始めるには
	- `git clone [url]`
		- リモートからローカルにダウンロードする
	- `git init`
		- ローカルリポジトリを作成する
## 参考
[図解Git](https://marklodato.github.io/visual-git-guide/index-ja.html).
- コミットオブジェクトは実際にはgit initしたディレクトリ以下の**スナップショット**
- gitコマンドの中にはコミットオブジェクトを差分っぽく扱うものがあるが、実際には対象コミットオブジェクトとその直前のコミットオブジェクトの**差分を見ている**
> Written with [StackEdit](httpsgit://stackedit.io/).
