package dayNine

import kotlin.math.abs

data class TileRectangle(val cornerTile: Tile, val oppositeCornerTile: Tile) {

    fun getArea(): Long {
        if (cornerTile == oppositeCornerTile) return 0

        val columns = abs(cornerTile.column - oppositeCornerTile.column) + 1
        val rows = abs(cornerTile.row - oppositeCornerTile.row) + 1

        return columns * rows
    }

    fun getId(): String {
        if (cornerTile == getTopCorner()) {
            return "${cornerTile.column},${cornerTile.row};${oppositeCornerTile.column},${oppositeCornerTile.row}"
        }

        return "${oppositeCornerTile.column},${oppositeCornerTile.row};${cornerTile.column},${cornerTile.row}"
    }

    private fun getTopCorner(): Tile {
        if (cornerTile.row < oppositeCornerTile.row) {
            return cornerTile
        } else if (cornerTile.row > oppositeCornerTile.row) {
            return oppositeCornerTile
        }

        if (cornerTile.column < oppositeCornerTile.column) {
            return cornerTile
        }

        return oppositeCornerTile
    }
}