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

    for (int j = 0; j < ARRAYLENGTH; j++)
        for (int i = ARRAYLENGTH - 1; j < i; i--)
        {
            count++;
            if (A[i] < A[i - 1]) // 比較回数はARRAYLENGTH-1 + ARRAYLENGTH-2 + .... + 1
            {
                int tmp = A[i - 1];
                A[i - 1] = A[i];
                A[i] = tmp;
            }
            confirm(A);
        }

    printf("比較回数：%d\n", count);

    return 0;
}
