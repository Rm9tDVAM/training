# Unity
1. オブジェクトを動かす方法
    1. Gravity
        1. オブジェクトにRigidbodyを適用
           > これだけで重力で落下する
        1. Rigidbodyを取得する
            ~~~c#
            Rigidbody hogeRigidBody = hoge.GetComponent<Rigidbody>();
            ~~~
    1. Transform
## 初期設定
1. GamePlay時に背景色を変更する
    - Edit →Preferences →Colors →Playmode tint →333333
## 用語と知識とか
1. Component
    1. Is Trigger
    1. Is Kinematic
1. Method
    1. Update()
    1. Instantiate()
    1. ?
    1. ?
    1. Destroy()
1. ゲームオブジェクト
    - さまざまなコンポーネントを追加できる。デフォルトではTransformコンポーネントのみが設定されている
1. 左手系の座標
    - Red x軸
    - Green y軸
    - Blue z軸
    > 左手系は軸を中心に左回りに回転する