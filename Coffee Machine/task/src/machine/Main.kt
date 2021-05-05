package machine
import java.util.*

class coffee(var milk: Int = 540, var water: Int = 400, var coffeeBeans:Int = 120, var cups: Int = 9, var money: Int = 550) {


    fun fill() {
        print("Write how many ml of water do you want to add: ")
        water += readLine()!!.toInt()
        print("Write how many ml of milk do you want to add: ")
        milk += readLine()!!.toInt()
        print("Write how many grams of coffee beans do you want to add: ")
        coffeeBeans += readLine()!!.toInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        cups += readLine()!!.toInt()
    }

    fun disp() {
        println("The coffee machine has: ")
        println("$water of water")
        println("$milk of milk")
        println("$coffeeBeans of coffee beans")
        println("$cups of disposable cups")
        println("$$money of money")
    }

    fun take() {
        println("I gave you $$money")
        money = 0
    }

    fun buy() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        when (readLine()!!) {
            "1" -> buyEspresso()
            "2" -> buyLatte()
            "3" -> buyCappuccino()
           // "back" ->
        }
    }

    fun buyEspresso() {
        when {
            water < 250 -> {
                println("Sorry, not enough water!")
            }
            coffeeBeans < 16 -> {
                println("Sorry, not enough coffee beans!")
            }
            cups == 0 -> {
                println("Sorry, no enough disposable cups!")
            }
            else -> {
                println("I have enough resources, making you a coffee!")
                water -= 250
                coffeeBeans -= 16
                money += 4
                cups--
            }
        }
    }

    fun buyLatte() {
        when {
            water < 350 -> {
                println("Sorry, not enough water!")
            }
            coffeeBeans < 20 -> {
                println("Sorry, not enough coffee beans!")
            }
            cups == 0 -> {
                println("Sorry, no enough disposable cups!")
            }
            milk < 75 -> {
                println("Sorry,not enough milk!")
            }
            else -> {
                println("I have enough resources, making you a coffee!")
                water -= 350
                milk -= 75
                coffeeBeans -= 20
                money += 7
                cups--
            }
        }
    }

    fun buyCappuccino() {
        when {
            water < 200 -> {
                println("Sorry, not enough water!")
            }
            coffeeBeans < 12 -> {
                println("Sorry, not enough coffee beans!")
            }
            cups == 0 -> {
                println("Sorry, no enough disposable cups!")
            }
            milk < 100 -> {
                println("Sorry,not enough milk!")
            }
            else -> {
                println("I have enough resources, making you a coffee!")
                water -= 200
                milk -= 100
                coffeeBeans -= 12
                money += 6
                cups--
            }
        }
    }
}


fun main() {

    /*
    print("Write how many cups of coffee you will need: ")
    val cups = readLine()!!.toInt()
    println("For $cups of coffee you will need: ")
    println("${cups*200} ml of water")
    println("${cups*50} ml of milk")
    println("${cups*15} g of coffee beans")


     */

    val coffeeMachine = coffee()
    mainMenu(coffeeMachine)


}

fun checkIfYouCanMakeCoffee(water: Int, milk: Int, coffeeBeans: Int, cups: Int) {
    val neededWater = 200
    val neededMilk = 50
    val neededCoffeeBeans = 15


    if (water / (neededWater * cups) > 0 && milk / (neededMilk * cups) > 0 && coffeeBeans / (neededCoffeeBeans * cups) > 0) {
        val amountOfCoffee =
            minOf(water / (neededWater * cups), milk / (neededMilk * cups), coffeeBeans / (neededCoffeeBeans * cups))
        println("Yes, I can make that amount of coffee (and even ${amountOfCoffee - cups} more than that)")
    }
    else if (water % (neededWater * cups) == 0 && milk % (neededMilk * cups) == 0 && coffeeBeans % (neededCoffeeBeans * cups) == 0) {
        println("Yes, I can make that amount of coffee")
    } else {
        val amountOfCoffee = minOf(water / neededWater, milk / neededMilk, coffeeBeans / neededCoffeeBeans)
        println("No, I can make only $amountOfCoffee cups of coffee")
    }
}
fun mainMenu(coffeeMachine: coffee){
    do {
        var exit = true
        print("Write action (buy, fill, take, remaining, exit): ")
        val input = readLine()!!
        println("")
        when (input) {
            "buy" -> coffeeMachine.buy()
            "take" -> coffeeMachine.take()
            "fill" -> coffeeMachine.fill()
            "remaining" -> coffeeMachine.disp()
            "exit"-> exit=false

        }
        println("")
    }while(exit)
}

