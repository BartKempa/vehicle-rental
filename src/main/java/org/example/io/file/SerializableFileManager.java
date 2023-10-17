package org.example.io.file;

import org.example.exception.DataExportException;
import org.example.exception.DataImportException;
import org.example.model.Rental;

import java.io.*;

public class SerializableFileManager implements FileManager{
    private static final String FILE_NAME = "Rental.o";

    @Override
    public Rental importData() {
        Rental rental = new Rental();
        try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
                ){
           rental = (Rental) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd odczytu danych z pliku " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny typ danych z pliku " + FILE_NAME);
        }
        return rental;
    }

    @Override
    public void exportData(Rental rental) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ){
            objectOutputStream.writeObject(rental);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu do pliku " + FILE_NAME);
        }
    }
}
