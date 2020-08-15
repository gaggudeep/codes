#include<bits/stdc++.h>

using namespace std;

int maxFamilyCount(vector<vector<int>> reservedSeats, int n)
{
    int cnt = 2 * n;
    unordered_map<int, vector<int>> seats;
    for(auto r : reservedSeats)
        seats[r[0]].push_back(r[1]);

    for(auto s : seats)
    {
        bool l = false, m = false, r = false;
        for(auto c : s.second)
        {
            if(1 < c && c < 6) l = true;
            if(3 < c && c < 8) m = true;
            if(5 < c && c < 10) r = true;
        }
        if(l) cnt--;
        if(r) cnt--;
        if(l && r && !m) cnt++;
    }

    return cnt;
}

int main()
{
    vector<vector<int>> a = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
    cout<<maxFamilyCount(a, 3);

    return 0;
}
