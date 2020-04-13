package subtask1

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {



        val chartalMap = HashMap<String, String>()

        chartalMap.put("1", "января")
        chartalMap.put("2", "февраля")
        chartalMap.put("3", "марта")
        chartalMap.put("4", "апреля")
        chartalMap.put("5", "мая")
        chartalMap.put("6", "июня")
        chartalMap.put("7", "июля")
        chartalMap.put("8", "августа")
        chartalMap.put("9", "сентября")
        chartalMap.put("10", "октября")
        chartalMap.put("11", "ноября")
        chartalMap.put("12", "декабря")


        val date = "$day.$month.$year"

        val format =  SimpleDateFormat("dd.MM.yyyy")
        var dayWeek: Date? = null
        try {
            dayWeek  = format.parse(date)
        }catch(e: Exception){
            e.printStackTrace()
        }

        val rus =  Locale("ru", "RU")

        val chartalDay = SimpleDateFormat("EEEE", rus).format(dayWeek)



        //проверка чтобы числовое значение месяца было корректным
        val list: List<String> = listOf("1","2","3","4","5","6","7","8","9","10","11","12",
            "01","02","03","04","05","06","07","08","09" )
        val isContains = list.contains(month)




        if((!GregorianCalendar().isLeapYear(year.toInt())) &&(day.toInt()>28 ))     {
            return "Такого дня не существует"
        }


        return if(isContains) {
            day +" " + chartalMap.get(month)+", " + chartalDay
        }else "Такого дня не существует"



    }

}
