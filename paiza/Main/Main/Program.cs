using System;
using System.Collections.Generic;
using System.Linq;

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
