package src.input_service.implementations;

import src.input_service.api.FileInputService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileInputImpl implements FileInputService
{


    @Override
    public ArrayList<String> inputFile(String path)
    {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return lines;
    }
}
