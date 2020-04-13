package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {


        fun fibonacci(i: Int): Int {
            var result = 0
            if (i==0) return 0
            if (i==1) return 1
            else return fibonacci(i-1)+ fibonacci(i-2)
        }


        var i = 0

        while((fibonacci(i)* fibonacci(i+1)!= n) &&  (fibonacci(i)* fibonacci(i+1) < n) )   {
            i++
        }

        val a = fibonacci(i)
        val b = fibonacci(i+1)
        var c = 0
        if(a*b==n){c=1} else c = 0


        var chartalArray = IntArray(3)
        chartalArray[0]= a
        chartalArray[1]= b
        chartalArray[2]= c


        return chartalArray



    }

}
