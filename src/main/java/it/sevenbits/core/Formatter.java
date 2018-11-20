package it.sevenbits.core;


import it.sevenbits.io.IReader;
import it.sevenbits.io.IWriter;

/**
 *
 */
public interface Formatter {

    /**
     * @param reader IReader
     * @param writer IWriter
     * @throws FormatterException Something has gone wrong
     */
    void format(IReader reader, IWriter writer) throws FormatterException;

}
