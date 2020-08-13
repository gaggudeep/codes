#include<bits/stdc++.h>

using namespace std;

vector<int> shuffle(vector<int>& nums, int n)
{
        for(int i = 2 * n - 1 ; i > 0 ; i--)
        {
            int k = i;
            do
            {
                if(k % 2 == 1)
                    k = k / 2 + n;
                else
                    k /= 2;
            }while(k > i);
            int t = nums[k];
            nums[k] = nums[i];
            nums[i] = t;
        }

        return nums;
}

int main()
{
    vector<int> arr = {1,2,3,4};
    shuffle(arr, 2);
    for(int i = 0 ; i < 4 ; i++)
        cout<<arr[i]<<" ";
}
