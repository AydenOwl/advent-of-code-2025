package dayNine

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MovieTheaterTest {
    @Test
    fun `largest rectangle should be equal to 0 if there is no switched tile`() {
        val movieTheater = MovieTheater()

        assertEquals(
            "0,0;0,0",
            movieTheater.largestSwitchedRectangle.getId()
        )
        assertEquals(0, movieTheater.largestSwitchedRectangle.getArea())
    }

    @Test
    fun `largest rectangle should be equal to a horizontal line`() {
        val movieTheater = MovieTheater()

        /* Grid:
           . S . . S
         */
        movieTheater.switchTile(Tile(4, 0))
        movieTheater.switchTile(Tile(1, 0))

        assertEquals(
            "1,0;4,0",
            movieTheater.largestSwitchedRectangle.getId()
        )
        assertEquals(4, movieTheater.largestSwitchedRectangle.getArea())
    }

    @Test
    fun `largest rectangle should be equal to a vertical line`() {
        val movieTheater = MovieTheater()

        /* Grid:
           . S
           . .
           . .
           . .
           . S
         */
        movieTheater.switchTile(Tile(1, 0))
        movieTheater.switchTile(Tile(1, 4))

        assertEquals(
            "1,0;1,4",
            movieTheater.largestSwitchedRectangle.getId()
        )
        assertEquals(5, movieTheater.largestSwitchedRectangle.getArea())
    }

    @Test
    fun `largest rectangle should be from two different rows and columns`() {
        val movieTheater = MovieTheater()

        /* Grid:
           . S . . .
           . . . . .
           . . . . .
           . . . . S
         */
        movieTheater.switchTile(Tile(1, 0))
        movieTheater.switchTile(Tile(4, 3))

        assertEquals(
            "1,0;4,3",
            movieTheater.largestSwitchedRectangle.getId()
        )
        assertEquals(16, movieTheater.largestSwitchedRectangle.getArea())
    }

    @Test
    fun `largest rectangle should be found from four rectangles`() {
        val movieTheater = MovieTheater()

        /* Grid:
           . . . . . . . . . . . . .
           . . . . . . . S . . . S .
           . . . . . . . . . . . . .
           . . S . . . . S . . . . .
           . . . . . . . . . . . . .
           . . S . . . . . . S . . .
           . . . . . . . . . . . . .
           . . . . . . . . . S . S .
         */
        movieTheater.switchTile(Tile(7,1))
        movieTheater.switchTile(Tile(11,1))
        movieTheater.switchTile(Tile(11,7))
        movieTheater.switchTile(Tile(9,7))
        movieTheater.switchTile(Tile(9,5))
        movieTheater.switchTile(Tile(2,5))
        movieTheater.switchTile(Tile(2,3))
        movieTheater.switchTile(Tile(7,3))

        assertEquals(
            "11,1;2,5",
            movieTheater.largestSwitchedRectangle.getId()
        )
        assertEquals(50, movieTheater.largestSwitchedRectangle.getArea())
    }
}