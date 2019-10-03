class Minesweeper {

    static char ASTERISK = '*'

    static def solveField(String field) {

        def rows = field.split("\n")
        def gridDimensions = rows[0].split(" ")
        def width = Integer.parseInt(gridDimensions[1])
        def height = Integer.parseInt(gridDimensions[0])

        int[][] outputGrid = new int[height][width]

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                def isMine = rows[y+1].charAt(x) == ASTERISK

                if(isMine) {
                    incrementNeighbours(outputGrid, width, height, x, y)
                }
            }
        }

        def mergedMines = overlayGrids(rows, width, height, outputGrid)

        return mergedMines
    }

    static def incrementNeighbours(int[][] outputGrid, int width, int height, int x, int y) {
        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++) {
                if(i < 0 || i >= width) continue
                if(j < 0 || j >= height) continue

                outputGrid[j][i]++
            }
        }
    }

    static def overlayGrids(String[] rows, int width, int height, int[][] outputGrid) {
        def result = ""

            for(int j = 0 ; j < height; j++) {
                for (int i = 0; i < width; i++) {
                    result += rows[j + 1].charAt(i) == "*" ? "*" : outputGrid[j][i]
                }

                if (j < height - 1) {
                    result += "\n"
                }
        }

        return result
    }

}
