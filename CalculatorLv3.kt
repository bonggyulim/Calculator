package com.example.calculator

import kotlinx.coroutines.coroutineScope

class CalculatorLv3 {


    open class Calculator() {

        fun mainAct(){
            var add = AddOperation()                                        // 더하기 연산
            var sub = SubstractOperation()                                  // 빼기 연산
            var mul = MultiplyOperation()                                   // 곱하기 연산
            var div = DivideOperation()                                     // 나누기 연산
            var splitFourData = splitFourData()                             // 입력된 문자 자르기

            println("계산할 식을 작성해주세요(숫자,연산자,숫자,등호) : ")

            var inputStr = readLine()!!.toString()
            var list = splitFourData.split(inputStr)
            var result = 0

            if(list.get(3) == 1) {                                          // 마지막입력이 = 이면 실행
                when (list.get(1)) {                                        // 들어온 연산자의 연산을 실행
                    1 -> result = add.operation(list.get(0), list.get(2))
                    2 -> result = sub.operation(list.get(0), list.get(2))
                    3 -> result = mul.operation(list.get(0), list.get(2))
                    4 -> result = div.operation(list.get(0), list.get(2))
                    -1 -> print("잘 못 입력")
                }
                println(result)
            }

            println("종료하실려면 = 을 입력, 이어서 계산 : $result")
            re(result)
        }

        fun re(result_: Int): Int {                                         // 재귀함수를 써 여러번 연산 가능
            var result = 0
            var add = AddOperation()
            var sub = SubstractOperation()
            var mul = MultiplyOperation()
            var div = DivideOperation()
            var splitThreeData = splitThreeData()

            var inputStr = readLine()!!.toString()
            var list = splitThreeData.split(inputStr)

            if(list.get(2) == 1) {
                when (list.get(0)) {
                    1 -> result = add.operation(result_, list.get(1))
                    2 -> result = sub.operation(result_, list.get(1))
                    3 -> result = mul.operation(result_, list.get(1))
                    4 -> result = div.operation(result_, list.get(1))
                    -1 -> print("잘 못 입력")
                }
                println(result)
                re(result)
            } else return 0

            return result
        }
    }

    abstract class Operation(): Calculator() {                                  // 연산 추상클래스
        open var result = 0
        open fun operation(num1: Int, num2: Int): Int {
            return result
        }
    }

    class AddOperation(): Operation() {
        override fun operation(num1: Int, num2: Int): Int {
            result = num1 + num2
            return result
        }
    }

    class SubstractOperation(): Operation() {
        override fun operation(num1: Int, num2: Int): Int {
            result = num1 - num2
            return result
        }
    }

    class MultiplyOperation(): Operation() {
        override fun operation(num1: Int, num2: Int): Int {
            result = num1 * num2
            return result
        }
    }

    class DivideOperation(): Operation() {
        override fun operation(num1: Int, num2: Int): Int {
            result = num1 / num2
            return result
        }
    }


    abstract class SplitData(): Calculator() {                                  // 데이터 분할 추상 클래스
        var listInt = mutableListOf<Int>()
        var num1: Int = 0
        var num2: Int = 0
        var operator: Int = 0
        var eql: Int = 0

        open fun split(str: String): List<Int>{

            return listInt
        }
    }

    class splitFourData(): SplitData(){
        override fun split(str: String): List<Int> {
            var strSplit = str.split("+", "-", "*", "/", "=")
            num1 = strSplit[0].toInt()
            num2 = strSplit[1].toInt()

            when {
                str.contains("+") -> operator = 1
                str.contains("-") -> operator = 2
                str.contains("*") -> operator = 3
                str.contains("/") -> operator = 4
            }

            if (str.contains("=")) eql = 1 else eql = 0

            listInt.add(num1)
            listInt.add(operator)
            listInt.add(num2)
            listInt.add(eql)

            return listInt
        }

    }

    class splitThreeData(): SplitData(){
        override fun split(str: String): List<Int> {
            var strSplit = str.split("+", "-", "*", "/", "=")
            num2 = strSplit[1].toInt()

            when {
                str.contains("+") -> operator = 1
                str.contains("-") -> operator = 2
                str.contains("*") -> operator = 3
                str.contains("/") -> operator = 4
            }

            if (str.contains("=")) eql = 1 else eql = 0

            listInt.add(operator)
            listInt.add(num2)
            listInt.add(eql)

            return listInt
        }

    }





}