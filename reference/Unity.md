# Unity
## 画面構成
1. Scene(シーン)ビュー
    - シーンの編集を行う基本的なビュー
1. Game(ゲーム)ビュー
    - ゲームのプレビューを表示
1. Hierarchy(ヒエラルキー)ビュー
    - 現在のシーンにあるオブジェクトを一覧形式で表示
1. Project(プロジェクト)ビュー
    - プロジェクトにインポートされているアセットの一覧を表示
1. Console(コンソール)ビュー
    - Unityが出力するエラーやワーニング、デバッグ情報を表示
1. Inspector(インスペクタ)ビュー
    - 現在選択されているオブジェクトの詳細な情報を表示
1. Preview(プレビュー)パネル
    - ゲームのプレビュー制御を行う
1. Tool(ツール)パネル
    - Sceneビュー上に存在するオブジェクトの操作方法を切り替えることができる
1. Layer(レイヤー)メニュー
    - 表示レイヤーを切り替える
1. Layout(レイアウト)メニュー
    - Unityエディターのビューレイアウトを変更する
    - 1画面で作業する場合はTall
## 基本操作
1. Toolのショートカット
    ~~~
    Q Hand Tool
    W Move Tool
    E Rotate Tool
    R Scale Tool
    T Rect Tool
    Y Move, Rotate or Scale selected objects
    ~~~
1. オブジェクトの設置
    1. ProjectでAssets を選択
    1. Createを選択しmを押す
1. オブジェクトへの重力付与
    1. 付与したいオブジェクトをHierarchyで選択
    1. Inspectorの一番下にあるAdd Componetを選択
    1. 検索窓にriと入力しRigidbodyを選択
## 初期設定
1. GamePlay時に背景色を変更する
    - Edit →Preferences →Colors →Playmode tint →333333
## 用語と知識とか
1. ゲームオブジェクト
    - さまざまなコンポーネントを追加できる。デフォルトではTransformコンポーネントのみが設定されている
1. 左手系の座標
    - Red x軸
    - Green y軸
    - Blue z軸
    > 左手系は軸を中心に左回りに回転する