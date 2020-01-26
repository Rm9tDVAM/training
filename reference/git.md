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
1. GitHubのversion管理から特定のファイルを外すには.gitignoreに記述する
	- \*.class
	> initしたルートなどに置くことで、*.classを管理対象から外すことができる
## 参考
[Joytas.net/Git](https://joytas.net/programming/git/git-1).  
[Joytas.net/GitHubとの連携1](https://joytas.net/programming/git/github1).  
[Joytas.net/GitHubとの連携2](https://joytas.net/programming/git/github2).  
[Joytas.net/Git(基本操作)](https://joytas.net/programming/git/basic).  
[Joytas.net/Git(基本操作2)](https://joytas.net/programming/git/basic2).  
[図解Git](https://marklodato.github.io/visual-git-guide/index-ja.html).  
[GitHubを利用している企業](https://www.wantedly.com/tools/github/companies).
- コミットオブジェクトは実際にはgit initしたディレクトリ以下の**スナップショット**
- gitコマンドの中にはコミットオブジェクトを差分っぽく扱うものがあるが、実際には対象コミットオブジェクトとその直前のコミットオブジェクトの**差分を見ている**
