package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String? {



        var hours = hour.toInt()
        var minutes = minute.toInt()


        val hoursChartalMap = HashMap<Int, String>()
        hoursChartalMap.put(1, "one")
        hoursChartalMap.put(2, "two")
        hoursChartalMap.put(3, "three")
        hoursChartalMap.put(4, "four")
        hoursChartalMap.put(5, "five")
        hoursChartalMap.put(6, "six")
        hoursChartalMap.put(7, "seven")
        hoursChartalMap.put(8, "eight")
        hoursChartalMap.put(9, "nine")
        hoursChartalMap.put(10, "ten")
        hoursChartalMap.put(11, "eleven")
        hoursChartalMap.put(12, "twelve")
        hoursChartalMap.put(13, "thirteen")
        hoursChartalMap.put(14, "fourteen")
        hoursChartalMap.put(15, "fifteen")
        hoursChartalMap.put(16, "sixteen")
        hoursChartalMap.put(17, "seventeen")
        hoursChartalMap.put(18, "eighteen")
        hoursChartalMap.put(19, "nineteen")
        hoursChartalMap.put(20, "twenty")
        hoursChartalMap.put(21, "twenty one")
        hoursChartalMap.put(22, "twenty two")
        hoursChartalMap.put(23, "twenty three")
        hoursChartalMap.put(24, "twenty four")
        hoursChartalMap.put(25, "twenty five")
        hoursChartalMap.put(26, "twenty six")
        hoursChartalMap.put(27, "twenty seven")
        hoursChartalMap.put(28, "twenty eight")
        hoursChartalMap.put(29, "twenty nine")




        if(minutes>59){return ""}
        if(minutes==0){return "${hoursChartalMap[hours]} o' clock"}
        if(minutes==1){return "one minute past ${hoursChartalMap[hours]}"}
        if(minutes==15){return "quarter past ${hoursChartalMap[hours]}"}
        if(minutes==30){return "half past ${hoursChartalMap[hours]}"}
        if(minutes==45){return "quarter to ${hoursChartalMap[hours+1]}"}
        if((1<minutes)&&(minutes<30)){return "${hoursChartalMap[minutes]} minutes past ${hoursChartalMap[hours]}"}
        else
        {return "${hoursChartalMap[60- minutes]} minutes to ${hoursChartalMap[hours+1]}"}


    }

}
