package dayNine

class MovieTheater {
    var switchedTiles: MutableList<Tile> = mutableListOf<Tile>()
    var largestSwitchedRectangle: TileRectangle = TileRectangle(Tile(0, 0), Tile(0, 0))

    fun switchTile(tile: Tile) {
        for (switchedTile in switchedTiles) {
            val tileRectangle = TileRectangle(tile, switchedTile)

            if(tileRectangle.getArea() > largestSwitchedRectangle.getArea()) {
                largestSwitchedRectangle = tileRectangle
            }
        }

        switchedTiles.add(tile)
    }
}