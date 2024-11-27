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

#### Данные на выход

Программа выводит все диагонали массива(ниже главной, главную, выше главной).
Также программа выводит индексы строки и столбца(целые, неотрицательные числа), при вычеркивании которых сумма всех элементов новой матрицы будет максимальной. Дополнительно выводит саму новую матрицу.

|               | Тип    | 
|---------------|--------|
| Диагонали     | Int    | 
| Целые числа   | Int    | 
| Массив        | Int    | 

### 3. Математическая модель

1. Среднее арифметическое = $`\frac{(x_1 + x_2 + ... + x_n)}{n}`$, где $`x_i`$- элемент последовательности, а n- количество элементов последовательности

### 4. Выбор структуры данных

Программа получает на вход натуральное число, для которго можно выделить переменную `N` типа `int`. После этого на вход подаются целые числа, из которых состоит массив. Создадим для них массив `a` типа `int`.
Для решения задачи также потребуются вспомогательные переменные для хранения сумм элементов диагоналей и разницы между ними(`sum`, `sum2` и `diff`) типа `int`, элемента на пересечении диагоналей(`middle`) типа `int`, сумм элементов строк и столбцов(`sum`) типа `int`, элементов диагоналей(`te`) типа `int`, индексов элементов массива(`i1` и `j1`) типа `int, суммы строк и столбцов(`sumstr` и `sumcol`) типа `int`, индексов строк и столбцов(`indstr` и `indcol`) типа `int`, среднего арифметического диагоналей(`srar`) типа `int`.
|       | название переменной | Тип (в Java) | 
|-------|---------------------|--------------|
| Число | `N`                 | `int`        |
| Число | `sum1`              | `int`        |
| Число | `sum2`              | `int`        |
| Число | `diff`              | `int`        |
| Число | `middle`            | `int`        |
| Число | `te`                | `int`        |
| Число | `sum`               | `int`        |
| Число | `j1`                | `int`        |
| Число | `i1`                | `int`        |
| Число | `sumstr`            | `int`        |
| Число | `sumcol`            | `int`        |
| Число | `indstr`            | `int`        |
| Число | `indcol`            | `int`        |
| Число | `srar`              | `double`     |
| Массив| `a`                 | `int`        |

### 5. Алгоритм

#### Алгоритм выполнения программы:

1. **Ввод данных:**
   Программа считывает натуральное число `N`. Далее считывает элементы массива `a`.
2. **Сортировка элементов главной диагонали по возрастанию, сортировка элементов побочной диагонали по убыванию:**
   Программа сортирует элементы диагоналей с помощью метода "пузырька".
3. **Нахождение суммы элементов на главной и побочной диагоналях, а также разницы между этими суммами:**
   Программа находит суммы элементов главной `sum1` и побочной `sum2` диагоналей и разницу между ними `diff`.
4. **Замена элемента на пересечении диагоналей на их среднее арифметическое:**
   Программа находит среднее арифметическое диагоналей `srar` и заменяет элемент на пересечении диагоналей(если он есть) на `srar`.
5. **Вывод всех диагоналей массива (ниже главной, главную, выше главной):**
   При помощи циклов программа выводит сначала диагонали, находящиеся ниже главной, потом главную, потом выше главной.
6. **Определение и вывод индексов строки и столбца, при вычеркивании которых сумма всех элементов новой матрицы будет максимальной:**
   Программа при помощи циклов находит индексы строки `indstr` и столбца `indcol` с минимальными суммами элементов.
7. **Вывод новой матрицы:**
   Программа выводит массив без строки с индексом `indstr` и столбца с индексом `indcol`.

### 6. Программа

```java
import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        int N = in.nextInt();
        if (N < 0){
            out.print("Недопустимый размер массива");
            System.exit(0);
        }
        int sum1 = 0;
        int sum2 = 0;
        int diff;
        double srar;
        int middle = 0;
        int [][] a = new int [N][N];
        int te;
        int sum;
        int j1;
        int i1;
        int sumstr = 0;
        int sumcol = 0;
        int indstr = 0;
        int indcol = 0;
//        Создание вспомогательных переменных
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = in.nextInt();
//        Ввод элементов массива
        for (int k = 0; k < N - 1; k++)
            for (int i = 0; i < N - 1 - k; i++)
                if (a[i][i] > a[i + 1][i + 1]) {
                    te = a[i][i];
                    a[i][i] = a[i + 1][i + 1];
                    a[i + 1][i + 1] = te;
                }
//        Сортировка элементов главной диагонали
        for (int k = 0; k < N - 1; k++)
            for (int i = 0; i < N - 1 - k; i++)
                if (a[N - i - 1][i] > a[N - i - 2][i + 1]) {
                    te = a[N - i - 1][i];
                    a[N - i - 1][i] = a[N - i - 2][i + 1];
                    a[N - i - 2][i + 1] = te;
                }
//        Сортировка элементов побочной диагонали
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (i == j)
                    sum1 += a[i][j];
                if (i == N - j - 1)
                    sum2 += a[i][j];
                if (i == N - j - 1 && i == j)
                    middle = a[i][j];
            }
//        Нахождение сумм элементов диагоналей и элемента на пересечении диагоналей
        srar = (double)(sum1 + sum2 - middle) / (2 * N - 1);
        diff = Math.abs(sum1 - sum2);
//        Нахождение среднего арифметического двух диагоналей и разницы между суммами диагоналей
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (i == N - j - 1 && i == j)
                    a[i][j] = (int)srar;
            }
//        Замена элемента, находящегося на пересечении диагоналей на среднее арифметическое этих диагоналей
        if (N % 2 != 0){
            sum1 = sum1 - middle + (int)srar;
            sum2 = sum2 - middle + (int)srar;
        }
//        Нахождение сумм элементов новых диагоналей

        out.println("Диагонали массива: ");

        for (int i = 1; i < N; i++){
            j1 = 0;
            i1 = i;
            while (i1 < N && j1 < N){
                out.print(a[i1][j1] + " ");
                j1++;
                i1++;
            }
            out.println();
        }
//        Вывод диагоналей ниже главной
        for (int i = 0; i < N; i++)
            out.print(a[i][i] + " ");

        out.println();
//        Вывод главной диагонали
        for (int i = 1; i < N; i++){
            i1 = 0;
            j1 = i;
            while (i1 < N && j1 < N){
                out.print(a[i1][j1] + " ");
                j1++;
                i1++;
            }
            out.println();
        }
//        Вывод диагоналей выше главной

        for (int k = 0; k < N; k++)
            sumstr += a[0][k];
//        Нахождение суммы элементов первой строки
        for (int l = 0; l < N; l++)
            sumcol += a[l][0];
//        Нахождение суммы элементов первого столбца

        for (int j = 0; j < N; j++) {
            sum = 0;
            for (int i = 0; i < N; i++)
                sum += a[i][j];
            if (sum < sumcol){
                sumcol = sum;
                indcol = j;
            }
        }
        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < N; j++) {
                sum += a[i][j];
            }
            if (sum < sumstr){
                sumstr = sum;
                indstr = i;
            }
        }
//        Нахождение индексов строки и столбца, при вычеркивании которых сумма останется максимальной
        out.println("Индекс строки, при вычеркивании которой сумма останется максимальной: " + indstr);
        out.println("Индекс столбца, при вычеркивании которого сумма останется максимальной: " + indcol);
        out.println();
        out.println();
        out.println();
        out.println("Новая матрица: ");
        for (int i = 0; i < N; i++) {
            out.println();
            for (int j = 0; j < N; j++)
                if (i != indstr && j != indcol)
                    out.print(a[i][j] + " ");
        }
//        Вывод новой матрицы без найденных строки и столбца
    }
}
```
