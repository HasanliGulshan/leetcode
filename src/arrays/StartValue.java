package arrays;

public class StartValue {
    public int minStartValue(int[] nums) {
        int ans=1;
        while(true)
        {
            int sum = ans;
            boolean f = true;
            for(int j : nums)
            {
                if((sum+=j)<1)
                {
                    f=false;
                    break;
                }
            }
            if(f)
                return ans;
            ans++;
        }
    }
}

