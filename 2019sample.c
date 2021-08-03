#include <stdio.h>
#define N 8
#define MAX 100
int a[] = {2, 5, 9, 11, 4, 13, 18, 10};
void merge(int lo, int mid, int hi)
{
    int b[N + 1], c[N + 1], i, j, k;
    for (i = lo; i <= mid; i++)
    {
        b[i] = a[i];
    }
    for (j = mid + 1; j <= hi; j++)
    {
        c[j] = a[j];
    }
    b[i] = MAX + 1;
    c[j] = MAX + 1;
    i = lo;
    j = mid + 1;
    for (k = lo; k <= hi; k++)
    {
        if (b[i] <= c[j])
        { /***** (A) *****/
            a[k] = b[i++];
        }
        else
        {
            a[k] = c[j++];
        }
    }
    for (i = lo; i <= hi; i++)
    {
        printf("%3d", a[i]);
    }
    putchar('\n');
}
void merge_sort(int lo, int hi)
{
    if (lo < hi)
    {
        int mid = (lo + hi) / 2;
        merge_sort(lo, mid);
        merge_sort(mid + 1, hi);
        merge(lo, mid, hi);
    }
}
int main()
{
    merge_sort(0, N - 1);
}