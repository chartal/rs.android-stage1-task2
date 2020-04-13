package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {

        var listA: ArrayList<Int> = ArrayList()
        for (char in a.toCharArray()) {
            listA.add(char.toInt())
        }



        var listB: ArrayList<Int> = ArrayList()
        for (char in b.toCharArray()) {
            listB.add(char.toInt())
        }




        fun function1(listA: ArrayList<Int>, listB: ArrayList<Int> ): Boolean {
            var k = 0
            for(i in 0..listA.size-1) {
                if(listA[i] == listB[i]){k++}
            }
            if(k == listA.size) return true
            else return false
        }






        fun chartalFornit(listA: ArrayList<Int>, listB: ArrayList<Int> ): Boolean {
            var listC: ArrayList<Int> = ArrayList()
            for(i in 0..listA.size-1) {
                if ( listB.contains(listA[i]) || listB.contains(listA[i]-32) )
                {
                    if(listB.contains(listA[i])){listC.add(listA[i])}
                    else{listC.add(listA[i]-32)}
                }
            }
            if((listC.size == listB.size) &&( function1(listB, listC))) return true
            else return false
        }





        if(chartalFornit(listA, listB)) return "YES"
        else return "NO"


    }

}
