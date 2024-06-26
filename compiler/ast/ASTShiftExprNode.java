package compiler.ast;

import compiler.Token;
import compiler.TokenIntf.Type;
import java.io.OutputStreamWriter;

public class ASTShiftExprNode extends ASTExprNode {

    public ASTExprNode lhsOperand;
    public ASTExprNode rhsOperand;
    public Token shiftKeyword;

    @Override
    public int eval() {
        if (shiftKeyword.m_type == Type.SHIFTLEFT) {
            return lhsOperand.eval() << rhsOperand.eval();
        } else if (shiftKeyword.m_type == Type.SHIFTRIGHT){
            return lhsOperand.eval() >> rhsOperand.eval();
        }
        throw new Error();
    }

    @Override
    public void print(OutputStreamWriter outStream, String indent) throws Exception {
        outStream.write(indent);
        outStream.write("SHIFT ");
        outStream.write(shiftKeyword.m_value);
        outStream.write("\n");
        indent += "  ";
        lhsOperand.print(outStream, indent);
        rhsOperand.print(outStream, indent);
    }

    @Override
    public compiler.InstrIntf codegen(compiler.CompileEnvIntf env) {
        compiler.InstrIntf rhsExpr = rhsOperand.codegen(env);
        compiler.InstrIntf lhsExpr = lhsOperand.codegen(env);
        compiler.InstrIntf resultExpr =  new compiler.instr.InstrShift(shiftKeyword.m_type, lhsExpr, rhsExpr);
        env.addInstr(resultExpr);
        return resultExpr;
    }

}
