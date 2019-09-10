import spock.lang.Specification

class MinesweeperSpec extends Specification {

    def "minesweeper can solve for field"() {
        given: "a field"
        def field = "4 4\n..*.\n....\n....\n...."

        when: "the field is parsed"
        def output = Minesweeper.solveField(field)

        then: "the output will be correct"
        output == "01*1\n0111\n0000\n0000"
    }

    def "minesweeper can solve for another field"() {
        given: "a field"
        def field = "3 5\n**...\n.....\n.*..."

        when: "the field is parsed"
        def output = Minesweeper.solveField(field)

        then: "the out will be correct"
        output == "**100\n33200\n1*100"
    }
}
