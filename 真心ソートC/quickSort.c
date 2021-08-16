#include <stdio.h>
#define ARRAYLENGTH 17

int A[ARRAYLENGTH] = {8, 1, 4, 4, 13, 45, 2, 696, 5, 1, 1, 2, 6, 45, 82, 4, 9};

void confirm(int *A)
{
    for (int i = 0; i < ARRAYLENGTH; i++)
    {
        printf("%d，", A[i]);
    }
    printf("\n");
}

// ピボットは常に右端とする．
int change(int l, int r, int pivot)
{
    while (1)
    {
        while (A[l] < A[pivot])
        {
            l++;
        }

        while (A[pivot] <= A[r] && l <= r)
        {
            r--;
        }
        if (l < r)
        {
            int tmp = A[l];
            A[l] = A[r];
            A[r] = tmp;
        }
        else
        {
            int tmp = A[pivot];
            A[pivot] = A[l];
            A[l] = tmp;
            break;
        }
    }

    confirm(A);
    return l; // 整列済みのindex
}

void saiki(int l, int r)
{
    if (l < r)
    {
        int pivot = r;
        int p = change(l, r, pivot);
        saiki(0, p - 1);
        saiki(p + 1, r);
    }
}

int main()
{
    int count = 0;

    saiki(0, ARRAYLENGTH - 1);

    printf("比較回数：%d\n", count);

    return 0;
}
