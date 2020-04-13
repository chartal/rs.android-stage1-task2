package subtask4

import java.util.ArrayList

class Pangram {


    fun getResult(inputString: String): String {


        //написать функцию которая проверяет является ли строка панграммой
        fun pangramIndication(inputString: String): Boolean {

            val stringABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            var listA: ArrayList<Int> = ArrayList()
            for (char in stringABC.toCharArray()) {
                listA.add(char.toInt())
            }
            println(listA.joinToString (" "))


            var listB: ArrayList<Int> = ArrayList()
            for (char in inputString.toCharArray()) {
                listB.add(char.toInt())
            }


            var countABC = 0
            for(i in 0..listA.size-1) {
                if ( listB.contains(listA[i]) || listB.contains(listA[i]+32) )
                { countABC++ }

            }
            return countABC == 26
        }





        //функция для проверки: является ли буква гласной
        fun vowelIndication(symbol: Int):Boolean {
            val stringVowels = "AEIOUY"
            var listA: ArrayList<Int> = ArrayList()
            for (char in stringVowels.toCharArray()) {
                listA.add(char.toInt())
            }
            var flag = false

            for(i in 0..listA.size-1) {
                if ( symbol == (listA[i]) || symbol == (listA[i]+32) )
                { flag = true }

            }
            return flag
        }


        //функция для проверки: является ли буква согласной
        fun antiVowelIndication(symbol: Int):Boolean {


            val stringVowels = "BCDFGHJKLMNPQRSTVWXZ"
            var listA: ArrayList<Int> = ArrayList()
            for (char in stringVowels.toCharArray()) {
                listA.add(char.toInt())
            }
            var flag = false

            for(i in 0..listA.size-1) {
                if ( symbol == (listA[i]) || symbol == (listA[i]+32) )
                { flag = true }

            }
            return flag
        }














        //функция конвертирующая отдельно взятое слово (изменяем гласные)
        fun convertWord(inputString: String): String {


            var listA: ArrayList<Int> = ArrayList()
            for (char in inputString.toCharArray()) {
                listA.add(char.toInt())
            }




            var l = 0
            var listB: ArrayList<Int> = ArrayList()
            for(i in 0..listA.size-1) {
                var flag = false
                if ( vowelIndication(listA[i])) {
                    l++
                    flag = true
                    if(vowelIndication(listA[i]-32)){listB.add(listA[i]-32)}else{listB.add(listA[i])}
                }
                if(!flag){ listB.add(listA[i])}

            }

            //преобразуем listB в массив символов
            val listC = ArrayList<Char>()
            for(i in 0..listB.size-1) {
                listC.add(listB[i].toChar())
            }
            val string1 = l.toString()
            val string2 = listC.joinToString("")
            val builder = StringBuilder()

            builder.append(string1)
            builder.append(string2)
            return builder.toString()

        }



        //функция конвертирующая отдельно взятое слово (изменяем согласные)
        fun convertWord2(inputString: String): String {


            var listA: ArrayList<Int> = ArrayList()
            for (char in inputString.toCharArray()) {
                listA.add(char.toInt())
            }

            var l = 0
            var listB: ArrayList<Int> = ArrayList()
            for(i in 0..listA.size-1) {
                var flag = false
                if ( antiVowelIndication(listA[i])) {
                    l++
                    flag = true
                    if(antiVowelIndication(listA[i]-32)){listB.add(listA[i]-32)}else{listB.add(listA[i])}
                }
                if(!flag){ listB.add(listA[i])}

            }

            //преобразуем listB в массив символов
            val listC = ArrayList<Char>()
            for(i in 0..listB.size-1) {
                listC.add(listB[i].toChar())
            }
            val string1 = l.toString()
            val string2 = listC.joinToString("")
            val builder = StringBuilder()

            builder.append(string1)
            builder.append(string2)
            return builder.toString()

        }




        //индикация пробела в строке
        fun cutIndication(input: ArrayList<Char>):Boolean {

            var flag1 = false
            var flag2 = true

            for (i in 0..input.size-1){
                if(input[i].toInt() == 32)
                {flag1 = true}
            }


            var list = ArrayList<Int>()
            for (i in 0..input.size-1){
                list.add(input[i].toInt())

            }

            //если сумма всех элементов равна произведению длины на 32 - то там только пробелы
            if(list.sum()== list.size*32){flag2 = false}


            return flag1&&flag2


        }


        fun fastIndication(text: String):Boolean{

            var k = 0
            for(i in text){if(i==' '){k++} }
            return k != text.length

        }





        // функция чтобы разрезать строку на слова
        fun separateString(inputString: String): ArrayList<String> {

            var list = ArrayList<String>()
            var list2 = ArrayList<String>()


            fun separateInside(inputChartal: ArrayList<Char>): ArrayList<Char> {

                while ((inputChartal[0] == ' ')) {
                    inputChartal.removeAt(0)
                }


                var arrayLeft: ArrayList<Char> = ArrayList()
                var arrayRight: ArrayList<Char> = ArrayList()
                var flag = false
                var a = 0

                for (i in 0 until inputChartal.size) {

                    if ((inputChartal[i] == ' ') && (flag == false)) {
                        a = i
                        flag = true
                    }
                }


                for (i in 0..a - 1) {
                    arrayLeft.add(inputChartal[i])
                }
                for (i in a..inputChartal.size - 1) {
                    arrayRight.add(inputChartal[i])
                }


                val s = arrayLeft.joinToString("")
                list.add(s)
                println(list.joinToString(" "))


                //отдаем на выход из метода правый остаток строки вырезав начальный пробел

                if(cutIndication(arrayRight))
                    while ((arrayRight[0] == ' ')) {
                        arrayRight.removeAt(0)
                    }


                println(arrayRight.joinToString(""))

                if(!cutIndication(arrayRight)){list2.add(arrayRight.joinToString (""))}

                return arrayRight

            }


            var testList = ArrayList<Char>()
            for (char in inputString.indices){
                testList.add(inputString[char])
            }


            while(cutIndication(testList)){

                testList = separateInside(testList)
            }

            var superTest = ArrayList<Char>()
            for(i in list2[0]){
                superTest.add(i)
            }

            if(fastIndication(list2[0])){list.add(list2[0])}






            return list
        }



        ////////////////////выполнение программы/////////////////////////////////





        if(!fastIndication(inputString)) return ""




        if(pangramIndication(inputString)){

            var list = separateString(inputString)
            var chartalList = ArrayList<String>()

            for(i in 0..list.size-1){chartalList.add(convertWord(list[i])) }
            println("Итоговый лист неотсортированный: ${chartalList.joinToString (" ")}" )


            chartalList.sortBy { it[0] }
            println("Итоговый лист   отсортированный: ${chartalList.joinToString (" ")}" )

            return chartalList.joinToString (" ")





        }else{

            //Для замены отдельных символов или строк используется функция replace().
            //    Заменим отдельные символы в строке.


            val inputStringReplace = inputString.replace('\n',' ')




            var list = separateString(inputStringReplace)
            var chartalList = ArrayList<String>()

            for(i in 0..list.size-1){chartalList.add(convertWord2(list[i])) }
            println("Итоговый лист неотсортированный: ${chartalList.joinToString (" ")}" )


            chartalList.sortBy { it[0] }
            println("Итоговый лист   отсортированный: ${chartalList.joinToString (" ")}" )

            return chartalList.joinToString (" ")



        }


    }








}
