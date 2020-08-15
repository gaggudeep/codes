#include<bits/stdc++.h>

using namespace std;

bool isMonotonic(int *a, int n)
{
    bool inc = true, dec = true;
    for(int i = 0 ; i < n - 1 ; i++)
    {
        if(a[i] < a[i + 1])
            dec = false;
        else if(a[i] > a[i + 1])
            inc = false;
        if(!inc && !dec)
            return false;
    }

    return true;
}

int main()
{
    int a[] = {1, 2, 3, 3, 5};
    cout<<isMonotonic(a, 5);

    return 0;
}
