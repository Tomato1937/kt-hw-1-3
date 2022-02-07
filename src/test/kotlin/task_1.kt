val timer = 1610

fun main() {
    println("Был(а) " + agoToText(timer = timer))
}

fun agoToText(timer: Int) = when (timer) {
    in 0..60 -> "только что"
    in 61..60*60 -> minutesAgo(timer/60)
    in 60*60+1..24*60*60 -> hoursAgo(timer/3600)
    in 24*60*60+1..24*60*60*2 -> "сегодня"
    in 24*60*60*2+1..24*60*60*3 -> "вчера"
    else -> "давно"
}

fun minutesAgo(minutes: Int) = when(minutes) {
    1, 21, 31, 41, 51 -> (minutes).toString() + " минуту назад"
    in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> (minutes).toString() + " минуты назад"
    else -> (minutes).toString() + " минут назад"
}

fun hoursAgo(hours: Int) = when(hours) {
    1, 21 -> (hours).toString() + " час назад"
    in 2..4, in 22..24 -> (hours).toString() + " часа назад"
    else -> (hours).toString() + " часов назад"
}
