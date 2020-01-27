# HTML
## Block-level Elements
ブロックレベル要素は、見出し・段落・表など、文書を構成する基本となる要素で、一つのブロック（かたまり）として認識されます。 ブラウザでの表示も一つのかたまりとして扱われることが多く、一般的なブラウザでは前後に改行が入ります。
## Inline Elements
インライン要素は、主にブロックレベル要素の内容として用いられる要素で、文章の一部として扱われます。 例えば、p要素の中のstrong要素のように、段落のなかの一部を強調するような使われ方をする要素です。 一般的なブラウザでは前後に改行が入らず、文章の一部として表示されます。
## Basic
~~~html
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="utf-8">
		<title>title</title>
		<link rel="stylesheet" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
		<link rel="stylesheet" href="css/main.css"/>
	</head>
	<body>
		<header>
		</header>
		<main>
		</main>
		<footer>
		</footer>
	</body>
</html>
~~~
## Lorem ipsum
~~~html
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
~~~
## Table
~~~html
<table border="1">
	<tr><th>th1</th><th>th2</th><th>th3</th></tr>
	<tr><td>td1</td><td>td2</td><td>td3</td></tr>
</table>
~~~
## Ordered List
~~~html
<ol>
	<li>JavaScript</li>
	<li>Java</li>
	<li>C#</li>
	<li>PHP</li>
	<li>Python</li>
</ol>
~~~
> olの代わりにul(Unordered List)を使うと番号なしのリストを作成できる
## Image
~~~html
<div class="box">
	<img src="images/[file name].jpg">
</div>
~~~
## スマホ最適化
~~~html
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
~~~
> スマホで表示したときに縮小されてしまうのを防ぐ設定。
## form
~~~html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>はじめてのフォーム</title>
	</head>
	<body>
		<form action="" method="post">
			<div>お名前:<input type="text" name="username" value="" /></div>
			<div>年齢:<input type="number" name="age" value="20" /></div>
			<div>
				性別:
				<input type="radio" name="sex" value="man"/>男
				<input type="radio" name="sex" value="woman"/>女
			</div>
			<div>
				趣味:
				<input type="checkbox" name="hobby" value="camera"/>カメラ
				<input type="checkbox" name="hobby" value="movie"/>映画
				<input type="checkbox" name="hobby" value="cooking"/>料理
			</div>
			<div>コメント:</div>
			<div>
				<textarea name="commit" rows="5" cols="40">コメントを入れてください。</textarea>
			</div>
			<div><input type="submit" value="送信"/></div>
		</form>
	</body>
</html>
~~~
# CSS
## 中央寄せ
~~~html
container{
  margin:0 auto;
}
~~~
> ブロック要素を親要素に対して、上下0左右をautoで左右中央寄せにしてくれる設定
## relativeで絶対配置
~~~html
<header>
	<h1>Hello Responsive Web Design!</h1>
</header>
~~~
~~~html
header{
	position:relative;
	padding-top:34%;
}
header h1{
	position: absolute;
	top:0;
	right:0;
	width:100%;
	height:100%;
	background-image:url(../images/[file name].png);
	background-size:cover;
	box-sizing: border-box;
	padding:10%;
	font-size:3.5vw;
}
~~~
> 親要素をrelative,子要素にabsoluteを指定  
> padding-top 34%に対して子要素でwidth,height:100%とすることで同じ領域を確保する  
> backrournd-size:coverとすることで、背景画像で領域を埋める  
> box-sizing:border-box;とすることでpaddingやborderを設定しても要素自体が大きくならない  
> font-size:3.5vw;画面幅に対して文字サイズを変更する(設定は%)  
## 参考
[Webサイト制作-1日目(html)](https://joytas.net/programming/website/website01).  
[Webサイト制作(レイアウト)](https://joytas.net/programming/website/layout).(1カラム,2カラム)  
[Joytas.net/Webサイト制作-5日目(レスポンシブ)](https://joytas.net/programming/website/website05).  
[Joytas.net/Webサイト制作-6日目(form)](https://joytas.net/programming/website/website06).  
[MDN web docs](https://developer.mozilla.org/ja/).  
[Can I use](https://caniuse.com/).  
[HTML特殊文字コード表](http://www.shurey.com/js/labo/character.html).
