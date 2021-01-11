package machine

data class Coffee(var water: Int = 0, var milk: Int = 0, var beans: Int = 0, var cups: Int = 0, var dollars: Int = 0)

fun main() {
    val CoffeeMachineStock = Coffee(400, 540, 120, 9, 550)
    val OneEspresso = Coffee(250, 0, 16, 1, 4)
    val OneLatte = Coffee(350, 75, 20, 1, 7)
    val OneCappuccino = Coffee(200, 100, 12, 1, 6)

    fun displayCoffeeMachineStock() {
        println("The coffee machine has:" )
        println("${CoffeeMachineStock.water} of water")
        println("${CoffeeMachineStock.milk} of milk")
        println("${CoffeeMachineStock.beans} of coffee beans")
        println("${CoffeeMachineStock.cups} of disposable cups")
        println("${CoffeeMachineStock.dollars} of money")
    }

    fun enoughEspresso(): Boolean = OneEspresso.water <= CoffeeMachineStock.water && OneEspresso.milk <= CoffeeMachineStock.milk &&
            OneEspresso.beans <= CoffeeMachineStock.beans && OneEspresso.cups <= CoffeeMachineStock.cups

    fun missingEspressoIngredient() {
        if (CoffeeMachineStock.water < OneEspresso.water) println("Sorry, not enough water!")
        if (CoffeeMachineStock.milk < OneEspresso.milk) println("Sorry, not enough milk!")
        if (CoffeeMachineStock.beans < OneEspresso.beans) println("Sorry, not enough beans!")
        if (CoffeeMachineStock.cups < OneEspresso.cups) println("Sorry, not enough cups!")
    }

    fun enoughLatte(): Boolean = OneLatte.water <= CoffeeMachineStock.water && OneLatte.milk <= CoffeeMachineStock.milk &&
            OneLatte.beans <= CoffeeMachineStock.beans && OneLatte.cups <= CoffeeMachineStock.cups

    fun missingLatteIngredient() {
        if (CoffeeMachineStock.water < OneLatte.water) println("Sorry, not enough water!")
        if (CoffeeMachineStock.milk < OneLatte.milk) println("Sorry, not enough milk!")
        if (CoffeeMachineStock.beans < OneLatte.beans) println("Sorry, not enough beans!")
        if (CoffeeMachineStock.cups < OneLatte.cups) println("Sorry, not enough cups!")
    }

    fun enoughCappuccino(): Boolean = OneCappuccino.water <= CoffeeMachineStock.water && OneCappuccino.milk <= CoffeeMachineStock.milk &&
            OneCappuccino.beans <= CoffeeMachineStock.beans && OneCappuccino.cups <= CoffeeMachineStock.cups

    fun missingCappuccinoIngredient() {
        if (CoffeeMachineStock.water < OneCappuccino.water) println("Sorry, not enough water!")
        if (CoffeeMachineStock.milk < OneCappuccino.milk) println("Sorry, not enough milk!")
        if (CoffeeMachineStock.beans < OneCappuccino.beans) println("Sorry, not enough beans!")
        if (CoffeeMachineStock.cups < OneCappuccino.cups) println("Sorry, not enough cups!")
    }

    fun buyEspresso() {
        if (enoughEspresso()) {
            CoffeeMachineStock.water -= OneEspresso.water
            CoffeeMachineStock.beans -= OneEspresso.beans
            CoffeeMachineStock.cups -= OneEspresso.cups
            CoffeeMachineStock.dollars += OneEspresso.dollars
            println("I have enough resources, making you a coffee!\n")
        } else missingEspressoIngredient()
    }

    fun buyLatte() {
        if (enoughLatte()) {
            CoffeeMachineStock.water -= OneLatte.water
            CoffeeMachineStock.milk -= OneLatte.milk
            CoffeeMachineStock.beans -= OneLatte.beans
            CoffeeMachineStock.cups -= OneLatte.cups
            CoffeeMachineStock.dollars += OneLatte.dollars
            println("I have enough resources, making you a coffee!\n")
        } else missingLatteIngredient()
    }

    fun buyCappuccino() {
        if (enoughCappuccino()) {
            CoffeeMachineStock.water -= OneCappuccino.water
            CoffeeMachineStock.milk -= OneCappuccino.milk
            CoffeeMachineStock.beans -= OneCappuccino.beans
            CoffeeMachineStock.cups -= OneCappuccino.cups
            CoffeeMachineStock.dollars += OneCappuccino.dollars
            println("I have enough resources, making you a coffee!\n")
        } else missingCappuccinoIngredient()
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        val choice = readLine()!!
        if (choice == "1") buyEspresso()
        if (choice == "2") buyLatte()
        if (choice == "3") buyCappuccino()
        if (choice == "back") return
    }

    fun fill() {
        println("how many ml of water do you want to add: ")
        val addedWater = readLine()!!.toInt()
        CoffeeMachineStock.water += addedWater
        println("how many ml of milk do you want to add: ")
        val addedMilk = readLine()!!.toInt()
        CoffeeMachineStock.milk += addedMilk
        println("how many grams of coffee beans do you want to add: ")
        val addedBeans = readLine()!!.toInt()
        CoffeeMachineStock.beans += addedBeans
        println("how many disposable cups of coffee do you want to add: ")
        val addedCups = readLine()!!.toInt()
        CoffeeMachineStock.cups += addedCups
        println()
    }

    fun take() {
        val totalMoney = CoffeeMachineStock.dollars
        CoffeeMachineStock.dollars = 0
        println("I gave you $$totalMoney")
        println()
    }

    fun start() {
        loop@ while (true) {
            println("Write action (buy, fill, take, remaining, exit): ")
            val input = readLine()!!
            println()
            if (input == "buy") buy()
            if (input == "fill") fill()
            if (input == "take") take()
            if (input == "remaining") displayCoffeeMachineStock()
            if (input == "exit") break@loop
        }
    }

    start()
}
