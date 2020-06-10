# Unity
1. オブジェクトを生成
    1. Instantiate
        ~~~c#
        public class Test : MonoBehaviour{
            public Transform prefab;
            private void Start()
            {
                for(int i = 0; i < 10; i++)
                {
                    Instantiate(
                        prefab,
                        new Vector3(i*2.0F,0,0),
                        Quaternion.identity
                    );
                }
            }
        }
        ~~~
    1. [unity|DOCUMENTATION:Object.Instantiate](https://docs.unity3d.com/ja/current/ScriptReference/Object.Instantiate.html)
1. オブジェクトを動かす方法
    1. AddForce(Rigidbody に力を加える)
        ~~~c#
        public class Test : MonoBehaviour{
            public float thrust;
            public Rigidbody rd;

            private void Start()
            {
                rd = GetComponent<Rigidbody>();
            }
            void Update() {
                rd.AddForce(transform.up*9.7f);
            }
        }
        ~~~
        - up, forward, rightがある(逆方向は-をつける)
            ~~~c#
            -transform.right
            ~~~
    1. [unity|DOCUMENTATION:Rigidbody.AddForce](https://docs.unity3d.com/ja/current/ScriptReference/Rigidbody.AddForce.html)
    1. Transform
        1. transform.position
        1. transform.localPosition
    - transform.forward
        > new Vector3(0,0,1.0f)
    1. 円運動
        ~~~c#
        public class Test : MonoBehaviour{
            Vector3 pos;
            void Start() {Vector3 pos = transform.position;}
            void Update() {transform.localPosition = pos + new Vector3(Mathf.Sin(Time.time), Mathf.Cos(Time.time), 0);}}
        ~~~
1. クォータニオン
    [【Unity道場 博多スペシャル 2017】クォータニオン完全マスター](https://www.youtube.com/watch?v=uKWLPU8gfIY)

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