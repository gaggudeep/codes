public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int dp1 = 1, dp2 = s.charAt(0) != '0' ? 1 : 0, dp = 0;
        if(s.length() == 1)
            return dp2;
        for(int i = 2 ; i <= s.length() ; i++) {
            dp = 0;
            int single = Integer.parseInt(s.substring(i - 1, i)), two =                 Integer.parseInt(s.substring(i - 2, i));
            if(single >= 1 && single <= 9)
                dp += dp2;
            if(two >= 10 && two <= 26)
                dp += dp1;
            dp1 = dp2;
            dp2 = dp;
        }
        return dp;
    }