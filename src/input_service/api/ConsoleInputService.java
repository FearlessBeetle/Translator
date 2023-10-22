package src.input_service.api;

import java.util.ArrayList;

/***
 * Интерфейс принимает входной поток из консоли и построчно сохраняет в ArrayList<String>, и возвращает его когда введена команда next.
 * Второй метод открывает поток, оставляет его открытым и строка за строкой передаёт файл с консоли, пока не
 * будет введена команда exit для выхода или команда next для продолжения;
 */
public interface ConsoleInputService {
    ArrayList<String> inputConsole();
    String inputConsoleByLine();
}
