#include<bits/stdc++.h>

using namespace std;

int majorityElement(int *a, int n)
{
    int maj = 0, cnt = 0;
    for(int i = 0 ; i < n ; i++)
    {
        if(cnt == 0)
            maj = a[i];
        cnt += maj == a[i] ? 1 : -1;
    }

    return maj;
}

int main()
{
    int a[] = {1,3,2,6,3,3,3};
    cout<<majorityElement(a, 7);

    return 0;
}
