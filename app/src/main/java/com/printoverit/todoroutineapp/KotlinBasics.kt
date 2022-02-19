package com.printoverit.todoroutineapp

fun main(){

    //TODO: Testing All the Kotlin Concepts
    var name="Jadiya"
    name="Sahrma"
    println("Vaibhav $name")
    q5()

    //var isEqual=5!=5
    //CHecking the $operator and
    println("It is ${5>3}")

    //IF -else , when
    var season=9
    when(season){
        //if
       1->{ println("Season 1") }
       3->{ println("Season 2")}
        //in (Range)
        in 2..5->{ println("Between 2 and 5")}
        6,9,12->{ println("even numbers")}
        //else
       else->{ println("End Season")}
    }
    //Type Casting with Any keyword
    //Unsafe Type Casting
    var namu :Any="Vaibahv"
    when(namu){
        is String->{println("It's a String")}
        is Int->{println("It's a Integar")}

    }
    //for loop
    //down to makes the series in reverse order
    var b=0
    for(asd in 10.downTo(b).step(2)){
        println(asd)
    }
    println("Forward For Loop")
    for(num in 1..10 step 2){
        println("number is $num")
    }
    println("for Loop with Until")
    // in 1..10 and in 1 until 10 is same
    for(intu in 1 until 12 step 6){
        println(intu)
    }
    //function calling
    println("sum is ${func(2,3)}")

    //Nullables
    var nulable: String?="Vaibhav"
   //nulable=null
    println(nulable?.length)

    //Classes
    var player1:Character= Character(name="Vaibhav",powers ="Web Shooters")
    //These both are same
    // var player1:Character= Character("Vaibhav","Web Shooters")
    var player2:Character= Character("Jamdiya","Thunder Power")
    var player3:Character= Character()
    println("The power of player one is now \"${player1.powerexchange(25)}\"")
    println("The Second Player Nerffed by ${player1.buffe} but his name is ${player2.name}")
    println("The Third Player whos name is ${player3.name} and got Buffed By ${(player1.buffe)*2} i.e double of player one (${player1.name}) ")
    println("Now the power of Third Player is upgraded to (${player3.powerexchange(65)}) ")
    println("The Net Buff in the Team is =${player1.buffe+player3.buffe}")
    //we can use any variable f any onject because we hae intialized them within the body as well with the help of this keyword

    // Data Class Use (It stores the and GLobalise for evryone fot yusing iut )
   val head= HeadQuators("Jaipur","Top")
   val head2= HeadQuators("Manipur","Middle")
    println(" Data clas contains ${head.location}")
    head.location="Banglore"
    println("HeadQuaotrs changed to ${head.location}")
    println("Second HeadQuaotrs changed to ${head2.location}")
    val (loc,pos)=head
    println("Locations and Postions of Headquators are $loc $pos")

    //Class Interhitance
    val par=Parent("Viabhav","INFTP")
    par.Property="INFTP"
    par.personType()

    //Smart Cast Type Casting


}
//Normal Function
private fun func( a:Int, b:Int) :Int{
    var sum =a+b
    return sum
}
//Data Class Declaration
data class HeadQuators(var location:String , var posotion: String )
//Inheritable Class
open class Child (var childName :String , var childProperty:String){

    var Property:String=childProperty
    var type:String ="null"
    fun personType(){
        when(Property){
            "INFTP"->{ println("Your are an INFTP pseronality so Cry About it XD")}
            else->{ println("Kuch Bhi BC kaha kaha se ajate se BKL")}
        }
    }
}
class Parent (childName :String , childProperty:String) : Child(childName,childProperty){
    var typo:String=childName
    init {

        println("The Child's Name is $typo")
    }

}
fun q5(){
    fun String.makeCharArray()=this.toCharArray()
    "hello".makeCharArray().forEach (::println)
}
class Character constructor(name: String ="Binod" , powers :String ="No Powers"){
    //Declaring Local Variable for Furthure Use the these outside of the class
    var powers :String?=null
    var name :String?=null
    var buffe :Int=0

    init {
        this.name=name
        println("The name is $name and the powers are $powers")
    }
    fun powerexchange(buff:Int):String?{
        //this always indicates the compilor for the current context variable or we can say local variable
        //this.local_variable=reference_variable(with actual value)
        this.powers=powers
        //buffe is a local varible and buff is the refrence variable with the value
        this.buffe=buff
        powers="God Mode with a buff of $buffe"
        return powers
    }

}