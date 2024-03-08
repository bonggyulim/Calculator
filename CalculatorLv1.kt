package com.example.calculator

class CalculatorLv1 {
    open class Calculator(){
        var num1 = 0
        var num2 = 0

        fun addOperation(num1: Int, num2: Int){
            println(num1 + num2)
        }
        fun substractOperation(num1: Int, num2: Int){
            println(num1 - num2)
        }
        fun multiplyoperation(num1: Int, num2: Int){
            println(num1 * num2)
        }
        fun divideOperation(num1: Int, num2: Int){
            println(num1 / num2)
        }
    }

    class OneLineCalculator(dataInput: String): Calculator(){               // 사칙연산기능의 Calculator를 상속받음
        var numberList = dataInput.split("+", "-", "*", "/")      // split()는 파라미터 기준으로 문자열을 분할함
        var dataInput = dataInput

        init{
            num1 = numberList.get(0).toInt()                                // toInt()써서 형변환
            num2 = numberList.get(1).toInt()                                // num1, num2를 가져와서 분할된 두 수를 저장
        }

        fun oneLineCal(){
            when (true){
                dataInput.contains("+") -> {
                    println("${addOperation(num1, num2)}")
                }
                dataInput.contains("-") -> {
                    println("${substractOperation(num1, num2)}")
                }
                dataInput.contains("*") -> {
                    println("${multiplyoperation(num1, num2)}")
                }
                dataInput.contains("/") -> {
                    println("${divideOperation(num1, num2)}")
                } else -> {
                println("잘못 입력")
            }
            }
        }
    }
}


// 테스트 코드 수정
