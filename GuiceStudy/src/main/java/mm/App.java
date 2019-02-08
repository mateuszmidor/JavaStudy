package mm;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // injector will build object graphs with @Inject's configured in provided Module's
        Injector injector = Guice.createInjector(new TextEditorModule());

        // make instance ob @Inject'ed TextEditor
        TextEditor editor = injector.getInstance(TextEditor.class);

        // use the @Inject'ed object
        editor.checkSpelling();
    }
}
