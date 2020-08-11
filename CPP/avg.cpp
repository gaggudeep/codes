#include<iostream>

using namespace std;
int main()
{
    int no , count_p = 0 , count_n = 0 , p = 1 , n = 1;
    float avg_p = 0 , avg_n = 0;
    cout<<"\nEnter number of numbers you want to add to the list: ";
    cin>>no;
    int a[n];
    cout<<"\nEnter values:-\n";
    for ( int i = 0 ; i < no ; i++ )
    {
        cin>>a[i];
        if ( a[i] >= 0)
        {
            avg_p += a[i];
            count_p++;
        }
        else
        {
            avg_n += a[i];
            count_n++;
        }
    }
    cout<<"\nAverage of positive numbers in the list: "<<( avg_p / count_p );
    cout<<"\nAverage of negative numbers in the list: "<<( avg_n / count_n );
}
