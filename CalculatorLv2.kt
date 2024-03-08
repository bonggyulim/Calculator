package com.example.calculator

class CalculatorLv2 {
    open class Calculator(){
        init{
            println("숫자, 연산자, 숫자 순으로 입력해주세요")
            println("-1은 = , 1은 +, 2는 -, 3은 *, 4는 /, 5는 % 입니다.")
        }
        var num1 = readLine()!!.toInt()

        fun mainAct(){
            var operator = readLine()!!.toInt()
            when (operator) {
                -1 -> {
                    exit()
                }
                1 -> {
                    var num2 = readLine()!!.toInt()
                    addOperation(num2)
                }
                2 -> {
                    var num2 = readLine()!!.toInt()
                    substractOperation(num2)
                }
                3 -> {
                    var num2 = readLine()!!.toInt()
                    multiplyoperation(num2)
                }
                4 -> {
                    var num2 = readLine()!!.toInt()
                    divideOperation(num2)
                }
                5 -> {
                    var num2 = readLine()!!.toInt()
                    modulo(num2)
                }
            }
        }

        fun addOperation(num2: Int){
            print("$num1 + $num2 = ")
            num1 = num1 + num2
            println(num1)
            mainAct()
        }
        fun substractOperation(num2: Int){
            print("$num1 - $num2 = ")
            num1 = num1 - num2
            println(num1)
            mainAct()
        }
        fun multiplyoperation(num2: Int){
            print("$num1 * $num2 = ")
            num1 = num1 * num2
            println(num1)
            mainAct()
        }
        fun divideOperation(num2: Int){
            print("$num1 / $num2 = ")
            num1 = num1 - num2
            println(num1)
            mainAct()
        }
        fun modulo(num2: Int){
            print("$num1 % $num2 = ")
            num1 = num1 % num2
            println(num1)
            mainAct()
        }
        fun exit(){
            println(num1)
        }


    }

}