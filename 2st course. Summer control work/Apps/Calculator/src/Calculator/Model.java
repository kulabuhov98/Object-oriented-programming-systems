package Calculator;

import java.io.*;

public class Model {
    /* Наименование файла с историей уравнений */
    public static final String FILE_HISTORY_OF_EQUATIONS = "equations.txt";
    /* Наименование файла с историей результатов работы калькулятора */
    public static final String FILE_HISTORY_OF_RESULTS = "results.txt";

    /* Запись информации в файл */
    protected void writerHistoryFromFile(String equation, Double result) {
        try {
            /* Новый экземпляр файла с историей уравнений из родительского абстрактного пути */
            File fileHistoryOfEquations = new File(FILE_HISTORY_OF_EQUATIONS);
            /* Новый экземпляр файла с историей результатов работы калькулятора из родительского абстрактного пути */
            File fileHistoryOfResults = new File(FILE_HISTORY_OF_RESULTS);

            /* Если файл с историей уравнений не существует, он создается */
            if (!fileHistoryOfEquations.exists()) {
                fileHistoryOfEquations.createNewFile();
            }
            /* Если файл с историей результатов работы калькулятора не существует, он создается */
            if (!fileHistoryOfResults.exists()) {
                fileHistoryOfResults.createNewFile();
            }

            /* Открытие файла с историей уравнений для записи потока символов */
            FileWriter fileWriterHistoryOfEquations = new FileWriter(fileHistoryOfEquations, true);
            /* Открытие файла с историей результатов работы калькулятора для записи потока символов */
            FileWriter fileWriterHistoryOfResults = new FileWriter(fileHistoryOfResults, true);

            /* Запись текста в поток символов файла с историей уравнений, буферизуя записанные символы */
            BufferedWriter bufferedWriterHistoryOfEquations = new BufferedWriter(fileWriterHistoryOfEquations);
            /* Запись текста в поток символов файла с историей результатов работы калькулятора, буферизуя записанные символы */
            BufferedWriter bufferedWriterHistoryOfResults = new BufferedWriter(fileWriterHistoryOfResults);

            /* Запись уравнения в файл с историей уравнений */
            bufferedWriterHistoryOfEquations.write(equation);
            /* Запись результата в файл с историей результатов работы калькулятора */
            bufferedWriterHistoryOfResults.write(String.valueOf(result));

            /* Перевод курсора в файле с историей уравнений на новую строку */
            bufferedWriterHistoryOfEquations.newLine();
            /* Перевод курсора в файле с историей результатов работы калькулятора на новую строку */
            bufferedWriterHistoryOfResults.newLine();

            /* Передача данных из buffer во writer */
            bufferedWriterHistoryOfEquations.flush();
            /* Передача данных из buffer во writer */
            bufferedWriterHistoryOfResults.flush();

            /* Закрытие потока данных */
            bufferedWriterHistoryOfEquations.close();
            /* Закрытие потока данных */
            bufferedWriterHistoryOfResults.close();
        } catch (Exception e) {
            /* Сообщение пользователю */
            System.out.println(e.getMessage());
        }
    }

    /* Получение информации из файла, наименование которого передается в параметрах метода */
    protected void showHistoryFromFile(String historyFromFile) {
        try {
            /* Новый экземпляр файла из родительского абстрактного пути */
            File file = new File(historyFromFile);
            /* Открытие файла для чтения потока символов */
            FileReader fileReader = new FileReader(file);
            /* Чтение текста из потока символов, буферизуя прочитанные символы */
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            /* Если файл не пустой, содержит какую-либо информацию */
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
