import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        compLexer lexer = new compLexer(new ANTLRFileStream("Portugal CentroNorte.bgl.xml"));
        compParser parser = new compParser(new CommonTokenStream(lexer));
        

        ParseTree tree = parser.document();

        ParseTreeWalker walker = new ParseTreeWalker();
        MyCompListener listener = new MyCompListener();
        walker.walk(listener, tree);
    }
}