class ReverseInt {
    public int reverse(int x) {
        int ans = 0;
        int temp = 0;
        while (x != 0) {
            temp = temp * 10 + x % 10;
            if (temp / 10 != ans) return 0;
            ans = temp;
            x /= 10;
        }
        return ans;
    }
}
