#include<bits/stdc++.h>

using namespace std;

void rotate(vector<int>& nums, int k)
{

        int n = nums.size(), cnt = 0;

        for(int i = 0 ; cnt < n ; i++)
        {
            int cur = i;
            int prev = nums[i];
            do
            {
                int next = (k + cur) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                cnt++;
            }while(cur != i);
        }
}

int main()
{
    vector<int> arr = {1, 2, 3, 4};
    rotate(arr, 2);
    for(int i = 0 ; i < 4 ; i++)
        cout<<arr[i]<<" ";

    return 0;
}
