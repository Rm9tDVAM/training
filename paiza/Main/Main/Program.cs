using System;

namespace Main{
    class Program{
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int M = int.Parse(Console.ReadLine());
            Console.WriteLine(N * M);
        }
    }
}
/* 0712
namespace Main{
    class Program{
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            if (40 <= N && N <= 60)
            {
                Console.WriteLine("OK");
            }
            else
            {
                Console.WriteLine("NG");
            }
        }
    }
}
*/
/* 0712
namespace Main{
    class Program{
        static void Main(string[] args){
            var list = new List<int>();
            for(int i = 0; i < 3; i++)
            {
                list.Add(System.Console.ReadLine().Length);
            }
            Console.WriteLine(list.Max());
        }
    }
}
 */
