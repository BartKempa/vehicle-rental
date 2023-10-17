package org.example.io.file;

import org.example.exception.NoSuchFileTypeException;
import org.example.io.ConsolePrinter;
import org.example.io.DataReader;

public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public FileManager build(){
        printer.printLine("Wybierz format danych: ");
        FileType type = getFileType();
        switch (type) {
            case CSV -> {
                return new SerializableFileManager();
            }
            case SERIAL -> {
                return new CsvFileManager();
            }
            default -> throw new NoSuchFileTypeException("Nieobsługiwany typ danych");
        }
    }

    private FileType getFileType() {
        FileType result = null;
        boolean typeOk = false;
        do {
            printTypes();
            try {
                String type = reader.getString().toUpperCase();
                result = FileType.valueOf(type);
                typeOk = true;
            } catch (IllegalArgumentException e){
               printer.printLine("Nieobsługiwany typ danych, wybierz ponownie.");
            }
        } while (!typeOk);
        return result;
    }

    private void printTypes() {
        FileType[] values = FileType.values();
        for (FileType value : values) {
            printer.printLine(value.name());
        }
    }
}
