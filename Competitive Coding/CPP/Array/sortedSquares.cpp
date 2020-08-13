#include<bits/stdc++.h>

using namespace std;

vector<int> sortedSquares(vector<int>& A)
{
        vector<int> res;
        int n = A.size(), negIdx = 0;

        while(negIdx < n && A[negIdx] < 0)
            negIdx++;
        int posIdx = negIdx;
        --negIdx;
        while(posIdx < n && negIdx >= 0)
        {
            int negSqr = A[negIdx] * A[negIdx], posSqr = A[posIdx] * A[posIdx];
            if(posSqr < negSqr)
            {
                res.push_back(posSqr);
                posIdx++;
            }
            else
            {
                res.push_back(A[negIdx] * A[negIdx]);
                negIdx--;
            }
        }
        while(negIdx >= 0)
        {
            res.push_back(A[negIdx] * A[negIdx]);
            negIdx--;
        }
        while(posIdx < n)
        {
            res.push_back(A[posIdx] * A[posIdx]);
            posIdx++;
        }

        return res;
}

int main()
{
    vector<int> arr = {-4, -3, -1, 0, 1, 3, 6};
    vector<int> res = sortedSquares(arr);
    for(int i = 0 ; i < 7 ; i++)
        cout<<res[i]<<" ";
}
