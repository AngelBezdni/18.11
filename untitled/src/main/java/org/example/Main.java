package org.example;
import java.util.Objects;

import java.util.Objects;

public class Main {

    // Метод для обработки пары
    public static <T, U> String processPair(Pair<T, U> pair) {
        if (pair == null || pair.getFirst() == null || pair.getSecond() == null) {
            throw new IllegalArgumentException("Пара или её элементы не должны быть null");
        }

        // Проверяем типы элементов пары
        if ((pair.getFirst() instanceof Number) && (pair.getSecond() instanceof Number)) {
            // Если оба элемента пары - числа, возвращаем их сумму
            double sum = ((Number) pair.getFirst()).doubleValue() + ((Number) pair.getSecond()).doubleValue();
            return Double.toString(sum);
        } else if ((pair.getFirst() instanceof CharSequence) && (pair.getSecond() instanceof CharSequence)) {
            // Если оба элемента - строки, выполняем конкатенацию
            return Objects.toString(pair.getFirst()) + Objects.toString(pair.getSecond());
        } else {
            return "Невозможно обработать данную пару";
        }
    }

    // Пример использования
    public static void main(String[] args) {
        Pair<Integer, Integer> intPair = new Pair<>(10, 20);
        System.out.println(processPair(intPair)); // Ожидаемый результат: "30"

        Pair<String, String> stringPair = new Pair<>("Hello", "World!");
        System.out.println(processPair(stringPair)); // Ожидаемый результат: "HelloWorld!"

        // Пример с разными типами
        Pair<Double, Integer> mixedPair = new Pair<>(12.34, 56);
        System.out.println(processPair(mixedPair)); // Ожидаемый результат: "68.34"

        // Неподдерживаемый случай
        Pair<Boolean, Boolean> boolPair = new Pair<>(true, false);
        System.out.println(processPair(boolPair)); // Ожидаемый результат: "Невозможно обработать данную пару"
    }
}