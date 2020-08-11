#include<iostream>

using namespace std;

void sumN(int n)
{
    int sum = 0;

    for(int i = 0 ; i < n ; i++)
    {
        int t;
        cin>>t;

        sum += t;
    }

    cout<<"\nSum: "<<sum<<'\n';

}

int main()
{
    int n;
    cin>>n;

    sumN(n);

    return 0;
}
