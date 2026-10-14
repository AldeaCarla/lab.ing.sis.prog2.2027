package org.example

import java.util.TreeSet

fun main() {
    val x = MutableList(5) { (0..10).random() }.sorted()
    val y = MutableList(7) { (0..10).random() }.sorted()


    val xPlusY = (x + y).sorted()


    val zSet = TreeSet<Int>()
    zSet.addAll(x.filter { it in y })


    val xMinusY = x.filter { it !in y }.sorted()


    val p = 4
    val xPlusYLimitedByP = (x + y)
        .filter { it <= p }
        .sorted()

    println("x = $x")
    println("y = $y")
    println("a) xPlusY = $xPlusY")
    println("b) zSet = $zSet")
    println("c) xMinusY = $xMinusY")
    println("d) xPlusYLimitedByP = $xPlusYLimitedByP")
}