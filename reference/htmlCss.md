# HTML
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
# CSS
## relativeで絶対配置
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
  color:#345;
}
~~~
> 親要素をrelative,子要素にabsoluteを指定  
> padding-top 34%に対して子要素でwidth,height:100%とすることで同じ領域を確保する  
> backrournd-size:coverとすることで、その画像で領域を埋める  
> box-sizing:border-box;とすることでpaddingやborderを設定しても要素自体が大きくならない  
> font-size:3.5vw;画面幅に対して文字サイズを変更する(設定は%)  
main h2{
  background: #345;
  color:white;
  text-align: center;
  font-size:3vw;
  padding:5px 0;
}
.imgFull{
  display: block;
  width:100%;
}
.youtubeContainer{
  position: relative;
  width:80%;
  padding-top:45%;
  margin:2vh auto;
}
.youtubeContainer iframe{
  position: absolute;
  top:0;
  right:0;
  width:100% !important;
  height:100% !important;
}

#floatItems img{
  display: block;
  width:50%;
border:1px solid #333;
  box-sizing: border-box;
  float:left;
}
footer{
  text-align: right;
  padding-right:10px;
  color:#345;
}
/*1200px以上で適用*/
@media screen and (min-width:1200px){
  header h1{
    font-size:3vw;
  }
}
/*600px以下で適用*/
@media screen and (max-width:600px){
  header h1{
    font-size:4vw;
  }
  main h2{
    font-size:3.5vw;
  }
}

/*480px以下で適用*/
@media screen and (max-width:480px){
  #floatItems img{

  width:100%;

 }
}


## 参考
[HTML特殊文字コード表](http://www.shurey.com/js/labo/character.html).
