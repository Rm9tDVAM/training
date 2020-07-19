using System;
namespace Mainn
{
    class Program
    {
        static void Main(string[] args)
        {

        }
    }
}
/*
0719
namespace Main
{
    class Program
    {
        static void Main(string[] args)
        {
            String[] sArr = Console.ReadLine().Split();
            int ATK = int.Parse(sArr[0]);
            int DEF = int.Parse(sArr[1]);
            int AGI = int.Parse(sArr[2]);
            int N = int.Parse(Console.ReadLine());
            for(int i = 0, count = 0; i < N; i++)
            {
                sArr = Console.ReadLine().Split();
                if ((int.Parse(sArr[1]) <= ATK && ATK <= int.Parse(sArr[2]))&&
                    (int.Parse(sArr[3]) <= DEF && DEF <= int.Parse(sArr[4]))&&
                    (int.Parse(sArr[5]) <= AGI && AGI <= int.Parse(sArr[6])))
                {
                    Console.WriteLine(sArr[0]);
                    count++;
                }
                if (i + 1 == N && count == 0)
                {
                    Console.WriteLine("no evolution");
                }
            }
        }
    }
}
0713
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
0712
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

0712
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
