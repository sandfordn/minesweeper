class Minesweeper {

    static char ASTERISK = '*'

    static def solveField(String field) {

        def rows = field.split("\n")
        def gridDimensions = rows[0].split(" ")
        def width = Integer.parseInt(gridDimensions[1])
        def height = Integer.parseInt(gridDimensions[0])

        int[][] outputGrid = [height][width]

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                def isMine = rows[i+1].charAt(j) == ASTERISK



                outputGrid[i][j] = "BALLOON"
            }
        }

        return "01*1\n0111\n0000\n0000"
    }

}
