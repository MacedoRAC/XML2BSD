import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws Exception {
        COMP lexer = new COMP(new ANTLRFileStream("ficheiro de teste"));
        CompParser parser = new CompParser(new CommonTokenStream(lexer));
        

        ParseTree tree = parser.document();

        ParseTreeWalker walker = new ParseTreeWalker();
        CompListener listener = new CompListener();
        walker.walk(listener, tree);
    }
}