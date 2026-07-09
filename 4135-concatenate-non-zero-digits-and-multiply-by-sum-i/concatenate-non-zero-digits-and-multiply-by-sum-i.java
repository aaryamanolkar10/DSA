class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        while (n > 0) {
            int last = n % 10;
            if (last != 0) {
                sum += last;
                sb.append(last);
            }
            n = n / 10;
        }
        if(sb.length()==0) return 0;
        
        long result = Long.parseLong(sb.reverse().toString()) * sum;
        return result;
    }
}