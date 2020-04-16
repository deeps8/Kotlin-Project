const val TOP_LEVEL_VARIABLE = "I'm a top level variable" //public static final String

fun main() {

    println(TOP_LEVEL_VARIABLE)

    val userName = "Vivek Sharma"        //val is more like final in Java, val's value cant be changed
    var age = 19
    val exampleString = "Vivek Sharma"
    val exampleNumber = 10
    val exampleLong: Long = exampleNumber.toLong() //converting to long type

    val str: String //declaration
    str = "Sharma is a good boy"      //initialization
    println(str)

    val testString = """ "This is
        |a Example String" """.trimMargin()
    println(testString)


    println("Hello World, $userName. I am $age years old . And I am going to be ${age + 1} in 1 year")
    //printKotlin()

    /**
     * Arithmetic Operator
     */
    var a = 5
    var b = 3.0

    println("a + b = ${a + b}")
    println("a - b = ${a - b}")
    println("a * b = ${a * b}")
    println("a / b = ${a / b}")
    println("a % b = ${a % b}")

    println("a++ : ${++a}")

    val name = "Vivek"
    println("Name is : $name")

    /**
     * Array
     */
    val names = arrayOf("Jim", "John", "Jem", "Vivek");
    names[0] = "Vivek"  //given array is val but we can change the value inside it, not the whole array
    println("Number of elements : " + names.size)
    println("Last Element is : ${names[names.size - 1]} and ${names.last()}")
    println("First Element: ${names[0]}")

    val numbers = arrayOf(1, "Hi", 'v')


    /**
     * loops
     */
    val testArray = arrayOf("Vivek", "Sharma", "Counter")
    for (test in testArray) {
        println(test)
    }

    for (i in names.indices)
        println("Index : $i Element : ${names[i]}")

    val helloString = "hello"
    for (eachChar in helloString)
        println(eachChar)

    for (i in 1..10)
        println(i)

    for (i in 1 until 10)   //do not include 10
        println(i)

    for (i in 10 downTo 1)
        println(i)

    for (i in 1..10 step 2)
        println(i)

    for (i in 'a'..'z')
        println(i)

    //while loop
    var i = 0
    while (i < 5) {
        println(i)
        ++i
    }

    //do while loop
    i = 0
    outer@ do {
        println(i)
        ++i

        var j = 0
        while (j < 5) {
            println("---$j")
            j++
            //break
            break@outer
        }

    } while (i < 5)

    /**
     * Operators
     */
    //${} is string placeholder
    println(" 2>1 is ${2 > 1}")
    println(" 1==1 is ${1 == 1}")
    println(" 2 != 1 is ${2 != 1}")
    println("true || false : ${true || false}")
    if ((2 > 1) and (1 == 1))
        println("inside if")
    else
        println("inside else")

    val condition = 2 > 1 || 3 > 2 && 2 > 3
    println(condition)

    var number = 100
    var count = 0
    while (number > 1) {
        number /= 2
        ++count
        println("$number -> $count ")
    }

    println()
    for (i in 1..10) {
        if (i !in 4..6)
            continue
        println(i)
    }

    println()
    for (i in 1..10) {
//        if (i !in 4..6)
//            print("-")
//        else
//            print(">")

        val prefix = if (i !in 4..6) "-" else ">"     //assigned  prefix string to prefix val
        println("$prefix $i")
    }

    var time = 14
    if (time in 0..11)
        println("Good Morning")
    else if (time == 12)
        println("Time For Lunch")
    else
        println("Good Day")

    //when operator == switch case
    when (time) {
        in 0..11 -> println("Good Morning")
        12 -> println("Time For Lunch")
        13, 14 -> {
            //{} is if we want to print multiple lines
            println("Yawn.....zzz")
            println("Time to sleep")
        }
        else -> println("Good Day")
    }

    println()
    time = 10
    var isWeekend = true
    when {
        isWeekend -> println("I am gonna play games whole night")
        time < 5 -> println("Why so early !")
        time in 0..11 -> println("Good Morning")
        time == 12 -> println("Time For Lunch")
        time == 13 || time == 14 -> {
            //{} is if we want to print multiple lines
            println("Yawn.....zzz")
            println("Time to sleep")
        }
        else -> println("Good Day")
    }

    /**
     * functions
     * CTRL+SHIFT+P   to get the return type of function
     * default return type is Unit(like Void)
     */
    greet("Vivek", 5)
    greet(  //specifying the arguments name and value, irrespective of order
            reps = 3,
            message = "How Are you !!!",
            name = "Ben"
    )
    printMax(10, 10)
    val max = getMax(10,2)
    println(max)
    println(getMax(11.4,22.3))
    println(getMax(10, 20, 3))
    println(getMax(1, 2,3,4,5))    //getMax(1, remaining = *intArrayOf(1, 2, 3) )

    val double = getDouble(232)
    println(getTriple(3))

    println(getSum(1, 2, 3, 4, 5, 6, 7))

    //class
    val user = User("Vivek", 19)
    val user2 = User("Deepak", 21)
    val user3 = User(age = 20)
    val user4 = User("    ", 20)
}

/**
 * function to print Kotlin
 */
fun printKotlin() {
    println("Hello Kotlin")
}


fun greet(name: String, reps: Int) {
    //all params in a function are val
    for (i in 0 until reps) {
        println("Hello $name , How you doing")
    }
}
//By changing the order of params, Function Overloading can be done , but not good practice
fun greet(reps: Int, name: String) {
    //all params in a function are val
    for (i in 0 until reps) {
        println("Hello $name , How you doing")
    }
}
fun greet(message: String, name: String = "User", reps: Int = 1){
    for (i in 0 until reps)
        println("Hello $name, $message")
}

fun printMax(a: Int, b: Int) {
    if (a > b)
        println("$a is max")
    else
        println("$b is max")
}

fun getMax(num1: Int, num2: Int): Int {
    val max = if(num1 > num2) num1 else num2
    return max
}
//Overloading of Function
fun getMax(num1: Double, num2: Double) = if (num1 > num2) num1 else num2
fun getMax(a: Int, b: Int, c: Int) =
        when{
            a >= b && a >= c -> a
            b >= a && b >= c -> b
            else -> c
        }
fun getMax(first: Int, vararg remaining: Int): Int{
    var max = first
    println(TOP_LEVEL_VARIABLE)

    for (i in remaining){
        if (i > max)
            max = i
    }

    return  max
}

fun getDouble(num1: Int): Int{
    return num1*2
}

//Single Expression Functions
fun getTriple(num: Int): Int = num*3
fun getMax2(a: Int, b: Int) = if (a > b) a else b

/*fun getSum(a: Int , b: Int , c: Int = 0, d: Int = 0): Int{
    return  a + b + c + d
}*/
fun getSum(vararg numbers: Int): Int{
    var sum = 0
    for (number in  numbers){
        sum += number
    }
    return sum
}

/**
 * Class
 */
class User(name: String = "No Name", var age: Int){
    val name: String

    init {
        if (name.isBlank()){
            this.name = "No Name"
        }else{
            this.name = name.trim()
        }

        println("New User Created. Name: ${name}, Age: $age")
    }

}



