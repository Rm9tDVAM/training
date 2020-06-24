# Unity
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
    - [unity|DOCUMENTATION:Object.Instantiate](https://docs.unity3d.com/ja/current/ScriptReference/Object.Instantiate.html)
1. AddForce
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
    - [unity|DOCUMENTATION:Rigidbody.AddForce](https://docs.unity3d.com/ja/current/ScriptReference/Rigidbody.AddForce.html)
1. Transform
    ~~~c#
    public class Test : MonoBehaviour
    {
        void Start()
        {
            foreach (Transform child in transform)
            {
                child.position += Vector3.up * 100.0f;
            }
        }
    }
    ~~~
    - [unity|DOCUMENTATION:Transform](https://docs.unity3d.com/ja/current/ScriptReference/Transform.html)
1. Vector3
    - [unity|DOCUMENTATION:Vector3](https://docs.unity3d.com/ja/current/ScriptReference/Vector3.html)
1. Input.GetAxis
    - [unity|DOCUMENTATION:Input.GetAxis](https://docs.unity3d.com/ja/current/ScriptReference/Input.GetAxis.html)
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
    1. Apply Root Motion
    1. Has Exit Time
1. Method
    1. Update()
    1. Instantiate()
    1. ?
    1. ?
    1. Destroy()
1. 左手系の座標
    - Red x軸
    - Green y軸
    - Blue z軸
    > 左手系は軸を中心に左回りに回転する