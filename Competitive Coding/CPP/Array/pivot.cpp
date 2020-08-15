#include<bits/stdc++.h>

using namespace std;

int pivotElement(int *a, int n)
{
    int sum = 0;
    for(int i = 0 ; i < n ; i++)
        sum += a[i];
    int leftSum = 0;
    for(int i = 0 ; i < n ; i++)
    {
        if(2 * leftSum == sum - a[i])
            return i;
        leftSum += a[i];
    }

    return -1;
}

int main()
{
    int a[] = {1, 1, -1, 1 , 1};
    cout<<pivotElement(a, 5);

    return 0;
}
