package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {


        when(blockB){





            Int::class ->{

                var list = blockA.filterIsInstance<Int>()
                return list.sum()
            }





            String::class ->{



                val builder = StringBuilder()
                for(i in blockA.indices){
                    if(blockA[i] is String){
                        builder.append(blockA[i] as String)
                    }
                }
                return builder.toString()
            }




            LocalDate::class -> {

                var list = blockA.filterIsInstance<LocalDate>()

                fun dateBefore(list: List<LocalDate>, localDate: LocalDate): LocalDate {

                    val list2  = ArrayList<LocalDate>()
                    val listResult = ArrayList<LocalDate>()

                    for(i in list.indices) {
                        if((list[i].compareTo(localDate)== -1)||(list[i].compareTo(localDate)== 0))     {
                            list2.add(list[i])
                            listResult.add(list[i])
                        }
                    }

                    var flag: Boolean

                    for(i in list2.indices) {
                        flag = false

                        for(k in list2.indices) {
                            if(list2[i].compareTo(list2[k])== -1) {
                                flag = true
                            }
                        }

                        if(flag== true){listResult.remove(list2[i])}
                    }
                    return listResult[0]
                }


                val date = dateBefore(list, LocalDate.now())
                val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale("ru", "RU"))
                val chartalDay = formatter.format(date)
                return chartalDay

            }


            else -> return Unit

        }


    }








}
