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
    int A[ARRAYLENGTH] = {8, 1, 13, 2, 9};

    // i: 今から正しい位置に持っていきたい数の入っているindex
    for (int i = 1; i < ARRAYLENGTH; i++)
    {
        int j = i - 1;
        int tmp = A[i];

        while (0 <= j && tmp < A[j])
        {
            A[j + 1] = A[j];
            j--;
        }

        A[j + 1] = tmp;
    }
    confirm(A);

    return 0;
}
