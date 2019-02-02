package it.sevenbits.formatters.state.handlers;

import it.sevenbits.formatters.state.containers.NewLineFlagContainer;
import it.sevenbits.formatters.state.formatsettings.LexerSettings;
import it.sevenbits.formatters.state.formatsettings.LexerSettingsException;
import it.sevenbits.formatters.state.tokens.Token;
import it.sevenbits.other.StringUtils;

/**
 *
 */
public class CloseBrace extends SimpleHandler {

    private NewLineFlagContainer flagContainer;

    @Override
    public void start(final LexerSettings settings) throws HandlerException {
        super.start(settings);
        try {
            flagContainer = (NewLineFlagContainer) settings.getContainers().get("NewLineFlagContainer");
        } catch (LexerSettingsException e) {
            throw new HandlerException();
        }
    }

    @Override
    public String handle(String lexeme) {
        String result = "";

        if (flagContainer.isNeedNewLine()) {
            result += "\n";
        }

        getFormat().setIndentLevel(getFormat().getIndentLevel() - 1);

        if (getFormat().isIndent()) {
            result += StringUtils.repeat(getFormat().getIndentString(), getFormat().getIndentLevel());
        }

        result += lexeme;

        getFormat().setIndent(true);

        flagContainer.setNeedNewLine(true);

        return result;
    }
}
