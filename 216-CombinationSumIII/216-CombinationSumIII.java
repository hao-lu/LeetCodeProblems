public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List <List<Integer>> combinations = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if ( k > n)
            return combinations;
        if (k == 1 && n <= 9) 
            list.add(n);
        
        int temp = 0, rem = n;
        for (int i = 1; i <= 9 && list.size() < 3; i++) {
            rem = rem - i;
            if (k - list.size() == 1) {
                rem = temp;
                if (rem == i)
                    list.add(i);
            }
            else 
                list.add(i);
            temp = rem;
        }
        
        combinations.add(list);
        return combinations;
    }
}


public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List <List<Integer>> combinations = new ArrayList<>();
        Set <Set<Integer>> combos = new HashSet<>();
        Set <Integer> set = new HashSet<>();
        
        // if ( k > n)
        //     return combinations;
        // if (k == 1 && n <= 9) {
        //     set.add(n);
        //     combinations.add(new ArrayList(set));
        //     return combinations;
        // }
        
        for (int i = 1; i <= 9; i++) {
            int sum = 0;
            set.add(i);
            sum += i;
            System.out.println(i);
            for (int j = 1; j <= 9 && set.size() != k; j++) {
                if (set.add(j))
                    sum += j;
                if (set.size() == k && sum != n) {
                    sum -= j;
                    set.remove(j);
                }
            }
            
            if (set.size() == k) {
                Set <Integer> temp = new HashSet(set);
                combos.add(temp);
            }
            set.clear();
        }
        
        for (Set s : combos) {
            combinations.add(new ArrayList(s));
        }
        
        return combinations;
    }
}

public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    combination(ans, new ArrayList<Integer>(), k, 1, n);
    return ans;
}

private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
    if (comb.size() == k && n == 0) {
        List<Integer> li = new ArrayList<Integer>(comb);
        ans.add(li);
        return;
    }
    for (int i = start; i <= 9; i++) {
        comb.add(i);
        combination(ans, comb, k, i+1, n-i);
        comb.remove(comb.size() - 1);
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Solution {
    List <List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int sum = 0;
        ArrayList<Integer> combo = new ArrayList();
        combinationSum3Helper(k, n, 0, 1, combo);
        return combinations;
    }
    
    private void combinationSum3Helper(int k, int n, int sum, int current, ArrayList<Integer> combo) {
        if (combo.size() == k && sum == n) {
            combinations.add(new ArrayList(combo));
            return;
        }
        for (int i = current; i <= 9; i++) {
            combo.add(i);
            combinationSum3Helper(k, n, sum + i, i + 1, combo);
            combo.remove(combo.size() - 1);
        }
    }
    
}