package Calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Model {
    /* Получение информации из файла, наименование которого передается в параметрах метода */
    protected void showHistoryFromFile(String historyFromFile) {
        try {
            /* Новый экземпляр файла из родительского абстрактного пути */
            File file = new File(historyFromFile);
            /* Открытие файла для чтения потока символов */
            FileReader fileReader = new FileReader(file);
            /* Чтение текста из потока символов, буферизуя прочитанные символы */
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            /* Если файл пустой, не содержит какой-либо информации */
            if (bufferedReader.ready()) {
                /* Чтение текста из файла, заканчивая последней строкой */
                while (bufferedReader.ready()) {
                    /* Отображение полученного текста из файла */
                    System.out.println(bufferedReader.readLine());
                }
            } else {
                /* Сообщение пользователю */
                System.out.print("The file is " + historyFromFile + " empty, does not contain any information.");
            }
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
    }
}
