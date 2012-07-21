import com.thoughtworks.biblioteca.Biblioteca;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

import java.io.PrintStream;

/**
* Created with IntelliJ IDEA.
* User: twer
* Date: 7/12/12
* Time: 10:35 PM
* To change this template use File | Settings | File Templates.
*/
public class BibliotecaTest {

    private Biblioteca biblioteca = new Biblioteca();

    private Mockery context = new JUnit4Mockery(){
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };
    private PrintStream mockPrintStream = context.mock(PrintStream.class);

    @Test
    public void should_show_welcome_message_when_start_up(){

        System.setOut(mockPrintStream);

        final String startMessage = "Welcome to use biblioteca!";
        context.checking(new Expectations(){{
            oneOf(mockPrintStream).println(startMessage);
        }});

        biblioteca.showMessage();
    }


}

