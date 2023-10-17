package org.example.io.file;

import org.example.model.Rental;

public interface FileManager {
    Rental importData();
    void exportData(Rental rental);

}
