#include <stdio.h>
#define ARRAYLENGTH 10

int A[ARRAYLENGTH] = {0, 9, 6, 2, 1, 94, 12, 5, 64, 10};

void confirm(int *A)
{
    for (int i = 0; i < ARRAYLENGTH; i++)
    {
        printf("%d，", A[i]);
    }
    printf("\n");
}

void shift_down(int index, int endIndex)
{
    // 子供がいる場合
    if (2 * index + 1 <= endIndex)
    {
        int largeChildIndex = 2 * index + 1;
        // 右の子がいる場合
        if (2 * index + 2 <= endIndex)
        {
            if (A[2 * index + 1] < A[2 * index + 2])
            {
                largeChildIndex = 2 * index + 2;
            }
        }

        if (A[index] < A[largeChildIndex])
        {
            int tmp = A[index];
            A[index] = A[largeChildIndex];
            A[largeChildIndex] = tmp;
            shift_down(largeChildIndex, endIndex);
        }
    }
}

int build_heap()
{
    for (int i = ARRAYLENGTH / 2 - 1; 0 <= i; i--)
    {
        shift_down(i, ARRAYLENGTH - 1);
    }
}

int main()
{
    build_heap();

    for (int i = 1; i < ARRAYLENGTH; i++)
    {
        int tmp = A[ARRAYLENGTH - i];
        A[ARRAYLENGTH - i] = A[0];
        A[0] = tmp;

        shift_down(0, ARRAYLENGTH - i - 1);
        confirm(A);
    }

    return 0;
}
