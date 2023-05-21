package Calculator;

import java.util.Stack;
public class Controller {
    /* Экземляр класса Model */
    Model model = new Model();

    /* Основной метод Calculator, взаимодействующий с результатом */
    protected double calculator(String equation) {
        /* Получение результата работы калькулятора */
        double result = resultFromRPN(reversePolishNotation(equation));
        /* Передача уравнения и результаты работы калькулятора методу writerHistoryFromFile класса Model */
        model.writerHistoryFromFile(equation, result);
        /* Передача результата работы калькулятора и управления методу main класса View */
        return result;
    }

    /* Обратная польская запись (Reverse Polish notation, RPN) */
    private String reversePolishNotation(String equation) {
        /* Математические значения */
        StringBuilder value = new StringBuilder();
        /* Математические операции */
        Stack<Character> stack = new Stack<>();
        /* Приоритет математических операций и значений */
        int priority;

        /* Обработка приоритета математических операций и значений */
        for (int i = 0; i < equation.length(); i++) {
            /* Получение приоритета математических операций и значений */
            priority = getPriority(equation.charAt(i));
            /* Обработка математических операции с приоритетом -1 */
            if (priority == -1) {
                value.append(' ');
                while (getPriority(stack.peek()) != 1) {
                    value.append(stack.pop());
                }
            }
            /* Обработка математических значений с приоритетом 0 */
            if (priority == 0) {
                value.append(equation.charAt(i));
            }
            /* Обработка математических операции с приоритетом 1 */
            if (priority == 1) {
                stack.push(equation.charAt(i));
            }
            /* Обработка математических операции с приоритетом 2 и 3 */
            if (priority > 1) {
                value.append(' ');
                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority) {
                        value.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(equation.charAt(i));
            }
        }

        while (!stack.empty()) {
            value.append(stack.pop());
        }
        return value.toString();
    }

    /* Преобразование обратной польской запись в результат */
    private double resultFromRPN(String rpn) {
        /* Математические значения */
        StringBuilder value = new StringBuilder();
        /* Результат работы калькулятора */
        Stack<Double> stack = new Stack<>();

        /* Обработка приоритета математических операций и значений */
        for (int i = 0; i < rpn.length(); i++) {
            /* Если найден разделительный символ пробел, операции продолжаются */
            if (rpn.charAt(i) == ' ') {
                continue;
            }
            /* Обработка математических значений с приоритетом 0 */
            if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0) {
                    value.append(rpn.charAt(i++));
                    if (i == rpn.length()) {
                        break;
                    }
                }

                stack.push(Double.parseDouble(String.valueOf(value)));
                value = new StringBuilder();
            }
            /* Обработка математических операции с приоритетом 2 и 3 */
            if (getPriority(rpn.charAt(i)) > 1) {
                /* Математические значения */
                double firstValue = stack.pop(), secondValue = stack.pop();

                /* Математическая операция + */
                if (rpn.charAt(i) == '+') {
                    stack.push(secondValue + firstValue);
                }
                /* Математическая операция - */
                if (rpn.charAt(i) == '-') {
                    stack.push(secondValue - firstValue);
                }
                /* Математическая операция * */
                if (rpn.charAt(i) == '*') {
                    stack.push(secondValue * firstValue);
                }
                /* Математическая операция / */
                if (rpn.charAt(i) == '/') {
                    stack.push(secondValue / firstValue);
                }
                /* Математическая операция ^ */
                if (rpn.charAt(i) == '^') {
                    stack.push(Math.pow(secondValue, firstValue));
                }
                /* Математическая операция % */
                if (rpn.charAt(i) == '%') {
                    stack.push(secondValue % firstValue);
                }
            }
        }

        return stack.pop();
    }

    /* Формирование приоритета математических операций и значений */
    protected int getPriority(char symbol) {
        /* Математические операции с приоритетом 3 */
        if (symbol == '*' || symbol == '/' || symbol == '^' || symbol == '%') {
            return 3;
            /* Математические операции с приоритетом 2 */
        } else if (symbol == '+' || symbol == '-') {
            return 2;
            /* Математические операции с приоритетом 1 */
        } else if (symbol == '(') {
            return 1;
            /* Математические операции с приоритетом -1 */
        } else if (symbol == ')') {
            return -1;
            /* Математические значения [0-9] с приоритетом 0 */
        } else {
            return 0;
        }
    }
}
