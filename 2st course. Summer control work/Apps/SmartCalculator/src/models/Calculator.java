package models;

import java.util.Stack;

public class Calculator {
    /* Получение результата работы приложения */
    public double main(String expression) {
        return resultFromRPN(reversePolishNotation(expression));
    }

    /* Обратная польская запись (Reverse Polish notation, RPN) */
    private String reversePolishNotation(String expression) {
        /* Математические значения */
        StringBuilder value = new StringBuilder();
        /* Математические операции */
        Stack<Character> stack = new Stack<>();
        /* Приоритет математических операций и значений */
        int priority;
        /* Обработка математической операции: деление без остатка с использованием // */
        expression = expression.replaceAll("//", "|");
        /* Обработка математической операции: возведение в степень с использованием ** */
        expression = expression.replaceAll("\\*\\*", "^");
        /* Обработка приоритета математических операций и значений */
        for (int i = 0; i < expression.length(); i++) {
            /* Получение приоритета математических операций и значений */
            priority = getPriority(expression.charAt(i));

            switch (priority) {
                /* Обработка математических операции с приоритетом -1 */
                case -1 -> {
                    value.append(' ');
                    while (getPriority(stack.peek()) != 1) {
                        value.append(stack.pop());
                    }
                    stack.pop();
                }
                /* Обработка математических значений с приоритетом 0 */
                case 0 -> value.append(expression.charAt(i));
                /* Обработка математических операции с приоритетом 1 */
                case 1 -> stack.push(expression.charAt(i));
                /* Обработка математических операции с приоритетом 2 и 3 */
                default -> {
                    value.append(' ');
                    while (!stack.empty()) {
                        if (getPriority(stack.peek()) >= priority) {
                            value.append(stack.pop());
                        } else {
                            break;
                        }
                    }
                    stack.push(expression.charAt(i));
                }
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

                switch (rpn.charAt(i)) {
                    /* Математическая операция: сложение */
                    case '+' -> stack.push(secondValue + firstValue);

                    /* Математическая операция: вычитание */
                    case '-' -> stack.push(secondValue - firstValue);

                    /* Математическая операция: умножение */
                    case '*' -> stack.push(secondValue * firstValue);

                    /* Математическая операция: деление */
                    case '/' -> stack.push(secondValue / firstValue);

                    /* Математическая операция: возведение в степень */
                    case '^' -> stack.push(Math.pow(secondValue, firstValue));

                    /* Математическая операция: деление без остатка */
                    case '|' -> stack.push((double)((int)Math.round(secondValue) / (int)Math.round(firstValue)));

                    /* Математическая операция: остаток от деления */
                    case '%' -> stack.push(secondValue % firstValue);
                }
            }
        }
        return stack.pop();
    }

    /* Формирование приоритета математических операций и значений */
    private int getPriority(char symbol) {
        return switch (symbol) {
            /* Математические операции с приоритетом 3 */
            case '*', '/', '^', '%', '|' -> 3;
            /* Математические операции с приоритетом 2 */
            case '+', '-' -> 2;
            /* Математические операции с приоритетом 1 */
            case '(' -> 1;
            /* Математические операции с приоритетом -1 */
            case ')' -> -1;
            /* Математические значения [0-9] с приоритетом 0 */
            default -> 0;
        };
    }
}
