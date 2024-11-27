import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        out.println("Ведите N");
        int N = in.nextInt();
        if (N <= 0){
            out.print("Недопустимый размер массива: ");
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
        int smin;
        int scom;
//        Создание вспомогательных переменных
        out.println("Введите элементы массива: ");
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

        smin = sumstr + sumcol - a[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumstr = 0;
                sumcol = 0;
                for (int k = 0; k < N; k++) {
                    sumstr += a[i][k];
                    sumcol += a[k][j];
                }
                scom = sumstr + sumcol - a[i][j];
                if (scom < smin){
                    smin = scom;
                    indstr = i;
                    indcol = j;
                }
            }
        }

//        Нахождение индексов строки и столбца, при вычеркивании которых сумма останется максимальной
        out.println("Индекс строки, при вычеркивании которой сумма останется максимальной: " + indstr);
        out.println("Индекс столбца, при вычеркивании которого сумма останется максимальной: " + indcol);
        out.println();
        out.println("Новая матрица: ");
        for (int i = 0; i < N; i++) {
            if (i != indstr)
                out.println();
            for (int j = 0; j < N; j++)
                if (i != indstr && j != indcol)
                    out.print(a[i][j] + " ");
        }
//        Вывод новой матрицы без найденных строки и столбца
    }
}
