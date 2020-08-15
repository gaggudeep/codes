#include<bits/stdc++.h>

using namespace std;

void rotate90(vector<vector<int>> &a)
{
    int n = a.size();
    for(int i = 0 ; i < n / 2 ; i++)
    {
        for(int j = i ; j < n - i - 1 ; j++)
        {
            int temp = a[i][j];
            a[i][j] = a[n - 1 - j][i];
            a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
            a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
            a[j][n - 1 - i] = temp;
        }
    }
}

int main()
{
    vector<vector<int>> a = {{1, 2}, {3, 4}};
    rotate90(a);
    for(int i = 0 ; i < 2 ; i++)
    {
        for(int j = 0 ; j < 2 ; j++)
            cout<<a[i][j]<<" ";
        cout<<endl;
    }

    return 0;
}
