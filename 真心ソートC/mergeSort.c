#include <stdio.h>
#define ARRAYLENGTH 8

int A[ARRAYLENGTH] = {8, 1, 4, 4, 13, 5, 2, 6};
int B[ARRAYLENGTH];

void confirm()
{
    for (int i = 0; i < ARRAYLENGTH; i++)
    {
        printf("%d，", B[i]);
    }
    printf("\n");
}

// left: 分割した左の配列の左端
// right: 分割した右の配列の右端
int merge(int left, int right, int split)
{
    int l = left;
    int r = split + 1;
    int k = left;

    while (l <= split && r <= right)
    {
        if (A[l] < A[r])
        {
            B[k] = A[l];
            l++;
        }
        else
        {
            B[k] = A[r];
            r++;
        }
        k++;
    }

    while (split < l && r <= right)
    {
        B[k] = A[r];
        r++;
        k++;
    }

    if (right < r && l <= split)
    {
        B[k] = A[l];
        l++;
        k++;
    }

    for (int i = left; i <= right; i++)
    {
        A[i] = B[i];
    }
    confirm();
}

void partition(int left, int right) // 引数はindex
{
    if (left != right)
    {
        int split = (left + right) / 2;
        // 左の分割
        partition(left, split);
        // 右の分割
        partition(split + 1, right);
        merge(left, right, split);
    }
}

int main()
{
    partition(0, ARRAYLENGTH - 1);
    confirm();
    return 0;
}
