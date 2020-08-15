#include<bits/stdc++.h>

using namespace std;

bool canArraysBeEqual(int *a, int *b, int n)
{
    unordered_map<int, int> freq;

    for(int i = 0 ; i < n ; i++)
    {
        freq[a[i]]++;
        freq[b[i]]--;
    }
    for(auto i : freq)
    {
        if(i.second)
            return false;
    }

    return true;
}

int main()
{
    int a[] = {3,7,9};
    int b[] = {3,7,11};
    cout<<canArraysBeEqual(a, b, 3);

    return 0;
}
