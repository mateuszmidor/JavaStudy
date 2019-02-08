package mm;

import javax.inject.Inject;

public class TextEditor {
    private final SpellChecker spellChecker;

    @Inject
    TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void checkSpelling() {
        spellChecker.checkSpelling();
    }
}
