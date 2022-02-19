package com.printoverit.todoroutineapp

object Constants {
    const val USER_NAME:String ="user_name"
    const val TOTAL_QUESTIONS:String ="total_questions"
    const val CORRECT_ANSWERS:String ="correct_answers"
    fun getQuestions():ArrayList<Questions>{
        val questionList= ArrayList<Questions>()

        val que1= Questions(1,
        "What country does this flag belongs to??"
        ,R.drawable.ic_flag_of_argentina,
        "Argentina",
        "Australia",
        "Nepal",
        "India"
        ,1)
        questionList.add(que1)

        val que2= Questions(2,
            "What country does this flag belongs to??"
            ,R.drawable.ic_flag_of_australia,
            "Canada",
            "Australia",
            "USA",
            "New ZeaLand"
            ,2)
        questionList.add(que2)

        val que3= Questions(3,
            "What country does this flag belongs to??"
            ,R.drawable.ic_flag_of_belgium,
            "Persia",
            "Russia",
            "Germany",
            "Belgium"
            ,4)
        questionList.add(que3)

        val que4= Questions(4,
            "What country does this flag belongs to??"
            ,R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Russia",
            "Japan",
            "China"
            ,1)
        questionList.add(que4)

        val que5= Questions(5,
            "What country does this flag belongs to??"
            ,R.drawable.ic_flag_of_denmark,
            "Canada",
            "Denmark",
            "Germany",
            "England"
            ,2)
        questionList.add(que5)

        val que6= Questions(6,
            "What country does this flag belongs to??"
            ,R.drawable.ic_flag_of_new_zealand,
            "Hawaii",
            "Denmark",
            "New Zealand",
            "Fiji"
            ,3)
        questionList.add(que6)

        val que7= Questions(7,
            "What country does this flag belongs to??"
            ,R.drawable.ic_flag_of_germany,
            "Russia",
            "Sri Lanka",
            "Germany",
            "India"
            ,3)
        questionList.add(que7)

        val que8= Questions(8,
            "What country does this flag belongs to??"
            ,R.drawable.ic_flag_of_india,
            "India",
            "Phillipines",
            "Korea",
            "Nepal"
            ,1)
        questionList.add(que8)

        return questionList
    }
}