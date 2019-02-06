fun main(args: Array<String>){
    var num:Int = 10;

    println("hello world"+num);
    println(sum(1,2))
    println(mul(3,3))

    var person = Person("222",2);
    person.age = 100;
   //  person.name= "cho";

    println(person.age);

    var button = Button(1,2,"Send");
    var button2 = Button(2,1);

    var table = Table(1,"myTable");

    var monster = Monster();
    monster.eat();
    monster.see();

    var cycle = Cycle();
    cycle.height = 50;
    println("cycle height "+cycle.height);

    cycle.height = -100;
    println("cycle height "+cycle.height);


    println(cycle)
    var dCycle = DataCycle(10);
    println(dCycle);


    println(dCycle.equals(cycle));

    //데이터 클레스는 헤쉬코드와 에퀄이 구현 되어있다. 메모리 주소 가 달라도 헤쉬코드와 이퀄이 자동으로 오버라이드 되어있음으로 .
    var dCycle2 = DataCycle(10);
    println(dCycle2.equals(dCycle));

    // 그럼 같은 메모리 주소를 참조하는 동일 객체 여부는 ????

    println(dCycle2);
    println(dCycle);

    println(dCycle.hashCode());
    println(dCycle2.hashCode());

    dCycle = dCycle2;
    dCycle2.height = 20;
    println(dCycle.hashCode());

}


fun sum(a:Int ,b:Int): Int {
    return a+b;

}


fun mul(a:Int, b:Int) = a*b;

class Person(
        val name: String,
        var age: Int
)

class Button(var width:Int,var height:Int, var name:String = "unkoneBuyyon");

class Table(){
    var id: Int =0;
    var text: String = "";

    constructor(id:Int, text: String) : this() {
        this.id = id;
        this.text = text;
    }

}


open class Book(val title:String){
    open fun printInfo(){
        println("this is a book"+this.title)

    }
}

class Ebook(title:String):Book(title){
    override fun printInfo() {
        //super.printInfo()
        println("this is a Ebook"+this.title);
    }
}


interface AnimalAction{
    fun eat();
    fun run();
    fun see()= print("animal see");
}

interface PersonAction{
    fun eat();
    fun run();
    fun see()= print("person see");
}


class Monster:AnimalAction, PersonAction{
    override fun see() {
        super<AnimalAction>.see()
    }

    override fun eat() {
        println("yam! yam! yam!")
    }

    override fun run() {
        println("hack! hack! hack!")
    }

}

class Cycle(){

    var height: Int =0
        get() = if (field > 0) field else 0
        set (value) {
            if (value > 0) field = value else field =0
        }
}


data class DataCycle(var height: Int){

}