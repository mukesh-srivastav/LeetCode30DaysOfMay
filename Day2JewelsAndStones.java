class Day2JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int c = 0;
        for (int i=0; i<S.length(); i++) {
            if (J.indexOf(S.charAt(i)) >= 0)
                c++;
        }
        
        return c;
    }
}