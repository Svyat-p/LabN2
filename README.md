# LabN2
## Отчет по лабораторной работе № 2

#### № группы: `ПМ-2402`

#### Выполнил: `Бронников Святослав Викторович`

#### Вариант: `4`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Напишите программу на Java, которая выполняет следующие действия
> с квадратным двумерным массивом целых чисел:
> 1. Считывает с консоли размер массива N, затем элементы массива
> размером N × N.
> 2. Сортирует элементы главной диагонали по возрастанию, не затрагивая остальные элементы, затем сортирует элементы побочной
> диагонали по убыванию. Далее заменяет элемент на пересечении
> диагоналей на их среднее арифметическое.
> 3. Находит сумму элементов на главной и побочной диагоналях, а
> также разницу между этими суммами.
> 4. Выводит все диагонали массива (ниже главной, главную, выше
> главной).
> 5. Определяет и выводит индексы строки и столбца, при вычеркивании которых сумма всех элементов новой матрицы будет максимальной. Дополнительно выводит саму новую матрицу.

Данную задачу можно разделить на несколько подзадач:

1) Ввод размеров массива и его элементов
2) Сортировка элементов главной диагонали
3) Сортировка элементов побочной диагонали
4) Нахождение сумм элементов главной и побочной диагонали
5) Расчет среднего арифметического элементов обоих диагоналей
6) Замена элемента на пересечении диагоналей на их среднее арифметическое
7) Нахождение разницы между суммами элементов диагоналей
8) Вывод всех диагоналей массива (ниже главной, главную, выше главной)
9) Определение индексов строки и столбца с наименьшей суммой
10) Удаление этой строки и столбца и вывод новой матрицы

### 2. Входные и выходные данные

#### Данные на вход

На вход программа получает одно натуральное число(так как размер массива не может быть не целым или отрицательным) - размер двумерного размера. Далее вводятся элементы массива - по условию целые числа.
|        | Тип              | min значение    | max значение     |
|--------|------------------|-----------------|------------------|
|    N   | Натуральное число| 1               | 2<sup>31</sup>-1 |
| a[i][j]| Целое число      | -2<sup>31</sup> | 2<sup>31</sup>-1 |
