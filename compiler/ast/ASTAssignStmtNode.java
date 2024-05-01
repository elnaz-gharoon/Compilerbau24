package compiler.ast;

import compiler.SymbolTableIntf;
import compiler.Token;

import java.io.OutputStreamWriter;

public class ASTAssignStmtNode extends ASTStmtNode {
    Token m_identifier;
    ASTExprNode m_expr;
    SymbolTableIntf m_symbolTable;

    public ASTAssignStmtNode(Token identifier, ASTExprNode expr, SymbolTableIntf symbolTable) {
        this.m_identifier = identifier;
        this.m_expr = expr;
        this.m_symbolTable = symbolTable;
    }

    @Override
    public void print(OutputStreamWriter outStream, String indent) throws Exception {
        outStream.write(indent);
        outStream.write("AssignStmt \n");
        outStream.write(indent + "  ");
        outStream.write(m_identifier.m_value + "\n");
        outStream.write(indent + "  ");
        outStream.write("ASSIGN \n");
        outStream.write(indent);
        m_expr.print(outStream, indent + "  ");
        outStream.write(indent + "  ");
        outStream.write("SEMICOLON \n");
    }

    @Override
    public void execute() {
        // m_symbolTable.getSymbol(identifier.m_value).set(expr.eval());
    }
}
