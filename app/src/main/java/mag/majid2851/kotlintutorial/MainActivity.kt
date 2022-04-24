package mag.majid2851.kotlintutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity()
{
    var mag="magnus"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //log(""+returnSum(4 ,5))
        var items = listOf<Int>(10, 20, 30, 40, 60, 45, 34);
        for (num in items)
            log("" + num + "\t")
        for (num in items.indices)
            log("$num : ${items[num]}")
        for ((index, value) in items.withIndex())
            log("$index : $value")

        var x=0;

        do{
           log(""+x)
            x++
        }while (x<10)


        for (i in 1..10)
            log(""+i)
        for (i in 5 downTo -2 step 2)
            log(i.toString())

        for (i in 3 until 7)
            log(i.toString())

        var numbers= mutableListOf<Int>(111,3,34,5,2,5,90)


        for(i in 3..7)
            numbers.add(i)

        for (i in numbers)
            log(i.toString())

        log(numbers.first().toString())
        log(numbers.last().toString())
        log(numbers.filter { it %2 !=0 }.toString())

        //no duplication
        val notDuplication= hashSetOf<String>("b","a","a","c")
        for (num in notDuplication.toSortedSet())
            log(num)

        val mapExample= hashMapOf<String,Int>("a" to 1,"b" to 2,"c" to 4)
        for (num in mapExample)
            log(num.key+":"+num.value)







    }

    fun returnSum(a:Int ,b:Int):Int{
        return a+b;
    }
    fun log(title:String)
    {
        Log.i("mag2851",title);
        //Log.i("mag2851","my favorite chees player is $mag");
    }
}