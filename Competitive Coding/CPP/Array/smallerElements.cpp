 #include<bits/stdc++.h>

 using namespace std;

 vector<int> smallerNumbersThanCurrent(vector<int>& nums)
 {
        int n = nums.size();
        vector<int> res(n);
        set<pair<int, int>> s;
        for(int i = 0 ; i < nums.size() ; i++)
            s.insert({nums[i], i});

        int j = 0, cnt = 0;
        res[s.begin()->second] = 0;
        int prev = s.begin()->first;
        for(auto i = ++s.begin() ; i != s.end() ; i++)
        {
            if(i->first != prev)
            {
                j += cnt + 1;
                cnt = 0;
            }
            else
                cnt++;
            res[i->second] = j;
            prev = i->first;
        }

        return res;
}

int main()
{
    vector<int> arr = {8,1,2,2,3};
    vector<int> r = smallerNumbersThanCurrent(arr);

    for(int i = 0 ; i < 5 ; i++)
        cout<<r[i]<<" ";

    return 0;
}
