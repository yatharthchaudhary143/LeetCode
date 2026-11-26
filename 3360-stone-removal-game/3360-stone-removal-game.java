class Solution {
    public boolean canAliceWin(int n) {
        if (n<10) return false;
        int n2=10;
        boolean flag=true;
        n=n-n2;
        n2--;

        while (n>=n2){
            n=n-n2;
            n2--;
            flag=!flag;
        }

        return flag;


    }
}