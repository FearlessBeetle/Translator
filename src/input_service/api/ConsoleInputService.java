package src.input_service.api;

import java.util.ArrayList;

/***
 * Интерфейс принимает входной поток из консоли и построчно сохраняет в ArrayList<String>, и возвращает его.
 */
public interface ConsoleInputService {
    ArrayList<String> inputFile();
}
