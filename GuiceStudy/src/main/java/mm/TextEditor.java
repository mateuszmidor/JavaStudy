package mm;

import javax.inject.Inject;

public class TextEditor {
    private final SpellChecker spellChecker;
    private final EpiloguePrinter epilogue;

    @Inject
    TextEditor(SpellChecker spellChecker, EpiloguePrinter epilogue) {
        // epilogue has no explicit binding so Guice will create just-in-time binding (inject default-constructed object of type EpiloguePrinter)
        this.spellChecker = spellChecker;
        this.epilogue = epilogue;
    }

    public void checkSpelling() {
        spellChecker.checkSpelling();
        epilogue.printEpilogue();
    }
}
