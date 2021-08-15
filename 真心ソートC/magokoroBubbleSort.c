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

    for (int j = 1; j < ARRAYLENGTH; j++)
        for (int i = 0; i < ARRAYLENGTH - j; i++)
        {
            count++;
            if (A[i + 1] < A[i])
            {
                int tmp = A[i];
                A[i] = A[i + 1];
                A[i + 1] = tmp;
            }
            confirm(A);
        }

    printf("比較回数：%d\n", count);

    return 0;
}
