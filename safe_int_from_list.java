package com.javarush.task.task10.task1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
@airoo
Безопасное извлечение из списка
Создать список целых чисел.
Ввести с клавиатуры 20 целых чисел.
Создать метод по безопасному извлечению чисел из списка:
int safeGetElement(ArrayList<Integer> list, int index, int defaultValue)
Метод должен возвращать элемент списка (list) по его индексу (index).
Если в процессе получения элемента возникло исключение, его нужно перехватить, и метод должен вернуть defaultValue.

Требования:
1. Программа должна считывать 20 чисел с клавиатуры.
2. Программа должна выводить данные на экран.
3. Метод safeGetElement должен возвращать элемент списка по индексу, если исключений внутри метода не возникло.
4. Метод safeGetElement должен возвращать defaultValue, если возникло исключений внутри метода. Исключение перехватить.
5. Метод safeGetElement не должен кидать исключения.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //заносим значение в список
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            int x = Integer.parseInt(reader.readLine());
            list.add(x);
        }
        //используем метод safeGetElement чтобы получить элемент из списка по индексу
        System.out.println(safeGetElement(list, 5, 1));
        System.out.println(safeGetElement(list, 20, 7));
        System.out.println(safeGetElement(list, -5, 9));
        System.out.println(safeGetElement(list, -5, 9));
    }

    public static int safeGetElement(ArrayList<Integer> list, int index, int defaultValue) {
        try{ 
            //здесь код, который потенциально может привести к ошибке
            int i = list.get(index); // получаем объект по индексу
            return i; //возвращаем из функции значение
        }
        //здесь описываются действия, направленные на обработку исключений 
        catch (ArithmeticException e) { //в скобках указывается класс конкретной ожидаемой ошибки  
            System.out.println("Произошла недопустимая арифметическая операция");
            return defaultValue;
        } catch (ArrayIndexOutOfBoundsException e) { 
            System.out.println("Обращение по недопустимому индексу массива"); 
            return defaultValue;
        } catch (Exception e) {
            System.out.println("Произошло ещё какое-то исключение"); 
            return defaultValue;
        }
        finally{ 
            //выполняется в любом случае ( блок finnaly не обязателен) 
        }
    }
}
