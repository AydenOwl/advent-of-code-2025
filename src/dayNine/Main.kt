package dayNine

import java.io.File

fun main() {
    val movieTheater = MovieTheater()

    File("input_movie_theatre.txt").forEachLine {
        val rawTile = it.split(',')
        movieTheater.switchTile(Tile(rawTile[0].toLong(), rawTile[1].toLong()))
    }

    println("The largest rectangle area is ${movieTheater.largestSwitchedRectangle.getArea()}")
}