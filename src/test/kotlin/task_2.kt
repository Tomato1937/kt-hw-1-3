val cardType = "Maestro"
val transferSum = 75020_00
val amount = 2010_00

fun main() {
    println("Размер комиссии: " + transferCalc(cardType, transferSum, amount) + " коп.")
}

fun transferCalc(
    cardType: String = "VK Pay",
    transferSum: Int = 0,
    amount: Int = 1000_00,
): String = when(cardType) {
    "Mastercard", "Maestro" -> masterCom(transferSum, amount)
    "Visa", "Мир" -> visaCom(transferSum, amount)
    "VK Pay" -> vkPay(transferSum, amount)
    else -> "некорректная операция"
}

fun masterCom(transferSum: Int = 0, amount: Int = 0) = when(transferSum != 0) {
    transferSum <= 75000_00 -> 0.toString()
    transferSum in 75000_00..600000_00 -> ((amount * 0.006).toInt() + 20_00).toString()
    else -> "Лимит по карте превышен"
}

fun visaCom(transferSum: Int = 0, amount: Int = 0) = when(transferSum != 0) {
    transferSum <= 600000_00 && amount * 0.0075 <= 35_00 -> "35_00"
    transferSum <= 600000_00 && amount * 0.0075 > 35_00 -> (amount * 0.0075).toString()
    else -> "Лимит по карте превышен"
}

fun vkPay(transferSum: Int = 0, amount: Int = 0) = when(transferSum != 0) {
    transferSum <= 40000_00 && amount <= 15000_00 -> 0.toString()
    else -> "Лимит по карте превышен"
}
