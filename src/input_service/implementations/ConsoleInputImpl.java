package src.input_service.implementations;

import src.input_service.api.ConsoleInputService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConsoleInputImpl implements ConsoleInputService
{
    @Override
    public ArrayList<String> inputConsole()
    {
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if ("next".equalsIgnoreCase(line)){
                    return lines;
                }
                lines.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return lines;
    }

    @Override
    public String inputConsoleByLine()
    {
        StringBuilder input = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }
                if ("next".equalsIgnoreCase(line)){
                    return input.toString();
                }
                input.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return input.toString();

    }
}
