package mm;

import com.google.inject.AbstractModule;

public class TextEditorModule extends AbstractModule {
    @Override
    protected void configure() {
        // explicit binding for SpellChecker class
        bind(SpellChecker.class).to(SpellCheckerEnglish.class);

        // EpiloguePrinter class will use just-in-time binding
    }
}
