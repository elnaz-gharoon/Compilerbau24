import java.io.OutputStreamWriter;

public class ParserMain {

    public static void main(String[] args) throws Exception {
        compiler.Lexer lexer = new compiler.Lexer();
        lexer.init("PRINT 1; PRINT 2;");
        compiler.Parser parser = new compiler.Parser(lexer);
        //compiler.ast.ASTExprNode rootExpr = parser.parseExpression("2^3 < 7");
        compiler.ast.ASTStmtNode printStmt = parser.getStmt();
        //printStmt.execute();
        OutputStreamWriter outputWriter = new OutputStreamWriter(System.out);
        //rootExpr.print(outputWriter, "  ");
        printStmt.print(outputWriter, "");
        outputWriter.flush();
        //int result = rootExpr.eval();
        //System.out.println(result);
    }

}
