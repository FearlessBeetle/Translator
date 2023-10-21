package src.parser.api;

import java.util.ArrayList;

/***
 * 1) String[] parseArrList(ArrayList<String> arrayList) принимает ArrayList<String>,
 * 2) разбивает его элементы на строки используя знак ;
 * 3) в случае если в рассматриваемой строке строке нет ; идём в следующую ячейку ArrayList.
 * 4) Заменяем все пробелы(с помощью Pattern Matcher) на символ ©, таким образом чтобы любое количество
 * пробелов превращалось в один символ ©.
 * 5) Возвращаем массив String[] выражений с цифрами и операциями, которые разделены символом ©
 * Примеры работы:
 * Входящий ArrayList:
 * 22 *(1123 + 33*44    -   11);
 * Получаемый массив:
 * 22©*(1123©+©33*44©-11);
 * Входящий ArrayList:
 * 2 2 - 14 /   23  ( 0 ) = 2 3     ; // Да в итоге мы получим бессмыслицу, но на этом этапе нас это не волнует.
 * Получаемый массив:
 * 2©2©-©14©/©23©(©0©)©=©2©3©;
 * Входящий ArrayList:
 * 21 + 3/2/3/4/          15         // Сколько бы ни было элементов в ArrayList и сколько бы ни было в них \n,
 * 23 23 * 11 +                           пока не встретится ; считаем это одной строкой.
 * 222;
 * Получаемый массив:
 * 21©+©3/2/3/4/©1523©23©*©11©+222;
 *
 * 1) String[][] parseToTokens(String[] arrOfTokens) принимает произвольный массив строк вида 21©+©3/2/3/4/©1523©23©*©11©+222;
 * 1.1) У нас будет итоговый Двумерный массив, каждая ячейка которого будет содержать токены для конкретной строки.
 * 2) Разбивает на токены используя, список токенов перечислен в Tokens, Enumы операций и цифр и скобок.
 * 3) Тут можно дать волю фантазии, можно дробить на массив значений используя метод split('©'), затем читаем каждый отдельный токен.
 * В случае если у нас получилась пустая строка вместо токена(а такое возможно), не записываем его.
 * Когда доходим до массива с ; у нас может быть 2 ситуации, либо он там один [;] и всё ок, добавляем его как токен EOL, либо
 * там лежит ещё ; и другой токен [32;], в таком случае просто отрезаем c помощью substring(0, exampleStr.length - 1), получаем
 * строку, без последнего символа и переводим её в токен. Теперь нужно создать ещё один массив, с размером length + 1, в него копируем
 * весь предыдущий массив, с помощью System.arrayCopy() и последний элемент заполняем токеном EOL.
 *
 * Можно пойти другим путём, создать ArrayList<Token>, отрезать от кусок от начала строки до © (не включительно), добавить в arrayList токен,
 * затем отрезать кусок с токеном от начала до ©, используя метод substring(). Затем повторять так, пока не наткнёмся на ;
 * , затем записываем EOL в ArrayList. Затем переводим ArrayList в массив строк и добавляем в наш результирующий массив.
 * Можно сделать рекурсивно.
 * Можете придумать свой, более эффективный способ.
 * В итоге из входной строки получаем следующее
 * Пример работы:
 * Входной массив:
 * 21©+©3/2/3/4/©1523©23©*©11©+222;
 * 222©22*31©2*(/);
 * 1©-©22;
 * Результат:
 * String[
 *      String[NUMBER, ADD, NUMBER, DIV, NUMBER, DIV, NUMBER, DIV, NUMBER, DIV, NUMBER, NUMBER, MLT, NUMBER, ADD, NUMBER, EOL],
 *      String[NUMBER, NUMBER, MLT, NUMBER, NUMBER, LRBR, DIV, RRBR, EOL],
 *      String[NUMBER, SUB, NUMBER, EOL]
 * ]
*/

public interface ParserService {
    String[] parseArrList(ArrayList<String> arrayList);
    String[][] parseToTokens(String[] arrOfTokens);
}
