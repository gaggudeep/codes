#include<bits/stdc++.h>

using namespace std;

int largestContSum(int * a, int n)
{
    int maxSum = INT_MIN, endIdxSum = 0;
    for(int i = 0 ; i < n ; i++)
    {
        endIdxSum += a[i];
        maxSum = max(maxSum, endIdxSum);
        if(endIdxSum < 0)
            endIdxSum = 0;
    }

    return maxSum;
}

int main()
{
    int a[] = {-2, -3, 5, -3, 3, -4};
    cout<<largestContSum(a, 6);
}
