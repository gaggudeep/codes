#include<bits/stdc++.h>

using namespace std;

bool isGapPossible(int *a, int n, int x, int len)
{
    int cowCount = 1, lastPos = a[0];
    for(int i = 1 ; i < len ; i++)
    {
        if(a[i] - lastPos >= x)
        {
            if(++cowCount == n)
                return true;
            lastPos = a[i];
        }
    }

    return false;
}

int largestMinGap(int *a, int len, int n)
{
    sort(a, a + len);
    int low = 0, high = len - 1, mid, maxGap = 0;
    while(low <= high)
    {
        mid = low - (low - high) / 2;
        if(isGapPossible(a, n, mid, len))
        {
            low = mid + 1;
            maxGap = mid;
        }
        else
        {
            high = mid - 1;
        }
    }

    return maxGap;
}

int main()
{
    int a[] = {1, 2, 8, 4, 9};
    cout<<largestMinGap(a, 5, 3);
}
