package src.input_service.api;


import java.util.ArrayList;

/***
 * Интерфейс принимает входной поток из файла и построчно сохраняет в ArrayList<String>, и возвращает его.
 */
public interface FileInputService {
    ArrayList<String> inputFile(String path);
}
