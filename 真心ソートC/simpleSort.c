#include <stdio.h>
#define ARRAYLENGTH 5

void confirm(int *A)
{
    for (int i = 0; i < ARRAYLENGTH; i++)
    {
        printf("%d，", A[i]);
    }
    printf("\n");
}

int main()
{
    int count = 0;
    int A[ARRAYLENGTH] = {8, 1, 13, 2, 9};
    for (int i = 0; i < ARRAYLENGTH - 1; i++)
    {
        for (int j = i + 1; j < ARRAYLENGTH; j++)
        {
            count++;
            if (A[j] < A[i]) // 比較回数はARRAYLENGTH-1 + ARRAYLENGTH-2 + .... + 1
            {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            confirm(A);
        }
    }
    printf("比較回数：%d\n", count);

    return 0;
}
