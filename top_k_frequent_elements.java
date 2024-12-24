import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class top_k_frequent_elements {
    public static void main(String arg[]) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){

            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);

        }

        PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (e1,e2) -> e2.getValue() - e1.getValue()
        );

        // for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
        //     pq.add(entry);
        // }

        pq.addAll(mp.entrySet());

        int[] topK = new int[k];

        for (int i = 0; i < k; i++) {
            topK[i] = pq.poll().getKey();
        }

        return topK;

    }
}
